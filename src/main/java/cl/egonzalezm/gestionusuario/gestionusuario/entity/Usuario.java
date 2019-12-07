package cl.egonzalezm.gestionusuario.gestionusuario.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cl.egonzalezm.gestionusuario.gestionusuario.constrain.PasswordConstrain;

@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = { "EMAIL" }))
public class Usuario {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	@Email
	private String email;

	@Column(name = "PASSWORD")
	@PasswordConstrain
	private String password;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Phone> phones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
