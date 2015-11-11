
package model;

public class Room
{

	private int _id;

	private int _sceneId;

	public Room(int id, int sceneId)
	{
		_id = id;
		_sceneId = sceneId;
	}

	public void update()
	{
		System.out.println(String.format("room update id:%s sceneId:%s", _id, _sceneId));
	}
}
