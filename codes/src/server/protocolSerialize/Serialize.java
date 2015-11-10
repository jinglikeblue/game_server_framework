package server.protocolSerialize;

import java.io.UnsupportedEncodingException;

import core.net.server.Console;


public class Serialize
{
	/**
	 * 登陆返回
	 * @param error
	 * @return
	 */
	static public byte[] loginResponse(byte error)
	{
		byte[] b = {error};
		return b;
	}
	
	/**
	 * 用户信息
	 * @param error
	 * @return
	 */
	static public byte[] playerInfo(String name)
	{
		byte[] b = null;
		try
		{
			b = name.getBytes("UTF-8");
		}
		catch(UnsupportedEncodingException e)
		{
			Console.log.error(name);
		}		 
		return b;
	}	
	
	/**
	 * 心跳返回
	 * @param error
	 * @return
	 */
//	static public byte[] pingResponse(int serverUTC)
//	{
//		
//	}
}
