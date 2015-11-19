
package demo.stateControlers;

import demo.Game;
import demo.consts.ErrorCode;
import model.Player;

public abstract class AControler
{

	protected Game game = null;

	public AControler(Game game)
	{
		this.game = game;
	}

	/**
	 * 玩家尝试进入房间
	 * 
	 * @param player
	 * @return 错误码
	 */
	abstract public ErrorCode playerEnter(Player player);

	/**
	 * 玩家尝试退出房间
	 * 
	 * @param player
	 * @return 错误码
	 */
	abstract public ErrorCode playerExit(Player player, int seat);

	/**
	 * 游戏更新
	 */
	abstract public void update();
}
