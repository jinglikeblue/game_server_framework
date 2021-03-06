
package server;

import java.util.Iterator;
import java.util.Vector;
import java.util.Map.Entry;

import vo.protocolVO.s2c.PPlayerInfoVO;
import model.Hall;
import model.Room;
import model.Scene;
import consts.protocol.ProtocolS2C;
import core.net.server.Client;
import core.net.server.utils.Serialize;

public class Channel
{

	private Client _c;

	public Channel(Client client)
	{
		_c = client;
	}

	private void send2Client(ProtocolS2C.E id, byte[] data)
	{
		_c.sendProtocol((short)id.ordinal(), data);
	}

	/**
	 * 用户信息
	 * 
	 * @param error
	 * @return
	 */
	public void playerInfo(String name)
	{
		Serialize s = new Serialize();
		s.writeUTFString(name);
		send2Client(ProtocolS2C.E.PLAYER_INFO, s.toBytes());
	}

	/**
	 * 心跳返回
	 * 
	 * @param error
	 * @return
	 */
	public void pingResponse(int serverUTC)
	{
		Serialize s = new Serialize();
		s.writeInt(serverUTC);
		send2Client(ProtocolS2C.E.PING_RESPONSE, s.toBytes());
	}

	/**
	 * 场景返回
	 */
	public void sceneListResponse(Hall hall)
	{
		Serialize s = new Serialize();
		s.writeShort((short)hall.scene().size());
		Iterator<Entry<Integer, Scene>> it = hall.scene().entrySet().iterator();
		while(it.hasNext())
		{
			Entry<Integer, Scene> e = it.next();
			Scene scene = (Scene)e.getValue();
			s.writeInt(scene.id());
			s.writeInt(scene.playerCount());
		}
		send2Client(ProtocolS2C.E.SCENE_LIST_RESPONSE, s.toBytes());
	}

	/**
	 * 房间列表返回
	 */
	public void roomListResponse(Scene scene)
	{
		Serialize s = new Serialize();
		s.writeInt(scene.id());
		s.writeShort((short)scene.roomAmount());
		for(int i = 0; i < scene.roomAmount(); i++)
		{
			Room room = scene.rooms()[i];
			s.writeInt(room.id());
			s.writeShort((short)room.playerCount());
		}
		send2Client(ProtocolS2C.E.ROOM_LIST_RESPONSE, s.toBytes());
	}

	/**
	 * 进入房间返回
	 */
	public void enterRoomResponse(int error, Vector<PPlayerInfoVO> players)
	{
		Serialize s = new Serialize();
		s.writeInt(error);
		if(0 == error)
		{
			s.writeShort((short)players.size());
			Iterator<PPlayerInfoVO> it = players.iterator();
			while(it.hasNext())
			{
				PPlayerInfoVO p = it.next();
				s.writeInt(p.seat);
				s.writeInt(p.gameId);
				s.writeUTFString(p.name);
			}
		}
		send2Client(ProtocolS2C.E.ENTER_ROOM_RESPONSE, s.toBytes());
	}

	/**
	 * 进入房间通知
	 */
	public void enterRoomNotify(int seat, int gameId, String name)
	{
		Serialize s = new Serialize();
		s.writeInt(seat);
		s.writeInt(gameId);
		s.writeUTFString(name);
		send2Client(ProtocolS2C.E.ENTER_ROOM_NOTIFY, s.toBytes());
	}

	/**
	 * 退出房间返回
	 */
	public void exitRoomResponse(int error)
	{
		Serialize s = new Serialize();
		s.writeInt(error);
		send2Client(ProtocolS2C.E.EXIT_ROOM_RESPONSE, s.toBytes());
	}

	/**
	 * 退出房间通知
	 */
	public void exitRoomNotify(int seat)
	{
		Serialize s = new Serialize();
		s.writeInt(seat);
		send2Client(ProtocolS2C.E.EXIT_ROOM_NOTIFY, s.toBytes());
	}

}
