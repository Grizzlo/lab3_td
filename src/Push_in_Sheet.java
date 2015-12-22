/**
 * Created by grizzly on 30-Nov-15.
 */
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
public class Push_in_Sheet {
    Push_in_Sheet(){
        try {
            //Get the excel file.
            InputStream fil = new FileInputStream("D:\\projects\\lab3_td\\data\\sheet.xlsx");

            //Get workbook for XLS file.
            Workbook wb =  WorkbookFactory.create(fil);

            Sheet sheet = wb.getSheet("Sheet1");
            Row row = sheet.getRow(4);
            try {
                Cell cell = row.getCell(3);
                if (cell.getCellType()== Cell.CELL_TYPE_BLANK) {
                    cell = row.createCell(3);
                }
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue("a test");
            } catch (NullPointerException e){
                System.out.println("aaa");
            }
            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream("D:\\projects\\lab3_td\\data\\sheet.xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
    } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
