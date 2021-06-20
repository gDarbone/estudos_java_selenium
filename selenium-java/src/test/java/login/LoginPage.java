package login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;
import leiloes.LeiloesPage;

public class LoginPage extends PageObject {

	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	public LoginPage() {
		super(null);
		browser.navigate().to(URL_LOGIN);
	}

	
	public void preencheFormularioDeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage submeteFormulario() {
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isPaginaDeLogin() {
		return (browser.getCurrentUrl().equals(URL_LOGIN));
	}

	public Object getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean contemElementoNaPagina(String element) {
		return browser.getPageSource().contains(element);
	}

	public void navegaParaPaginaDeLances() {
		browser.navigate().to("http://localhost:8080/leiloes/2");

	}

}
