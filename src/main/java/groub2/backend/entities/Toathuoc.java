/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groub2.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "toathuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Toathuoc.findAll", query = "SELECT t FROM Toathuoc t"),
    @NamedQuery(name = "Toathuoc.findById", query = "SELECT t FROM Toathuoc t WHERE t.id = :id"),
    @NamedQuery(name = "Toathuoc.findByName", query = "SELECT t FROM Toathuoc t WHERE t.name = :name"),
    @NamedQuery(name = "Toathuoc.findByPhone", query = "SELECT t FROM Toathuoc t WHERE t.phone = :phone"),
    @NamedQuery(name = "Toathuoc.findByAddress", query = "SELECT t FROM Toathuoc t WHERE t.address = :address"),
    @NamedQuery(name = "Toathuoc.findBySymptom", query = "SELECT t FROM Toathuoc t WHERE t.symptom = :symptom"),
    @NamedQuery(name = "Toathuoc.findByDescription", query = "SELECT t FROM Toathuoc t WHERE t.description = :description"),
    @NamedQuery(name = "Toathuoc.findByState", query = "SELECT t FROM Toathuoc t WHERE t.state = :state"),
    @NamedQuery(name = "Toathuoc.findByCreateAt", query = "SELECT t FROM Toathuoc t WHERE t.createAt = :createAt")})
public class Toathuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "symptom")
    private String symptom;
    @Column(name = "description")
    private String description;
    @Column(name = "state")
    private Boolean state;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne
    private Doctor doctorId;
    @OneToMany(mappedBy = "toathuocId")
    @JsonIgnore
    private Collection<ToathuocDetails> toathuocDetailsCollection;

    public Toathuoc() {
    }

    public Toathuoc(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    @XmlTransient
    public Collection<ToathuocDetails> getToathuocDetailsCollection() {
        return toathuocDetailsCollection;
    }

    public void setToathuocDetailsCollection(Collection<ToathuocDetails> toathuocDetailsCollection) {
        this.toathuocDetailsCollection = toathuocDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Toathuoc)) {
            return false;
        }
        Toathuoc other = (Toathuoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "groub2.backend.entities.Toathuoc[ id=" + id + " ]";
    }
    
}
