package excel.Apache;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

public class DBToExcel {
	
	@Autowired
	private UserService service;
	
	 public DBToExcel(UserService service) {
		// TODO Auto-generated constructor stub
		 this.service = service;
	}

	 
    public void main() {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create headers for each column
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Expenditure");

            // Retrieve data from the database using the service
            List<User> users = service.viewUsers();

            // Write database entries into the Excel sheet
            int rowNumber = 1;
            for (User user : users) {
                Row dataRow = sheet.createRow(rowNumber++);
                dataRow.createCell(0).setCellValue(user.getId());
                dataRow.createCell(1).setCellValue(user.getName());
                dataRow.createCell(2).setCellValue(user.getEmail());
                dataRow.createCell(3).setCellValue(user.getExpenditure());
            }

            FileOutputStream fileOut = new FileOutputStream("src/main/java/SampleCustomer.xlsx");
            workbook.write(fileOut);
            fileOut.close();

            System.out.println("Excel file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   







    }
	


