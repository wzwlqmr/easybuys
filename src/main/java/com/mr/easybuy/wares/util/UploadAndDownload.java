package com.mr.easybuy.wares.util;

	import java.io.BufferedInputStream;
	import java.io.BufferedOutputStream;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.UUID;

	import javax.servlet.ServletOutputStream;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.springframework.web.multipart.MultipartFile;

	
	public class UploadAndDownload {

	/**
	上传
	@ResponseBody
	@RequestMapping("/upload")
	public String upload(@PathParam("imgFile") MultipartFile imgFile,HttpServletRequest req) {
		String str = UploadAndDownload.upload(imgFile, "D:\\imgDownload", "imgs");
		return str;
	}
	//下载
	@RequestMapping("download")
	public void download(HttpServletResponse resp,String path) {
		UploadAndDownload.download("D:\\imgDownload", path, resp);
	}
	//读取图片
	@RequestMapping("redPic")
	public void redPic(HttpServletResponse resp,String path) {
		UploadAndDownload.readPic("D:\\imgDownload", path, resp);
	}
		 * 说明:上传图片的路径是本项目的路径;
		 * 创建人：王志文     
		 * 创建时间：2019年6月24日 下午8:35:36    
		 * 修改人：王志文       
		 * 修改时间：2019年6月24日 下午8:35:36    
		 * 修改备注： 
		 * 功能:该功能是图片上传的方法,接收的参数依次为:
		 * @param img:前台传来的file文件;
		 * @param fileName:文件夹的名称;
		 * @param request:一次请求,获取项目路径;
		 * @return :返回图片上传功能后的路径;
		 */
		public static String uploadFile(MultipartFile img,String fileName,HttpServletRequest request){
			
			//获取文件/图片的名称
	    	String newImgName = img.getOriginalFilename();
	    	
	    	//1、将获取的文件/图片名称拼接UUID获得新的文件/图片名称
	    	//String newName = UUID.randomUUID()+"_"+newImgName;
	    	//2、将获取的文件/图片名称拼接UUID获得新的文件/图片名称
	    	String newName = UUID.randomUUID().toString()+newImgName.substring(newImgName.lastIndexOf("."));
	    	/*
	    	 * 上述两种方法传输之后获取得数据
	    	 * 1、1ff21a44-fec1-4f95-a1b7-d9d2aef196cc_t01be9176c9f2dfff9c.jpg
			 * 2、c10d407f-9d23-4c6c-8a5d-d400c01f6e6f.jpg
			 * t01be9176c9f2dfff9c.jpg是图片的名称
			 * 本类暂时使用第二种方法
	    	 */
	    	
	    	//获取项目路径
	    	String path = request.getServletContext().getRealPath("/"+fileName);
	    	//创建一个文件夹以存放文件/图片
	    	File filePath = new File(path);
			// 判断路径是否存在
			if (!filePath.exists()) { // 如果不存在，则新建目录
				filePath.mkdir();
			}
			
			//创建空文件
			File newFile = new File(path+"/"+newName);
	    	try {
	    		//将 img(文件) 写入到磁盘中
				img.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	//将访问的路径返回
	    	return fileName+"/"+newName;
		}
		
		/**
		 * 说明:下载图片的路径是本项目的路径
		 * 创建人：刘谱     
		 * 创建时间：2019年6月25日 上午8:52:08    
		 * 修改人：刘谱      
		 * 修改时间：2019年6月25日 上午8:52:08    
		 * 修改备注： 
		 * 功能:该功能是图片下载的方法,接收的参数依次为:
		 * @param imgPath:前台传来的图片的路径;
		 * @param request:一次请求,获取项目的具体路径;
		 * @param response:通过response,获取servlet输出流,将图片通过输出流下载到指定路径;
		 */
		public static void downloadFile(String imgPath,HttpServletRequest request,HttpServletResponse response){
				// 获取项目的真实路径
				String path = request.getServletContext().getRealPath("/"+imgPath);
				//实例化文件对象
				File file = new File(path);
				//获取文件名
				//String fileName = file.getName();
				String fileName = UUID.randomUUID().toString() + path.substring(path.lastIndexOf("."));
				BufferedInputStream in =null;
				BufferedOutputStream out=null;
			try {
				  //创建输入流 
				  in = new BufferedInputStream(new FileInputStream(file));
				  // 使用 request 和 response
				  //创建输入流   response.getOutputStream()是servlet的输出流  是浏览器下载时的输出流
				  out = new BufferedOutputStream(response.getOutputStream());
				  //解决不同浏览器的兼容问题  chrome
				  if(request.getHeader("User-Agent").toLowerCase().indexOf("chrome")>0){
					  fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
				  }else{
					  fileName = java.net.URLEncoder.encode("fileName","UTF-8");
					  fileName = new String(fileName.getBytes("UTF-8"),"GBK");
				  }
				  	  response.reset();
					  //作用是使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
					  response.setContentType("application/x-msdownload");
				      // inline在浏览器中直接显示，不提示用户下载
			          // attachment弹出对话框，提示用户进行下载保存本地
			          // 默认为inline方式
			          response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		        
			        //循环 读取内容  开始下载
			        byte[] b = new byte[1024];
			        int s = 0;// 输入流中将最多 b.length 个字节的数据读入一个 byte
		        while ((s=in.read(b))!=(-1)) {
						out.write(b,0,s);// 将 b.length 个字节从指定 byte 数组写入此文件输出流中。
						out.flush();
					}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
					try {
						if(in !=null){
						  in.close();
						}
						if(out !=null){
						  out.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				    }
			  }
		 }
		
		
		/**
		 * 说明:上传图片的路径是绝对路径(指定磁盘下的路径) 
		 * 创建人：刘谱     
		 * 创建时间：2019年6月25日 下午5:13:49    
		 * 修改人：刘谱      
		 * 修改时间：2019年6月25日 下午5:13:49    
		 * 修改备注： 
		 * @param imgPath: 图片上传的绝对路径;例如- E:/upload
		 * @param img:  前台传来的图片的信息
		 * @param fileName: 文件夹的名称
		 * @return : 返回上传成功后的图片路径信息
		 */
		public static String upload(MultipartFile img,String imgPath,String fileName){
			//获取文件/图片的名称
	    	String newImgName = img.getOriginalFilename();
	    	
	    	//1、将获取的文件/图片名称拼接UUID获得新的文件/图片名称
	    	//String newName = UUID.randomUUID()+"_"+newImgName;
	    	//2、将获取的文件/图片名称拼接UUID获得新的文件/图片名称
	    	String newName = UUID.randomUUID().toString()+newImgName.substring(newImgName.lastIndexOf("."));
	    	/*
	    	 * 上述两种方法传输之后获取得数据
	    	 * 1、1ff21a44-fec1-4f95-a1b7-d9d2aef196cc_t01be9176c9f2dfff9c.jpg
			 * 2、c10d407f-9d23-4c6c-8a5d-d400c01f6e6f.jpg
			 * t01be9176c9f2dfff9c.jpg是图片的名称
			 * 本类暂时使用第二种方法
	    	 */
	    	
	    	//获取绝对路径 
	    	String path = imgPath+"/"+fileName;
	    	//创建一个文件夹以存放文件/图片
	    	File filePath = new File(path);
			// 判断路径是否存在
			if (!filePath.exists()) { // 如果不存在，则新建目录
				filePath.mkdir();
			}
			
			//创建空文件
			File newFile = new File(path+"/"+newName);
	    	try {
	    		//将 img(文件) 写入到磁盘中
				img.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	//将访问的路径返回
	    	return fileName+"/"+newName;
		}
		
		/**
		 * 说明:下载图片的路径是绝对路径(指定磁盘下的路径);   
		 * 创建人：刘谱     
		 * 创建时间：2019年6月25日 下午5:07:08    
		 * 修改人：刘谱      
		 * 修改时间：2019年6月25日 下午5:07:08    
		 * 修改备注： 
		 * @param imgPath:下载图片的具体路径;例如- E:/upload
		 * @param imgName:下载图片的属性名
		 * @param response:通过response返回信息到前台
		 */
		public static void download(String imgPath,String imgName,HttpServletResponse response){
			// 1. 找到对应的下载文件并且读入到流中
			FileInputStream fis = null;
			ServletOutputStream os = null;
			try {                                    
				fis = new FileInputStream(new File(imgPath+"/"+imgName));
				
				// 2. 设置response返回的内容和头信息
				response.reset();
				
				// 设置编码格式
				response.setCharacterEncoding("iso-8859-1");
				
				// 设置打开方式
				String fileName = UUID.randomUUID().toString() + imgName.substring(imgName.lastIndexOf("."));
			
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
				
				// 3 通过outputstream进行下载
				os = response.getOutputStream();
				// 构建字节缓冲区
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					// 写入数据
					os.write(buffer, 0, len);
					os.flush();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				// 4 关流 先开的后关 后开的先关
				try {
					if (null != os) {
						os.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if (null != fis) {
						fis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		/**
		 * 说明:根据前台传来的绝对路径读取图片,并显示到前台  
		 * 创建人：刘谱     
		 * 创建时间：2019年6月25日 下午9:57:23    
		 * 修改人：刘谱      
		 * 修改时间：2019年6月25日 下午9:57:23    
		 * 修改备注： 
		 * @param imgPath:读取图片的相关路径;例如-E:/upload
		 * @param imgName:前台传来的相对图片路径信息
		 * @param respons:通过respons返回到前台 
		 */ 
		public static void readPic(String imgPath,String imgName,HttpServletResponse respons){
			FileInputStream fis = null;
			ServletOutputStream toClient= null;
			// 读入到流中
			try {
				fis = new FileInputStream(new File(imgPath+"/"+imgName));
				int i = fis.available(); // 得到文件大小  
				byte data[] = new byte[i];
				fis.read(data); // 读数据  
				fis.close(); 
				respons.setContentType("image/*"); // 设置返回的文件类型  
				toClient = respons.getOutputStream(); // 得到向客户端输出二进制数据的对象  
				toClient.write(data); // 输出数据 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(null!=fis) {
						fis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null!= toClient) {
						toClient.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	

}
