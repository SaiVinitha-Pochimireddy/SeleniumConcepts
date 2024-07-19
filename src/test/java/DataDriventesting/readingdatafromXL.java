package DataDriventesting;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingdatafromXL {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\xldata\\caldata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sh= wb.getSheet("sheet2");
		int row=sh.getLastRowNum();
		int col=sh.getRow(1).getLastCellNum();
		
		for(int i=0;i<=row;i++)
		{
			XSSFRow currentrow= sh.getRow(i);
			for(int c=0;c<col;c++)
			{
				//XSSFCell res=currentrow.getCell(c);
				String str=currentrow.getCell(c).toString();
				System.out.print(str+"  ");
			}
			System.out.println();
		}
		wb.close();
		file.close();

	}

}
