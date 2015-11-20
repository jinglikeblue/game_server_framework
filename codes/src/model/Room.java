
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

	private AGame _game;

	/**
	 * 与房间绑定的游戏逻辑
	 * 
	 * @return
	 */
	public AGame game()
	{
		return _game;
	}

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
		if(error != 0)
		{
			
		}
		return error;
	}
	
	public void enterResponse(int error)
	{
		
	}	
	
	public void enterResponse(Player player, int seat)
	{
		
	}

	/**
	 * 玩家进入了房间
	 */
	public void onPlayerEnter(Player player, int seat)
	{
		_players[seat] = player;
		//通知玩家进入房间
		player.channel().enterRoomResponse(error);
		
		//通知其他玩家该事件
		for(int i = 0; i < _players.length; i++)
		{
			if(i != seat && null != _players[i])
			{
				Player p = _players[i];				
				p.channel().enterRoomNotify();
			}			
		}
	}

	public int exit(Player player)
	{
		int error = _game.playerExit(player, -1);
		return error;
	}

	/**
	 * 玩家退出了房间
	 */
	public void onPlayerExit(Player player, int seat)
	{
		_players[seat] = null;
		
		//通知玩家退出房间
		
		//通知其他玩家该事件
	}

	public void update()
	{
		if(null != _game)
		{
			_game.update();
		}
	}
}
