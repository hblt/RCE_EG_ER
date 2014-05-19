/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.ClasificacionPrevision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface ClasificacionPrevisionFacadeLocal {

  void create(ClasificacionPrevision clasificacionPrevision);

  void edit(ClasificacionPrevision clasificacionPrevision);

  void remove(ClasificacionPrevision clasificacionPrevision);

  ClasificacionPrevision find(Object id);

  List<ClasificacionPrevision> findAll();

  List<ClasificacionPrevision> findRange(int[] range);

  int count();
  
}
