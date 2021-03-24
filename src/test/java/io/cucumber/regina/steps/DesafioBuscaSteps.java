package io.cucumber.regina.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.regina.page.DesafioBuscaPage;

public class DesafioBuscaSteps {
	
	DesafioBuscaPage desafioPage = new DesafioBuscaPage();
	
	public WebDriver browser;
	
	//Método que chama o Chromedriver
	public DesafioBuscaSteps() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");		
		browser = new ChromeDriver();
	}
	
	//Entra no site para pesquisa
	@Dado("que que estou no site do tornese um programador")
	public void que_que_estou_no_site_do_tornese_um_programador() {
		 browser.get("http://www.torneseumprogramador.com.br/");
	}

	//Digite valor recebido da feature para pesquisar
	@Quando("digito no campo de busca a palavra \"([^\"]*)\"$")
	public void digito_no_campo_de_busca_a_palavra(String textoDaBusca) {
		
		WebElement input = browser.findElement( By.cssSelector("#aula") );
		input.sendKeys(textoDaBusca);
		WebElement procura = browser.findElement( By.cssSelector("#icon-pesquisa"));
		procura.click();
	}
	
	

	//Valida o resultado da pesquisa
	@Entao("devo ver o resultado na busca \"([^\"]*)\"$")
	public void devo_ver_o_resultado_na_busca (String textoResultadoDaBusca) {
		//String para receber o texto da pesquisa
		String textoParaValidar = 
				//Elemento HTML com o resultado da pesquisa
				browser.findElement(By.cssSelector("body > div.container-fluid.imagem-topo > div > div > div > h1"))
					//Comando para pegar o texto do HTML
					.getText()
						//Comando para retirar as "aspas" da pesquisa
						.replace("\"", "");
								
		//Valida os textos
		assertTrue("Resultado não foi o correto!!!", 
				desafioPage.testes(textoResultadoDaBusca, textoParaValidar ));

		browser.quit();
		
	}

}
