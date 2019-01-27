package liverpool.project.mail;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("javasampleapproachMailSender")
public class Mail {

	private String from;
	
	private String to;
	
	private String subject;
	
	private String message;
	
	public Mail() {
		this.from="fcliverpooltest@gmail.com";
	}
}
