/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.atenciontickets.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "at_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtDepartamento.findAll", query = "SELECT a FROM AtDepartamento a")
    , @NamedQuery(name = "AtDepartamento.findByDepartamentoId", query = "SELECT a FROM AtDepartamento a WHERE a.departamentoId = :departamentoId")
    , @NamedQuery(name = "AtDepartamento.findByNombre", query = "SELECT a FROM AtDepartamento a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AtDepartamento.findByTelefono", query = "SELECT a FROM AtDepartamento a WHERE a.telefono = :telefono")})
public class AtDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "departamento_id")
    private Integer departamentoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 25)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atDepartamento")
    private List<AtUsuario> atUsuarioList;

    public AtDepartamento() {
    }

    public AtDepartamento(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public AtDepartamento(Integer departamentoId, String nombre) {
        this.departamentoId = departamentoId;
        this.nombre = nombre;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<AtUsuario> getAtUsuarioList() {
        return atUsuarioList;
    }

    public void setAtUsuarioList(List<AtUsuario> atUsuarioList) {
        this.atUsuarioList = atUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departamentoId != null ? departamentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtDepartamento)) {
            return false;
        }
        AtDepartamento other = (AtDepartamento) object;
        if ((this.departamentoId == null && other.departamentoId != null) || (this.departamentoId != null && !this.departamentoId.equals(other.departamentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtDepartamento[ departamentoId=" + departamentoId + " ]";
    }
    
}
