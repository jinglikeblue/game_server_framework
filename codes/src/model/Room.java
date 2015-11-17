
package model;

import manager.DataMgr;
import manager.HallMgr;

public class Room
{

	private int _id;

	/**
	 * 房间ID
	 * 
	 * @return
	 */
	public int id()
	{
		return _id;
	}

	private int _sceneId;

	/**
	 * 房间所属的场景ID
	 * 
	 * @return
	 */
	public int sceneId()
	{
		return _sceneId;
	}

	private Player[] _players;

	/**
	 * 房间中的玩家列表
	 * 
	 * @return
	 */
	public Player[] players()
	{
		return _players;
	}

	private int _playerCount;

	/**
	 * 玩家数
	 * 
	 * @return
	 */
	public int playerCount()
	{
		return _playerCount;
	}

	/**
	 * 与房间绑定的游戏逻辑
	 */
	private AGame _game;

	public Room(int id, int sceneId)
	{
		_id = id;
		_sceneId = sceneId;
		_players = new Player[DataMgr.cfgVO.roomPlayerAmount];

		try
		{
			_game = (AGame)HallMgr.gameCls.newInstance();
			_game.bind(this);
		}
		catch(InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	public int enter(Player player)
	{
		int error = _game.playerEnter(player);
		if(0 == error)
		{
			_playerCount++;
			for(int i = 0; i < _players.length; i++)
			{
				if(_players[i] == null)
				{
					_players[i] = player;
				}
			}
			_game.onPlayerEnter(player);
		}

		return error;
	}

	public int exit(Player player)
	{
		int error = _game.playerExit(player);
		if(0 == error)
		{
			_playerCount--;
			for(int i = 0; i < _players.length; i++)
			{
				if(_players[i] == player)
				{
					_players[i] = null;
				}
			}
			_game.onPlayerExit(player);
		}

		return error;
	}

	public void update()
	{
		if(null != _game)
		{
			_game.update();
		}
	}
}
