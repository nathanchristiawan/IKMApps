/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ikm.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "responden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responden.findAll", query = "SELECT r FROM Responden r")
    , @NamedQuery(name = "Responden.findByNores", query = "SELECT r FROM Responden r WHERE r.nores = :nores")
    , @NamedQuery(name = "Responden.findByTanggal", query = "SELECT r FROM Responden r WHERE r.tanggal = :tanggal")
    , @NamedQuery(name = "Responden.findByUmur", query = "SELECT r FROM Responden r WHERE r.umur = :umur")
    , @NamedQuery(name = "Responden.findByJk", query = "SELECT r FROM Responden r WHERE r.jk = :jk")
    , @NamedQuery(name = "Responden.findByPendidikan", query = "SELECT r FROM Responden r WHERE r.pendidikan = :pendidikan")
    , @NamedQuery(name = "Responden.findByPekerjaan", query = "SELECT r FROM Responden r WHERE r.pekerjaan = :pekerjaan")
    , @NamedQuery(name = "Responden.findByPeriode", query = "SELECT r FROM Responden r WHERE r.periode = :periode")})
public class Responden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nores")
    private Integer nores;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(name = "umur")
    private Integer umur;
    @Size(max = 10)
    @Column(name = "jk")
    private String jk;
    @Size(max = 50)
    @Column(name = "pendidikan")
    private String pendidikan;
    @Size(max = 50)
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Column(name = "periode")
    private Integer periode;
    @OneToMany(mappedBy = "nores", fetch = FetchType.LAZY)
    private List<AnswerAll> answerAllList;
    @OneToMany(mappedBy = "nores", fetch = FetchType.LAZY)
    private List<AnswerLoket> answerLoketList;

    public Responden() {
    }

    public Responden(Integer nores) {
        this.nores = nores;
    }

    public Integer getNores() {
        return nores;
    }

    public void setNores(Integer nores) {
        this.nores = nores;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public Integer getPeriode() {
        return periode;
    }

    public void setPeriode(Integer periode) {
        this.periode = periode;
    }

    @XmlTransient
    public List<AnswerAll> getAnswerAllList() {
        return answerAllList;
    }

    public void setAnswerAllList(List<AnswerAll> answerAllList) {
        this.answerAllList = answerAllList;
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
        hash += (nores != null ? nores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responden)) {
            return false;
        }
        Responden other = (Responden) object;
        if ((this.nores == null && other.nores != null) || (this.nores != null && !this.nores.equals(other.nores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ikm.model.Responden[ nores=" + nores + " ]";
    }
    
}
