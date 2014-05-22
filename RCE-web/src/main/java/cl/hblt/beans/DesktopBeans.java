/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import cl.hblt.models.Menu;
import cl.hblt.sessions.MenuFacade;
import cl.hblt.sessions.MenuFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author cabldgti09
 */
@ManagedBean
@RequestScoped
public class DesktopBeans {
    
    @EJB
    private MenuFacadeLocal menuFacadeLocal;
    private List<Menu> menu;
    private PieChartModel chart;
    private MenuModel menuBar;


    public DesktopBeans() {
        this.menu = new ArrayList<Menu>();
        menuFacadeLocal = new MenuFacade();
        
        llenaChart();
    }

    public List<Menu> getMenu(){
        this.menu = menuFacadeLocal.findAll();
        return menu;
    }

    //MENU BAR
    private void llenaMenuBar(){
        System.out.println("Llegue a llenaMenuBar");
        
        /*
        DefaultSubMenu subMenu2 = new DefaultSubMenu("Pacientes");
        DefaultMenuItem menuItem2 = new DefaultMenuItem("Ingresar Pacientes");
        DefaultMenuItem menuItem3 = new DefaultMenuItem("Eliminar Pacientes");
        DefaultMenuItem menuItem4 = new DefaultMenuItem("Listar Pacientes");
        subMenu2.addElement(menuItem2);
        subMenu2.addElement(menuItem3);
        subMenu2.addElement(menuItem4);
        
        menuBar.addElement(subMenu2);
        menuBar.generateUniqueIds();
        */
    }
    public MenuModel getMenuBar() {
        menuBar = new DefaultMenuModel();
        List<Menu> menu = this.getMenu();
        
        DefaultSubMenu inicio = new DefaultSubMenu("Inicio");
        inicio.setIcon("ui-icon-window");
        if(!menu.isEmpty()){
            
            for (Menu m : menu) { 
                
                if(m.getIdMenupadre() == 0){
                    
                    //creo el menu padre
                    DefaultSubMenu subMenu = new DefaultSubMenu(m.getMenuNombre());
                    inicio.addElement(subMenu);
                    
                    for (Menu m2 : menu) {
                        if(m.getIdMenu() == m2.getIdMenupadre())
                        {
                            DefaultMenuItem menuItem = new DefaultMenuItem(m2.getMenuNombre());
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
    //FIN MENU BAR

    //CHART
    private void llenaChart(){
        System.out.println("Llegue a llenaChart");
        chart = new PieChartModel();
        chart.set("Me Gusta",900);
        chart.set("No me Gusta",100);
        chart.set("Me super agrada",1000);
        chart.set("Lo recomiendo",300);
    }   
    public PieChartModel getChart(){
        return chart;
    }
    //FIN CHART
}
