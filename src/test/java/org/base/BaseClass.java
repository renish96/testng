package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static void enterUrl(String url) {
		driver.get(url);

	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();

	}

	public void elementSendkeys(WebElement element, String data) {
		explicitVisibilityOf(30, element);
		element.sendKeys(data);

	}

	public void elementClick(WebElement element) {
		explicitVisibilityOf(30, element);
		element.click();

	}

	public void alertClickOk(Alert alert) {

		Alert al = driver.switchTo().alert();
		al.accept();

	}

	public void alertClickCancel(Alert alert) {
		Alert al = driver.switchTo().alert();
		al.dismiss();

	}

	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	public void closeWindow() {
		driver.close();

	}

	public static void quitWindow() {
		driver.quit();

	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void selectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void elementSendkeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	public void elementClickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);

	}

	public static void chromeBrowserLaunch() {
		driver = new ChromeDriver();

	}

	public void switchToChildWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindow : allWindows) {
			if (!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);

			}

		}

	}

	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);

	}

	public void switchFrameByFrameId(String frameId) {
		driver.switchTo().frame(frameId);

	}

	public WebElement findLocatorById(String attribute) {

		WebElement element = driver.findElement(By.id(attribute));
		return element;

	}

	public WebElement findLocatorByClass(String attribute) {
		WebElement element = driver.findElement(By.className(attribute));
		return element;

	}

	public WebElement findLocatorByName(String attribute) {
		WebElement element = driver.findElement(By.name(attribute));
		return element;

	}

	public WebElement findLocatorByXpath(String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;

	}

	public List<String> getAllOptionsTextDropDown(WebElement element) {
		List<String> listText = new ArrayList<String>();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement eachElement : options) {
			String text = eachElement.getText();
			listText.add(text);

		}
		return listText;
	}

	public List<String> getAllOptionsAttributeDropDown(WebElement element, String value) {
		List<String> listAttribute = new ArrayList<String>();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement eachElement : options) {
			String attribute = eachElement.getAttribute(value);

		}
		return listAttribute;

	}

	public String firstSelectedOptions(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;

	}

	public boolean isMultiSelect(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public static void implicitlyWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void explicitVisibilityOf(int secs, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

//	public void fluentWait(int secs, String xpath) {
//		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(secs))
//				.pollingEvery(Duration.ofSeconds(secs)).ignoring(Exception.class);
//
//		WebElement until = w.until(new Function<WebDriver, WebElement>() {
//
//			public WebElement apply(WebDriver driver) {
//
//				return driver.findElement(By.xpath(xpath));
//			}
//		});
//
//	}

	public boolean isDisplayed(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		boolean displayed = element.isDisplayed();
		return displayed;

	}

	public boolean isEnabled(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		boolean enabled = element.isEnabled();
		return enabled;

	}

	public boolean isSelected(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		boolean selected = element.isSelected();
		return selected;

	}

	public void deSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void deSelectByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	public void deSelectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public String getParentWindow() {
		String parentWindow = driver.getWindowHandle();
		return parentWindow;

	}

	public Set<String> getAllWindow() {

		Set<String> allWindows = driver.getWindowHandles();

		return allWindows;

	}

	public void elementClear(WebElement element) {
		element.clear();

	}

	public void screenShot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Arockia\\eclipse-workspace\\MavenProject\\ScreenShot\\" + name + ".png");
		FileUtils.copyFile(s, d);
	}

	public void screenShotWebElement(String xpathExpession, String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		WebElement element = driver.findElement(By.xpath(xpathExpession));
		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Arockia\\eclipse-workspace\\MavenProject\\ScreenShot\\" + name + ".png");
		FileUtils.copyFile(s, d);

	}

	public void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public void dragAndDrop(WebElement source, WebElement Destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, Destination).perform();

	}

	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

	public void insertAndEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);

	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public static String readCellData(String sheetName, int rownum, int cellnum) throws IOException {
		String res = "";
		File file = new File("C:\\Users\\Arockia\\eclipse-workspace\\MavenProject\\ExcelSheet\\LoginData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				res = dateFormat.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check == numericCellValue) {
					res = String.valueOf(check);

				} else {
					res = String.valueOf(numericCellValue);
				}
			}
			break;

		default:
			break;
		}
		return res;

	}

	public void replaceCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\Arockia\\eclipse-workspace\\MavenProject\\ExcelSheet\\LoginData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);

		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	public void insertValueInCell(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\Arockia\\eclipse-workspace\\MavenProject\\ExcelSheet\\LoginData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	public void removeSelectedProducts(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < elements.size(); i++) {
			if (elements.size() != 0) {
				WebElement element2 = elements.get(i);
				element2.click();
			}

		}
	}

}
