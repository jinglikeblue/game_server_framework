package debug;

import manager.DBMgr;
import vo.dao.PlayerDaoVO;
import interfaces.IDaoUser;
import dao.PlayerDAO;


public class DaoTest implements IDaoUser
{
	public DaoTest()
	{
		DBMgr.init("localhost", 3306, "root", "123456", "db_chess");			
		new PlayerDAO(this, "dao", null).queryPlayer(1, "321");;
	}

	@Override
	public void daoQueryResponse(Object[] daoVOs, String key, Object data)
	{
		PlayerDaoVO vo = null;
		if(daoVOs != null)
		{
			 vo = (PlayerDaoVO)daoVOs[0];
		}
		System.out.println(vo.name);
	}

	@Override
	public void daoUpdateResponse(int effectedCount, String key, Object data)
	{
		
		
	}
}
