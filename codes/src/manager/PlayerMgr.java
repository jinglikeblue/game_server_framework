
package manager;

import java.util.HashMap;

import core.net.server.Client;
import model.Player;

/**
 * 玩家管理器
 * 
 * @author Jing
 */
public class PlayerMgr
{
	//客户端连接到玩家的映射
	static private HashMap<Client, Player> _client2Player = new HashMap<Client, Player>();

	//玩家ID到玩家的映射
	static private HashMap<Integer, Player> _id2Player = new HashMap<Integer, Player>();

	/**
	 * 检查是否包含用户
	 * @param client
	 * @return
	 */
	static public boolean containsPlayer(Client client)
	{
		return _client2Player.containsKey(client);
	}
	
	/**
	 * 检查是否包含用户
	 * @param client
	 * @return
	 */
	static public boolean containsPlayer(int id)
	{
		return _id2Player.containsKey(id);
	}
	
	/**
	 * 增加一个用户
	 * @param player
	 */
	static public void addPlayer(Player player)
	{
		_client2Player.put(player.client(), player);
		_id2Player.put(player.id(), player);
	}

	/**
	 * 移除一个用户
	 * @param id
	 */
	static public void removePlayer(int id)
	{
		Player p = _id2Player.get(id);
		_id2Player.remove(id);
		_client2Player.remove(p);
	}
	
	/**
	 * 获取玩家模型
	 * @param client
	 * @return
	 */
	static public Player getPlayer(Client client)
	{
		return _client2Player.get(client);
	}
	
	/**
	 * 获取玩家模型
	 * @param client
	 * @return
	 */
	static public Player getPlayer(int id)
	{
		return _id2Player.get(id);
	}
}
