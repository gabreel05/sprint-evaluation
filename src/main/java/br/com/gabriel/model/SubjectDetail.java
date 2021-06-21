package br.com.gabriel.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class SubjectDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SubjectDetailPK subjectDetailPK;

	public SubjectDetailPK getSubjectDetailPK() {
		return subjectDetailPK;
	}

	public void setSubjectDetailPK(SubjectDetailPK subjectDetailPK) {
		this.subjectDetailPK = subjectDetailPK;
	}

}
