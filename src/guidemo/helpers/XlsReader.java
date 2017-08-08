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
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import guidemo.models.WaterDetail;
import java.util.ArrayList;

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

                    if (type == CellType.BOOLEAN) {
                        System.out.print(cell.getBooleanCellValue());
                    }

                    if (type == CellType.FORMULA) {
                        System.out.print(cell.getCellFormula());
                    }

                    if (type == CellType.NUMERIC) {
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

    static public WaterDetail[] readWaterInfo(String fileName, int beginRow, int sheetNumber) {
        
        ArrayList<WaterDetail> rs = new ArrayList<>();
        
        try {
            FileInputStream excelFile = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet datatypeSheet = workbook.getSheetAt(sheetNumber);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int line = 0;
            
            
            
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();

                if (line >= beginRow) {
                    Cell dateCell = nextRow.getCell(1);
                    Cell tciInCell = nextRow.getCell(2);
                    Cell tciOutCell = nextRow.getCell(3);
                    Cell tempCell = nextRow.getCell(4);
                    Cell nh3Cell = nextRow.getCell(5);
                    Cell no2Cell = nextRow.getCell(6);
                    Cell umkdCell = nextRow.getCell(7);
                    Cell fnCell = nextRow.getCell(8);
                    Cell brcCell = nextRow.getCell(9);
                    Cell retTimeCell = nextRow.getCell(10);
                    Cell krtCell = nextRow.getCell(11);
                    Cell krt20Cell = nextRow.getCell(12);
                    Cell tciBRCCell = nextRow.getCell(13);
                    Cell tabletCell = nextRow.getCell(14);

                    if (canParseDate(dateCell)) {
                        Date date = dateCell.getDateCellValue();
                        float tciIn = tryParseNumber(tciInCell);
                        float tciOut = tryParseNumber(tciOutCell);
                        float temp = tryParseNumber(tempCell);
                        float nh3 = tryParseNumber(nh3Cell);
                        float no2 = tryParseNumber(no2Cell);
                        float tablet = tryParseNumber(tabletCell);
                        float umkd = tryParseNumber(umkdCell);
                        float fn = tryParseNumber(fnCell);
                        float brc = tryParseNumber(brcCell);
                        float retTime = tryParseNumber(retTimeCell);
                        float krt = tryParseNumber(krtCell);
                        float krt20 = tryParseNumber(krt20Cell);
                        float tciBRC = tryParseNumber(tciBRCCell);

                        WaterDetail dt;
                        dt = new WaterDetail(date, tciIn, tciOut, temp, nh3, no2, tablet);
                        dt.umkd = umkd;
                        dt.fn = fn;
                        dt.brc = brc;
                        dt.retTime = retTime;
                        dt.krt = krt;
                        dt.krt20 = krt20;
                        dt.tciBRC = tciBRC;
                                
                        rs.add(dt);
                    }
                }

                line++;
            }

            workbook.close();
            excelFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XlsReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XlsReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs.toArray(new WaterDetail[rs.size()]);
    }

    public static float tryParseNumber(Cell cell) {
        float val = 0;

        if (cell != null) {
            CellType type = cell.getCellTypeEnum();

            if (type == CellType.NUMERIC) {
                val = (float) cell.getNumericCellValue();
            }
            
            if (type == CellType.FORMULA) {
                
                CellType cachedType = cell.getCachedFormulaResultTypeEnum();
                if ( cachedType == CellType.NUMERIC) {
                    val = (float) cell.getNumericCellValue();
                }
                
            }
        }

        return val;
    }

    private static Boolean canParseDate(Cell cell) {
        if (cell == null) {
            return false;
        }

        return cell.getCellTypeEnum() == CellType.NUMERIC;
    }
}
