/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.atenciontickets.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "at_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtTicket.findAll", query = "SELECT a FROM AtTicket a")
    , @NamedQuery(name = "AtTicket.findByTicketId", query = "SELECT a FROM AtTicket a WHERE a.ticketId = :ticketId")
    , @NamedQuery(name = "AtTicket.findByAsunto", query = "SELECT a FROM AtTicket a WHERE a.asunto = :asunto")
    , @NamedQuery(name = "AtTicket.findByDescripcion", query = "SELECT a FROM AtTicket a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "AtTicket.findByEstado", query = "SELECT a FROM AtTicket a WHERE a.estado = :estado")
    , @NamedQuery(name = "AtTicket.findByFechaCreacion", query = "SELECT a FROM AtTicket a WHERE a.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "AtTicket.findByFechaSolucion", query = "SELECT a FROM AtTicket a WHERE a.fechaSolucion = :fechaSolucion")})
public class AtTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_solucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atTicket")
    private List<AtBitacora> atBitacoraList;
    @JoinColumns({
        @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
        , @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")})
    @ManyToOne(optional = false)
    private AtCategoria atCategoria;
    @JoinColumns({
        @JoinColumn(name = "tecnico_id", referencedColumnName = "usuario_id")
        , @JoinColumn(name = "tecnico_id", referencedColumnName = "usuario_id")
        , @JoinColumn(name = "tecnico_id", referencedColumnName = "usuario_id")})
    @ManyToOne
    private AtUsuario atUsuario;
    @JoinColumns({
        @JoinColumn(name = "solicitante_id", referencedColumnName = "usuario_id")
        , @JoinColumn(name = "solicitante_id", referencedColumnName = "usuario_id")})
    @ManyToOne(optional = false)
    private AtUsuario atUsuario1;

    public AtTicket() {
    }

    public AtTicket(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public AtTicket(Integer ticketId, String asunto, String descripcion, Character estado, Date fechaCreacion) {
        this.ticketId = ticketId;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    @XmlTransient
    public List<AtBitacora> getAtBitacoraList() {
        return atBitacoraList;
    }

    public void setAtBitacoraList(List<AtBitacora> atBitacoraList) {
        this.atBitacoraList = atBitacoraList;
    }

    public AtCategoria getAtCategoria() {
        return atCategoria;
    }

    public void setAtCategoria(AtCategoria atCategoria) {
        this.atCategoria = atCategoria;
    }

    public AtUsuario getAtUsuario() {
        return atUsuario;
    }

    public void setAtUsuario(AtUsuario atUsuario) {
        this.atUsuario = atUsuario;
    }

    public AtUsuario getAtUsuario1() {
        return atUsuario1;
    }

    public void setAtUsuario1(AtUsuario atUsuario1) {
        this.atUsuario1 = atUsuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtTicket)) {
            return false;
        }
        AtTicket other = (AtTicket) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.com.kinal.tickets.model.AtTicket[ ticketId=" + ticketId + " ]";
    }
    
}
