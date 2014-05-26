/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import cl.hblt.models.Usuario;
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
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Usuario> usuario;
    
    public UsuarioBean() {
        this.usuario = new ArrayList<Usuario>();
        usuarioFacadeLocal = new UsuarioFacade();
    }

    public List<Usuario> getUsuario() {
        this.usuario = usuarioFacadeLocal.findAll();
        return usuario;
    }
}
