package com.mealservice.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: azim
 * Date: 3/25/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginFilter implements Filter {

    private FilterConfig filterConfig;
    //static Logger log = Logger.getLogger(LoginFilter.class.getName());

    @Override
    public void destroy() {

       //log.info(filterConfig.getFilterName() +  " destroyed.");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest)req).getSession();
        String requestedUri = ((HttpServletRequest)req).getRequestURI();

        if(session == null || session.getAttribute("user") == null)
        {
            if(requestedUri.contains("add")|| requestedUri.contains("show") || requestedUri.contains("logout"))
            {
                ((HttpServletResponse)resp).sendRedirect("login.xhtml");
            }
            else
            {
                chain.doFilter(req, resp);
            }

        }
        else if(session != null && session.getAttribute("user") != null)
        {
            if(requestedUri.contains("login") || requestedUri.contains("index"))
            {
                ((HttpServletResponse)resp).sendRedirect("show_assign_meal.xhtml");
            }
            else
            {
                chain.doFilter(req, resp);
            }
        }
        else
        {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

        this.filterConfig = config;
        //log.info(filterConfig.getFilterName() + " initialized.");
    }

}
