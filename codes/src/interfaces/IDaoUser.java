package interfaces;

/**
 * 数据接口调用者
 * @author Jing
 *
 */
public interface IDaoUser
{
	/**
	 * 查询回调
	 * @param daoVO 查询返回的数据
	 * @param key 需要回传的KEY
	 * @param data 需要回传的数据
	 */
	void daoQueryResponse(Object daoVO, String key, Object data);
	
	/**
	 * 更新回调
	 * @param effectedCount 影响的行数
	 * @param key 需要回传的KEY
	 * @param data 需要回传的数据
	 */
	void daoUpdateResponse(int effectedCount, String key, Object data);
}
