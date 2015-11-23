
package model;

import java.util.Vector;

import vo.protocolVO.s2c.PPlayerInfoVO;
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

	public void enter(Player player)
	{
		int error = _game.playerEnter(player);
		if(error != 0)
		{
			player.channel().enterRoomResponse(error, null);
		}
	}

	/**
	 * 进入房间回执
	 */
	public void enterResponse(Player player, int seat)
	{
		_players[seat] = player;

		Vector<PPlayerInfoVO> infos = new Vector<PPlayerInfoVO>();

		// 通知其他玩家该事件
		for(int i = 0; i < _players.length; i++)
		{
			if(null != _players[i])
			{
				Player p = _players[i];
				if(p != player)
				{
					// 告诉其它玩家，该玩家登陆
					p.channel().enterRoomNotify(seat, player.daoVO().gameId, player.daoVO().name);
					// 加入推送给进入房间玩家的列表
					infos.add(new PPlayerInfoVO(i, p.daoVO().gameId, p.daoVO().name));
				}
			}
		}

		player.channel().enterRoomResponse(0, infos);
	}

	public void exit(Player player)
	{
		int error = _game.playerExit(player, -1);
		if(error != 0)
		{
			player.channel().exitRoomResponse(error);
		}
	}

	/**
	 * 玩家退出了房间
	 */
	public void exitResponse(Player player, int seat)
	{
		_players[seat] = null;

		// 通知玩家退出房间
		player.channel().exitRoomResponse(0);

		// 通知其他玩家该事件
		for(int i = 0; i < _players.length; i++)
		{
			if(null != _players[i])
			{
				Player p = _players[i];
				p.channel().exitRoomNotify(seat);
			}
		}

	}

	public void update()
	{
		if(null != _game)
		{
			_game.update();
		}
	}
}
