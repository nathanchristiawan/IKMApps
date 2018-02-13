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
@Table(name = "answer_all")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnswerAll.findAll", query = "SELECT a FROM AnswerAll a")
    , @NamedQuery(name = "AnswerAll.findByIdAnswAll", query = "SELECT a FROM AnswerAll a WHERE a.idAnswAll = :idAnswAll")
    , @NamedQuery(name = "AnswerAll.findByAnswerAll", query = "SELECT a FROM AnswerAll a WHERE a.answerAll = :answerAll")})
public class AnswerAll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_answ_all")
    private Integer idAnswAll;
    @Column(name = "answer_all")
    private Integer answerAll;
    @JoinColumn(name = "nores", referencedColumnName = "nores")
    @ManyToOne(fetch = FetchType.LAZY)
    private Responden nores;
    @JoinColumn(name = "id_qall", referencedColumnName = "id_qall")
    @ManyToOne(fetch = FetchType.LAZY)
    private Qall idQall;

    public AnswerAll() {
    }

    public AnswerAll(Integer idAnswAll) {
        this.idAnswAll = idAnswAll;
    }

    public Integer getIdAnswAll() {
        return idAnswAll;
    }

    public void setIdAnswAll(Integer idAnswAll) {
        this.idAnswAll = idAnswAll;
    }

    public Integer getAnswerAll() {
        return answerAll;
    }

    public void setAnswerAll(Integer answerAll) {
        this.answerAll = answerAll;
    }

    public Responden getNores() {
        return nores;
    }

    public void setNores(Responden nores) {
        this.nores = nores;
    }

    public Qall getIdQall() {
        return idQall;
    }

    public void setIdQall(Qall idQall) {
        this.idQall = idQall;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnswAll != null ? idAnswAll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnswerAll)) {
            return false;
        }
        AnswerAll other = (AnswerAll) object;
        if ((this.idAnswAll == null && other.idAnswAll != null) || (this.idAnswAll != null && !this.idAnswAll.equals(other.idAnswAll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ikm.model.AnswerAll[ idAnswAll=" + idAnswAll + " ]";
    }
    
}
