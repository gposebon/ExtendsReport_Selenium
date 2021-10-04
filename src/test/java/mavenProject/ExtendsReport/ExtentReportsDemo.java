package mavenProject.ExtendsReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		String urlReport = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(urlReport);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Guillermo Posebon");
	}
	
	
	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Test Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();		
		extent.flush();
	}

}
