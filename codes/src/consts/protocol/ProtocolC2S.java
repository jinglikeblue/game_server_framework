package consts.protocol;

/**
 * 客户端到服务器的协议
 * @author Jing
 *
 */
public class ProtocolC2S
{
	
	/**
	 * 登陆
	 */
	static public short LOGIN = 1;
	
	/**
	 * 心跳
	 */
	static public short PING = 2;
	
	/**
	 * 进入房间
	 */
	static public short ENTER_ROOM = 3;
	
	/**
	 * 退出房间
	 */
	static public short EXIT_ROOM = 4;
	
	/**
	 * 请求用户信息
	 */
	static public short REQUEST_PLAYER_INFO = 5;
	
	/**
	 * 更新用户信息
	 */
	static public short UPDATE_PLAYER_INFO = 6;
}
