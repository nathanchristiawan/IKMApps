/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ikm.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author user
 */
@Entity
@Table(name = "loket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loket.findAll", query = "SELECT l FROM Loket l")
    , @NamedQuery(name = "Loket.findByIdloket", query = "SELECT l FROM Loket l WHERE l.idloket = :idloket")
    , @NamedQuery(name = "Loket.findByNama", query = "SELECT l FROM Loket l WHERE l.nama = :nama")})
public class Loket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idloket")
    private String idloket;
    @Size(max = 50)
    @Column(name = "nama")
    private String nama;
    @OneToMany(mappedBy = "idloket", fetch = FetchType.LAZY)
    private List<AnswerLoket> answerLoketList;

    public Loket() {
    }

    public Loket(String idloket) {
        this.idloket = idloket;
    }

    public String getIdloket() {
        return idloket;
    }

    public void setIdloket(String idloket) {
        this.idloket = idloket;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @XmlTransient
    public List<AnswerLoket> getAnswerLoketList() {
        return answerLoketList;
    }

    public void setAnswerLoketList(List<AnswerLoket> answerLoketList) {
        this.answerLoketList = answerLoketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idloket != null ? idloket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loket)) {
            return false;
        }
        Loket other = (Loket) object;
        if ((this.idloket == null && other.idloket != null) || (this.idloket != null && !this.idloket.equals(other.idloket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ikm.model.Loket[ idloket=" + idloket + " ]";
    }
    
}
