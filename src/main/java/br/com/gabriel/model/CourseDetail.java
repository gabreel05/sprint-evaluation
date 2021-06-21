package br.com.gabriel.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CourseDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CourseDetailPK courseDetailPK;

	public CourseDetailPK getCourseDetailPK() {
		return courseDetailPK;
	}

	public void setCourseDetailPK(CourseDetailPK courseDetailPK) {
		this.courseDetailPK = courseDetailPK;
	}

}
