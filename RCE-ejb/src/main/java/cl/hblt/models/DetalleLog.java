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
@Table(name = "DetalleLog")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "DetalleLog.findAll", query = "SELECT d FROM DetalleLog d"),
  @NamedQuery(name = "DetalleLog.findByIdDetallelog", query = "SELECT d FROM DetalleLog d WHERE d.idDetallelog = :idDetallelog"),
  @NamedQuery(name = "DetalleLog.findByDeloCampo", query = "SELECT d FROM DetalleLog d WHERE d.deloCampo = :deloCampo"),
  @NamedQuery(name = "DetalleLog.findByDeloValor", query = "SELECT d FROM DetalleLog d WHERE d.deloValor = :deloValor")})
public class DetalleLog implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_detallelog")
  private Integer idDetallelog;
  @Size(max = 256)
  @Column(name = "delo_campo")
  private String deloCampo;
  @Size(max = 2147483647)
  @Column(name = "delo_valor")
  private String deloValor;
  @OneToMany(mappedBy = "idDetallelog")
  private Collection<Log> logCollection;

  public DetalleLog() {
  }

  public DetalleLog(Integer idDetallelog) {
    this.idDetallelog = idDetallelog;
  }

  public Integer getIdDetallelog() {
    return idDetallelog;
  }

  public void setIdDetallelog(Integer idDetallelog) {
    this.idDetallelog = idDetallelog;
  }

  public String getDeloCampo() {
    return deloCampo;
  }

  public void setDeloCampo(String deloCampo) {
    this.deloCampo = deloCampo;
  }

  public String getDeloValor() {
    return deloValor;
  }

  public void setDeloValor(String deloValor) {
    this.deloValor = deloValor;
  }

  @XmlTransient
  public Collection<Log> getLogCollection() {
    return logCollection;
  }

  public void setLogCollection(Collection<Log> logCollection) {
    this.logCollection = logCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idDetallelog != null ? idDetallelog.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DetalleLog)) {
      return false;
    }
    DetalleLog other = (DetalleLog) object;
    if ((this.idDetallelog == null && other.idDetallelog != null) || (this.idDetallelog != null && !this.idDetallelog.equals(other.idDetallelog))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "cl.hblt.models.DetalleLog[ idDetallelog=" + idDetallelog + " ]";
  }
  
}
