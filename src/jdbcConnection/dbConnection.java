package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;






public class dbConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	
		String host= "localhost";
		String port= "3306";
	Connection con=	DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/demo", "root", "sql@password");
Statement st=	con.createStatement();
		ResultSet rs=st.executeQuery("select * from Employee_info where name='sad';");
		while (rs.next())
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Selenium\\chromedriver.exe");
			
			//invoke webdriver object
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com/?locale=in");
			
	driver.findElement(By.id("username")).sendKeys(rs.getString("name")) ;
	driver.findElement(By.id("password")).sendKeys(rs.getString("location"));
		}
		
	}

}
