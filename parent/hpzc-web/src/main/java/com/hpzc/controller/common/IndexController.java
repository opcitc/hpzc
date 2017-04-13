package com.hpzc.controller.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpzc.model.common.Student;
import com.hpzc.model.job.HpzcJob;
import com.hpzc.service.util.JobService;

@Controller
public class IndexController {

	@RequestMapping("ece")
	public String ece() {
		System.out.println("ece");
		return "tms/tmsa";
	}

	@Autowired
	private JobService jobService;

	@RequestMapping("execl")
	public String execl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Student> list = new ArrayList<Student>();
		Student student = new Student();
		student.setSno(12);
		student.setName("zhangsan");
		student.setAge(12);

		Student student1 = new Student();
		student1.setSno(12);
		student1.setName("zhangsan");
		student1.setAge(12);

		list.add(student);
		list.add(student1);
		HSSFWorkbook wb = export(list);
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=student.xls");
		OutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			wb.write(ouputStream);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("execl");
		return "tms/tms";
	}

	public HSSFWorkbook export(List<Student> list) {
		String[] excelHeader = { "Sno", "Name", "Age" };
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Student");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			Student student = list.get(i);
			row.createCell(0).setCellValue(student.getSno());
			row.createCell(1).setCellValue(student.getName());
			row.createCell(2).setCellValue(student.getAge());
		}
		return wb;
	}

	@RequestMapping("quartz")
	public String index() throws SchedulerException {
		// HpzcJob job = new HpzcJob();
		// job.setJobName("jobName");
		// job.setJobStatus("1");
		// job.setJobGroup("dataWork");
		// job.setJobTime("0/5 * * * * ?");
		// job.setJobMeme("测试");
		// job.setClassName("com.hpzc.model.job.JobBction");
		// jobService.addJob(job);
		System.out.println("quartz");
		return "tms/tms";
	}

}
