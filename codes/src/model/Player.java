
package model;

import core.net.server.Client;

/**
 * 玩家
 * @author Jing
 *
 */
public class Player
{
	private Client _client = null;
	
	/**
	 * 客户端连接对象
	 * @return
	 */
	public Client client()
	{
		return _client;
	}
	
	private int _id = -1;
	
	/**
	 * 玩家ID
	 * @return
	 */
	public int id()
	{
		return _id;
	}

	public Player()
	{

	}
}
