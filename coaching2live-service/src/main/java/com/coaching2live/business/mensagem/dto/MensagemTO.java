package com.coaching2live.business.mensagem.dto;

import java.util.Date;

import com.coaching2live.business.objetivo.dto.ObjetivoTO;
import com.coaching2live.business.pessoa.profissional.dto.ProfissionalTO;
import com.coaching2live.business.to.BaseTO;

/**
 * @author rober
 *
 */
public class MensagemTO extends BaseTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7415112101014682231L;
	private String descricao;
	private boolean lida;
	private Date dataCadastro;
	private Date dataLeitura;
	private ProfissionalTO criador;
	private ObjetivoTO objetivo;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isLida() {
		return lida;
	}
	public void setLida(boolean lida) {
		this.lida = lida;
	}
	public Date getDataLeitura() {
		return dataLeitura;
	}
	public void setDataLeitura(Date dataLeitura) {
		this.dataLeitura = dataLeitura;
	}
	public ProfissionalTO getCriador() {
		return criador;
	}
	public void setCriador(ProfissionalTO criador) {
		this.criador = criador;
	}
	public ObjetivoTO getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(ObjetivoTO objetivo) {
		this.objetivo = objetivo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
