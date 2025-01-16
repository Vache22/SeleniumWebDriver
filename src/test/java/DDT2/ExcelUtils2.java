package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils2 {

    private static Workbook workbook;
    private static Sheet sheet;

    // Method to open the Excel file and sheet
    public static void openExcelFile(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(new File("testData/sample.xlsx"));
        workbook = new XSSFWorkbook(fis);  // For .xlsx files
        sheet = workbook.getSheet(sheetName);
    }

    // Method to get data from the sheet (returns a List of Objects representing rows)
    public static List<Object[]> getData() {
        List<Object[]> data = new ArrayList<>();

        // Iterate over all rows (starting from row 1, assuming row 0 contains headers)
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();  // Skip the header row

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            List<String> rowData = new ArrayList<>();

            // Iterate over each cell and store its value
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                rowData.add(cell.toString());  // Store each cell value as a string
            }

            // Add the row's data as an Object array
            data.add(rowData.toArray(new Object[0]));
        }

        return data;
    }

    // Method to close the Excel file
    public static void closeExcel() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
