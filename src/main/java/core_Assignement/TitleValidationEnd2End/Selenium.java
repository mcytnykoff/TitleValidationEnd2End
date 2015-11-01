package core_Assignement.TitleValidationEnd2End;

//BEGIN
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
       
	
	
	
	 public static void main(String[] args) throws IOException {

  	   core_Assignement.TitleValidationEnd2End.Selenium selenuim = new core_Assignement.TitleValidationEnd2End.Selenium();
        selenuim.a2d();

     }



	
	
	
	
	
	
	public String[][] a2d() throws IOException {

    	 //String csvFile = "C:/Workspace/TitleValidationEnd2End/src/main/resources/Title_Validation.csv";
   		   String csvFile = "/Users/cydobolctbnem/Documents/Development/TitleValidationEnd2End/src/main/resources/Title_Validation.csv";
             
             BufferedReader br = null;
             String line = null;
             String[] column = null;
             int lines = 0;
             int columns = 0;
             String SplitBy = ",";
             String text_case_id = null;
             String url = null;
             String title_expected = null;
             
             // COUNTING LINES AND COLUMNS

             br = new BufferedReader(new FileReader(csvFile));
             
             while ((line = br.readLine()) != null) {

                    lines++;

                    column = line.split(SplitBy);

                    columns = column.length;

             }

             br.close();

 

             String s2d[][] = new String[lines][columns];

             br = new BufferedReader(new FileReader(csvFile));

             WebDriver driver = new FirefoxDriver();

             int i = 0;

             while ((line = br.readLine()) != null) {

 

                    String[] csv = line.split(SplitBy);

 

                    text_case_id = csv[0];

                    url = csv[1];

                    title_expected = csv[2];

 

                    driver.get(url);

                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

                    String title_actual = driver.getTitle();

 

                    s2d[i][0] = text_case_id;

                    s2d[i][1] = title_expected;

                    s2d[i][2] = title_actual;

 

                   i++;

             }

 

             driver.quit();

             br.close();

             return s2d;

 

       }

 

      


// END
}
