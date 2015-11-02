import java.io.IOException;

import manager.DataMgr;
import server.GameServer;
import vo.serverConfig.ServerCfgVO;

import com.google.gson.Gson;

import core.io.FileUtil;
import core.net.server.Console;


public class Main
{

	public static void main(String[] args)
	{		
	
		
		GameServer gs = new GameServer();
		gs.start();
	}

}
