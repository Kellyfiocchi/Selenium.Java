import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCadastro {
	
	@Test
	public void CadastroRealizadoComSucesso() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Kelly");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Fiocchi");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		driver.findElement(By.id("elementosForm:escolaridade")).sendKeys("Mestrado");
		driver.findElement(By.id("elementosForm:esportes")).sendKeys("Natacao");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
        
		
        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Kelly"));
        Assert.assertEquals("Sobrenome: Fiocchi", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Feminino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
        driver.close();
		
	}
	@Test
	public void deveValidarNomeObrigatorio() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
		driver.close();
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
		driver.close();
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
		driver.close();
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
		driver.close();
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		System.setProperty("webdriver.chrome.driver", "/Users/Kelly/OneDrive/Área de Trabalho/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Karate");
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();
		driver.close();
	}


}

	