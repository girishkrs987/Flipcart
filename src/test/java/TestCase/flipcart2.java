package TestCase;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipcart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		

		System.setProperty("webdriver.chrome.driver", "C:/Users/Girish/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://www.flipkart.com");
			
			
			// take the control to the pop up window and close that pop up window 
			
			Set<String> windows=	driver.getWindowHandles(); 
			
			Iterator<String> Childwindows=windows.iterator();
			String ChW=Childwindows.next();
			
			// switch to pop up window from webpage to click close button of that pop up window 
			driver.switchTo().window(ChW);
			
			driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
			
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Mobiles");
			driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
			
			// collect the weblements of mobile phone name
			
			List<WebElement> Pone_Names=driver.findElements(By.xpath("//div[@class='_3wU53n']"));
//			
//			
//			// collect the weblements of mobile phone price
//			
			List<WebElement> Pone_Price=driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
//			
			// next button 
			
			List<WebElement> next=driver.findElements(By.xpath("/a[@class='_3fVaIS']"));
			
			//for (int j=1; j<next.size();j++) {
				
			//	next.get(j).click();
				
				//List<WebElement> Pone_Names1=driver.findElements(By.xpath("//div[@class='_3wU53n']"));
				
				
				// collect the weblements of mobile phone price
				
				//List<WebElement> Pone_Price1=driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
				
			
			Utility.Xls_Reader reader=new Utility.Xls_Reader("C:\\Users\\Girish\\eclipse-workspace\\FlipKart\\src\\main\\java\\Data\\Flipcartdatafile.xlsx"); 
			
			reader.addSheet("Flipcart_Test_Data");
			reader.addColumn("Flipcart_Test_Data", "Mobile Name");
			reader.addColumn("Flipcart_Test_Data", "Mobile Price");
			
			for (int i=1; i<Pone_Names.size();i++) {
				String P_Name=Pone_Names.get(i).getText();
				String P_Price=Pone_Price.get(i).getText();
				
				//String P_Name1=Pone_Names1.get(i).getText();
				//String P_Price1=Pone_Price1.get(i).getText();
				
				
				System.out.println(P_Name);
				System.out.println(P_Price);
				reader.setCellData("Flipcart_Test_Data", "Mobile Name", i+1, P_Name);
				reader.setCellData("Flipcart_Test_Data", "Mobile Price", i+1, P_Price);
				//reader.setCellData("Flipcart_Test_Data", "Mobile Name", i+1, P_Name1);
				//reader.setCellData("Flipcart_Test_Data", "Mobile Price", i+1, P_Price1);
				
				
			}
	}

}

//}
