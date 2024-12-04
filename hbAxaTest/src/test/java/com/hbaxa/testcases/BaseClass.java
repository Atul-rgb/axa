package com.hbaxa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import com.hbaxa.utilities.ReadConfig;

import bsh.util.Sessiond;

public class BaseClass {
	
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	//public String username = readconfig.getUsername();
	//public String password = readconfig.getPassword();
	public static WebDriver driver;
	//public static final ThreadLocal<WebDriver> driver;
	//public static WebDriver driver1;
	///public static WebDriver driver2;
	public static StopWatch loadTimer;
	//StopWatch pageLoad = new StopWatch();
	
	Pattern patrn;
	Matcher matchr;
	String extractValue;
	public static String currentRow;
	
	
	public static Logger logger;
	
	//@Parameters("Browser")
	@Parameters({ "Browser", "tc_row", "test_name" })
	@BeforeClass
	public void setup(String br, String Crow, String test_name)
	{
		
		logger = Logger.getLogger("hbAxa");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			//System.setProperty("webdriver.chrome.driver", "C:\\chromeD\\chromedriver.exe"); //Latest chromeDriver but not supported giving error..session not created: Chrome version must be between 70 and 73
			
			/*if(test_name.equals("TC_PA_")){
				
				driver=new ChromeDriver();
				loadTimer = new StopWatch();
				
			}else if(test_name.equals("TC_Reimbursment_")){
				
				driver1=new ChromeDriver();
				loadTimer = new StopWatch();
				driver = driver1;
			}
			else if(test_name.equals("TC_Cashless_")){
				
				driver2=new ChromeDriver();
				loadTimer = new StopWatch();
				driver = driver2;
			}*/
			
			
			/*ChromeOptions options = new ChromeOptions();  
			options.addArguments("--headless", "--disable-gpu", "--window-size=1366,768","--ignore-certificate-errors","--disable-features=VizDisplayCompositor");  
			driver = new ChromeDriver(options);*/
			
			
			driver=new ChromeDriver();
			loadTimer = new StopWatch();
			

		    //ChromeDriverManager.getInstance().setup();
		   // ChromeOptions chromeOptions = new ChromeOptions();
		   // chromeOptions.addArguments("--headless");
		   // chromeOptions.addArguments("disable-gpu");
		   // chromeOptions.addArguments("window-size=800x600");
		   // chromeOptions.addArguments("screenshot");
		   // driver = new ChromeDriver(chromeOptions);
			
	       // //driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
			
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getIePath());
			driver=new InternetExplorerDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver=new EdgeDriver();
		}
		/*else if(br.equals("htmlUnit")){
			
			driver = new HtmlUnitDriver();
		}*/
		
		/*======== CONFIGURE BROWSER SETTINGS ========*/
		driver.manage().getCookies().clear();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 90);
		
		currentRow = Crow;
		System.out.println("Current Row is "+ currentRow);
		/*======== Launch Browser ========*/
		driver.get(baseURL);
		logger.info("Base url launched");
	}
	
	@AfterClass
	public void quitBrowser() throws Exception
	{
	  	//driver.quit();
		Thread.sleep(3000l);
		//String methodName = this.getClass().getName();
	}
	
/*	public static void switchtoWindow(int index){
		
		String windowId = null;
		String windowIds = driver.getWindowHandles();
		Set<String> iter = windowIds.iterator();
		
		for(int i =1; i<= index; i++){
			
			windowId = iter.next();
		}
		driver.switchTo().window(windowId);
	}*/	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());//TimeStamp
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname +"_"+timeStamp + ".png");
		
		File target = new File(System.getProperty("user.dir") + "/target/Screenshots/" + tname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	public void captureScreenfullPage(WebDriver driver, String tname) throws IOException {
		
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    ImageIO.write(fpScreenshot.getImage(),"PNG",new File(System.getProperty("user.dir") + "/target/Screenshots/" + tname +".png"));
		System.out.println("Full Page Screenshot taken");
	}
	
	
	public String regExtract(String value)
	{
		if (value.contains("Claim Number")) {

			patrn = Pattern.compile("(\\d+)");
			
		} else if (value.contains("-")) {
			
			patrn = Pattern.compile("(PA\\d+-\\d+)");

		} else {

			patrn = Pattern.compile("(PA\\d+)");
		}

		 matchr = patrn.matcher(value);
	     
	     while(matchr.find()) {
	    	 extractValue = matchr.group();
	            System.out.println(matchr.group());
	        }
		
	     
		return extractValue;
	}

}
