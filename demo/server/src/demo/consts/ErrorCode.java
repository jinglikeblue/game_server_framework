package demo.consts;

/**
 * 错误码
 * @author Jing
 *
 */
public enum ErrorCode
{
	/**
	 * 无错误
	 */
	NONE,
	
	/**
	 * 未定义的错误
	 */
	UNDEFINED_ERROR,
	
	/**
	 * 游戏进入失败(人满)
	 */
	GAME_ENTER_FAIL_FULL,
	
	/**
	 * 游戏进入失败(不是空闲)
	 */
	GAME_ENTER_FAIL_NOT_FREE,
	
	/**
	 * 游戏退出失败(游戏进行中)
	 */
	GAME_EXIT_FAIL_PLAYING,
}
