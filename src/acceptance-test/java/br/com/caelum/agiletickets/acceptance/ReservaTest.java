package br.com.caelum.agiletickets.acceptance;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.caelum.agiletickets.acceptance.page.ReservasPage;

public class ReservaTest {
	public static String BASE_URL = "http://localhost:8585/agiletickets";
	private static WebDriver browser;
	private ReservasPage reservas;
	
	@BeforeClass
	public static void abreBrowser() {
		browser = new FirefoxDriver();
	}

	@Before
	public void setUp() throws Exception {
		reservas = new ReservasPage(browser);
	}
	
	@After
	public void tearDown() {
		browser.close();
	}
	
	@Test
	public void precoDoIngressoDeveSer55() throws Exception {
		reservas.abreSessao(6);

		reservas.compraIngresso("1");

		reservas.mensagemDeveSer("Sessão reservada com sucesso por R$ 55,00");
	}
}