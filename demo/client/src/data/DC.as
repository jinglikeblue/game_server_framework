package data
{
	import views.Room;
	
	import vos.PlayerVO;
	import vos.RoomVO;
	import vos.SceneVO;

	public class DC
	{
		public function DC()
		{
		}
		
		static public var player:PlayerVO;
		static public var sceneList:Vector.<SceneVO>;
		static public var roomList:Vector.<RoomVO>;
		static public var playerList:Vector.<PlayerVO>;
	}
}