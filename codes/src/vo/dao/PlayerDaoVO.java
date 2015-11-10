
package vo.dao;

/**
 * 玩家表数据结构
 * 
 * @author Jing
 */
public class PlayerDaoVO
{

	/**
	 * 玩家游戏ID
	 */
	public int gameId;

	/**
	 * 玩家账号
	 */
	public String account;

	/**
	 * 玩家密码
	 */
	public String pwd;

	/**
	 * 玩家昵称
	 */
	public String name;

	/**
	 * 注册UTC
	 */
	public int registUtc;

	/**
	 * 注册时间
	 */
	public String registDate;

	/**
	 * 最后登录UTC
	 */
	public int lastLoginUtc;

	/**
	 * 最后登录时间
	 */
	public String lastLoginDate;
}
