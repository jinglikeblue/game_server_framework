
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
		 * 		int32 scene_id		场景ID
		 * 		int32 player_count 	玩家数量
		 * ]
		 */
		SCENE_LIST_RESPONSE,
		
		/**
		 * 房间列表返回
		 * int32 scene_id	场景ID
		 * [
		 * 		int32 room_id	房间ID
		 * 		int16 roomplayer_count	 房间中玩家数	
		 * ]
		 * 
		 */
		ROOM_LIST_RESPONSE,

		/**
		 * 进入房间失败返回
		 * int32 error		错误码
		 */
		ENTER_ROOM_RESPONSE_ERROR,
		
		/**
		 * 进入房间成功
		 * [
		 * 		int		seat		玩家座位号
		 * 		int 	game_id		玩家游戏ID
		 * 		string	name		玩家昵称 		
		 * ] 
		 */
		ENTER_ROOM_RESPONSE_SUCCESS,

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
