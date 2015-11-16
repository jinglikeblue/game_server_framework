
package server;

import java.io.IOException;

import manager.DBMgr;
import manager.DataMgr;
import manager.HallMgr;
import model.Hall;
import vo.serverConfig.ServerCfgDataBaseVO;
import vo.serverConfig.ServerCfgServerVO;
import vo.serverConfig.ServerCfgVO;
import cacher.EnterRoomCacher;
import cacher.ExitRoomCacher;
import cacher.LoginCacher;
import cacher.PingCacher;
import cacher.RoomListCacher;
import cacher.SceneListCacher;

import com.google.gson.Gson;

import consts.PathDefine;
import consts.protocol.ProtocolC2S;
import core.io.FileUtil;
import core.net.server.Console;
import core.net.server.Server;

/**
 * 游戏服务器入口对象
 * @author Jing
 *
 */
public class Game
{

	public Game()
	{

	}

	public void start()
	{
		loadConfig();
		initMgr();
		initHall();
		runServer();
	}
	
	private void loadConfig()
	{
		Gson gson = new Gson();
		String cfgStr = null;
		try
		{
			cfgStr = FileUtil.readFile(PathDefine.SERVER_CFG);
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
	
	private void initHall()
	{
		HallMgr.hall = new Hall();
	}
	
	private void runServer()
	{
		Server server = Server.instance();
		server.addEventListener(Server.EVENT.ENTER_FRAME.name(), new ServerEnterFrameHandle()) ;
		
		server.registProtocolCacher((short)ProtocolC2S.E.LOGIN.ordinal(), new LoginCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.PING.ordinal(), new PingCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.SCENE_LIST.ordinal(), new SceneListCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.ROOM_LIST.ordinal(), new RoomListCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.ENTER_ROOM.ordinal(), new EnterRoomCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.EXIT_ROOM.ordinal(), new ExitRoomCacher());
		
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
