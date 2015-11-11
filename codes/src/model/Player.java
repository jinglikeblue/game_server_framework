
package model;

import server.Channel;
import vo.dao.PlayerDaoVO;
import core.net.server.Client;

/**
 * 玩家
 * 
 * @author Jing
 */
public class Player
{

	private Client _client = null;

	/**
	 * 客户端连接对象
	 * 
	 * @return
	 */
	public Client client()
	{
		return _client;
	}

	private Channel _channel = null;

	/**
	 * 和客户端通信的通道
	 * 
	 * @return
	 */
	public Channel channel()
	{
		return _channel;
	}

	private int _id = -1;

	/**
	 * 玩家ID
	 * 
	 * @return
	 */
	public int id()
	{
		return _id;
	}

	private PlayerDaoVO _daoVO;

	/**
	 * 数据对象
	 * 
	 * @return
	 */
	public PlayerDaoVO daoVO()
	{
		return _daoVO;
	}

	public Player(Client client, PlayerDaoVO vo)
	{
		this._daoVO = vo;
		this._id = vo.gameId;
		_client = client;
		_channel = new Channel(client);
	}

}
