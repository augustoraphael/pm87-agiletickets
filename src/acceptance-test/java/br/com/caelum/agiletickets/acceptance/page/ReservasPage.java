package br.com.caelum.agiletickets.acceptance.page;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservasPage {

	private static final String BASE_URL = "http://localhost:8585/agiletickets";
	private final WebDriver driver;

	public ReservasPage(WebDriver driver) {
		this.driver = driver;
	}

	public void abreSessao(int id) {
		driver.get(BASE_URL + "/sessao/" + id);
	}

	public void compraIngresso(String qtd) {
		WebElement form = form();
		form.findElement(By.id("qtde")).sendKeys(qtd);
		form.submit();
	}
	
	public void mensagemDeveSer(String msgEsperada) {
		WebElement temEstacionamento = driver.findElement(By.id("message"));
		assertThat(temEstacionamento.getText(), is(msgEsperada));
	}

	private WebElement form() {
		return driver.findElement(By.tagName("form"));
	}

}
