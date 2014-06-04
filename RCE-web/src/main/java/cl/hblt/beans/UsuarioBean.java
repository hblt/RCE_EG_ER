/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import cl.hblt.models.Persona;
import cl.hblt.models.Usuario;
import cl.hblt.sessions.PersonaFacade;
import cl.hblt.sessions.PersonaFacadeLocal;
import cl.hblt.sessions.UsuarioFacade;
import cl.hblt.sessions.UsuarioFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Emanuel Roco
 * @correo emanuelroco@gmail.com
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {

  @EJB
  private final UsuarioFacadeLocal usuarioFacadeLocal;
  @EJB
  private final PersonaFacadeLocal personaFacadeLocal;
          
  private List<Usuario> usuarios;
  private Persona persona;
  private Usuario usuario;

  public UsuarioBean() {
      this.usuarios = new ArrayList<Usuario>();
      usuarioFacadeLocal = new UsuarioFacade();
      personaFacadeLocal = new PersonaFacade();
  }

  public List<Usuario> getLUsuario() {
      this.usuarios = usuarioFacadeLocal.findAllRelacionado();
      return usuarios;
  }

  public void save(){
    try {
      personaFacadeLocal.create(persona);
      usuarioFacadeLocal.create(usuario);
    } catch (Exception e) {
      
    }
  }

  public Persona getPersona() {
    if(persona==null){
      System.out.println("Se crea la instancia de la persona");
      persona= new Persona();
    }
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  public Usuario getUsuario() {
    if(usuario==null){
      System.out.println("Se crea la instancia del Usuario");
      usuario= new Usuario();
    }
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
