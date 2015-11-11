
package consts.protocol;

/**
 * 客户端到服务器的协议
 * 
 * @author Jing
 */
public class ProtocolC2S
{

	static public enum E
	{
		NONE,

		/**
		 * 登陆
		 * int32 game_id
		 * int16 pwd_length
		 * char[] pwd
		 */
		LOGIN,

		/**
		 * 心跳
		 * int32 client_utc
		 */
		PING,

		/**
		 * 获取场景列表
		 */
		SCENE_LIST,
		
		/**
		 * 房间列表
		 * int16 scene_id	场景ID
		 */
		ROOM_LIST,
		
		/**
		 * 进入房间
		 * int16 scene_id	场景ID		
		 * int32 room_id	房间ID	if(value<=0)表示快速进入
		 */
		ENTER_ROOM,

		/**
		 * 退出房间
		 */
		EXIT_ROOM,

		/**
		 * 请求用户信息
		 */
		REQUEST_PLAYER_INFO,

		/**
		 * 更新用户信息
		 */
		UPDATE_PLAYER_INFO,
	}

}
