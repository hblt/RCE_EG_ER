/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.Log;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface LogFacadeLocal {

  void create(Log log);

  void edit(Log log);

  void remove(Log log);

  Log find(Object id);

  List<Log> findAll();

  List<Log> findRange(int[] range);

  int count();
  
}
