package com.coaching2live.business.email;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coaching2live.model.exception.Coaching2liveException;
import com.coaching2live.model.util.EmailConstantes;
import com.coaching2live.service.EmailService;

public class EmailBusiness implements EmailService {

		private Properties mailServerProperties;
		private Session getMailSession;
		private Message generateMailMessage;
		private Transport transport;

		private static Logger log = LoggerFactory.getLogger(EmailBusiness.class);

		public EmailBusiness() {


		}

		/*@Override
		public void enviarEmailConfirmacaoPedidoRealizado(PedidoEntity pedido) throws Coaching2liveException {
			
			log.info(this.getSubjectMessageConfirmacaoPedido(pedido));
			try {

				this.init();

				generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(pedido.getUsuarioMesa().getUsuario().getEmail()));
				generateMailMessage.setSubject(this.getSubjectMessageConfirmacaoPedido(pedido));

				StringBuilder emailBody = new StringBuilder();
				emailBody.append(String.format("<p>Seu Pedido (#"+pedido.getNumeroDoPedidoFormatado()+") foi feito com sucesso.</p>"));
				emailBody.append(String.format("<p>Itens do Pedido: %s </p>", pedido.getItensDoPedido().toString()));

				generateMailMessage.setContent(emailBody.toString(), "text/html");

				this.sendEmail();

				log.info("E-mail enviado com sucesso.");
			} catch (MessagingException e) {

				log.error(e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {

				log.error(e.getMessage());
				e.printStackTrace();
			} finally {

				try {
					transport.close();
				} catch (MessagingException e) {

					log.error(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		@Override
		public void enviarEmailConfirmacaoPedidoRealizado(PedidoEntity pedido, SaleDTO sale) throws Coaching2liveException {

			log.info(this.getSubjectMessageConfirmacaoPedido(pedido));
			try {
				
				this.init();
				
				generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(pedido.getUsuarioMesa().getUsuario().getEmail()));
				generateMailMessage.setSubject(this.getSubjectMessageConfirmacaoPedido(pedido));

				StringBuilder emailBody = new StringBuilder();
				emailBody.append(String.format("<p>Seu Pedido (#"+pedido.getNumeroDoPedidoFormatado()+") foi feito com sucesso.</p>"));
				emailBody.append(String.format("<p>Itens do Pedido: %s </p>", pedido.getItensDoPedido().toString()));

				emailBody.append(String.format("<p>Pagamento Efetivado: " + sale.toString() + " foi feito com sucesso.</p>"));
				generateMailMessage.setContent(emailBody.toString(), "text/html");

				this.sendEmail();

			} catch (MessagingException e) {

				log.error(e.getMessage());
				e.printStackTrace();
			} finally {

				try {
					transport.close();
				} catch (MessagingException e) {

					log.error(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		@Override
		public void enviarEmailConfirmacaoPedidoProntoParaRetiradaNoBalcao(PedidoEntity pedido) throws Coaching2liveException {

			log.info(this.getSubjectMessageConfirmacaoPedido(pedido));
			try {

				this.init();

				generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(pedido.getUsuarioMesa().getUsuario().getEmail()));
				generateMailMessage.setSubject(this.getSubjectMessageConfirmacaoPedido(pedido));

				StringBuilder emailBody = new StringBuilder();
				emailBody.append(String.format("<p>Seu Pedido (#"+pedido.getNumeroDoPedidoFormatado()+") foi feito com sucesso.</p>"));
				emailBody.append(String.format("<p>Itens do Pedido: %s </p>", pedido.getItensDoPedido().toString()));

				generateMailMessage.setContent(emailBody.toString(), "text/html");

				this.sendEmail();
			} catch (MessagingException e) {

				log.error(e.getMessage());
				throw new Coaching2liveException(e);
			} finally {

				try {

					transport.close();
				} catch (MessagingException e) {

					log.error(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		*//**
		 * 
		 * *//*
		private void init() {
			
			log.debug("1st ===> setup Mail Server Properties..");
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
			mailServerProperties.put("mail.smtp.socketFactory.port", "465");
			mailServerProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.port", "465");

			try {

				getMailSession = Session.getDefaultInstance(mailServerProperties, null);
				generateMailMessage = new MimeMessage(this.getMailSession); 
				generateMailMessage.setFrom(new InternetAddress(EmailConstantes.EMAIL_NO_REPLY));
				generateMailMessage.setReplyTo(new javax.mail.Address[]
						{new javax.mail.internet.InternetAddress(EmailConstantes.EMAIL_NO_REPLY)});
				
			} catch (MessagingException e) {

				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		
		*//**
		 * 
		 * *//*
		private void sendEmail() {
			
			try {

				Transport transport = getMailSession.getTransport("smtp");
				transport.connect(EmailConstantes.HOST, EmailConstantes.USER, EmailConstantes.PASSWORD);
				transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());

				log.info("E-mail enviado com sucesso.");			
			} catch (MessagingException e) {

				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		
		*//**
		 * 
		 * *//*
		private String getSubjectMessageConfirmacaoPedido(PedidoEntity pedido) {
			
			return String.format("Cardapia: Confirmação do pedido (#%s) feito na empresa %s às %s.", 
					pedido.getNumeroDoPedidoFormatado(), 
					pedido.getUsuarioMesa().getMesa().getArea().getEmpresa().getNomeFantasia(), 
					pedido.getDataPedidoFormatada());
		}
	}*/
}
