package com.coaching2live.business.pessoa.profissional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching2live.business.pessoa.PessoaBusiness;
import com.coaching2live.business.pessoa.cliente.dto.ClienteTO;
import com.coaching2live.business.pessoa.profissional.dto.ProfissionalTO;
import com.coaching2live.business.pessoa.profissional.helper.ProfissionalHelper;
import com.coaching2live.model.Cliente;
import com.coaching2live.model.Profissional;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.model.exception.ExceptionTypeEnum;
import com.coaching2live.repository.ClienteRepository;
import com.coaching2live.repository.ProfissionalRepository;
import com.coaching2live.service.ProfissionalService;

@Service
public class ProfissionalBusiness extends PessoaBusiness<Profissional> implements ProfissionalService {
	
	@Autowired private ProfissionalRepository profissionalRepository;
	@Autowired private ClienteRepository clienteRepository;
	
	@Override
	public ProfissionalTO bindClients(ProfissionalTO to) throws Coaching2liveException {

		Profissional profissional;
		List<Cliente> clientes = null;
		Cliente cliente = null;
		if (null != to.getClientes() && !to.getClientes().isEmpty()) {

			clientes = new ArrayList<Cliente>();
			for (ClienteTO cliTo : to.getClientes() ) {

				cliente = this.clienteRepository.findByEmailAndDeleteFalse(cliTo.getEmail());
				if (null != cliente) {

					clientes.add(cliente);
				}
			}
		}

		profissional = this.profissionalRepository.findByEmail(to.getEmail());
		if (null == profissional) {

			throw new Coaching2liveException("Erro ao tentar atualizar a lista de clientes do Profissional.");
		}
		
		this.validarVinculoClienteProfissional(profissional, clientes);

		profissional.setClientes(clientes);
		this.profissionalRepository.save(profissional);
		to = ProfissionalHelper.entityToTo(profissional);

		return to;
	}
	
	/**
	 * Verifica se já existe o vinculo do cliente com o profissional.
	 * 
	 * */
	private void validarVinculoClienteProfissional(Profissional profissional, List<Cliente> clientes) throws Coaching2liveException {

		for (Cliente cliente : clientes) {

			if (profissional.getClientes().contains(cliente)) {
				throw new Coaching2liveException(ExceptionTypeEnum.ALERT_WARNING,
						"Já existe o vínculo do cliente ("+cliente.getEmail()+") com o profissional ("+profissional.getEmail()+").");
			}
		}
	}
}
