/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.security;

import cl.hblt.models.Usuario;
import cl.hblt.utilities.CadenasRCE;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edwin Guaman
 */
public class Filter implements javax.servlet.Filter{

  FilterConfig config;
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    config=filterConfig;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    Usuario u = (Usuario)((HttpServletRequest) request).getSession().getAttribute(CadenasRCE.LOGIN_USER.toString());
    if(u!=null){
      System.out.println("Usuario es:"+ u.getUsuaName());
      chain.doFilter(request, response);
    }else{
      System.out.println("Usuario es nulo");
      ((HttpServletResponse) response).sendRedirect("http://localhost:8080/RCE-web/index.xhtml");
    }
  }

  @Override
  public void destroy() {
    config = null;
  }
  
}
