package com.hpzc.controller.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
			// 此处未使用UUID来生成唯一标识,用日期做为标识
			// String path = path1 + new
			// SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileName;
			String path = "I:" + File.separator + fileName;
			// 查看文件上传路径,方便查找
			System.out.println(path);
			// 把文件上传至path的路径
			File localFile = new File(path);
			file.transferTo(localFile);
		}
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
	public String download(String fileName, HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		try {
			fileName = "待办.txt";
			String path = request.getSession().getServletContext().getRealPath("upload") + File.separator + fileName;

			InputStream inputStream = new FileInputStream(new File(path));

			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			FileUtils.getFile("E:");
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
