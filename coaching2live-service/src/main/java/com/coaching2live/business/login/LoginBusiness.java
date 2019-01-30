package com.coaching2live.business.login;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching2live.model.Login;
import com.coaching2live.model.Pessoa;
import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.model.exception.ExceptionTypeEnum;
import com.coaching2live.repository.LoginRepository;
import com.coaching2live.repository.PessoaRepository;
import com.coaching2live.service.LoginService;

@Service(value="loginService")
public class LoginBusiness implements LoginService {

	@Autowired private PessoaRepository pessoaRepository;
	@Autowired private LoginRepository loginRepository;

	@Override
	public Login registrarLogin(Login login) throws Coaching2liveException {

		Pessoa pessoa = null;
		pessoa = this.pessoaRepository.findByEmail(login.getPessoa().getEmail());
		if (null == pessoa) {

			throw new Coaching2liveException(ExceptionTypeEnum.ALERT_WARNING, "E-mail não cadastrado.");
		}

		login.setPessoa(pessoa);
		login.setDataLogin(new Date());
		this.loginRepository.save(login);

		return login;
	}
}
