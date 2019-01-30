package com.coaching2live.business.login.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.coaching2live.business.pessoa.dto.PessoaTO;
import com.coaching2live.business.to.BaseTO;
import com.coaching2live.model.enums.OrigemLoginEnum;
import com.coaching2live.model.enums.SistemaOperacionalEnum;

@Component
public class LoginTO extends BaseTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4665129507151523515L;
	private PessoaTO pessoa;
	private String pushId;
	private Date dataLogin;
	private OrigemLoginEnum origemLogin;
	private SistemaOperacionalEnum sistemaOperacional;

	public LoginTO() {

		this.pessoa = new PessoaTO();
	}

	public PessoaTO getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaTO pessoa) {
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
	@Override
	public String getId() {
		
		return super.id;
	}
	@Override
	public void setId(String id) {

		super.id = id;
	}
}
