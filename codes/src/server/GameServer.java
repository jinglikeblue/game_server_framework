
package server;

import java.io.IOException;

import manager.DBMgr;
import manager.DataMgr;
import vo.serverConfig.ServerCfgDataBaseVO;
import vo.serverConfig.ServerCfgServerVO;
import vo.serverConfig.ServerCfgVO;
import cacher.LoginCacher;
import cacher.PingCacher;

import com.google.gson.Gson;

import consts.protocol.ProtocolC2S;
import core.io.FileUtil;
import core.net.server.Console;
import core.net.server.Server;

public class GameServer
{

	public GameServer()
	{

	}

	public void start()
	{
		loadConfig();
		initMgr();
		runServer();
	}
	
	private void loadConfig()
	{
		Gson gson = new Gson();
		String cfgStr = null;
		try
		{
			cfgStr = FileUtil.readFile("./src/assets/server_cfg.json");
			ServerCfgVO cfgVO = gson.fromJson(cfgStr, ServerCfgVO.class);
			DataMgr.cfgVO = cfgVO;
		}
		catch(IOException e)
		{			
			Console.log.error(e);
		}	
	}
	
	private void initMgr()
	{
		ServerCfgDataBaseVO vo = DataMgr.cfgVO.database;
		DBMgr.init(vo.address, vo.port, vo.user, vo.pwd, vo.dbName);
	}
	
	private void runServer()
	{
		Server server = Server.instance();
		server.registProtocolCacher((short)ProtocolC2S.E.LOGIN.ordinal(), new LoginCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.PING.ordinal(), new PingCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.ENTER_ROOM.ordinal(), new PingCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.EXIT_ROOM.ordinal(), new PingCacher());
		try
		{
			ServerCfgServerVO vo = DataMgr.cfgVO.server;
			server.run(vo.port, vo.bufferSize, vo.fps);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
