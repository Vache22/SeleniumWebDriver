package Data_Driven_Testing;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataIntoExcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"/testData/data2.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("welcome");
        row1.createCell(1).setCellValue(1234);
        row1.createCell(2).setCellValue("Java");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Python");
        row2.createCell(1).setCellValue(1234);
        row2.createCell(2).setCellValue("Appium");

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("JS");
        row3.createCell(1).setCellValue(1234);
        row3.createCell(2).setCellValue("Automation");

        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("file is created");

    }
}
