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
@Table(name = "qloket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qloket.findAll", query = "SELECT q FROM Qloket q")
    , @NamedQuery(name = "Qloket.findByIdQloket", query = "SELECT q FROM Qloket q WHERE q.idQloket = :idQloket")
    , @NamedQuery(name = "Qloket.findByQuestionLoket", query = "SELECT q FROM Qloket q WHERE q.questionLoket = :questionLoket")})
public class Qloket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_qloket")
    private String idQloket;
    @Size(max = 200)
    @Column(name = "question_loket")
    private String questionLoket;
    @OneToMany(mappedBy = "idQloket", fetch = FetchType.LAZY)
    private List<AnswerLoket> answerLoketList;

    public Qloket() {
    }

    public Qloket(String idQloket) {
        this.idQloket = idQloket;
    }

    public String getIdQloket() {
        return idQloket;
    }

    public void setIdQloket(String idQloket) {
        this.idQloket = idQloket;
    }

    public String getQuestionLoket() {
        return questionLoket;
    }

    public void setQuestionLoket(String questionLoket) {
        this.questionLoket = questionLoket;
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
        hash += (idQloket != null ? idQloket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qloket)) {
            return false;
        }
        Qloket other = (Qloket) object;
        if ((this.idQloket == null && other.idQloket != null) || (this.idQloket != null && !this.idQloket.equals(other.idQloket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ikm.model.Qloket[ idQloket=" + idQloket + " ]";
    }
    
}
