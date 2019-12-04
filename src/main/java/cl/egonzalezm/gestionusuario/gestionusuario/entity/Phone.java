package cl.egonzalezm.gestionusuario.gestionusuario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PHONE")
public class Phone {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@Column(name = "NUMBER")
	private String number;

	@Column(name = "CITY_CODE")
	private String citycode;

	@Column(name = "CONTRY_CODE")
	private String contrycode;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	@JsonIgnore
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
