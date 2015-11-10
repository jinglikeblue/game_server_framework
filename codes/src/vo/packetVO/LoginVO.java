package vo.packetVO;

import core.net.server.ByteArray;


public class LoginVO
{
	public int gameId;
	public String pwd;
	
	public LoginVO(byte[] bytes)
	{		
		ByteArray ba = new ByteArray(bytes);
		this.gameId = ba.readInt();
		pwd = ba.readUTFString();
	}
}
