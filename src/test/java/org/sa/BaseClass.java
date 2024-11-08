package org.sa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.gecko.GeckoDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void launchBrowser() {
		//System.setProperty("webdriver.firefox.driver", "C:\\Users\\Saranya\\eclipse-workspace\\JunitProject\\drivers\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		
						driver= new FirefoxDriver();
	}

	public static void windowMaximize() {
		// TODO Auto-generated method stub
		// manage
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}

	public static void pageTitle() {
		// TODO Auto-generated method stub
		String pageTitle = driver.getTitle();
		System.out.println("Current Page Title: " + pageTitle);
	}

	public static void launchUrl() {
		// TODO Auto-generated method stub
		// Current Url
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Page Url is: " + currentUrl);
	}

	public static void passText(String txt, WebElement element) {
		// TODO Auto-generated method stub
		element.sendKeys(txt);
	}

	public static void closeEntireBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}
	public static void clickButton(WebElement element) {
		// TODO Auto-generated method stub
		element.click();
	}
	
	//Actions
	public static Actions obj;
	
	public static void mouseHover(WebElement courseElement){
		obj = new Actions(driver);
		obj.moveToElement(courseElement).perform();
	}
	
	public static void dragDrop(WebElement dragElement, WebElement dropElement){
		obj = new Actions(driver);
		obj.dragAndDrop(dragElement,dropElement).perform();
	}
	
	public static JavascriptExecutor js;
	
	public static void scrollthePage(WebElement target) {
		// TODO Auto-generated method stub
		 js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", target);
	}
	public static void scrolltheView(WebElement targetf) {
		// TODO Auto-generated method stub
		 js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", targetf);
	}
	
	public static void excelRead(String sheetName,int row,int cell) throws IOException{
		
		//file path -find
		File f= new File("C:\\Users\\Saranya\\eclipse-workspace\\MavenProject\\Excel\\SampleData.xlsx");
		//file read
		FileInputStream fis= new FileInputStream(f);		
		//create object for xssf workbook - to read xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(fis);		
		//get sheet from workbook		
		XSSFSheet mySheet = wb.getSheet("Datas");			
			Row r = mySheet.getRow(row);			
			Cell c = r.getCell(cell);
			int cellType=c.getCellType();
			String  Value= " ";			
			if(cellType== 1) {
				String value = c.getStringCellValue();				
			}
			else if(DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				//convert date cell tostring format
				SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yy");
				String dateValue = s.format(date);
							}
			else {
				double numericCellValue = c.getNumericCellValue();
				long l = (long) numericCellValue;
				//convert long to string
				String numValue = String.valueOf(l);				
			}
			
	}
	
	//Create NewExce file
	public static void createNewExcelFile(int rowNum,int cellNum,String newData) throws IOException{
		File f = new File("C:\\Users\\Saranya\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newSheet = w.createSheet("Datas");
		Row newRow =newSheet.createRow(rowNum);
		Cell newCell =newRow.createCell(cellNum);
		newCell.setCellValue(newData);
		FileOutputStream fos= new FileOutputStream(f);
		w.write(fos);		
	}

	
	//Create Cell
	
		public static void createCell(int rowNum,int cellNum,String newData) throws IOException{
			File f = new File("C:\\Users\\Saranya\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
			FileInputStream fis= new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet newSheet = w.getSheet("Datas");
			Row newRow =newSheet.getRow(rowNum);
			Cell newCell =newRow.createCell(cellNum);
			newCell.setCellValue(newData);
			FileOutputStream fos= new FileOutputStream(f);
			w.write(fos);		
		}
		//create row
		public static void createRow(int creRow,int cell,String newData) throws IOException{
			File f = new File("C:\\Users\\Saranya\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
			FileInputStream fis= new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);	
			Sheet newSheet = w.getSheet("Datas");
			Row newRow =newSheet.createRow(creRow);
			Cell newCell =newRow.createCell(cell);
			newCell.setCellValue(newData);
			FileOutputStream fos= new FileOutputStream(f);
			w.write(fos);		
		}
		//update data in cell
		public static void updateCell(int creRow,int cell,String newData, String updateData) throws IOException{
			File f = new File("C:\\Users\\Saranya\\eclipse-workspace\\MavenProject\\Excel\\newfile.xlsx");
			FileInputStream fis= new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);	
			Sheet newSheet = w.getSheet("Datas");
			Row newRow =newSheet.getRow(creRow);
			Cell newCell =newRow.getCell(cell);
			String str = newCell.getStringCellValue();
			if(str.equals(newData)) {
			newCell.setCellValue(updateData);
			}
			FileOutputStream fos= new FileOutputStream(f);
			w.write(fos);		
		}
}
