package excel.Apache;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ExcelToDB {
	
	@Autowired
	private UserService service;
	
	 public ExcelToDB(UserService service) {
		// TODO Auto-generated constructor stub
		 this.service = service;
	}

	public void main() {
	        try (FileInputStream file = new FileInputStream("src/main/java/SampleCustomer.xlsx")) {
	            Workbook workbook = WorkbookFactory.create(file);

	            // Assuming the first sheet is the one you want to read
	            Sheet sheet = workbook.getSheetAt(0);
	           
	            
	            // Create a DataFormatter object
	            DataFormatter dataFormatter = new DataFormatter();

	            // Iterate over rows
	            for (Row row : sheet) {
	                // Iterate over cells in each row
	            	User newUser = new User();
	            	
	            	if(row.getRowNum() == 0) {
	            		continue;
	            		
	            	}
	            	else {
	        
		                for (Cell cell : row) {
		                    // Get the formatted value of the cell
		                    if (cell.getColumnIndex() == 0) {
		                    	String ID = dataFormatter.formatCellValue(cell);
		                    	newUser.setId(Long.parseLong(ID));
		                    }
		                    if (cell.getColumnIndex() == 1) {
		                    	String name = dataFormatter.formatCellValue(cell);
		                    	newUser.setName(name);
		                    }
		                    if (cell.getColumnIndex() == 2) {
		                    	String email = dataFormatter.formatCellValue(cell);
		                    	newUser.setEmail(email);
		                    }
		                    if (cell.getColumnIndex() == 3) {
		                    	String expenditure = dataFormatter.formatCellValue(cell);
		                    	newUser.setExpenditure(Float.parseFloat(expenditure));
		                    }
		                }
	            	}
	            	
	                
	                service.addUser(newUser);

	            }
	            System.out.println("Done adding all users !");
	            // Close the workbook
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


