
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
     WebDriver driver;	
     DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.close();
	}
	
	
	@Test
	public void testeTextField() {
		dsl.escreve("elementosForm:nome", "Teste de escrita"); 
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
		
	}
	
	@Test
	public void testTextFieldDuplo() {
		dsl.escreve("elementosForm:nome", "Wagner");
		Assert.assertEquals("Wagner", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreve("elementosForm:nome", "Aquino");
		Assert.assertEquals("Aquino", dsl.obterValorCampo("elementosForm:nome"));
	


	}
	
	@Test
	public void deveInteragirComTextArea() {
		dsl.escreve("elementosForm:sugestoes", "teste");
		Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void deveInteragirComRadioButton() {
         dsl.clicarRadio("elementosForm:sexo:0");
        Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:1"));
			
	}
	@Test
	public void deveInteragirComCheckbox() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
	}
	
	@Test
	public void deveInteragirComCombo() {	
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void deveVerificarValoresCombo() {
       Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
       Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
        

	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
      
		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(3, opcoesMarcadas.size());
        
        dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
        opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2, opcoesMarcadas.size());
        Assert.assertTrue(opcoesMarcadas.containsAll(List.of("Natacao", "O que eh esporte?")));
        
        }
	
	@Test
	public void deveInteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValorCampo("buttonSimple"));
		
		}
	
	@Test
	//@Ignore
	public void deveInteragirComLinks() {
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		//Assert.fail();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl .obterTexto(By.className("facilAchar")));
	   }	
	}