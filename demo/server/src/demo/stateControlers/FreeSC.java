
package demo.stateControlers;

import demo.Game;
import demo.consts.ErrorCode;
import model.Player;

public class FreeSC extends AControler
{

	public FreeSC(Game game)
	{
		super(game);
	}

	@Override
	public ErrorCode playerEnter(Player player)
	{
		Player[] players = game.room().players();
		for(int seat = 0; seat < players.length; seat++)
		{
			if(null == players[seat])
			{
				game.room().onPlayerEnter(player, seat);
				return ErrorCode.NONE;
			}
		}
		return ErrorCode.GAME_ENTER_FAIL_FULL;
	}

	@Override
	public ErrorCode playerExit(Player player, int seat)
	{
		if(-1 == seat)
		{
			Player[] players = game.room().players();
			for(int i = 0; i < players.length; i++)
			{
				if(player == players[i])
				{
					seat = i;
					break;
				}
			}
		}

		game.room().onPlayerExit(player, seat);
		return ErrorCode.NONE;
	}

	@Override
	public void update()
	{

	}
}
