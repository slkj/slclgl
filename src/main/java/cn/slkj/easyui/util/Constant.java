package cn.slkj.easyui.util;

import java.util.Properties;

/**
 * 常量工具类
 * @author panglongfei
 *
 */
public class Constant {
	
	private Constant(){
		
	}
	/**
	 * 上传图片或附件路径
	 */
	public static String path = null; 
	public static String userPath = null;

	/**
	 * 加载配置文件config.properties
	 */
	private static Properties p = PropertiesUtils.getInstance().loadProperties("config.properties");
	static{
		if(path == null){
			path = PropertiesUtils.getInstance().getAttribute("path", p); 
		}
		if(userPath == null){
			userPath = PropertiesUtils.getInstance().getAttribute("userPath", p); 
		}
	}
	
	
	

}
