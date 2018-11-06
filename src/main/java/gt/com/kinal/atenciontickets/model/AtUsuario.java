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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "at_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtUsuario.findAll", query = "SELECT a FROM AtUsuario a")
    , @NamedQuery(name = "AtUsuario.findByUsuarioId", query = "SELECT a FROM AtUsuario a WHERE a.usuarioId = :usuarioId")
    , @NamedQuery(name = "AtUsuario.findByNombre", query = "SELECT a FROM AtUsuario a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AtUsuario.findByEmail", query = "SELECT a FROM AtUsuario a WHERE a.email = :email")
    , @NamedQuery(name = "AtUsuario.findByPassword", query = "SELECT a FROM AtUsuario a WHERE a.password = :password")
    , @NamedQuery(name = "AtUsuario.findByRol", query = "SELECT a FROM AtUsuario a WHERE a.rol = :rol")})
public class AtUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol")
    private Character rol;
    @OneToMany(mappedBy = "atUsuario")
    private List<AtTicket> atTicketList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atUsuario1")
    private List<AtTicket> atTicketList1;
    @JoinColumns({
        @JoinColumn(name = "departamento_id", referencedColumnName = "departamento_id")
        , @JoinColumn(name = "departamento_id", referencedColumnName = "departamento_id")})
    @ManyToOne(optional = false)
    private AtDepartamento atDepartamento;

    public AtUsuario() {
    }

    public AtUsuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public AtUsuario(Integer usuarioId, String nombre, String email, String password, Character rol) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getRol() {
        return rol;
    }

    public void setRol(Character rol) {
        this.rol = rol;
    }

    @XmlTransient
    public List<AtTicket> getAtTicketList() {
        return atTicketList;
    }

    public void setAtTicketList(List<AtTicket> atTicketList) {
        this.atTicketList = atTicketList;
    }

    @XmlTransient
    public List<AtTicket> getAtTicketList1() {
        return atTicketList1;
    }

    public void setAtTicketList1(List<AtTicket> atTicketList1) {
        this.atTicketList1 = atTicketList1;
    }

    public AtDepartamento getAtDepartamento() {
        return atDepartamento;
    }

    public void setAtDepartamento(AtDepartamento atDepartamento) {
        this.atDepartamento = atDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtUsuario)) {
            return false;
        }
        AtUsuario other = (AtUsuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtUsuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
