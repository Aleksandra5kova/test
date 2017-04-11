package musala.schoolapp.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "school")
public class School {

	@Id
	@GeneratedValue
	@Column(name = "school_id")
	private Integer id;

	@NotNull
	@Column(name = "school_name", unique = true)
	private String name;

	@Column(name = "school_address")
	private String address;

	@Column(name = "school_phone")
	private String phone;

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("student_index")
	private Collection<Student> students = new ArrayList<Student>();

	public School() {
	}

	public School(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		String school = "School [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
		return school;
	}
}