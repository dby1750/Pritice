package service;

import dao.DBhelper;
import dao.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerService
{
    //展示
    public List<Player> getPlayer()
    {
        List<Player> players=new ArrayList<Player>();
        String sql="select * from player";
        System.out.println(sql);
        ResultSet res = DBhelper.executeQuery(sql);
        try
        {
            while (res.next())
            {
                Player player = new Player();
                player.setPlayerID(res.getInt("PlayerID"));
                player.setName(res.getString("Name"));
                player.setSex(res.getString("Sex"));
                player.setAge(res.getInt("Age"));
                player.setAddress(res.getString("Address"));
                players.add(player);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return players;
    }
    //查询
    public Player getPlayer(int PlayerID)
    {
        String sql="select * from player where PlayerID="+PlayerID;
        ResultSet res= DBhelper.executeQuery(sql);
        Player player=new Player();
        try
        {
            if (res.next())
            {
                player.setPlayerID(res.getInt("PlayerID"));
                player.setName(res.getString("Name"));
                player.setSex(res.getString("Sex"));
                player.setAge(res.getInt("Age"));
                player.setAddress(res.getString("Address"));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return player;
    }
    //删除
    public int delPlayer(int PlayerID)
    {
        String sql="delete from player where PlayerID="+PlayerID;
        int result= DBhelper.executeNonQuery(sql);
        return result;
    }

    //增加
    public int addPlayer(Player Player)
    {
        String sql="insert into player values("+Player.getPlayerID()+",'"+Player.getName()+"' ,'"+Player.getSex()+"' ,"+Player.getAge()+",'"+ Player.getAddress()+"')";
        System.out.println(sql);
        int result= DBhelper.executeNonQuery(sql);
        return result;
    }
    //修改
    public int updatePlayer(Player Player)
    {
        String sql="update player set PlayerID="+Player.getPlayerID()+",Name='"+Player.getName()+"' ,Sex='"+Player.getSex()+"' ,Age="+Player.getAge()+",Address='"+ Player.getAddress()+"'";
        int result= DBhelper.executeNonQuery(sql);
        return result;
    }
}
