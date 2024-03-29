/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.Paciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface PacienteFacadeLocal {

  void create(Paciente paciente);

  void edit(Paciente paciente);

  void remove(Paciente paciente);

  Paciente find(Object id);

  List<Paciente> findAll();

  List<Paciente> findRange(int[] range);

  int count();
  
}
