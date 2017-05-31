package com.hpzc.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiExcel {
	private Workbook wb;
	private CellStyle defaultCs;
	private String excelName;

	/**
	 * 加载Excel模板
	 * 
	 * @param exlPath
	 * @return
	 */
	public void loadExcelTemplate(String exlPath) throws InvalidFormatException {
		try {
			File file = new File(exlPath);
			wb = new XSSFWorkbook(new FileInputStream(file));
			// wb=WorkbookFactory.create(new FileInputStream(file));
			defaultCs = wb.createCellStyle();
			defaultCs.setBorderTop(CellStyle.BORDER_THIN);
			defaultCs.setBorderBottom(CellStyle.BORDER_THIN);
			defaultCs.setBorderLeft(CellStyle.BORDER_THIN);
			defaultCs.setBorderRight(CellStyle.BORDER_THIN);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("文件不存在");
		} catch (IOException e) {
			throw new RuntimeException("IOException");
		}
	}

	/**
	 * @param exlPath
	 * @param excelName
	 * @throws InvalidFormatException
	 */
	public void loadExcelTemplate(String exlPath, String excelName) throws InvalidFormatException {
		this.loadExcelTemplate(exlPath);
		this.excelName = excelName;
	}

	/**
	 * @param row
	 * @param cellnum
	 * @return
	 */
	public Cell getCellIfNull(Row row, int cellnum) {
		Cell cell = ExcelUtils.getCellIfNull(row, cellnum);
		cell.setCellStyle(defaultCs);
		return cell;
	}

	/**
	 * @param sheetIndex
	 * @return
	 */
	public Sheet getSheet(int sheetIndex) {
		return wb.getSheetAt(sheetIndex);
	}

	/**
	 * @param sheet
	 * @param rownum
	 * @return
	 */
	public Row getRowIfNull(Sheet sheet, int rownum) {
		return ExcelUtils.getRowIfNull(sheet, rownum);
	}

	/**
	 * @param os
	 */
	public void write(OutputStream os) {
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @param counter
	 * @param startRow
	 * @return
	 */
	public SheetInfo createSheetInfo(int counter, int startRow) {
		return this.new SheetInfo(counter, startRow);
	}

	/**
	 * @author AcoreHeng
	 *
	 */
	public class SheetInfo {
		private int counter = 0;
		private int startRow = 0;

		private SheetInfo(int counter, int startRow) {
			super();
			this.counter = counter;
			this.startRow = startRow;
		}

		public int getCounter() {
			return counter;
		}

		public int getStartRow() {
			return startRow;
		}
	}

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}
}
