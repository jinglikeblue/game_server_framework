
package vo.protocolVO.s2c;

import core.net.server.utils.Serialize;

public class PPlayerInfoVO
{

	public int seat = 0;

	public int gameId = 0;

	public String name;

	public PPlayerInfoVO(int seat, int gameId, String name)
	{
		this.seat = seat;
		this.gameId = gameId;
		this.name = name;
	}

	public byte[] toBytes()
	{
		Serialize s = new Serialize();
		s.writeInt(seat);
		s.writeInt(gameId);
		s.writeUTFString(name);
		return s.toBytes();
	}
}
