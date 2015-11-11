
package server;

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
	public void sceneResponse()
	{
//		Serialize s = new Serialize();
//		s.writeShort(0);
	}

}
