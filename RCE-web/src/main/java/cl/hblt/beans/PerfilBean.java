/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import cl.hblt.models.Perfil;
import cl.hblt.models.Usuario;
import cl.hblt.sessions.PerfilFacade;
import cl.hblt.sessions.PerfilFacadeLocal;
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
 **/
@ManagedBean
@RequestScoped
public class PerfilBean {

    @EJB
    private PerfilFacadeLocal perfilFacadeLocal;
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Perfil> perfil;
    private List<Usuario> usuario;
    private Usuario selectedUsuario;
    
    public PerfilBean() {
        this.perfil = new ArrayList<Perfil>();
        perfilFacadeLocal = new PerfilFacade();
        
        this.usuario = new ArrayList<Usuario>();
        usuarioFacadeLocal = new UsuarioFacade();
    }
    public List<Perfil> getPerfil() {
        //Obtengo todos los perfiles para cargar el comboBox
        this.perfil = perfilFacadeLocal.findAll();
        return perfil;
    }
    public List<Usuario> getUsuario() {
        //Obtengo a todos los Usuario del sistema
        this.usuario = usuarioFacadeLocal.findAll();
        return usuario;
    }
    public Usuario getSelectedUsuario() {
        //Obtengo al usuario selecionado en el DataTable
        return selectedUsuario;
    }
    public void setSelectedUsuario(Usuario selectedUsuario) {
        //seteo el usuario selecionado e el datatable
        this.selectedUsuario = selectedUsuario;
    }   
}
