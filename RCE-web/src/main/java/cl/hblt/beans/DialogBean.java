/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import java.util.HashMap;
import java.util.Map;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Edwin Guaman
 * 
 */
public class DialogBean {

  /**
   * Creates a new instance of DialogBean
   */
  Map<String, Object> propierties;
 
  
  public DialogBean() {
    propierties = new HashMap<String, Object>();
    propierties.put("resizable",true);
    propierties.put("visible", true);

  }
  
  public void open(String nombreVentana){
    System.out.println("llego aca: "+nombreVentana);
    RequestContext.getCurrentInstance().openDialog("pagina", propierties, null);
  }
  
  public void demo(){
    RequestContext.getCurrentInstance().openDialog("pagina", propierties, null);
  }
  
  public void demo1(){
    RequestContext.getCurrentInstance().openDialog("perfil", propierties, null);
  }
  
}
