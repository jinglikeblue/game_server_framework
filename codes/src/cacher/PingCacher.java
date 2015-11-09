package cacher;

import java.io.IOException;

import core.events.EventDispatcher;
import core.events.IEventListener;
import core.net.server.Client;
import core.net.server.interfaces.IPacket;
import core.net.server.interfaces.IProtocolCacher;


public class PingCacher implements IEventListener, IProtocolCacher
{

	@Override
	public void onCacheProtocol(Client client, IPacket packet) throws IOException
	{
		

	}

	@Override
	public void onReciveEvent(String type, EventDispatcher dispatcher, Object data)
	{
		

	}

}
