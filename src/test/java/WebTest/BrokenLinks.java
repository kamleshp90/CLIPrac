package WebTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	/*		HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
	conn.setRequestMethod("Header");
	conn.connect();
	int resCode=conn.getResponseCode();
*/

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		//broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        //  Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KAMLESH\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));

	      SoftAssert a =new SoftAssert();


	      for(WebElement link : links)

	      {
	          String url= link.getAttribute("href");
	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println(respCode);

	          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);

	      }
	      a.assertAll();


	}



	private static Object getReturnCode(WebElement link) {

	// TODO Auto-generated method stub

	return null;

	}



	}