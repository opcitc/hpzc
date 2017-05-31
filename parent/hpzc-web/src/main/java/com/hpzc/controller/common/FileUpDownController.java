package com.hpzc.controller.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hpzc.model.tms.HpzcCgd;

@Controller
@RequestMapping("file")
public class FileUpDownController {

	@RequestMapping("/file")
	public String index() {
		System.out.println(12);
		return "file/file";
	}

	@RequestMapping("upload")
	public String upload(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
		// 此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
		if (file.isEmpty()) {
			System.out.println("文件未上传!");
		} else {
			// 得到上传的文件名
			String fileName = file.getOriginalFilename();
			// 得到服务器项目发布运行所在地址
			String path1 = request.getSession().getServletContext().getRealPath("upload") + File.separator;
			String path = "I:" + File.separator + fileName;
			// 此处未使用UUID来生成唯一标识,用日期做为标识
			// String path = path1 + new
			// SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileName;
//			String path = "I:" + File.separator + fileName;
			// 查看文件上传路径,方便查找
			System.out.println(path);
			// 把文件上传至path的路径
			File localFile = new File(path1);
			file.transferTo(localFile);
		}
		return "file/success";
	}

	@RequestMapping("uploadfile")
	public String uploadfile(HttpServletRequest request) throws IOException {
		// 此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了
		// 得到上传的文件名
		List temp = new ArrayList();
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
		return "file/success";
	}

	// @RequestMapping("upload")
	// public String upload(@RequestParam(value = "file", required = false)
	// MultipartFile file, HttpServletRequest request,
	// ModelMap model) {
	//
	// System.out.println("开始");
	// String path =
	// request.getSession().getServletContext().getRealPath("upload");
	// System.out.println(path);
	//// String sss = "C:\Users\Administrator\Desktop\file";
	// String fileName = file.getOriginalFilename();
	// // String fileName = new Date().getTime()+".jpg";
	// System.out.println(path);
	// File targetFile = new File(path, fileName);
	// if (!targetFile.exists()) {
	// targetFile.mkdirs();
	// }
	//
	// // 保存
	// try {
	// file.transferTo(targetFile);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// // model.addAttribute("fileUrl", request.getContextPath() + "/upload/" +
	// // fileName);
	//
	// return "file/success";
	// }

	@RequestMapping("/download")
	public String download(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		String fileName = file.getOriginalFilename();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		try {
			// fileName = "待办.txt";
//			String path = request.getSession().getServletContext().getRealPath("upload") + File.separator + fileName;
			String path = "I:" + File.separator + fileName;
			InputStream inputStream = new FileInputStream(new File(path));

			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
//			FileUtils.getFile("E:/"+File.separator+fileName);
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}

			// 这里主要关闭。
			os.close();

			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 返回值要注意，要不然就出现下面这句错误！
		// java+getOutputStream() has already been called for this response
		return null;
	}

	@RequestMapping(value = "/download12", produces = "application/octet-stream;charset=UTF-8")
	public ResponseEntity<byte[]> download() throws IOException {
		// 指定文件,必须是绝对路径

		// 下载浏览器响应的那个文件名
		String dfileName = "访问地址.txt";
		String path = "I:/1" + File.separator + dfileName;
		File file = new File(path);
		// 下面开始设置HttpHeaders,使得浏览器响应下载
		HttpHeaders headers = new HttpHeaders();
		// 设置响应方式
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 设置响应文件
		headers.setContentDispositionFormData("attachment", dfileName);
		// 把文件以二进制形式写回
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
