
package model;

public class AGame
{

	protected Room _room = null;

	/**
	 * 和游戏绑定的房间
	 * 
	 * @return
	 */
	public Room room()
	{
		return _room;
	}

	/**
	 * 绑定
	 * 
	 * @param room
	 */
	protected void bind(Room room)
	{
		this._room = room;
	}

	/**
	 * 玩家尝试进入房间
	 * 
	 * @param player
	 * @return 错误码
	 */
	public int playerEnter(Player player)
	{
		return 0;

	}

	/**
	 * 玩家尝试退出房间
	 * 
	 * @param player
	 * @return 错误码
	 */
	public int playerExit(Player player, int seat)
	{
		return 0;

	}

	/**
	 * 游戏更新
	 */
	public void update()
	{
		// System.out.println("agame");
	}
}
