/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.SubEspecialidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface SubEspecialidadFacadeLocal {

  void create(SubEspecialidad subEspecialidad);

  void edit(SubEspecialidad subEspecialidad);

  void remove(SubEspecialidad subEspecialidad);

  SubEspecialidad find(Object id);

  List<SubEspecialidad> findAll();

  List<SubEspecialidad> findRange(int[] range);

  int count();
  
}
