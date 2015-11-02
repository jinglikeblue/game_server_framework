package interfaces;

import model.Player;


public interface IGame
{
	/**
	 * 改变游戏状态
	 * 
	 * @param state
	 * @return
	 */
	public int changeState(int state);

	/**
	 * 玩家尝试进入房间
	 * @param player
	 * @return 错误码
	 */
	public int playerEnter(Player player);

	/**
	 * 玩家进入了房间
	 */
	public void onPlayerEnter(Player player);

	/**
	 * 玩家尝试退出房间
	 * @param player
	 * @return 错误码
	 */
	public int playerExit(Player player);

	/**
	 * 玩家退出了房间
	 */
	public void onPlayerExit();

	/**
	 * 游戏更新
	 */
	public void update();
}
