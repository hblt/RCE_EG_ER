/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import cl.hblt.models.Usuario;
import cl.hblt.sessions.UsuarioFacade;
import cl.hblt.sessions.UsuarioFacadeLocal;
import cl.hblt.utitities.CadenasRCE;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Edwin Guaman
 */
@ManagedBean
@RequestScoped
public class LoginBean {
  @EJB
  private final UsuarioFacadeLocal usuarioFacade;
  private Usuario usuario;

  /***
   * 
   * @param evt
   * @throws IOException 
   */
  public void setLogin(ActionEvent evt) throws IOException{
    FacesContext contenido = FacesContext.getCurrentInstance();
    ExternalContext extcontenido = contenido.getExternalContext();
    HttpServletRequest request = (HttpServletRequest) contenido.getExternalContext().getRequest();
    Usuario rs= usuarioFacade.login(usuario);
    if(rs != null){
      contenido.getExternalContext().redirect(request.getContextPath() + "/views/desktop.xhtml");
      extcontenido.getSessionMap().put(CadenasRCE.LOGIN_USER.toString(), usuario);
    }else{
      contenido.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Verificar Datos Ingresados"));
    }
  }
  
  public LoginBean() {
    usuario = new Usuario();
    usuarioFacade = new UsuarioFacade();
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
