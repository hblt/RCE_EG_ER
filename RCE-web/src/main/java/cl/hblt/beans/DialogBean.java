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
  public Integer width= 1280;
  public Integer height= 600;
  public Boolean truee = true;
  public Boolean falsee = false;
 
  
  public DialogBean() {
    propierties = new HashMap<String, Object>();
    propierties.put("maximizable", truee);
    propierties.put("minimizable", truee);
    propierties.put("closable",truee);
    propierties.put("width", width);
    propierties.put("height", height);
    propierties.put("contentWidth", width);
    propierties.put("contentHeight", height);
  }
  
  public void getOpen(String nombreVentana){
    System.out.println("NombreVentana"+RequestContext.getCurrentInstance().toString()+nombreVentana);
    RequestContext.getCurrentInstance().openDialog(nombreVentana, propierties, null);
  }
  
  public void getNewDialog(String nombreVentana){
    System.out.println("NombreVentana"+RequestContext.getCurrentInstance().toString()+nombreVentana);
    propierties.put("modal", truee);
    RequestContext.getCurrentInstance().openDialog(nombreVentana, propierties, null);
  }
}
