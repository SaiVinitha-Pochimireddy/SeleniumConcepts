package DataDriventesting;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingdatatoXL {

	public static void main(String[] args) throws IOException {
		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+"\\xldata\\writing.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sh= wb.createSheet("sheet1");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<=2;i++)
		{
			XSSFRow currentrow= sh.createRow(i);
			for(int c=0;c<3;c++)
			{
				System.out.println("enter value for "+i+" row "+c+" col");
				String str=sc.next();
				currentrow.createCell(c).setCellValue(str);
			}
			System.out.println();
		}
		wb.write(file);
		wb.close();
		file.close();

	}

}
