/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.security;


import cl.hblt.models.Usuario;
import cl.hblt.utilities.CadenasRCE;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Edwin Guaman
 */
public class UsuarioLoginBean {

  /**
   * Creates a new instance of UsuarioLoginBean
   */
  protected FacesContext contenido = FacesContext.getCurrentInstance();
  protected HttpServletResponse response = (HttpServletResponse) contenido.getExternalContext().getResponse();
  protected HttpServletRequest request = (HttpServletRequest) contenido.getExternalContext().getRequest();
  protected ExternalContext extcontenito = contenido.getExternalContext();
  private final Usuario user;
  private static UsuarioLoginBean INSTANCE = null;

  public static UsuarioLoginBean getINSTANCE() {
    if (INSTANCE==null) {
      INSTANCE= new UsuarioLoginBean();
    }
    return INSTANCE;
  }
  
  public UsuarioLoginBean() {
    user = (Usuario) ((HttpServletRequest)request).getSession().getAttribute(CadenasRCE.LOGIN_USER.toString());
  }
  
  public Usuario getUsuarioLogin(){
    return user;
  }
}
