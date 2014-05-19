/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.sessions;

import cl.hblt.models.UsuarioPerfil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Edwin Guaman
 */
@Local
public interface UsuarioPerfilFacadeLocal {

  void create(UsuarioPerfil usuarioPerfil);

  void edit(UsuarioPerfil usuarioPerfil);

  void remove(UsuarioPerfil usuarioPerfil);

  UsuarioPerfil find(Object id);

  List<UsuarioPerfil> findAll();

  List<UsuarioPerfil> findRange(int[] range);

  int count();
  
}
