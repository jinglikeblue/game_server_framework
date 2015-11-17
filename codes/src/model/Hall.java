
package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import manager.DataMgr;

/**
 * 游戏大厅
 * 
 * @author Jing
 */
public class Hall
{

	/**
	 * 场景
	 */
	private HashMap<Integer, Scene> _scene = new HashMap<Integer, Scene>();

	public HashMap<Integer, Scene> scene()
	{
		return _scene;
	}

	public Scene getScene(int sceneId)
	{
		return _scene.get(sceneId);
	}

	public Hall()
	{
		for(int i = 0; i < DataMgr.cfgVO.sceneAmount; i++)
		{
			createScene(i + 1, DataMgr.cfgVO.sceneRoomAmount);
		}

		System.out.println("scene size:" + _scene.size());
	}

	private void createScene(int id, int roomAmount)
	{
		_scene.put(id, new Scene(id, roomAmount));
	}

	public void update()
	{
		Iterator<Entry<Integer, Scene>> it = _scene.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<Integer, Scene> e = it.next();
			Scene scene = (Scene)e.getValue();
			scene.update();
		}
	}
}
