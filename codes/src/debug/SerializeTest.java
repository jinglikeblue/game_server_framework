package debug;

import core.net.server.utils.ByteArray;
import core.net.server.utils.Serialize;


public class SerializeTest
{
	public SerializeTest()
	{
		Serialize s = new Serialize();
		s.writeByte((byte)1);
		s.writeInt(3);
		s.writeShort((short)2);		
		s.writeUTFString("jing");
		s.writeLong(4);
		byte[] b = s.toBytes();
		ByteArray ba = new ByteArray(b);
		System.out.println(ba.readByte());
		System.out.println(ba.readInt());
		System.out.println(ba.readShort());		
		System.out.println(ba.readUTFString());
		System.out.println(ba.readLong());		
	}
}
