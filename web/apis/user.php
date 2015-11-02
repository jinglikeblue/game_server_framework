<?php

class User
{
    /**
     * 用户登陆
     */
    public function register(&$params, &$res)
    {
        $id = mysql_escape_string($params->id);
        $name = mysql_escape_string($params->name);
        $pwd = mysql_escape_string($params->pwd);

        $result = $this->getPlayer($id);

        $player = null;
        if(0 == count($result))
        {
            //没有注册的ID
            if(true == $this->signUp($id, $pwd, $name))
            {
                //注册成功
                $player = $this->getPlayer($id)[0];
            }
//            else
//            {
//                //注册失败
//            }
        }
        else if($id == $result[0]["account"] && $pwd == $result[0]["pwd"])
        {
            //登陆成功,更新信息
            if(true == $this->update($result[0]["game_id"], $name))
            {
                //更新成功
                $player = $result[0];
            }
//            else
//            {
//                //更新失败
//            }
        }
//        else
//        {
//            //已被注册
//        }

        if(null == $player)
        {
            $res['error'] = 1;
            $res['msg'] = "登陆失败！";
        }
        else
        {
            $res['game_id'] = $player['game_id'];
        }
    }

    private function getPlayer($id)
    {
        $st = new SqlHelper();

        $sql = "SELECT game_id,account,pwd FROM tbl_player WHERE account='$id'";

        $st->conn();
        $result = $st->query($sql);
        $st->close();

        return $result;
    }

    private function signUp($account,$pwd,$player_name)
    {
        $st = new SqlHelper();

        $sql = "INSERT INTO tbl_player(account, pwd, player_name, regist_utc, regist_date, last_login_utc, last_login_date)
                VALUES('$account','$pwd','$player_name',unix_timestamp(now()), NOW() ,unix_timestamp(now()), NOW())";

        $st->conn();
        $result = $st->modify($sql);
        $st->close();

        return $result;
    }

    private function update($gameId, $player_name)
    {
        $st = new SqlHelper();

        $sql = "UPDATE tbl_player SET player_name='$player_name',last_login_utc=UNIX_TIMESTAMP(NOW()), last_login_date = NOW() WHERE game_id=$gameId";

        $st->conn();
        $result = $st->modify($sql);
        $st->close();

        return $result;
    }
}