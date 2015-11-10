
package dao;

import interfaces.IDaoUser;

import java.sql.ResultSet;
import java.sql.SQLException;

import manager.DBMgr;
import vo.dao.PlayerDaoVO;
import core.db.worker.IMysqlWorkerUser;

/**
 * 玩家数据接口
 * 
 * @author Jing
 */
public class PlayerDAO extends ADao implements IMysqlWorkerUser
{

	public PlayerDAO(IDaoUser user, String key, Object data)
	{
		super(user, key, data);
	}

	public void queryPlayer(int id, String pwd)
	{
		String sql = "SELECT * FROM tbl_player WHERE game_id=%d AND pwd='%s'";
		sql = String.format(sql, id, pwd);		
		
		//String sql = "SELECT game_id FROM tbl_player";
		DBMgr.query.excute(sql, this, _key, _data);
	}

	@Override
	public void queryResult(String key, Object data, ResultSet rs) throws SQLException
	{
		Object[] rows = null;
		if(rs.last())
		{
			int rowAmount = rs.getRow();
			rows = new Object[rowAmount];
			rs.first();
			do
			{
				PlayerDaoVO vo = null;
				vo = new PlayerDaoVO();
				vo.gameId = rs.getInt("game_id");
				vo.account = rs.getString("account");
				vo.pwd = rs.getString("pwd");
				vo.name = rs.getString("name");
				vo.registUtc = rs.getInt("regist_utc");
				vo.registDate = rs.getString("regist_date");
				vo.lastLoginUtc = rs.getInt("last_login_utc");
				vo.lastLoginDate = rs.getString("last_login_date");
				int index = rs.getRow() - 1;
				rows[index] = vo;
			}
			while(rs.next());
		}

		this._user.daoQueryResponse(rows, this._key, this._data);
	}

	@Override
	public void updateResult(String key, Object data, int effectedCount) throws SQLException
	{
		

	}

}
