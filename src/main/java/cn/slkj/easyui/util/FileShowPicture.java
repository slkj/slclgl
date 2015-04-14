package cn.slkj.easyui.util;

import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 图片展示工具类
 * @author plf
 *
 */
@Controller
@RequestMapping(value = "/showPicture")
public class FileShowPicture {
	
	private static Logger log = LoggerFactory.getLogger(FileShowPicture.class);
	
	@RequestMapping(value = "/load")
    public void load(@RequestParam(required = false, defaultValue = "") String imgPath,
			HttpServletRequest request,
			HttpServletResponse response){   
		
		try {
			request.setCharacterEncoding("UTF-8");
			String path =new String((Constant.path + imgPath).getBytes("ISO-8859-1"), "UTF-8");
			log.debug("图片路径URL：{}", path);
			FileInputStream is = new FileInputStream(path);
			int i = is.available(); // 得到文件大小
			byte data[] = new byte[i];
			is.read(data); // 读数据
			is.close();
			response.setContentType("image/*"); // 设置返回的文件类型
			OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
			toClient.write(data); // 输出数据
			toClient.close();
		} catch (Exception e) {
			log.debug("系统找不到指定的路径。{}", "");
		}
    } 
	
	@RequestMapping(params = "method=user")  
    public void loadUserPicture(@RequestParam(required = false, defaultValue = "") String imgPath,
			HttpServletRequest request,
			HttpServletResponse response){   
		
		try {
			request.setCharacterEncoding("UTF-8");
			String path =new String((Constant.userPath + imgPath).getBytes("ISO-8859-1"), "UTF-8");
			log.debug("图片路径URL：{}", path);
			FileInputStream is = new FileInputStream(path);
			int i = is.available(); // 得到文件大小
			byte data[] = new byte[i];
			is.read(data); // 读数据
			is.close();
			response.setContentType("image/*"); // 设置返回的文件类型
			OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
			toClient.write(data); // 输出数据
			toClient.close();
		} catch (Exception e) {
			log.debug("系统找不到指定的路径。{}", "");
		}
    }
}
