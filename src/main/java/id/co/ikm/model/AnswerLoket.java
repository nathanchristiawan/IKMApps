/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ikm.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "answer_loket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnswerLoket.findAll", query = "SELECT a FROM AnswerLoket a")
    , @NamedQuery(name = "AnswerLoket.findByIdAnswLoket", query = "SELECT a FROM AnswerLoket a WHERE a.idAnswLoket = :idAnswLoket")
    , @NamedQuery(name = "AnswerLoket.findByAnswLoket", query = "SELECT a FROM AnswerLoket a WHERE a.answLoket = :answLoket")})
public class AnswerLoket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_answ_loket")
    private Integer idAnswLoket;
    @Column(name = "answ_loket")
    private Integer answLoket;
    @JoinColumn(name = "nores", referencedColumnName = "nores")
    @ManyToOne(fetch = FetchType.LAZY)
    private Responden nores;
    @JoinColumn(name = "idloket", referencedColumnName = "idloket")
    @ManyToOne(fetch = FetchType.LAZY)
    private Loket idloket;
    @JoinColumn(name = "id_qloket", referencedColumnName = "id_qloket")
    @ManyToOne(fetch = FetchType.LAZY)
    private Qloket idQloket;

    public AnswerLoket() {
    }

    public AnswerLoket(Integer idAnswLoket) {
        this.idAnswLoket = idAnswLoket;
    }

    public Integer getIdAnswLoket() {
        return idAnswLoket;
    }

    public void setIdAnswLoket(Integer idAnswLoket) {
        this.idAnswLoket = idAnswLoket;
    }

    public Integer getAnswLoket() {
        return answLoket;
    }

    public void setAnswLoket(Integer answLoket) {
        this.answLoket = answLoket;
    }

    public Responden getNores() {
        return nores;
    }

    public void setNores(Responden nores) {
        this.nores = nores;
    }

    public Loket getIdloket() {
        return idloket;
    }

    public void setIdloket(Loket idloket) {
        this.idloket = idloket;
    }

    public Qloket getIdQloket() {
        return idQloket;
    }

    public void setIdQloket(Qloket idQloket) {
        this.idQloket = idQloket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnswLoket != null ? idAnswLoket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnswerLoket)) {
            return false;
        }
        AnswerLoket other = (AnswerLoket) object;
        if ((this.idAnswLoket == null && other.idAnswLoket != null) || (this.idAnswLoket != null && !this.idAnswLoket.equals(other.idAnswLoket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ikm.model.AnswerLoket[ idAnswLoket=" + idAnswLoket + " ]";
    }
    
}
