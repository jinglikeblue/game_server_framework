
package model;

import interfaces.IGame;

import java.util.Vector;

public class Room
{

	private int _id;
	
	public int id()
	{
		return _id;
	}

	private int _sceneId;
	
	public int sceneId()
	{
		return _sceneId;
	}
	
	private Vector<Player> _players;

	public Vector<Player> players()
	{
		return _players;
	}
	
	private IGame game;
	
	public Room(int id, int sceneId)
	{
		_id = id;
		_sceneId = sceneId;
		_players = new Vector<Player>();
	}
	
	public void enter(Player player)
	{
		game.playerEnter(player);
	}
	
	public void exit(Player player)
	{
		
	}

	public void update()
	{
		game.update();
		System.out.println(String.format("room update id:%s sceneId:%s", _id, _sceneId));
	}
}
