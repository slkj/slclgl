/**   
 * @Title: package-info.java 
 * @Package cn.slkj.clgl.common 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangtc   
 * @date 2015年1月10日 上午9:10:29 
 */
/** 
 * @ClassName: package-info 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zhangtc
 * @date 2015年1月10日 上午9:10:29 
 *  
 */
package cn.slkj.slclgl.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.slkj.easyui.util.Constant;
import cn.slkj.easyui.util.FileUpload;


@Controller
@RequestMapping(value = "/common")
public class ComController{

	@ResponseBody
	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String upload(HttpServletRequest request,@RequestParam(required = false, defaultValue = "") String num) throws Exception {
		try {System.out.println("111111111111111111111");
			FileUpload fileUpload = new FileUpload(Constant.path, request);
			HashMap<String, String> mapFile = fileUpload.upload();System.out.println("num:"+num);
			if (StringUtils.isNotBlank(num)) {
				if(num.equals("2")){System.out.println(mapFile.get("picFile2")+"picFile2");
					return mapFile.get("picFile2");
				}
				if(num.equals("3")){System.out.println(mapFile.get("picFile3")+"picFile3");
					return mapFile.get("picFile3");
				}
			}else{System.out.println(mapFile.get("picFile")+"picFile");
				//return mapFile.get("picFile");
			return "aaa";
			}
			return null;
		} catch (Exception e) {
			throw new Exception(
					"this is the detail of ajax exception information");
		}
}
	
}
