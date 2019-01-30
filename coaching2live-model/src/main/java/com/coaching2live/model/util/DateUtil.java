package com.coaching2live.model.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.util.StringUtils;

public class DateUtil {

	public static final Locale LOCALE_PT_BR =  new Locale( "pt", "BR" );
	
	/**
	 * Formato dd/MM/yyy
	 * */
	public static final String FORMATO_PADRAO_DATA = "dd/MM/yyyy";
	
	/**
	 * Formato dd/MM/yyyy HH:mm:ss
	 * */
	public static final String FORMATO_PADRAO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	
	/**
	 * Formato dd/MM/yyyy HH:mm
	 * */
	public static final String FORMATO_PADRAO_DATA_HORA_CURTO = "dd/MM/yyyy HH:mm";
	
	/**
	 * Formato HH:mm:ss
	 * */
	public static final String FORMATO_PADRAO_HORA_LONGO = "HH:mm:ss";
	
	/**
	 * Formato HH:mm:ss
	 * */
	public static final String FORMATO_PADRAO_DATA_HORA_INPUT_APP = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	
	/**
	 * Formato yyyy-MM-dd
	 * */
	public static final String FORMATO_PADRAO_DATA_INPUT_APP = "yyyy-MM-dd";
	
	/**
	 * Formato HH:mm
	 * */
	public static final String FORMATO_PADRAO_HORA = "HH:mm";
	
	
	private static final long HORA_MILESEGUNDOS = 3600000;
	private static final long MINUTO_MILESEGUNDOS = 60000;
	private static final long SEGUNDO_MILESEGUNDOS = 1000;

	
	/**
	 * 
	 * 
	 * */
	public static Date getDateCurrent() {

		Calendar cal = Calendar.getInstance(LOCALE_PT_BR);
		return cal.getTime();
	}
	
	public static String getDateCurrentFormatada() {

		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_PADRAO_DATA_HORA);
		Calendar cal = Calendar.getInstance(LOCALE_PT_BR);
		return sdf.format(cal.getTime());
	}
	
	public static String getDateShortCurrentFormatada() {

		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_PADRAO_DATA_HORA_CURTO);
		Calendar cal = Calendar.getInstance(LOCALE_PT_BR);
		return sdf.format(cal.getTime());
	}

	public static double converteMilesegundosHora(final long milesegundos) {
		
		try {
			
			return new Double(milesegundos/HORA_MILESEGUNDOS) ;
		} catch (Exception e) {
			
			return 0d;
		}
	}
	
	public static Integer converteMilesegundosMinutos(final long milesegundos) {
		
		try {
			
			return new Long((long) (milesegundos/MINUTO_MILESEGUNDOS)).intValue() ;
		} catch (Exception e) {
			
			return 0;
		}
	}
	
	/**
	 * 
	 * */
	public static Date convertStringDateToDate(String dataStr) {

		DateFormat df = new SimpleDateFormat(FORMATO_PADRAO_DATA, LOCALE_PT_BR);
		try {
			
			if (!StringUtils.isEmpty(dataStr)) {

				return df.parse(dataStr);
			}	

			return null;
		} catch (ParseException e) {

			return null;
		}
	}
	
	/**
	 * 
	 * */
	public static Date convertStringDateToDate(String dataStr, String formato) {

		DateFormat df = new SimpleDateFormat(formato, LOCALE_PT_BR);
		try {
			
			if (!StringUtils.isEmpty(dataStr)) {

				return df.parse(dataStr);
			}	

			return null;
		} catch (ParseException e) {

			return null;
		}
	}
	
	/**
	 * Converte uma data {@link String} e hora {@link String} para data {@link Date}
	 * 
	 * @param dataStr {@link String} dd/MM/yyyy
	 * @param dataStr {@link horaStr} HH:mm
	 * */
	public static Date convertStringDateHourToDate(String dataStr, String horaStr) {

		DateFormat df = new SimpleDateFormat(FORMATO_PADRAO_DATA_HORA_CURTO, LOCALE_PT_BR);
		try {

			if (!StringUtils.isEmpty(dataStr.concat(" ").concat(horaStr))) {

				return df.parse(dataStr);
			}	

			return null;
		} catch (ParseException e) {

			return null;
		}
	}
	
	/**
	 * Converte uma data {@link String} e hora {@link String} para Hora {@link Date} no formato HH:mm
	 * 
	 * @param dataStr {@link String} dd/MM/yyyy
	 * @param dataStr {@link horaStr} HH:mm
	 * */
	public static Date convertStringHourToHour(String dataStr, String horaStr) {

		DateFormat df = new SimpleDateFormat(FORMATO_PADRAO_HORA, LOCALE_PT_BR);
		try {

			if (!StringUtils.isEmpty(dataStr.concat(" ").concat(horaStr))) {

				return df.parse(dataStr);
			}	

			return null;
		} catch (ParseException e) {

			return null;
		}
	}
	
	/**
	 * 
	 * @param {@link Date} date
	 * @param {{@link String} formato padr�o dd/MM/yyyy
	 * */
	public static String convertDateToString(Date date) {

		return convertDateToString(date, FORMATO_PADRAO_DATA_HORA);
	}
	
	/**
	 * 
	 * @param {@link Date} date
	 * @param {{@link String} formato
	 * */
	public static String convertDateToString(Date date, String formato) {

		DateFormat df = new SimpleDateFormat(FORMATO_PADRAO_DATA_HORA, LOCALE_PT_BR);
		if (null != date) {

			try {

				if (null == formato || StringUtils.isEmpty(formato)) {

					df = new SimpleDateFormat(FORMATO_PADRAO_DATA, LOCALE_PT_BR);
				} else {

					df = new SimpleDateFormat(formato, LOCALE_PT_BR);
				}

				return df.format(date);  
			} catch (Exception e) {

				throw e;
			}
		}
		return null;
	}
	
	/**
	 * Recupera o dia de hoje com a horas, minutos, segundo e milesegundos zerados.
	 * 
	 * @return {@link Date}
	 * */
	public static Date getDateWithFirstHourOfTheDay() {

		Calendar cal = new GregorianCalendar(LOCALE_PT_BR);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();		
	}

	public static Date getDateWithLastHourOfTheDay() {

		Calendar cal = new GregorianCalendar(LOCALE_PT_BR);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();		
	}
	
	public static Date getDateWithFirstDayOfMonth() {

		Calendar cal = new GregorianCalendar(LOCALE_PT_BR);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();		
	}
	
	public static Date getDateWithLastDayOfMonth() {

		Calendar cal = new GregorianCalendar(LOCALE_PT_BR);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();		
	}
	
	/**
	 * Recupera a da Data e zera a hora, minutos, segundo e milesgundos
	 * 
	 * @param date {@link Date}
	 * @return date {@link Date}
	 * */
	public static Date zeraHorasMinutosSegundos(Date date) {

		Calendar cal = new GregorianCalendar(LOCALE_PT_BR);
		cal.setTime(date);

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();		
	}
	
	public static void zeraHorasMinutosSegundos(Calendar cal) {

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}
	
	public static Date getDifferenceBetweenDates(Date startDate, Date endDate) {

		Calendar dStart = GregorianCalendar.getInstance(LOCALE_PT_BR);
		Calendar dEnd = GregorianCalendar.getInstance(LOCALE_PT_BR);
		Calendar now = GregorianCalendar.getInstance(LOCALE_PT_BR);

		dStart.setTime(startDate);
		dEnd.setTime(endDate);

		Long dif = (dEnd.getTimeInMillis() - dStart.getTimeInMillis())/SEGUNDO_MILESEGUNDOS;

		DateUtil.zeraHorasMinutosSegundos(now);
		now.set(Calendar.SECOND, dif.intValue());

		return now.getTime();
	}
}
