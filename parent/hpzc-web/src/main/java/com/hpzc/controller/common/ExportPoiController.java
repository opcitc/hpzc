package com.hpzc.controller.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.service.tms.HpzcCgdService;

@Controller
@RequestMapping("export")
public class ExportPoiController {

	@Autowired
	private HpzcCgdService hpzcCgdService;

	// 采购单导出
	@RequestMapping("purchase")
	public String poi(HttpServletRequest request, HttpServletResponse response, Model mm, String[] ids) {
		List<HpzcCgd> list = hpzcCgdService.selectByIds(ids);
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("采购单清单");
		// 在sheet里创建第二行
		HSSFRow row0 = sheet.createRow(0);
		// 创建单元格并设置单元格内容
		row0.createCell(0).setCellValue("进货编号");
		row0.createCell(1).setCellValue("制单人");
		row0.createCell(2).setCellValue("供应商名称");
		row0.createCell(3).setCellValue("支付描述");
		// 在sheet里创建第三行
		for (int i = 1; i < list.size(); i++) {
			HpzcCgd hpzcCgd = list.get(i - 1);
			HSSFRow row3 = sheet.createRow(i);
			row3.createCell(0).setCellValue(hpzcCgd.gethCode());
			row3.createCell(1).setCellValue(hpzcCgd.gethCusCode());
			row3.createCell(2).setCellValue(hpzcCgd.gethCusName());
			row3.createCell(3).setCellValue(hpzcCgd.gethGysmc());
		}
		// 输出Excel文件
		// OutputStream output;
		response.reset();
		response.setHeader("Content-disposition", "attachment;filename=qw.xls");
		response.setContentType("application/msexcel");
		try {
			OutputStream output = response.getOutputStream();
			wb.write(output);
			// output.flush();
			output.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("kaptcha");
		return "tms/poi";
	}

	// 采购单导入
	@RequestMapping("importLoad")
	public String importLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<HpzcCgd> temp = new ArrayList<HpzcCgd>();
		String fileName2 = request.getParameter("trueattachment");
		fileName2 = File.separator + fileName2;
		// String filePath = "D:/gooled" + File.separator + "detaildas.xls";
		FileInputStream fileIn = new FileInputStream(fileName2);
		// 根据指定的文件输入流导入Excel从而产生Workbook对象
		Workbook wb0 = new HSSFWorkbook(fileIn);
		// 获取Excel文档中的第一个表单
		Sheet sht0 = wb0.getSheetAt(0);
		// 对Sheet中的每一行进行迭代
		for (Row r : sht0) {
			// 如果当前行的行号（从0开始）未达到2（第三行）则从新循环
			if (r.getRowNum() < 1) {
				continue;
			}
			// 创建实体类
			HpzcCgd hpzcCgd = new HpzcCgd();
			// 取出当前行第1个单元格数据，并封装在info实体stuName属性上
			hpzcCgd.sethCode(r.getCell(0).getStringCellValue());
			hpzcCgd.sethCusName(r.getCell(1).getStringCellValue());
			temp.add(hpzcCgd);
		}
		fileIn.close();
		return "";
	}
}
