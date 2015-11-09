package cacher;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashSet;

import manager.PlayerMgr;
import core.db.worker.IMysqlWorkerUser;
import core.events.EventDispatcher;
import core.events.IEventListener;
import core.net.server.Client;
import core.net.server.interfaces.IPacket;
import core.net.server.interfaces.IProtocolCacher;


public class LoginCacher implements IProtocolCacher, IEventListener, IMysqlWorkerUser
{
	static private HashSet<Client> clientRequestSet = new HashSet<Client>();
	
	@Override
	public void onReciveEvent(String type, EventDispatcher dispatcher, Object data)
	{		

	}

	@Override
	public void onCacheProtocol(Client client, IPacket packet) throws IOException
	{		
		if(PlayerMgr.containsPlayer(client) || clientRequestSet.contains(client))
		{
			System.out.println("user repeat login");
			client.dispose();
			return;
		}
		
		//加入到客户端请求集
		clientRequestSet.add(client);
		
		
	}

	@Override
	public void queryResult(String key, Object data, ResultSet rs)
	{
		
		
	}

	@Override
	public void updateResult(String key, Object data, int effectedCount)
	{
		
		
	}

}
