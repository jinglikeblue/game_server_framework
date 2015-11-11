
package cacher;

import java.io.IOException;
import java.util.Date;

import manager.PlayerMgr;
import model.Player;
import core.net.server.Client;
import core.net.server.interfaces.IPacket;
import core.net.server.interfaces.IProtocolCacher;

public class PingCacher implements IProtocolCacher
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

		long time = new Date().getTime();
		p.channel().pingResponse((short)time);
	}
}
