package manager;

import core.db.worker.MysqlQueryWorker;
import core.db.worker.MysqlUpdateWorker;

/**
 * 数据库管理器
 * @author Jing
 *
 */
public final class DBMgr
{
	static public MysqlQueryWorker query = null;
	static public MysqlUpdateWorker update = null;
	
	static public void init(String address, int port, String user, String password, String dbName)
	{
		query = MysqlQueryWorker.create(address, port, user, password, dbName);
		update = MysqlUpdateWorker.create(address, port, user, password, dbName);
	}
}
