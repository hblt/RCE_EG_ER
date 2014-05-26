/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import cl.hblt.models.Menu;
import cl.hblt.models.Perfil;
import cl.hblt.models.Usuario;
import cl.hblt.models.UsuarioPerfil;
import cl.hblt.sessions.MenuFacade;
import cl.hblt.sessions.MenuFacadeLocal;
import cl.hblt.sessions.MenuPerfilFacadeLocal;
import cl.hblt.sessions.PerfilFacade;
import cl.hblt.sessions.PerfilFacadeLocal;
import cl.hblt.sessions.UsuarioFacade;
import cl.hblt.sessions.UsuarioFacadeLocal;
import cl.hblt.sessions.UsuarioPerfilFacade;
import cl.hblt.sessions.UsuarioPerfilFacadeLocal;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * @author Emanuel Roco
 * @correo emanuelroco@gmail.com
 **/
@ManagedBean
@RequestScoped
public class UsuarioPerfilMenuBean {

    @EJB
    private PerfilFacadeLocal perfilFacadeLocal;
    private List<Perfil> perfil;
    private Perfil selectedPerfil;
    private String stringPerfil;
    private Perfil perfiles;
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private List<Usuario> usuario;
    private Usuario selectedUsuario;
    
    @EJB
    private UsuarioPerfilFacadeLocal usuarioPerfilFacadeLocal;
    
    @EJB
    private MenuFacadeLocal menuFacadeLocal;
    private List<Menu> menu;
    private Menu menus;
    
    public UsuarioPerfilMenuBean() {
        
        perfilFacadeLocal = new PerfilFacade();
        this.perfil = new ArrayList<Perfil>();
        
        usuarioFacadeLocal = new UsuarioFacade();
        this.usuario = new ArrayList<Usuario>();
        
        menuFacadeLocal = new MenuFacade();
        this.menu = new ArrayList<Menu>();
        
    }
    public void btnCreateUsuarioPerfil(ActionEvent actionEvent){
        System.out.println("idPerfil "+selectedPerfil.getIdPerfil());
        System.out.println("usuaname "+selectedUsuario.getUsuaName());
        
        UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
        usuarioPerfil.setPerfil(selectedPerfil);
        usuarioPerfil.setUsuario(selectedUsuario);
        usuarioPerfilFacadeLocal.create(usuarioPerfil);
        /*
        String msg;
        if(){
            msg = "Se creo correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
            FacesContext.getCurrentInstance().addMessage(null,message);
        }
        else{
            msg = "Error al crear el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
            FacesContext.getCurrentInstance().addMessage(null,message);
        }   
        */    
    }
    
    /*Getter y Setter*/
    public Menu getMenus() {
        return menus;
    }
    public void setMenus(Menu menus) {
        this.menus = menus;
    }
    
    public List<Menu> getMenu() {
        this.menu = menuFacadeLocal.findAll();
        return menu;
    }
    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
    
    public Perfil getPerfiles() {
        return perfiles;
    }
    public void setPerfiles(Perfil perfiles) {
        this.perfiles = perfiles;
    }
    
    public List<Perfil> getPerfil() {
        //Obtengo todos los perfiles para cargar el comboBox
        this.perfil = perfilFacadeLocal.findAll();
        return perfil;
    }
    public void setPerfil(List<Perfil> perfil) {
        this.perfil = perfil;
    }
    
    public List<Usuario> getUsuario() {
        //Obtengo a todos los Usuario del sistema
        this.usuario = usuarioFacadeLocal.findAll();
        return usuario;
    }
    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getSelectedUsuario() {
        //Obtengo al usuario selecionado en el DataTable
        return selectedUsuario;
    }
    public void setSelectedUsuario(Usuario selectedUsuario) {
        //seteo el usuario selecionado e el datatable
        this.selectedUsuario = selectedUsuario;
    }
    
    public Perfil getSelectedPerfil() {
        return selectedPerfil;
    }
    public void setSelectedPerfil(Perfil selectedPerfil) {
        this.selectedPerfil = selectedPerfil;
    }
    
    public String getStringPerfil() {
        return stringPerfil;
    }
    public void setStringPerfil(String stringPerfil) {
        this.stringPerfil = stringPerfil;
    }
     
  
    
}
