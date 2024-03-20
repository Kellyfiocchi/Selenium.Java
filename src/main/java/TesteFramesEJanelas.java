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

public class TesteFramesEJanelas {
	
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
	public void deveInteragirComFrames() {
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
		
		dsl.sairFrame();
		dsl.escreve("elementosForm:nome", msg);
	}
	
	@Test
	public void deveInteragirComJanelas() {
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escreve("textarea", "Deu certo?");
		driver.close();
		dsl.trocarJanela("");
		dsl.escreve("elementosForm:sugestoes", "e agora?");
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
		dsl.escreve("textarea", "Deu certo?");
		dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
		dsl.escreve("elementosForm:sugestoes", "e agora?");
	}
}
