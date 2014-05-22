/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Emanuel Roco
 * @correo emanuelroco@gmail.com
 **/
@ManagedBean
@RequestScoped
public class RedirectBean {

    /**
     * Creates a new instance of RedirectBean
     */
    public RedirectBean() {
    }

    public void redirectLogin(ActionEvent evt) throws IOException{
        
        FacesContext contenido = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) contenido.getExternalContext().getRequest();
        contenido.getExternalContext().redirect(request.getContextPath() + "/index.xhtml");

    }
}
