/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.Cargo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface CargoFacadeLocal {

  void create(Cargo cargo);

  void edit(Cargo cargo);

  void remove(Cargo cargo);

  Cargo find(Object id);

  List<Cargo> findAll();

  List<Cargo> findRange(int[] range);

  int count();
  
}
