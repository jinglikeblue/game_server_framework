
package model;

public class AGame
{
	protected Room room = null;
	/**
	 * 绑定
	 * 
	 * @param room
	 */
	protected void bind(Room room)
	{
		this.room = room;
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
	 * 玩家进入了房间
	 */
	public void onPlayerEnter(Player player)
	{

	}

	/**
	 * 玩家尝试退出房间
	 * 
	 * @param player
	 * @return 错误码
	 */
	public int playerExit(Player player)
	{
		return 0;

	}

	/**
	 * 玩家退出了房间
	 */
	public void onPlayerExit(Player player)
	{

	}

	/**
	 * 游戏更新
	 */
	public void update()
	{
		//System.out.println("agame");
	}
}
