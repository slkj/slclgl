package cn.slkj.easyui.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 配置文件工具类
 * 
 * @author panglongfei
 * 
 */
public class PropertiesUtils {
	private static Logger log = LoggerFactory.getLogger(PropertiesUtils.class);

	private static PropertiesUtils instance;

	private PropertiesUtils() {
	}

	public static synchronized PropertiesUtils getInstance() {
		if (instance == null) {
			instance = new PropertiesUtils();
		}
		return instance;
	}

	/**
	 * 第一步 加载配置文件
	 * 
	 * @param configName
	 * @return
	 */
	public Properties loadProperties(String configName) {
		Properties p = new Properties();
		try {
			InputStream inputStream = PropertiesUtils.class.getClassLoader()
					.getResourceAsStream(configName);
			p.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("初始化文件" + configName + "没有找到，请与相关负责人联系！！！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * 第二步 根据属性名称获取属性值
	 * 
	 * @param name
	 * @param p
	 * @return
	 */
	public String getAttribute(String name, Properties p) {
		return p.getProperty(name).trim();
	}

	public static void main(String[] args) {

		Properties p = PropertiesUtils.getInstance().loadProperties("config.properties");
		System.out.println(PropertiesUtils.getInstance().getAttribute("path", p));
	}
}
