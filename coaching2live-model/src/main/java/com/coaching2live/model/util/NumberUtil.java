package com.coaching2live.model.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;


public class NumberUtil {

	private static int QTDE_DIGITOS_CPF = 11;
	private static Locale LOCALE_PT_BR = new Locale("pt", "BR");
	
	/**
	 * 
	 * 
	 * */
	public static String formataMonetarioReal(BigDecimal valor) {

		NumberFormat nf = NumberFormat.getCurrencyInstance(LOCALE_PT_BR);
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);

		try {

			return nf.format(valor);
		} catch (Exception e) {

			return nf.format(0);
		}
	}
	
	/**
	 * 
	 * */
	public static String formatCPF(Long cpf) {

		return formatCPF(String.valueOf(cpf));
	}
	
	/**
	 * 
	 * */
	public static String formatCPF(String cpf) {

		if (!StringUtils.isEmpty(cpf) 
				&& QTDE_DIGITOS_CPF >= cpf.length()) {
			
			cpf = zeroEsquerdaCpf(cpf);
			Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
			Matcher matcher = pattern.matcher(cpf);
			if (matcher.matches()) {

				cpf = matcher.replaceAll("$1.$2.$3-$4");
			}	
			return cpf;		
		}
		
		return "0";
	}
	
	/**
	 * 
	 * */
	public static String zeroEsquerdaCpf(String cpf) {

		if (!StringUtils.isEmpty(cpf) && 
				QTDE_DIGITOS_CPF >= cpf.length()) {

				return "0";//StringUtils.leftPad(String.valueOf(cpf), QTDE_DIGITOS_CPF, "0");
		}
		
		return "0";
	}
}
