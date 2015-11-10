
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
		 * int8 error 不为0则表示失败
		 */
		LOGIN_RESPONSE,

		/**
		 * 用户信息
		 * string player_name
		 */
		PLAYER_INFO,
		
		/**
		 * 心跳返回
		 * int32 server_utc
		 */
		PING_RESPONSE,
		
		/**
		 * 场景列表返回		  
		 * [
		 * 		int16 scene_id		场景ID
		 * 		int32 player_count 	玩家数量
		 * 		[
		 * 			int32	room_id				房间ID
		 * 			int16	room_player_count	房间中玩家数 			 			
		 * 		]
		 * ]
		 */
		SCENE_LIST_RESPONSE,

		/**
		 * 进入房间返回
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
