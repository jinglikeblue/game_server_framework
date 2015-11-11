
package model;

public class Scene
{

	private int _id;

	/**
	 * ID
	 * 
	 * @return
	 */
	public int id()
	{
		return _id;
	}

	private int _roomAmount;

	/**
	 * 房间数
	 * 
	 * @return
	 */
	public int roomAmount()
	{
		return _roomAmount;
	}

	private Room[] _rooms = null;

	public Room[] rooms()
	{
		return _rooms;
	}

	private int _playerCount;

	/**
	 * 玩家数
	 * @return
	 */
	public int playerCount()
	{
		return _playerCount;
	}

	public Scene(int id, int roomAmount)
	{
		_id = id;
		_roomAmount = roomAmount;
		_rooms = new Room[roomAmount];
		for(int i = 0; i < roomAmount; i++)
		{
			_rooms[i] = new Room(i + 1, id);
		}
	}

	public void update()
	{
		for(int i = 0; i < _roomAmount; i++)
		{
			_rooms[i].update();
		}
	}
}
