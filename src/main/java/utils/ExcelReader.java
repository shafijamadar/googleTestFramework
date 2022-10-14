package utils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ExcelReader {

    @DataProvider(name="excelData")
    public Object[][] getExcelData(Method method) throws EncryptedDocumentException, IOException {

        String sheetName = method.getName();

        FileInputStream is = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\loginData.xlsx"));
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheetname = wb.getSheet(sheetName);

        int totalRows = sheetname.getLastRowNum();
        System.out.println("Total rows of the sheet are " +totalRows);
        Row rowCells = sheetname.getRow(0);
        int totalCols = rowCells.getLastCellNum();

        System.out.println("Total columns are "+totalCols);

        DataFormatter dataFormatter = new DataFormatter();

        String testData[][] = new String [totalRows][totalCols];
        for(int i=1; i<=totalRows;i++){
            for(int j=0; j<totalCols;j++){
                testData[i-1][j]= dataFormatter.formatCellValue(sheetname.getRow(i).getCell(j));
            }
        }
        return testData;
    }
}
