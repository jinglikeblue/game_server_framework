
package vo;

/**
 * 服务器初始化配置数据
 * 
 * @author Jing
 */
public class ServerInitConfigVO
{

	/**
	 * 服务器端口
	 */
	public int serverPort;

	/**
	 * 服务器缓冲区大小
	 */
	public int serverBufferSize;

	/**
	 * 服务器每秒迭代次数
	 */
	public int serverFPS;

	/**
	 * 数据库地址
	 */
	public String dbAddress;

	/**
	 * 数据库端口
	 */
	public int dbPort;

	/**
	 * 数据库用户名
	 */
	public String dbUser;

	/**
	 * 数据库密码
	 */
	public String dbPWD;

	/**
	 * 数据库名称
	 */
	public String dbName;

	/**
	 * 生成场景数量
	 */
	public int sceneAmount;

	/**
	 * 生成房间数量
	 */
	public int sceneRoomAmount;

	/**
	 * 生成玩家数量
	 */
	public int roomPlayerAmount;
}
