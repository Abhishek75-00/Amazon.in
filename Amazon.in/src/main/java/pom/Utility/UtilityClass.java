package pom.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {

	public static void capture(WebDriver driver,int testid,String methodName) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date=new Date();
		String DateTime=sdf.format(date);
		String ScreenshotName=DateTime+" "+testid+" "+methodName;
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest="./test-output/Screenshot/" +ScreenshotName+".png";
		
		File destination=new File(dest);
		
		ImageIO.write(ImageIO.read(source),"png",destination);
		
	}
	
	private static final String FILE_NAME=".\\src\\main\\resources\\Test-Data\\BatchOct@2.xlsx";
	
	
	public static String fetchDataAsString(String sheetName, int row, int cell) {
	    String data = null;
	    FileInputStream file = null;
	    Workbook workbook = null;

	    try {
	        file = new FileInputStream(FILE_NAME);
	        workbook = new XSSFWorkbook(file);
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row rowObj = sheet.getRow(row);
	        Cell cellObj = rowObj.getCell(cell);

	        if (cellObj != null) {
	            switch (cellObj.getCellType()) {
	                case STRING:
	                    data = cellObj.getStringCellValue();
	                    break;
	                case NUMERIC:
	                    double numericValue = cellObj.getNumericCellValue();
	                    if (numericValue % 1 == 0) {
	                        
	                        data = Integer.toString((int) numericValue);
	                    } else {
	                       
	                        data = Double.toString(numericValue);
	                    }
	                    break;
	                default:
	                    
	                    break;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (file != null) {
	                file.close();
	            }
	            if (workbook != null) {
	                workbook.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return data;
	}}