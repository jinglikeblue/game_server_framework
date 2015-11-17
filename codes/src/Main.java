import server.GameServer;

public class Main
{

	public static void main(String[] args)
	{
		// new DaoTest();
		// new SerializeTest();

		GameServer g = new GameServer(null, null);
		g.start();
	}
}
