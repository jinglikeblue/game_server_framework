
package vo.protocolVO;

import core.net.server.utils.ByteArray;

public class PRoomListVO
{

	public int sceneId;

	public PRoomListVO(byte[] bytes)
	{
		ByteArray ba = new ByteArray(bytes);
		sceneId = ba.readInt();		
	}
}
