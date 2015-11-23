package vo.protocolVO.c2s;

import core.net.server.utils.ByteArray;


public class PEnterRoomVO
{
	public int sceneId;
	public int roomId;
	public PEnterRoomVO(byte[] bytes)
	{
		ByteArray ba = new ByteArray(bytes);
		this.sceneId = ba.readInt();
		this.roomId = ba.readInt();
	}
	
}
