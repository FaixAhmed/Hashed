package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class rwtoexcel {
    public static final String setcell = null;
    private static HSSFWorkbook workbook;
    private static HSSFSheet sheet;
    private static HSSFRow row;
    private static HSSFCell cell;

    public static void setFile( String excelFP,String sheetName) throws IOException
    {
        //object of file
        File file = new File(excelFP);

        //input stream to read the file;
        FileInputStream inputStream = new FileInputStream(file);
        //workbook instance;
        workbook = new HSSFWorkbook(inputStream);
        //sheet object;
        sheet=workbook.getSheet(sheetName);
    }
    //get data from given cell
    public static String cellData(int rnumber,int cnumber){
        cell=sheet.getRow(rnumber).getCell(cnumber);
        return cell.getStringCellValue();
        
    }
    //get total number of rows;
    public static int rowcount(){
        int rcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        return rcount;
    }
    public static void setcell(int rnum, int cnum, String cvalue, String excelFP) throws IOException
    {
        //setting a value to the cell
        sheet.getRow(rnum).createCell(cnum).setCellValue(cvalue);
        FileOutputStream outputStream = new FileOutputStream(excelFP);
        workbook.write(outputStream);
    }




}
