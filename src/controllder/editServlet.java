package controllder;

import dao.Player;
import service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editServlet", value = "/editServlet")
public class editServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PlayerService ps=new PlayerService();
        Player p=new Player();
        p=ps.getPlayer(Integer.parseInt(request.getParameter("PlayerID")));
        request.setAttribute("player",p);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }
}
