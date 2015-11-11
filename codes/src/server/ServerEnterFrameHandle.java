
package server;

import manager.HallMgr;
import core.events.EventDispatcher;
import core.events.IEventListener;

public class ServerEnterFrameHandle implements IEventListener
{

	@Override
	public void onReciveEvent(String type, EventDispatcher dispatcher, Object data)
	{
		HallMgr.hall.update();

	}
}
