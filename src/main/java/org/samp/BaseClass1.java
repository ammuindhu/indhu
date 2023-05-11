package org.samp;



	import java.io.File;
	import java.io.FileInputStream;
	
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.sql.Date;
	
	import java.text.SimpleDateFormat;

	

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;



	public class BaseClass1 {
		public static WebDriver driver;
		
		public static void launchBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		public static void windowMaximize() {
			driver.manage().window().maximize();
		}
		public static void Launchurl(String url) {
			driver.get(url);
		}
		public static void pageTitle() {
			String title = driver.getTitle();
			System.out.println(title);
		}
		public static void pageurl() {
			String url = driver.getCurrentUrl();
			System.out.println(url);
		}
		public static void passText(String txt,WebElement ele ) {
			ele.sendKeys(txt);
		}
		public static void closeEntireBrowser() {
			driver.quit();
		}
		public static void clickButton(WebElement ele) {
			ele.click();
		}
		public static void screenshot(String imgname) throws IOException  {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File image = ts.getScreenshotAs(OutputType.FILE);
			File f = new File("location+imagename.png");
			FileUtils.copyFile(image, f);
			
		}
		public static Actions a;
		public static void MoveThecursor(WebElement targetWebElement) {
			a=new Actions(driver);
			a.moveToElement(targetWebElement).perform();
		}
		public static void dragDrop(WebElement dragwebElement,WebElement dropElement) {
			a=new Actions(driver);
			a.dragAndDrop(dragwebElement, dropElement).perform();
		}
			public static JavascriptExecutor js;
			public static void ScrollThePage(WebElement tarwebElement) {
				js= (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollintoview(true).", tarwebElement);
				
			}
				public static void scroll(WebElement element) {
					js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollintoview(false)", element);
					
				}
			public static void excelRead(String sheetname,int rownum,int cellnum)throws IOException {
				File f =new File("C:\\Users\\ammui\\eclipse-workspace\\ DataDriven\\excel.xlsx");
				FileInputStream fis = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fis);
				Sheet mysheet = wb.getSheet("Datas");
				Row r = mysheet.getRow(rownum);
				Cell c = r.getCell(cellnum);
				int celltype = c.getCellType();
				
				String value = " ";
				if (celltype==1) {
					String value2 = c.getStringCellValue();
				}	
				else if (DateUtil.isCellDateFormatted(c)) {
					Date dd = (Date) c.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat(value);
					String value1= s.format(dd);
				}		
				else {
					double d = c.getNumericCellValue();
					long l = (long)d;
					String valueof = String.valueOf(l);
				}
		
			}
		public static void createnewexcelfile(int rownum,int cellnum,String newdata) throws IOException {
			File f = new File("C:\\Users\\ammui\\eclipse-workspace\\ DataDriven\\excel\\newfile.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newsheet = w.createSheet("Datas");
			Row newrow = newsheet.createRow(rownum);
			Cell newcell = newrow.createCell(cellnum);
			newcell.setCellValue(newdata);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			
		}
		public static void createcell(int rownum,int cellnum,String newdata) throws IOException {
			File f = new File("C:\\Users\\ammui\\eclipse-workspace\\ DataDriven\\excel\\newfile.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet("Datas");
		    Row r = s.getRow(rownum);
		    Cell c = r.createCell(cellnum);
		    c.setCellValue(newdata);
		    FileOutputStream fos = new FileOutputStream(f);
		    w.write(fos);
			
	}
		public static void createrow(int createrow,int createcell,String newdata) throws IOException {
			File f = new File("C:\\Users\\ammui\\eclipse-workspace\\ DataDriven\\excel\\newfile.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s= w.getSheet("Datas");
			Row r = s.createRow(createrow);
			Cell c = r.createCell(createcell);
			c.setCellValue(newdata);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
		}
		public static void updatedatatoparticularcell(int gettherow,int getthecell,String existingdata,String writennewdata) throws IOException {
			File f = new File("C:\\Users\\ammui\\eclipse-workspace\\ DataDriven\\excel\\newfile.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet("Datas");
			Row r = s.getRow(gettherow);
			Cell c = r.getCell(getthecell);
			String str = c.getStringCellValue();
			if (str.equals(existingdata)) {
				c.setCellValue(writennewdata);
			}
				FileOutputStream fos = new FileOutputStream(f);
				w.write(fos);
			}
			
	}
