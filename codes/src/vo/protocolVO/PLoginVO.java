package vo.protocolVO;

import core.net.server.utils.ByteArray;


public class PLoginVO
{
	public int gameId;
	public String pwd;
	
	public PLoginVO(byte[] bytes)
	{		
		ByteArray ba = new ByteArray(bytes);
		this.gameId = ba.readInt();
		pwd = ba.readUTFString();
	}
}
