
package cacher;

import interfaces.IDaoUser;

import java.io.IOException;
import java.util.HashSet;

import manager.PlayerMgr;
import vo.dao.PlayerDaoVO;
import vo.packetVO.LoginVO;
import core.events.EventDispatcher;
import core.events.IEventListener;
import core.net.server.Client;
import core.net.server.interfaces.IPacket;
import core.net.server.interfaces.IProtocolCacher;
import dao.PlayerDAO;

public class LoginCacher implements IProtocolCacher, IEventListener, IDaoUser
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

		// 加入到客户端请求集
		clientRequestSet.add(client);
		LoginVO loginVO = new LoginVO(packet.getProtoData());
		// 请求用户数据
		new PlayerDAO(this, "query user", client).queryPlayer(loginVO.gameId, loginVO.pwd);
	}

	@Override
	public void daoQueryResponse(Object[] daoVOs, String key, Object data)
	{
		if(null != daoVOs)
		{
			PlayerDaoVO playerDaoVO = (PlayerDaoVO)daoVOs[0];
			Client client = (Client)data;
			if(false == clientRequestSet.remove(client))
			{
				// 数据移除出错！！！
			}
		}
		else
		{
			//玩家不存在
		}		
	}

	@Override
	public void daoUpdateResponse(int effectedCount, String key, Object data)
	{

	}

}
