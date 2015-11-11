
package cacher;

import interfaces.IDaoUser;

import java.io.IOException;
import java.util.HashSet;

import manager.PlayerMgr;
import model.Player;
import vo.dao.PlayerDaoVO;
import vo.protocolVO.PLoginVO;
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
		PLoginVO loginVO = new PLoginVO(packet.getProtoData());
		// 请求用户数据
		new PlayerDAO(this, "query user", client).queryPlayer(loginVO.gameId, loginVO.pwd);
	}

	@Override
	public void daoQueryResponse(Object[] daoVOs, String key, Object data)
	{
		if(null != daoVOs)
		{
			gotPlayerData((Client)data, (PlayerDaoVO)daoVOs[0]);
		}
		else
		{
			// 玩家不存在
		}
	}

	@Override
	public void daoUpdateResponse(int effectedCount, String key, Object data)
	{

	}

	private void gotPlayerData(Client client, PlayerDaoVO vo)
	{
		if(clientRequestSet.remove(client))
		{
			Player p = new Player(client, vo);
			PlayerMgr.addPlayer(p);
			
			//返回玩家信息
			p.channel().playerInfo(p.daoVO().name);
			
			//返回场景列表
		}
	}

}
