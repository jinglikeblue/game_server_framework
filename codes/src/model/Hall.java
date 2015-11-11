
package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import vo.serverConfig.ServerCfgRoomVO;
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

	public Hall()
	{
		for(int i = 0; i < DataMgr.cfgVO.rooms.length; i++)
		{
			ServerCfgRoomVO vo = DataMgr.cfgVO.rooms[i];
			createScene(vo.scene, vo.roomAmount);
		}
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
