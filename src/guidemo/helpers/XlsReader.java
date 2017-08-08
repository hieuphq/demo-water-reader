/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author hieuphan
 */
public class XlsReader {

    public static void readXlsFile(String fileName) {
        String excelFilePath = fileName;
        try {
            FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet datatypeSheet = workbook.getSheetAt(1);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    CellType type = cell.getCellTypeEnum();
                    
                    if (type == CellType.STRING) {
                        System.out.print(cell.getStringCellValue());
                    }
                    
                    if (type == CellType.BOOLEAN){
                        System.out.print(cell.getBooleanCellValue());
                    }
                    
                    if (type == CellType.FORMULA){
                        System.out.print(cell.getCellFormula());
                    }
                    
                    if (type == CellType.NUMERIC){
                        System.out.print(cell.getNumericCellValue());
                    }
                    
                    System.out.print(" - ");
                }
                System.out.println();
            }

            workbook.close();
            excelFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XlsReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XlsReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
