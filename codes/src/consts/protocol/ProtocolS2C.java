package consts.protocol;

/**
 * 服务器到客户端的协议
 * @author Jing
 *
 */
public class ProtocolS2C
{
	/**
	 * 登陆返回
	 */
	static public short LOGIN_RESPONSE = 1;
	
	/**
	 * 用户信息
	 */
	static public short PLAYER_INFO = 2;
	
	/**
	 * 进入房间放回
	 */
	static public short ENTER_ROOM_RESPONSE = 3;
	
	/**
	 * 进入房间通知
	 */
	static public short ENTER_ROOM_NOTIFY = 4;
	
	/**
	 * 退出房间返回
	 */
	static public short EXIT_ROOM_RESPONSE = 5;
	
	/**
	 * 退出房间通知
	 */
	static public short EXIT_ROOM_NOTIFY = 6;
}
