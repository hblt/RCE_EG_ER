/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import cl.hblt.models.Menu;
import cl.hblt.models.Usuario;
import cl.hblt.sessions.MenuFacade;
import cl.hblt.sessions.MenuFacadeLocal;
import cl.hblt.sessions.UsuarioFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

/**
 * @author Emanuel Roco
 * @correo emanuelroco@gmail.com
 **/
@ManagedBean
@RequestScoped
public class DesktopBean {
    
    @EJB
    private MenuFacadeLocal menuFacadeLocal;
    private List<Menu> menu;
    
    private List<Usuario> usuario;
    private UsuarioFacadeLocal usuarioFacadeLocal;
    
    private MenuModel menuBar;
    
    private DialogBean  dialogBean;

    
    public DesktopBean()  {
      dialogBean= new DialogBean();
        /*
        //Obtengo un usuario del sistema para remplazar el session si llega algo pasa el login. si no se va index nuevamente.
        this.usuario = new ArrayList<Usuario>();
        usuarioFacadeLocal = new UsuarioFacade();
        usuario = usuarioFacadeLocal.findAll();
        if( usuario != null){*/
            
            this.menu = new ArrayList<Menu>();
            menuFacadeLocal = new MenuFacade(); 
        /* 
        }else{
            
            FacesContext contenido = FacesContext.getCurrentInstance();
            HttpServletRequest request2 = (HttpServletRequest) contenido.getExternalContext().getRequest();
            contenido.getExternalContext().redirect(request2.getContextPath() + "/index.xhtml");
            
        }  
        */
    }
    public List<Menu> getMenu(){
        //Obtengo todos los menu de la base de datos.
        this.menu = menuFacadeLocal.findAll();
        return menu;
    }
    public MenuModel getMenuBar() {
        //creo el menu bar que se visualiza arriba en el escriorio
        menuBar = new DefaultMenuModel();
        //obtengo todos los menus
        List<Menu> menu = this.getMenu();
        //genero el primer submenu LLamado Inicio para emular el de Window
        DefaultSubMenu inicio = new DefaultSubMenu();
        //Agrego el icono de window
        inicio.setIcon("ui-icon-window");
        
        //creo los menus padres e hijos. FALTA QUE SEA DINAMICO PARA MAS DE 3 SUB MENUS
        if(!menu.isEmpty()){           
            for (Menu m : menu) { 
                if(m.getIdMenupadre() == 0){
                    //creo el menu padre
                    DefaultSubMenu subMenu = new DefaultSubMenu(m.getMenuNombre());
                    inicio.addElement(subMenu);
                    for (Menu m2 : menu) {
                        if(m.getIdMenu() == m2.getIdMenupadre()) {
                            DefaultMenuItem menuItem = new DefaultMenuItem(m2.getMenuNombre());
                            String command = String.format("#{dialogBean.open('%s')}", m2.getMenuUrl());
                            menuItem.setCommand(command);
                            //menuItem.setOnclick("alert('"+m2.getMenuUrl()+"');");
                            //menuItem.setHref(m2.getMenuUrl());
                            
                            menuItem.setAjax(true);
                            menuItem.setRendered(true);
                            subMenu.addElement(menuItem);
                            
                        }
                    } 
                }
            }
        }
        menuBar.addElement(inicio);
        menuBar.generateUniqueIds();
        return menuBar;
    }

  public DialogBean getDialogBean() {
    return dialogBean;
  }

  public void setDialogBean(DialogBean dialogBean) {
    this.dialogBean = dialogBean;
  }
}