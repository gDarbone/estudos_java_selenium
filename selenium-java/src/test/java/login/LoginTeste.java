package login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoginTeste {
	
	private LoginPage paginaDeLogin;

	
	@BeforeEach
	public void BeforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void AfterEach() {
		this.paginaDeLogin.fechar();
	}
	
	@Test
	public void LoginDadosValidos() {
		this.paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLogin.submeteFormulario();
		
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
		}
	
	@Test
	public void LoginDadosInvalidos() {
		this.paginaDeLogin.preencheFormularioDeLogin("tete", "tete");
		this.paginaDeLogin.submeteFormulario();
		
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assert.assertTrue(paginaDeLogin.contemElementoNaPagina("Usuário e senha inválidos."));
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
	}
	
	@Test
	public void NaoDeveriaAcessarPaginaRegistraSemLogar() {
		this.paginaDeLogin.navegaParaPaginaDeLances();

		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.contemElementoNaPagina("Dados do Leilão"));
	}

}
