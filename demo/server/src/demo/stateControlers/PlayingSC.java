
package demo.stateControlers;

import demo.Game;
import demo.consts.ErrorCode;
import model.Player;

public class PlayingSC extends AControler
{

	public PlayingSC(Game game)
	{
		super(game);

	}

	@Override
	public ErrorCode playerEnter(Player player)
	{

		return ErrorCode.GAME_ENTER_FAIL_NOT_FREE;
	}

	@Override
	public ErrorCode playerExit(Player player, int seat)
	{

		return ErrorCode.GAME_EXIT_FAIL_PLAYING;
	}

	@Override
	public void update()
	{

	}

}
