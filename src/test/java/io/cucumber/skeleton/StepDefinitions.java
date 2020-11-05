
  package io.cucumber.skeleton;
  
  import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
  

  public class StepDefinitions {
	  public static String inputfile=System.getProperty("user.dir")+ "\\TestData\\TestData.xlsx";
	  public static FileInputStream inputStream;
	  public static XSSFWorkbook workbook;
	  public static XSSFSheet spreadsheet;
	  public static Sheet sheet;
	  public static Row DataRow;
	  public static Cell DataCell;
	  
	  @Given("This is my test one")
		public void this_is_my_test_one() {
		    System.out.println("This is test one");
		    System.out.println("input path:" + inputfile);
		}

		@Then("This is my test two")
		public void this_is_my_test_two() {
			 System.out.println("This is test two");
		}

		@Then("This is my test three")
		public void this_is_my_test_three() {
			 System.out.println("This is test three");
		}
		
		@Given("I add payload with {string} and then get asyncquotes api payload with {string}")
		public void i_add_payload_with_and_then_get_asyncquotes_api_payload_with(String arg1, String arg2) throws IOException 
		{
			System.out.println("input path:" + inputfile);
			System.out.println("This is test" + arg1);
		    System.out.println("This is test" + arg2);
		    System.out.println("*****************************************************");
		    System.out.println("Processed one..... processing next test data.....");
		    
		    /* Add lead Scenario */
			
			  String get_make=get_value_from_excel(inputfile,"VehicleTestData",arg1,"Make");
			  //System.out.println(arg1 + "---> getmake : "  + get_make );
			  String get_model=get_value_from_excel(inputfile,"VehicleTestData",arg1,"Model");
			  //System.out.println(arg1 + "---> getmodel : "  + get_model );
			  String get_version=get_value_from_excel(inputfile,"VehicleTestData",arg1,"Version");
			  //System.out.println(arg1 + "---> getversion : "  + get_version );
			  String get_rto_code=get_value_from_excel(inputfile,"VehicleTestData",arg1,"rto_code");
			  //ystem.out.println(arg1 + "---> get_rto_code : "  + get_rto_code );
			 
			  System.out.println(arg1  + "||" + get_make + "||" + get_model +"||" + get_version +"||" +  get_rto_code);
		    
		    /* Now you got all data related to adding a lead */
		    
		    /* Running Quotes Verification Scenario */
		   
		    String get_policy_type=get_value_from_excel(inputfile,"PolicyTestData",arg2,"policy_Type");
		    	//System.out.println(arg2 + "---> getPolicyTpe : "  + get_policy_type );
		    String get_idv=get_value_from_excel(inputfile,"PolicyTestData",arg2,"idv");
		    	//System.out.println(arg2 + "---> get_idv : "  + get_policy_type );
		    String get_preNcbpercentage=get_value_from_excel(inputfile,"PolicyTestData",arg2,"prevNcbPercentage");
		    	//System.out.println(arg2 + "---> get_PreNcbpercentage : "  + get_policy_type );
		    
		    System.out.println(arg2  + "||" + get_policy_type + "||" + get_idv +"||" + get_preNcbpercentage);
	    
		}

		

		@When("user calls api")
		public void user_calls_api() {
		   System.out.println("this is code for user api call");
		}

		@Then("api call is success")
		public void api_call_is_success() {
			System.out.println("this is code to check  api call success");
		}

		@Then("message in response body success")
		public void message_in_response_body_success() {
			System.out.println("this is code to check response body");
		}

		@Then("status in response body {string}")
		public void status_in_response_body(String string) {
			System.out.println("this is code to check code 200 in response");
		}
		
		@Then("get asyncquote")
		public void get_asyncquote() {
			System.out.println("this is code to check get asyncquote");
		}

		@Then("user calls getquotesapi")
		public void user_calls_getquotesapi() {
			System.out.println("this is code to call getquotesapi");
		}

		@Then("api call is success with code {string}")
		public void api_call_is_success_with_code(String string) {
			System.out.println("this is code to check code 200 in response");
		}

  
  private String get_value_from_excel(String inputfile, String SheetName, String TestDataColumnName, String TestDataRowName) throws IOException
	{
		int row_number_to_read=0;
		//System.out.println("StoreReportValue-Input/Output");
		   int columns_count=0;
		   int Column_number_to_write=0;
		   String column_name=null;
		File file =new File(inputfile);
		inputStream=new FileInputStream(file);
		workbook= new XSSFWorkbook(inputStream);
		sheet=workbook.getSheet(SheetName);
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		//System.out.println("Number of Rows : " + rowCount );

		 /* Get the Column Number */
		
		
		/* Get the Value based on RowName */
		
		 
		/* Get the Row Number as per the RowName in the received argument */
		
			for(int i=0;i<rowCount+1;i++)
			{
					DataRow=sheet.getRow(i);
				for(int j=0;j<1;j++)
				{
					//System.out.println(DataRow.getCell(j).getRichStringCellValue() + " II ");
					if(DataRow.getCell(j).getStringCellValue().equalsIgnoreCase(TestDataRowName))
					{
						row_number_to_read=i;
					//System.out.println("Row Number to get Data is : "  + row_number_to_read);
					break;
					}
				}
			}

		DataRow=sheet.getRow(row_number_to_read);
		//System.out.println("fiding column");
		columns_count=DataRow.getLastCellNum();

		/* Get the Column Number to write as per Column Name recieved in the arguments */
		for(int j=0;j<=columns_count;j++)
		{
			DataRow=sheet.getRow(0);
			//DataCell=DataRow.getCell(j);
			column_name=DataRow.getCell(j).getStringCellValue();
			//System.out.println("Column Name : "  + column_name);

			if(column_name.equalsIgnoreCase(TestDataColumnName))
			{
			Column_number_to_write=j;
			//System.out.println("Column Number to get data : "  + Column_number_to_write);
			break;
			}
		}
		DataRow=sheet.getRow(row_number_to_read);
		DataCell=DataRow.getCell(Column_number_to_write);
		int cell_type=DataCell.getCellType();
		//System.out.println("Cell type" + cell_type);
		
		
		String value_retrieved=DataRow.getCell(Column_number_to_write).getStringCellValue();
		//System.out.println("value retrieved is : " + value_retrieved);
		workbook.close();
		return value_retrieved;
	}
  }
  