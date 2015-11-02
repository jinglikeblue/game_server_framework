
package consts.protocol;

/**
 * 服务器到客户端的协议
 * 
 * @author Jing
 */
public class ProtocolS2C
{

	static public enum E
	{
		NONE,

		/**
		 * 登陆返回
		 */
		LOGIN_RESPONSE,

		/**
		 * 用户信息
		 */
		PLAYER_INFO,

		/**
		 * 进入房间放回
		 */
		ENTER_ROOM_RESPONSE,

		/**
		 * 进入房间通知
		 */
		ENTER_ROOM_NOTIFY,

		/**
		 * 退出房间返回
		 */
		EXIT_ROOM_RESPONSE,

		/**
		 * 退出房间通知
		 */
		EXIT_ROOM_NOTIFY,
	}

}
