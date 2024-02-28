package utilities;
 
import java.io.IOException;
 
import org.testng.annotations.DataProvider;
 
public class DataProviders {
 
@DataProvider(name="invalid_password")
	
	public String [][] invalid_password() throws IOException
	{
		String path=".\\Testdata\\data.xlsx";        //taking xl file from testData
		Excelutils xlutil=new Excelutils(path);      //creating an object for XLUtility
		int totalrows=xlutil.getRowCount("Sheet2");	
		int totalcols=xlutil.getCellCount("Sheet2",1);
		String invalid_password[][] = 	new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=0;j<totalcols;j++)  
			{
				invalid_password[i-1][j]= xlutil.getCellData("Sheet2",i, j);  
			}
		}
	return invalid_password;
	}
}	