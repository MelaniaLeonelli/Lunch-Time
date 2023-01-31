package controller;

import model.UtenteDAO;
import model.ProdottoDAO;
import model.CarrelloDAO;
import model.PreferisceDAO;
import model.OrdineDAO;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;

import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;

import org.junit.Before; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
    private WebDriver driver;
    
    private Map<String, Object> vars;
    UtenteDAO utentedao = new UtenteDAO();
    

    String inputText = "";
    String jsString = "";

    String url = "http://localhost:8080/LunchTime/index.jsp";
    JavascriptExecutor js;
    
    
    

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saso\\Desktop\\LaunchTime\\drivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1080));

    }
    

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    /*
    registerTest rg = new registerTest();

    @Nested
    class registerTest {
    	
        @Test //Registrazione OK
        public void registerTC1() throws InterruptedException, SQLException, ClassNotFoundException {
        	driver.findElement(By.cssSelector("#registerBtn")).click();
            inputText = "saso";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#nomeutente")));
            inputText = "saso@saso.it";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#emailutente")));
            inputText = "Sasosaso";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#password")));
            inputText = "00000050";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#codicetessera")));
            WebElement rbutton = driver.findElement(By.cssSelector("#categoria[value= '1']")); 
            rbutton.click(); 
            Thread.sleep(3000);
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#registerBtn")));
            Thread.sleep(600);
            driver.findElement(By.cssSelector("#registerBtn")).click();
            Thread.sleep(3000);
            assertEquals(driver.findElement(By.cssSelector("#registerEff")).getAttribute("innerHTML"), "Registrazione Completata!");
       }
        
 
        @Test //Password non valida
        public void registerTC2() throws InterruptedException, SQLException, ClassNotFoundException {
        	
            	driver.findElement(By.cssSelector("#registerBtn")).click();
                inputText = "saso";
                jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
                ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#nomeutente")));
                inputText = "saso@saso.it";
                jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
                ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#emailutente")));
                inputText = "psw";
                jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
                ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#password")));
                inputText = "00000050";
                jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
                ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#codicetessera")));
                WebElement rbutton = driver.findElement(By.cssSelector("#categoria[value= '1']")); 
                rbutton.click(); 
                Thread.sleep(3000);
                new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#registerBtn")));
                Thread.sleep(600);
                driver.findElement(By.cssSelector("#registerBtn")).click();
                Thread.sleep(3000);
                assertEquals(driver.findElement(By.cssSelector("#password-error")).getAttribute("innerHTML"), "Please enter at least 5 characters.");
        	
        }
        
 
        @Test //Email già registrata
        public void registerTC3() throws InterruptedException, SQLException, ClassNotFoundException {
        	driver.findElement(By.cssSelector("#registerBtn")).click();
            inputText = "zoso";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#nomeutente")));
            inputText = "e.allocco1@studenti.unisa.it";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#emailutente")));
            inputText = "HotCold";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#password")));
            inputText = "00000050";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#codicetessera")));
            WebElement rbutton = driver.findElement(By.cssSelector("#categoria[value= '1']")); 
            rbutton.click(); 
            Thread.sleep(3000);
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#registerBtn")));
            Thread.sleep(600);
            driver.findElement(By.cssSelector("#registerBtn")).click();
            Thread.sleep(3000);
            assertEquals(driver.findElement(By.cssSelector("#registerEff")).getAttribute("innerHTML"), "Utente già registrato.");
        	
        }



        @Test //Formato Email non valido
        public void registerTC5() throws InterruptedException, SQLException, ClassNotFoundException {
        	driver.findElement(By.cssSelector("#registerBtn")).click();
            inputText = "saso";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#nomeutente")));
            inputText = "sasosaso.it";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#emailutente")));
            inputText = "password";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#password")));
            inputText = "00000050";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#codicetessera")));
            WebElement rbutton = driver.findElement(By.cssSelector("#categoria[value= '1']")); 
            rbutton.click(); 
            Thread.sleep(3000);
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#registerBtn")));
            Thread.sleep(600);
            driver.findElement(By.cssSelector("#registerBtn")).click();
            Thread.sleep(3000);
            assertEquals(driver.findElement(By.cssSelector("#emailutente-error")).getAttribute("innerHTML"), "Please enter a valid email address.");
        }
        
 
        @Test //Campo email vuoto
        public void registerTC6() throws InterruptedException, SQLException, ClassNotFoundException {
        	driver.findElement(By.cssSelector("#registerBtn")).click();
            inputText = "saso";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#nomeutente")));
            inputText = "";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#emailutente")));
            inputText = "password";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#password")));
            inputText = "00000050";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#codicetessera")));
            WebElement rbutton = driver.findElement(By.cssSelector("#categoria[value= '1']")); 
            rbutton.click(); 
            Thread.sleep(3000);
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#registerBtn")));
            Thread.sleep(600);
            driver.findElement(By.cssSelector("#registerBtn")).click();
            Thread.sleep(3000);
            assertEquals(driver.findElement(By.cssSelector("#emailutente-error")).getAttribute("innerHTML"), "This field is required.");
        	
        	
        }

        
    }
    
    
    @Nested
    class loginTest {
        @Test //Login OK
        public void loginTC1() throws InterruptedException, SQLException, ClassNotFoundException {
            
        	driver.findElement(By.cssSelector("#loginBtn")).click();
            inputText = "paolo@gmail.com";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingInput")));
            inputText = "Paolo";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingPassword")));
            Thread.sleep(3000);
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginBtn")));
            Thread.sleep(600);
            driver.findElement(By.cssSelector("#loginBtn")).click();
            Thread.sleep(3000);
            String titolo = driver.getTitle();
            assertEquals(titolo, "HomePage");
        }
     
        @Test //Login fallito: Credenziali Errate
        public void loginTC2() throws SQLException, ClassNotFoundException, InterruptedException {
            
        	driver.findElement(By.cssSelector("#loginBtn")).click();
            inputText = "paolo@gmail.com";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingInput")));
            inputText = "nonPaolo";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingPassword")));
            Thread.sleep(3000);
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginBtn")));
            Thread.sleep(600);
            driver.findElement(By.cssSelector("#loginBtn")).click();
            Thread.sleep(2000);
            assertEquals(driver.findElement(By.cssSelector("#loginWrongMessage")).getAttribute("innerHTML"), "Email o Password errati!");

            
        }
  
    }
    
 
    @Nested
    class addPreferitiTest{

        @BeforeEach
        public void setUpAddPreferiti() throws InterruptedException, SQLException, ClassNotFoundException {
        	driver.findElement(By.cssSelector("#loginBtn")).click();
            inputText = "paolo@gmail.com";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingInput")));
            inputText = "Paolo";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingPassword")));
            driver.findElement(By.cssSelector("#loginBtn")).click();
            
            }

        
        @Test //Aggiunta preferito: OK
        public void addPreferitiTC1() throws InterruptedException {
        	Thread.sleep(2000);
        	driver.findElement(By.cssSelector("#navbarsExample08 > ul > li:nth-child(1) > a")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.cssSelector("#container2 > div > div:nth-child(5) > a")).click();
        	Thread.sleep(2000);
            
            assertEquals(driver.findElement(By.cssSelector("#registerEff")).getAttribute("innerHTML"), "Prodotto aggiunto ai preferiti!");
            Thread.sleep(2000);
        }
        
        
        @Test //Preferito Già Esistente
        public void addPreferitiTC2() throws InterruptedException {
        	Thread.sleep(3000);
        	driver.findElement(By.cssSelector("#navbarsExample08 > ul > li:nth-child(1) > a")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.cssSelector("#container2 > div > div:nth-child(5) > a")).click();
        	Thread.sleep(3000);
            
            assertEquals(driver.findElement(By.cssSelector("#registerEff")).getAttribute("innerHTML"), "Prodotto già Presente Nei Preferiti! <br> Ti Piace Cosi Tanto?");
            Thread.sleep(3000);
        }
 
    }
    
    
    @Nested
    class acquistaProdottoTest{

        @BeforeEach
        public void setUpAcquista() throws InterruptedException, SQLException, ClassNotFoundException {
        	
            	driver.findElement(By.cssSelector("#loginBtn")).click();
                inputText = "paolo@gmail.com";
                jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
                ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingInput")));
                inputText = "Paolo";
                jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
                ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingPassword")));
                driver.findElement(By.cssSelector("#loginBtn")).click();
         }
        
        @Test //Acquisto Effettuato
        public void acquistoTC1() throws InterruptedException{
        	Thread.sleep(3000);
        	driver.findElement(By.cssSelector("#portfolio > div > h2:nth-child(2) > a")).click();
        	Thread.sleep(1000);
        	driver.findElement(By.cssSelector("#container2 > div > div:nth-child(1) > div > div > a")).click();
        	Thread.sleep(1000);
        	driver.findElement(By.cssSelector("body > section > div.text-center > a:nth-child(1)")).click();
        	Thread.sleep(1000);
            assertEquals(driver.findElement(By.cssSelector("#formdivAlto")).getAttribute("innerHTML"), "<h3>Grazie per aver effettuato l'ordine!</h3>");
        
        }
        @Test //Saldo Insufficiente
        public void acquistoTC2() throws InterruptedException{
        	Thread.sleep(3000);
        	driver.findElement(By.cssSelector("#portfolio > div > h2:nth-child(2) > a")).click();
        	Thread.sleep(1000);
        	driver.findElement(By.cssSelector("#container2 > div > div:nth-child(1) > div > div > a")).click();
        	Thread.sleep(1000);
        	driver.findElement(By.cssSelector("body > section > div.text-center > a:nth-child(1)")).click();
        	Thread.sleep(1000);
            assertEquals(driver.findElement(By.cssSelector("#formdivAlto")).getAttribute("innerHTML"), "<h3>Il tuo Saldo è insufficiente!</h3>");

        	
        }
        
        @Test //Prodotto non più disponibile
        public void acquistoTC3() throws InterruptedException{
        	Thread.sleep(3000);
        	driver.findElement(By.cssSelector("#portfolio > div > h2:nth-child(2) > a")).click();
        	Thread.sleep(1000);
        	driver.findElement(By.cssSelector("#container2 > div > div:nth-child(1) > div > div > a")).click();
        	Thread.sleep(1000);
        	driver.findElement(By.cssSelector("body > section > div.text-center > a:nth-child(1)")).click();
        	Thread.sleep(1000);
            assertEquals(driver.findElement(By.cssSelector("#formdivAlto > h3")).getAttribute("innerHTML"), "Uno dei Tuoi Prodotti non è disponibile!");
         }
    }
    */

    @Nested
    class addProductTest{
        @BeforeEach
        public void setUpAddProductTest() throws InterruptedException{
            driver.findElement(By.cssSelector("#loginBtn")).click();
            inputText = "mario@mario.it";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingInput")));
            inputText = "Mario";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingPassword")));
            driver.findElement(By.cssSelector("#loginBtn")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#loginBtn")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#admin > div > ul > li:nth-child(1) > a")).click();
        }
/*
        @Test //Aggiunta di un prodotto
        public void addProductTestTC1() throws InterruptedException{
        	Thread.sleep(3000);
            inputText = "00000030";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#idp")));
            inputText = "salame";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#name")));
            inputText = "secondopiatto";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#categoria")));
            inputText = "1.0";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#prezzo")));
            inputText = "0";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#disponibile")));
            inputText = "salame napoletano";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#genere")));
            Thread.sleep(500);
            driver.findElement(By.cssSelector("#addBtn")).click();
            Thread.sleep(3000);
            assertEquals(driver.findElement(By.cssSelector("#registerEff")).getAttribute("innerHTML"), "Prodotto Aggiunto con Successo!");
            
        }
        
  
        @Test //Prodotto già esistente
        public void addProductTestTC2() throws InterruptedException {
        	Thread.sleep(3000);
            inputText = "00000001";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#idp")));
            inputText = "cicoria";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#name")));
            inputText = "contorno";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#categoria")));
            inputText = "1.0";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#prezzo")));
            inputText = "0";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#disponibile")));
            inputText = "verdura di stagione";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#genere")));
            Thread.sleep(500);
            driver.findElement(By.cssSelector("#addBtn")).click();
            Thread.sleep(3000);
            assertEquals(driver.findElement(By.cssSelector("#registerEff")).getAttribute("innerHTML"), "Prodotto Già Presente Nel Catalogo!");
        }
        

        @Test //idprodotto non valido
        public void addProductTestTC3() throws InterruptedException {
        	Thread.sleep(3000);
            inputText = "codiceuno";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#idp")));
            inputText = "cicoria";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#name")));
            inputText = "contorno";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#categoria")));
            inputText = "1.0";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#prezzo")));
            inputText = "0";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#disponibile")));
            inputText = "verdura di stagione";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#genere")));
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#addBtn")).click();
            Thread.sleep(3000);
            
        }
        */
        @Test //Prezzo non valido
        public void addProductTestTC4() throws InterruptedException {
        	Thread.sleep(3000);
            inputText = "00000078";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#idp")));
            inputText = "cicoria";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#name")));
            inputText = "contorno";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#categoria")));
            inputText = "prezzo";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#prezzo")));
            inputText = "0";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#disponibile")));
            inputText = "verdura di stagione";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#genere")));
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#addBtn")).click();
            Thread.sleep(3000);
            
        }
    
    
    }
    /*
    @Nested
    class editProductTest{
        @BeforeEach
        public void setUpEditProductTest() throws InterruptedException{
            driver.findElement(By.cssSelector("#loginBtn")).click();
            Thread.sleep(500);
            System.out.println("partp parto");
            inputText = "mario@mario.it";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingInput")));
            inputText = "Mario";
            jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
            ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#floatingPassword")));
            driver.findElement(By.cssSelector("#loginBtn")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#loginBtn")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("#admin > div > ul > li:nth-child(4) > a")).click();
        }
    
    
    @Test //Prodotto Aggiornato
    public void editProductTestTC1() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(By.cssSelector("#edtbtn")).click();
        inputText = "1.0";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#prezzo")));
        inputText = "1";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#disponibile")));
        inputText = "pasta e patate";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#descrizione")));
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#editBtn")).click();
        Thread.sleep(3000);
        assertEquals(driver.findElement(By.cssSelector("body > p")).getAttribute("innerHTML"), "Prodotto aggiornato.");

        
 }
    
    @Test //Formato Prezzo Non Valido
    public void editProductTestTC2() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(By.cssSelector("#edtbtn")).click();
        inputText = "nonvalido";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#prezzo")));
        inputText = "1";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#disponibile")));
        inputText = "pasta e patate";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#descrizione")));
        Thread.sleep(8000);
        driver.findElement(By.cssSelector("#editBtn")).click();
        Thread.sleep(3000);

        
 }
    @Test //Valore Disponibile Non Valido
    public void editProductTestTC3() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(By.cssSelector("#edtbtn")).click();
        inputText = "1.0";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#prezzo")));
        inputText = "Non Disponibile";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#disponibile")));
        inputText = "pasta e patate";
        jsString = "arguments[0].setAttribute('value', '" + inputText + "')";
        ((JavascriptExecutor) driver).executeScript(jsString, driver.findElement(By.cssSelector("#descrizione")));
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("#editBtn")).click();
        Thread.sleep(3000);

        
 }
 
    }
    */
}



