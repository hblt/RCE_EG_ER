package cl.hblt.beans;

import cl.hblt.models.Usuario;
import cl.hblt.security.UsuarioLoginBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;



/**
 * @author Edwin Guaman
 * @version 1.0
 **/
@ManagedBean
@RequestScoped
public class DesktopBean {
  private MenuModel menuModel;
  private Usuario user;
  
  public DesktopBean() {
    user = UsuarioLoginBean.getINSTANCE().getUsuarioLogin();
    System.out.println(user.getUsuaName());
  }
  
  
  /*@PostConstruct
  public void init() {
    menuModel = new DefaultMenuModel();

    //First submenu
    DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

    DefaultMenuItem item = new DefaultMenuItem("External");
    item.setUrl("http://www.primefaces.org");
    item.setIcon("ui-icon-home");
    firstSubmenu.addElement(item);

    menuModel.addElement(firstSubmenu);

    //Second submenu
    DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

    item = new DefaultMenuItem("Save");
    item.setIcon("ui-icon-disk");
    item.setCommand("#{desktopBean.save}");
    item.setUpdate("messages");
    secondSubmenu.addElement(item);

    item = new DefaultMenuItem("Delete");
    item.setIcon("ui-icon-close");
    item.setCommand("#{desktopBean.delete}");
    item.setAjax(false);
    secondSubmenu.addElement(item);

    item = new DefaultMenuItem("Redirect");
    item.setIcon("ui-icon-search");
    item.setCommand("#{desktopBean.redirect}");
    secondSubmenu.addElement(item);

    menuModel.addElement(secondSubmenu);
  }

  public MenuModel getModel() {
      return menuModel;
  }  

  public void save() {
      RequestContext.getCurrentInstance().openDialog("pagina", null, null);   
  }

  public void update() {
      addMessage("Success", "Data updated");
  }

  public void delete() {
      addMessage("Success", "Data deleted");
      
  }

  public void addMessage(String summary, String detail) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    FacesContext.getCurrentInstance().addMessage(null, message); 
  }*/

  public Usuario getUser() {
    return user;
  }

  public void setUser(Usuario user) {
    this.user = user;
  }
}
