/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.Comuna;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Edwin Guaman
 */
@Stateless
public class ComunaFacade extends AbstractFacade<Comuna> implements ComunaFacadeLocal {
  @PersistenceContext(unitName = "cl.hblt_RCE-ejb_ejb_1.0PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ComunaFacade() {
    super(Comuna.class);
  }
  
}
