package br.com.dedurando.test;

import org.apache.commons.mail.EmailException;

import br.com.dedurando.util.CommonsMail;

public class CommonsMailTest {

	//@Test
	public void sendSimpleEmail() throws EmailException {
		CommonsMail email = new CommonsMail();
		email.sendSimpleEmail();
	}
}