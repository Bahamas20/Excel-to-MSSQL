package excel.Apache;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class Main implements CommandLineRunner {
	
	@Autowired
	private UserService service;
	
	
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
 


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome");
		System.out.println("Here are the features you can do below");
		System.out.println("1.Write data from Excel file into Database");
		System.out.println("2.Write data from your Database into Excel");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		if(num == 1) {
			ExcelToDB excel = new ExcelToDB(service);
			excel.main();
			
		}
		else if (num == 2) {
			
			DBToExcel excel = new DBToExcel(service);
			excel.main();
			
			
		}
		
		//Stop
		System.exit(0); 
		    
		
	}
	

}

