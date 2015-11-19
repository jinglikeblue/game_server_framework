
package demo.stateControlers;

import demo.Game;
import demo.consts.ErrorCode;
import model.Player;

public class ReadySC extends AControler
{

	public ReadySC(Game game)
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

		return ErrorCode.NONE;
	}

	@Override
	public void update()
	{

	}

}
