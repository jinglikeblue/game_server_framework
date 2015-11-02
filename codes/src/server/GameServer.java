package server;

import java.io.IOException;

import cacher.LoginCacher;
import cacher.PingCacher;
import consts.protocol.ProtocolC2S;
import core.net.server.Server;

public class GameServer
{
	public GameServer()
	{

	}
	
	public void start()
	{
		Server server = Server.instance();	
		server.registProtocolCacher(ProtocolC2S.LOGIN, new LoginCacher());
		server.registProtocolCacher(ProtocolC2S.PING, new PingCacher());
		server.registProtocolCacher(ProtocolC2S.ENTER_ROOM, new PingCacher());
		server.registProtocolCacher(ProtocolC2S.EXIT_ROOM, new PingCacher());
		try
		{
			server.run(9527, 4096, 30);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
