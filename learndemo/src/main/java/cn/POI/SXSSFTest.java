package cn.POI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class SXSSFTest {

    static String path = "C:\\Users\\Administrator\\Desktop\\testF.xlsx";

    public static void main(String[] args) throws Throwable {
        creatEmptySheet();
    }

    public static void creatEmptySheet() throws IOException {
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // 在内存当中保持 100 行 , 超过的数据放到硬盘中
        Sheet sh = wb.createSheet();
        Row row = sh.createRow(0);
        Cell cell = row.createCell(3);
        String address = new CellReference(cell).formatAsString();
        cell.setCellValue(address);
        FileOutputStream out = new FileOutputStream(path);
        wb.write(out);
        out.close();
        wb.dispose();
    }

    public static void creatSheetLoop() throws IOException {
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // 在内存当中保持 100 行 , 超过的数据放到硬盘中
        Sheet sh = wb.createSheet();
        for (int rownum = 0; rownum < 10000; rownum++) {
            Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < 10; cellnum++) {
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }

        }
        FileOutputStream out = new FileOutputStream(path);
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();
    }

}
