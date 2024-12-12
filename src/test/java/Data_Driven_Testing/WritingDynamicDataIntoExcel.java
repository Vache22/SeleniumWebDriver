package Data_Driven_Testing;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WritingDynamicDataIntoExcel {
    public static void main(String[] args)  throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"/testData/data3.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DynamicData");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int numOfRows = sc.nextInt();

        System.out.println("Enter number of cells: ");
        int numOfCells = sc.nextInt();

        for (int r=0; r <= numOfRows; r++){
            XSSFRow currentRow = sheet.createRow(r);
            for(int c=0; c < numOfCells; c++){
                XSSFCell currentCell = currentRow.createCell(c);
                currentCell.setCellValue(sc.next());
            }
        }
        workbook.write(file);
        workbook.close();
        file.close();

        System.out.println("file is created...");
    }
}
