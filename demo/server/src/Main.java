import java.io.IOException;

import server.GameServer;
import vo.ServerInitConfigVO;

import com.google.gson.Gson;

import consts.PathDefine;
import core.io.FileUtil;
import core.net.server.Console;
import demo.Game;

public class Main
{

	public static void main(String[] args)
	{
		Console.setPrintEnable(true);

		ServerInitConfigVO vo = loadConfig();

		GameServer g = new GameServer(vo, Game.class);
		g.start();
	}

	private static ServerInitConfigVO loadConfig()
	{
		Gson gson = new Gson();
		String cfgStr = null;
		ServerInitConfigVO cfgVO = null;
		try
		{
			cfgStr = FileUtil.readFile(PathDefine.SERVER_CFG);
			cfgVO = gson.fromJson(cfgStr, ServerInitConfigVO.class);
		}
		catch(IOException e)
		{
			Console.log.error(e);
		}

		return cfgVO;
	}
}
