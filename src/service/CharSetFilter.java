package service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName = "CharSetFilter")
public class CharSetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        CharacterRequest characterRequest = new CharacterRequest(request);
        filterChain.doFilter(characterRequest,response);
    }

    @Override
    public void destroy() {
    }
}

class CharacterRequest extends HttpServletRequestWrapper{

    private HttpServletRequest request;

    public CharacterRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        if (null == parameter){
            return null;
        }
        String method = super.getMethod();
        if ("get".equalsIgnoreCase(method)){
            try {
                parameter = new String(parameter.getBytes("iso-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return parameter;
    }
}
