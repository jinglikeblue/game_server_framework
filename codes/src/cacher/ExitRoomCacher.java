package cacher;

import java.io.IOException;

import manager.HallMgr;
import manager.PlayerMgr;
import model.Player;
import model.Room;
import model.Scene;
import vo.protocolVO.c2s.PEnterRoomVO;
import core.events.EventDispatcher;
import core.events.IEventListener;
import core.net.server.Client;
import core.net.server.interfaces.IPacket;
import core.net.server.interfaces.IProtocolCacher;


public class ExitRoomCacher implements IEventListener, IProtocolCacher
{

	@Override
	public void onCacheProtocol(Client client, IPacket packet) throws IOException
	{
		do
		{
			Player p = PlayerMgr.getPlayer(client);
			if(null == p)
			{
				break;
			}

			PEnterRoomVO vo = new PEnterRoomVO(packet.getProtoData());
			Scene scene = HallMgr.hall.getScene(vo.sceneId);
			if(null == scene)
			{
				break;
			}

			Room room = scene.getRoom(vo.roomId);
			if(null == room)
			{
				break;
			}

			room.exit(player);
			return;
		} while(false);

		client.dispose();
	}

	@Override
	public void onReciveEvent(String type, EventDispatcher dispatcher, Object data)
	{
		// TODO Auto-generated method stub

	}

}
