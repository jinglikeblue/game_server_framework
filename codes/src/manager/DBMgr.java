package manager;


/**
 * 数据库管理器
 * @author Jing
 *
 */
public final class DBMgr
{
//	static public MysqlQueryWorker query = null;
//	static public MysqlUpdateWorker update = null;
	
	/**
	 * 初始化数据管理器
	 * @param address 数据库地址
	 * @param port 数据库端口
	 * @param user 用户名
	 * @param password 用户密码
	 * @param dbName 数据库名称
	 * @return
	 */
	static public boolean init(String address, int port, String user, String password, String dbName)
	{
//		query = MysqlQueryWorker.create(address, port, user, password, dbName);
//		update = MysqlUpdateWorker.create(address, port, user, password, dbName);
//		
//		if(null == query || null == query)
//		{
//			System.out.println("database connect fail!");
//			return false;
//		}
		return true;
	}
}
