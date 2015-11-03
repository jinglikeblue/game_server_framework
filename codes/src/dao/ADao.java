package dao;

import interfaces.IDaoUser;


public class ADao
{
	protected IDaoUser _user;

	protected String _key;

	protected Object _data;
	
	public ADao(IDaoUser user, String key, Object data)
	{
		this._user = user;
		this._key = key;
		this._data = data;
	}
}
