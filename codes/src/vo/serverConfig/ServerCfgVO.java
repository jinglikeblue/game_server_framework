
package vo.serverConfig;

/**
 * 服务器的配置信息
 * @author Jing
 *
 */
public class ServerCfgVO
{
	/**
	 * 服务器配置
	 */
	public ServerCfgServerVO server;

	/**
	 * 数据库配置
	 */
	public ServerCfgDataBaseVO database;

	/**
	 * 房间配置
	 */
	public ServerCfgRoomVO[] rooms;
}
