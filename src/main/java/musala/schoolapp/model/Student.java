package musala.schoolapp.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer id;

	@NotNull
	@Column(name = "student_firstname")
	private String firstname;

	@NotNull
	@Column(name = "student_lastname")
	private String lastname;

	@NotNull
	@Column(name = "student_gender")
	private String gender;

	@NotNull
	@Column(name = "student_date_of_birth")
	private Date dateOfBirth;

	@Column(name = "student_city")
	private String city;

	@Column(name = "student_phone")
	private String phone;

	@NotNull
	@Column(name = "student_index", unique = true)
	private String index;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "school_id")
	private School school;

	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Subject> subjects = new ArrayList<Subject>();

	public Student() {
	}

	public Student(String firstname, String lastname, String gender, Date dateOfBirth, String phone, String city,
			String index) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.phone = phone;
		this.index = index;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Collection<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Collection<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String student = "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender="
				+ gender + ", city=" + city + ", dateOdBirth=" + df.format(dateOfBirth) + ", phone=" + phone
				+ ", index=" + index + ", school= " + (school != null ? school.getName() : null) + "]";
		return student;
	}

}
