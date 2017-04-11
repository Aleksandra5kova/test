package musala.schoolapp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({ @NamedQuery(name = "subject.listSubjects", query = "FROM Subject"),
		@NamedQuery(name = "subject.listSubjectsByStudent", query = "SELECT subject FROM Subject subject JOIN subject.students student WHERE student.id=:studentId") })

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private Integer id;

	@NotNull
	@Column(name = "subject_name", unique = true)
	private String name;

	@NotNull
	@Column(name = "subject_status")
	private String status;

	@Column(name = "subject_credits")
	private Integer credits;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "subject_student", joinColumns = { @JoinColumn(name = "subject_id") }, inverseJoinColumns = {
			@JoinColumn(name = "student_id") })
	private Collection<Student> students = new ArrayList<Student>();

	public Subject() {
	}

	public Subject(String name, String status, Integer credits) {
		this.name = name;
		this.status = status;
		this.credits = credits;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		String subject = "Subject [id=" + id + ", name= " + name + ", status= " + status + ", credits= " + credits
				+ "]";
		return subject;
	}
}
