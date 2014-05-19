/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.hblt.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edwin Guaman
 */
@Entity
@Table(name = "Prevision")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Prevision.findAll", query = "SELECT p FROM Prevision p"),
  @NamedQuery(name = "Prevision.findByIdPrevision", query = "SELECT p FROM Prevision p WHERE p.idPrevision = :idPrevision"),
  @NamedQuery(name = "Prevision.findByPrevNombre", query = "SELECT p FROM Prevision p WHERE p.prevNombre = :prevNombre")})
public class Prevision implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_prevision")
  private Integer idPrevision;
  @Size(max = 50)
  @Column(name = "prev_nombre")
  private String prevNombre;
  @OneToMany(mappedBy = "idPrevision")
  private Collection<ClasificacionPrevision> clasificacionPrevisionCollection;

  public Prevision() {
  }

  public Prevision(Integer idPrevision) {
    this.idPrevision = idPrevision;
  }

  public Integer getIdPrevision() {
    return idPrevision;
  }

  public void setIdPrevision(Integer idPrevision) {
    this.idPrevision = idPrevision;
  }

  public String getPrevNombre() {
    return prevNombre;
  }

  public void setPrevNombre(String prevNombre) {
    this.prevNombre = prevNombre;
  }

  @XmlTransient
  public Collection<ClasificacionPrevision> getClasificacionPrevisionCollection() {
    return clasificacionPrevisionCollection;
  }

  public void setClasificacionPrevisionCollection(Collection<ClasificacionPrevision> clasificacionPrevisionCollection) {
    this.clasificacionPrevisionCollection = clasificacionPrevisionCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPrevision != null ? idPrevision.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Prevision)) {
      return false;
    }
    Prevision other = (Prevision) object;
    if ((this.idPrevision == null && other.idPrevision != null) || (this.idPrevision != null && !this.idPrevision.equals(other.idPrevision))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.Prevision[ idPrevision=" + idPrevision + " ]";
  }
  
}
