/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.Region;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface RegionFacadeLocal {

  void create(Region region);

  void edit(Region region);

  void remove(Region region);

  Region find(Object id);

  List<Region> findAll();

  List<Region> findRange(int[] range);

  int count();
  
}
