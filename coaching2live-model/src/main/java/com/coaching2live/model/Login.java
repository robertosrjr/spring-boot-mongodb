package com.coaching2live.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.coaching2live.model.enums.OrigemLoginEnum;
import com.coaching2live.model.enums.SistemaOperacionalEnum;

@Document(collection = "login")
public class Login extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8831077180857837392L;

	@DBRef private Pessoa pessoa;
	private String pushId;
	private Date dataLogin;
	private OrigemLoginEnum origemLogin;
	private SistemaOperacionalEnum sistemaOperacional;

	public Login() {

	}

	public Login(Pessoa pessoa) {

		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getPushId() {
		return pushId;
	}
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}
	public Date getDataLogin() {
		return dataLogin;
	}
	public void setDataLogin(Date dataLogin) {
		this.dataLogin = dataLogin;
	}
	public OrigemLoginEnum getOrigemLogin() {
		return origemLogin;
	}
	public void setOrigemLogin(OrigemLoginEnum origemLogin) {
		this.origemLogin = origemLogin;
	}
	public SistemaOperacionalEnum getSistemaOperacional() {
		return sistemaOperacional;
	}
	public void setSistemaOperacional(SistemaOperacionalEnum sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
}
