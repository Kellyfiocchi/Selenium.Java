import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCadastro {
	
	  WebDriver driver;	
	  DSL dsl;
	  CampoTreinamentoPage page;
		
		@Before
		public void inicializa() {
			System.setProperty("webdriver.chrome.driver",
					"/Users/Kelly/OneDrive/Área de Trabalho/DriverAt/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("http://wcaquino.me/selenium/componentes.html");
			dsl = new DSL(driver);
			page = new CampoTreinamentoPage(driver);
		}
		
		@After
		public void finaliza() {
			driver.close();
		}
	
	@Test
	public void CadastroRealizadoComSucesso() {
		page.setNome("Kelly");
		page.setSobrenome("Fiocchi");
		page.setSexoFeminino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
		
        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assert.assertTrue(page.obterNomeCadastro().endsWith("Kelly"));
        Assert.assertEquals("Sobrenome: Fiocchi", page.obterSobrenomeCadastro());
        Assert.assertEquals("Sexo: Feminino", page.obterSexoCadastro());
        Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());	
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio",dsl.alertaObterTextoEAceita());
		
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
	  page.setNome("Nome qualquer");
	  page.cadastrar();
	  Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaVegetariana();
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaPizza();
		page.setEsporte("Karate", "O que eh esporte?");
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}


}

	