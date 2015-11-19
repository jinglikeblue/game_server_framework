
package server;

import java.io.IOException;

import manager.DBMgr;
import manager.DataMgr;
import manager.HallMgr;
import model.AGame;
import model.Hall;
import vo.ServerInitConfigVO;
import cacher.EnterRoomCacher;
import cacher.ExitRoomCacher;
import cacher.LoginCacher;
import cacher.PingCacher;
import cacher.RoomListCacher;
import cacher.SceneListCacher;
import consts.protocol.ProtocolC2S;
import core.net.server.Server;

/**
 * 游戏服务器入口对象
 * 
 * @author Jing
 */
public class GameServer
{

	public GameServer(ServerInitConfigVO vo, Class<?> cls)
	{
		DataMgr.cfgVO = vo;
		HallMgr.gameCls = null == cls ? AGame.class : cls;
	}

	public void start()
	{
		initMgr();
		initHall();
		runServer();
	}

	private void initMgr()
	{
		ServerInitConfigVO vo = DataMgr.cfgVO;
		DBMgr.init(vo.dbAddress, vo.dbPort, vo.dbUser, vo.dbPWD, vo.dbName);
	}

	private void initHall()
	{
		HallMgr.hall = new Hall();
	}

	private void runServer()
	{
		Server server = Server.instance();
		server.addEventListener(Server.EVENT.ENTER_FRAME.name(), new ServerEnterFrameHandle());
		server.registProtocolCacher((short)ProtocolC2S.E.LOGIN.ordinal(), new LoginCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.PING.ordinal(), new PingCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.SCENE_LIST.ordinal(), new SceneListCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.ROOM_LIST.ordinal(), new RoomListCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.ENTER_ROOM.ordinal(), new EnterRoomCacher());
		server.registProtocolCacher((short)ProtocolC2S.E.EXIT_ROOM.ordinal(), new ExitRoomCacher());

		try
		{
			ServerInitConfigVO vo = DataMgr.cfgVO;
			server.run(vo.serverPort, vo.serverBufferSize, vo.serverFPS);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
