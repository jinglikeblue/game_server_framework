
package demo;

import java.util.HashMap;

import demo.consts.GameState;
import demo.stateControlers.AControler;
import demo.stateControlers.FreeSC;
import demo.stateControlers.PlayingSC;
import demo.stateControlers.ReadySC;
import model.AGame;
import model.Player;

public class Game extends AGame
{

	public GameState state = GameState.FREE;

	private AControler _sc = null;

	private HashMap<GameState, AControler> _scMap = null;

	public Game()
	{
		_scMap = new HashMap<GameState, AControler>();
		_scMap.put(GameState.FREE, new FreeSC(this));
		_scMap.put(GameState.PLAYING, new PlayingSC(this));
		_scMap.put(GameState.READY, new ReadySC(this));
		changeState(GameState.FREE);
	}

	/**
	 * 改变游戏状态
	 * 
	 * @param state
	 * @return
	 */
	public int changeState(GameState state)
	{
		_sc = _scMap.get(state);
		return 0;
	}

	/**
	 * 玩家尝试进入房间
	 * 
	 * @param player
	 * @return 错误码
	 */
	@Override
	public int playerEnter(Player player)
	{
		return _sc.playerEnter(player).ordinal();
	}

	/**
	 * 玩家尝试退出房间
	 * 
	 * @param player
	 * @return 错误码
	 */
	@Override
	public int playerExit(Player player, int seat)
	{
		return _sc.playerExit(player, seat).ordinal();
	}



	/**
	 * 游戏更新
	 */
	@Override
	public void update()
	{
		_sc.update();
	}

}
