package com.fasts.nu.student;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataProvider {

    public static List<Object[]> readExcelSheet(String fileName, String sheetName) throws Exception {
        List<Object[]> data = new ArrayList<>();

        InputStream is = ExcelDataProvider.class
                .getClassLoader()
                .getResourceAsStream(fileName);

        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheet(sheetName);

        // Start from row 1 (skip header row 0)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            double marks = row.getCell(0).getNumericCellValue();
            String expectedGrade = row.getCell(1).getStringCellValue();
            data.add(new Object[]{marks, expectedGrade});
        }

        workbook.close();
        return data;
    }
}
