import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import core.io.FileUtil;
import server.GameServer;
import vo.ServerCfg;


public class Main
{

	public static void main(String[] args)
	{
		
		Gson gson = new Gson();
		String cfg = null;
		try
		{
			cfg = FileUtil.readFile("./src/assets/server_cfg.json");
		}
		catch(IOException e)
		{			
			e.printStackTrace();
		}
		ServerCfg obj = gson.fromJson(cfg, ServerCfg.class);
		
		
		GameServer gs = new GameServer();
		gs.start();
	}

}
