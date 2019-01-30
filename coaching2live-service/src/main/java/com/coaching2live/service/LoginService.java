package com.coaching2live.service;

import com.coaching2live.model.Login;
import com.coaching2live.model.exception.Coaching2liveException;

public interface LoginService {

	Login registrarLogin(Login login) throws Coaching2liveException;
}
