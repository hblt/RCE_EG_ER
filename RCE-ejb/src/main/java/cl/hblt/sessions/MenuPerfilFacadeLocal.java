/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.MenuPerfil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface MenuPerfilFacadeLocal {

  void create(MenuPerfil menuPerfil);

  void edit(MenuPerfil menuPerfil);

  void remove(MenuPerfil menuPerfil);

  MenuPerfil find(Object id);

  List<MenuPerfil> findAll();

  List<MenuPerfil> findRange(int[] range);

  int count();
  
}
