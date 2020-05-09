package life.senna11.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import life.senna11.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
