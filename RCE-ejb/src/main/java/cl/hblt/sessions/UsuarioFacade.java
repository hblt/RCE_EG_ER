/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edwin Guaman
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
  @PersistenceContext(unitName = "cl.hblt_RCE-ejb_ejb_1.0PU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public UsuarioFacade() {
    super(Usuario.class);
  }

  @Override
  public Usuario login(Usuario usuario) {
    try{
      Query query = em.createNamedQuery("Usuario.loginUsuario");
      query.setParameter("user", usuario.getUsuaName());
      query.setParameter("pass", usuario.getUsuaPass());
      Usuario u = (Usuario) query.getSingleResult();
      if(u==null){
        return null;
      }else{
        return u;
      }
    }catch (NoResultException nre){
    //Ignore this because as per your logic this is ok!
    }
    return null;
  }
}
