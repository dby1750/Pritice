package controllder;

import dao.Player;
import service.PlayerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addServlet", value = "/addServlet")
public class addServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PlayerService ps=new PlayerService();
        Player p=new Player();
        p.setPlayerID(Integer.parseInt(request.getParameter("PlayerID")));
        p.setName(request.getParameter("Name"));
        p.setSex(request.getParameter("Sex"));
        p.setAge(Integer.parseInt(request.getParameter("Age")));
        p.setAddress(request.getParameter("Address"));
        ps.addPlayer(p);
        request.getRequestDispatcher("showServlet").forward(request,response);
        //this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       this.doGet(request,response);
    }
}
