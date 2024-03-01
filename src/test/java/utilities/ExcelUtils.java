package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style; 
	public static XSSFFont font;
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,List<String>arr)throws IOException
	{	
		
		
		fi=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\courseDetails.xlsx");
		wb=new XSSFWorkbook(fi);
		if(wb.getSheetIndex(xlsheet)==-1)
			ws=wb.createSheet(xlsheet);
		else
			ws=wb.getSheet(xlsheet);
		setStyle(0,0);
		setStyle(0,1);
		setStyle(0,2);
		row=ws.createRow(rownum);
		
		int colnum=0;
		for(String s:arr) {
			cell=row.createCell(colnum);
			System.out.println(s);
			cell.setCellValue(s);
			
			colnum++;
		}
		int count=ws.getLastRowNum();
		for(int i=0;i<count;i++)
			ws.autoSizeColumn(i);
		fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\courseDetails.xlsx");
		
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
				
	}
	
	public static void setStyle(int rownum,int colnum) throws IOException
	{
		
		row=ws.createRow(rownum);
		cell=row.createCell(colnum);
		
		style=wb.createCellStyle();
		font = wb.createFont();
		font.setColor(HSSFColorPredefined.WHITE.getIndex());
        
		style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		style.setFont(font);
		
		cell.setCellStyle(style);		
		
	}

	public static void setCellData(String string, String xlsheet, List<String> arr) {
		try {
			fi=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\courseDetails.xlsx");
		
		wb=new XSSFWorkbook(fi);
		if(wb.getSheetIndex(xlsheet)==-1)
			ws=wb.createSheet(xlsheet);
		else
			ws=wb.getSheet(xlsheet);
		setStyle(0,0);
		int colnum=0;
		int r=1;
		for(String s:arr) {
			row=ws.createRow(r);
			cell=row.createCell(colnum);
			System.out.println(s);
			cell.setCellValue(s);
			r++;
		}
			
		
		for(int i=0;i<r;i++)
			ws.autoSizeColumn(i);
		fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\courseDetails.xlsx");
		
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
		} catch (Exception e) {}
			
	}

}
