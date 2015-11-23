
package cacher;

import java.io.IOException;

import manager.HallMgr;
import manager.PlayerMgr;
import model.Player;
import vo.protocolVO.c2s.PRoomListVO;
import core.net.server.Client;
import core.net.server.interfaces.IPacket;
import core.net.server.interfaces.IProtocolCacher;

public class RoomListCacher implements IProtocolCacher
{

	@Override
	public void onCacheProtocol(Client client, IPacket packet) throws IOException
	{
		Player p = PlayerMgr.getPlayer(client);
		if(null == p)
		{
			client.dispose();
			return;
		}

		int sceneId = new PRoomListVO(packet.getProtoData()).sceneId;
		p.channel().roomListResponse(HallMgr.hall.getScene(sceneId));
	}

}
