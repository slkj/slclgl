package cn.slkj.easyui.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * SpringMVC上传工具类
 * @author panglongfei
 *
 */
public class FileUpload {
	
	/** request对象 */
	private HttpServletRequest request = null;
	/** 上传文件的路径 */
	private String uploadPath = null;
	/** 会员上传资质的路径 */
	private String userUploadPath = null;
	/** 根据日期创建文件夹*/
	private String date = null;
	/** response对象 */
	private HttpServletResponse response = null;
	
	public FileUpload(){}
	public FileUpload(String path,HttpServletRequest request){
		setUploadPath(path);
		setRequest(request);
	}
	public FileUpload(String path,HttpServletRequest request,String uid){
		setUserUploadPath(path,uid);
		setRequest(request);
	}
	public FileUpload(HttpServletResponse response){
		
		setResponse(response);
	}
	/**
	 * 设定request对象。
	 * 
	 * @param request
	 *            HttpServletRequest request对象 <br />
	 *            第一步设置的参数
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * 设定response对象
	 * @param response
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 设定文件上传路径。
	 * 
	 * @param path
	 *            用户指定的文件的上传路径。 <br />
	 *            第二步设置的参数
	 */
	public void setUploadPath(String path) {
		Calendar date=Calendar.getInstance();	
		SimpleDateFormat format=new SimpleDateFormat( "yyyy-MM-dd"); 
		this.date=format.format(date.getTime()); 
		
		if (path.indexOf(":") > -1) {
			this.uploadPath = path;
		} else {
			this.uploadPath = this.request.getRealPath(path);
		}
		this.uploadPath = this.uploadPath.trim();
		if ((!this.uploadPath.endsWith("\\"))
				&& (!this.uploadPath.endsWith("/"))) {
			this.uploadPath += "\\";
		}
		// 如果路径不存在则，创建路径。
		
		if (path.indexOf(":") > -1) {
			this.uploadPath += this.date + "/";
		} else {
			this.uploadPath += this.date + "\\";
		}
		System.out.println("文件保存路径：" + this.uploadPath);
		makeFilePath(this.uploadPath );
	}
	/**
	 * 设定会员资质上传路径。
	 * 
	 * @param path
	 *            会员资质的上传路径。 <br />
	 *            第二步设置的参数
	 */
	public void setUserUploadPath(String path,String uid) {
		
		
		if (path.indexOf(":") > -1) {
			this.userUploadPath = path;
		} else {
			this.userUploadPath = this.request.getRealPath(path);
		}
		this.userUploadPath = this.userUploadPath.trim();
		if ((!this.userUploadPath.endsWith("\\"))
				&& (!this.userUploadPath.endsWith("/"))) {
			this.userUploadPath += "\\";
		}
		// 如果路径不存在则，创建路径。
		
		if (path.indexOf(":") > -1) {
			this.userUploadPath += uid + "/";
		} else {
			this.userUploadPath += uid + "\\";
		}
		System.out.println("文件保存路径：" + this.userUploadPath);
		makeFilePath(this.userUploadPath );
	}


	
	public HashMap<String, String> upload() {
		HashMap<String, String> mapFile = new HashMap<String, String>();
		//创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(multipartResolver.isMultipart(request)){
			//转换成多部分request  
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			//取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while(iter.hasNext()){
				//记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				//取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if(file != null){
					//取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if(myFileName.trim() !=""){
						System.out.println("原文件名称" + file.getName());
						//重命名上传后的文件名
						String fileName = new Date().getTime() + myFileName.substring(myFileName.lastIndexOf("."));
						System.out.println("重命名上传后的文件名" + fileName);
						//定义上传路径
						this.uploadPath += fileName;
						File localFile = new File(uploadPath);
						try {
							file.transferTo(localFile);
							mapFile.put(file.getName(), this.date + "/" + fileName);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				//记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}
			
		}
		return mapFile;
	}
	
	//会员上传图片
	public HashMap<String, String> upload(String uid) {
		HashMap<String, String> mapFile = new HashMap<String, String>();
		//创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(multipartResolver.isMultipart(request)){
			//转换成多部分request  
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			//取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while(iter.hasNext()){
				//记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				//取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if(file != null){
					//取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if(myFileName.trim() !=""){
						System.out.println("原文件名称" + file.getName());
						//重命名上传后的文件名
						String fileName = new Date().getTime() + myFileName.substring(myFileName.lastIndexOf("."));
						System.out.println("重命名上传后的文件名" + fileName);
						//定义上传路径
						this.userUploadPath += fileName;
						File localFile = new File(userUploadPath);
						try {
							file.transferTo(localFile);
							mapFile.put(file.getName(), uid + "/" + fileName);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				//记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}
			
		}
		return mapFile;
	}
	
	//会员下载图片
		public String download(String filePath) {
	        response.setCharacterEncoding("UTF-8");	     
	        
	        BufferedInputStream buffer=null;
	        OutputStream out=null;
	        try
	        {
	            File f = new File(filePath);
	                      //检查该文件是否存在
	            if(!f.exists()){
	                response.sendError(404,"File not found!");
	                return "File not found!";
	            }
	            buffer = new BufferedInputStream(new FileInputStream(f));
	            byte[] buf = new byte[1024];
	            int len = 0;
	         
	            response.reset(); //非常重要
	                response.setContentType("application/x-msdownload"); 
	                 
	                response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(f.getName(),"UTF-8")); 
	         
	            out = response.getOutputStream();
	            while((len = buffer.read(buf)) >0){
	                out.write(buf,0,len);
	                out.flush();
	            }
	        }catch(Throwable e)
	        {
	            e.printStackTrace();
	        }finally
	        {
	            try
	            {
	                buffer.close();
	                out.close();
	            }catch(Throwable e)
	            {
	                e.printStackTrace();   
	            }
	        }
	        return "";
		}
		
	
	private void makeFilePath(String filePath) {
		File file = new File(filePath);
		if (!file.exists())
			file.mkdirs();
	}
}
