package br.com.dedurando.rest;

import javax.jws.WebService;

import br.com.dedurando.bean.ReviewReason;

@WebService
public class Teste {
	public String teste()
	{
		return "Teste";
	}
	
	public ReviewReason testeR()
	{
		ReviewReason teste = new ReviewReason();
		teste.setDescription("fdafds");
		return teste;
	}
}
