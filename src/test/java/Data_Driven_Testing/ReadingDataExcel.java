package Data_Driven_Testing;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingDataExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/testData/data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        //workbook.getSheet("Sheet1");
        XSSFSheet sheet = workbook.getSheet("1ფურცელი");
        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(1).getLastCellNum();
        System.out.println("num of total  rows: " + totalRows);
        System.out.println("num of total cells: " + totalCells);

        for(int r=0; r<= totalRows; r++){
            XSSFRow currentRow = sheet.getRow(r);
            for(int c=0; c<totalCells; c++){
                XSSFCell currentCell = currentRow.getCell(c);
                System.out.print(currentCell.toString()+"\t");
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}
