/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.DetalleLog;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface DetalleLogFacadeLocal {

  void create(DetalleLog detalleLog);

  void edit(DetalleLog detalleLog);

  void remove(DetalleLog detalleLog);

  DetalleLog find(Object id);

  List<DetalleLog> findAll();

  List<DetalleLog> findRange(int[] range);

  int count();
  
}
