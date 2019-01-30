package com.coaching2live.business.pessoa.dto;

import java.util.Collection;
import java.util.Date;

import com.coaching2live.business.to.BaseTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class PessoaTO extends BaseTO {

	private static final long serialVersionUID = 7872271349084641372L;
	private String cpf;
	private String nome;
	private String sobrenome;
	private String email;
	private Date dataNascimento;
	private Date dataCadastro;
	private String idSocialUsuario;
	private Integer ddi;
	private Integer ddd;
	private Long numeroTelefone;
	private String fotoPerfil;
	private String profissao;
	private String biografia;
	private Collection<String> hobbies;

	public PessoaTO() {

	}
	
	public PessoaTO(String id) {

		this.id = id;
	}

	@JsonInclude(Include.NON_NULL)	
	public String getCpf() {
		return cpf;
	}

	@JsonInclude(Include.NON_NULL)
	public String getNome() {
		return nome;
	}

	@JsonInclude(Include.NON_NULL)
	public String getSobrenome() {
		return sobrenome;
	}

	@JsonInclude(Include.NON_NULL)
	public String getEmail() {
		return email;
	}

	@JsonInclude(Include.NON_NULL)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@JsonInclude(Include.NON_NULL)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	@JsonInclude(Include.NON_NULL)
	public String getIdSocialUsuario() {
		return idSocialUsuario;
	}

	@JsonInclude(Include.NON_NULL)
	public Integer getDdi() {
		return ddi;
	}

	@JsonInclude(Include.NON_NULL)
	public Integer getDdd() {
		return ddd;
	}

	@JsonInclude(Include.NON_NULL)
	public Long getNumeroTelefone() {
		return numeroTelefone;
	}

	@JsonInclude(Include.NON_NULL)
	public String getFotoPerfil() {
		return fotoPerfil;
	}

	@JsonInclude(Include.NON_NULL)
	public String getProfissao() {
		return profissao;
	}

	@JsonInclude(Include.NON_NULL)
	public String getBiografia() {
		return biografia;
	}

	@JsonInclude(Include.NON_NULL)
	public Collection<String> getHobbies() {
		return hobbies;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setIdSocialUsuario(String idSocialUsuario) {
		this.idSocialUsuario = idSocialUsuario;
	}

	public void setDdi(Integer ddi) {
		this.ddi = ddi;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public void setNumeroTelefone(Long numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public void setHobbies(Collection<String> hobbies) {
		this.hobbies = hobbies;
	}


	
}
