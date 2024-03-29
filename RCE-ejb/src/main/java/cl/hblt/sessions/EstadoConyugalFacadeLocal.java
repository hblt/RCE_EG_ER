/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.EstadoConyugal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface EstadoConyugalFacadeLocal {

  void create(EstadoConyugal estadoConyugal);

  void edit(EstadoConyugal estadoConyugal);

  void remove(EstadoConyugal estadoConyugal);

  EstadoConyugal find(Object id);

  List<EstadoConyugal> findAll();

  List<EstadoConyugal> findRange(int[] range);

  int count();
  
}
