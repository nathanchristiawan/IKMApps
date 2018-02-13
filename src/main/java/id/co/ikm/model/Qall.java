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
@Table(name = "qall")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qall.findAll", query = "SELECT q FROM Qall q")
    , @NamedQuery(name = "Qall.findByIdQall", query = "SELECT q FROM Qall q WHERE q.idQall = :idQall")
    , @NamedQuery(name = "Qall.findByQuestion", query = "SELECT q FROM Qall q WHERE q.question = :question")})
public class Qall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id_qall")
    private String idQall;
    @Size(max = 200)
    @Column(name = "question")
    private String question;
    @OneToMany(mappedBy = "idQall", fetch = FetchType.LAZY)
    private List<AnswerAll> answerAllList;

    public Qall() {
    }

    public Qall(String idQall) {
        this.idQall = idQall;
    }

    public String getIdQall() {
        return idQall;
    }

    public void setIdQall(String idQall) {
        this.idQall = idQall;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @XmlTransient
    public List<AnswerAll> getAnswerAllList() {
        return answerAllList;
    }

    public void setAnswerAllList(List<AnswerAll> answerAllList) {
        this.answerAllList = answerAllList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQall != null ? idQall.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qall)) {
            return false;
        }
        Qall other = (Qall) object;
        if ((this.idQall == null && other.idQall != null) || (this.idQall != null && !this.idQall.equals(other.idQall))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ikm.model.Qall[ idQall=" + idQall + " ]";
    }
    
}
