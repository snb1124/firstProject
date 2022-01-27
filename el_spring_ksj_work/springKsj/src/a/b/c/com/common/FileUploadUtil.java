package a.b.c.com.common;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class FileUploadUtil {

		private String imgfilePaths;
		private int imgfileSize;
		private String encodeType;
		private MultipartRequest mr;
		
		public FileUploadUtil(String imgfilePaths, int imgfileSize, String encodeType) {
			this.imgfilePaths = imgfilePaths;
			this.imgfileSize = imgfileSize;
			this.encodeType = encodeType;		
		}
		public boolean imgfileUpload(HttpServletRequest req) {
			boolean bool = imgfileUpload(req, imgfilePaths);
			return bool;
			
		}
		
		public boolean imgfileUploadSize(HttpServletRequest req) {
			
			boolean bool = imgfileUploadSize(req, imgfilePaths);		
			return bool;
		}
		
		public boolean imgfileUpload(HttpServletRequest req, String filePath){
			boolean bool= false;
			try {
				mr= new MultipartRequest(req, filePath, imgfileSize, encodeType, new FileRename());
				System.out.println("mr ->>."+mr);
			}catch(Exception e) {
				System.out.println("이미지 파일 업로드 오류 발생 ->>>"+ e.getMessage());
				System.out.println("오류 발생 mr -->>>+ mr");
			}
			return bool;
		}
		
		public boolean imgfileUploadSize(HttpServletRequest req, String filePath) {
			boolean bool = false;
			try {
				mr= new MultipartRequest(req, filePath, imgfileSize, encodeType, new FileRename());
				System.out.println("mr ->>."+mr);
				System.out.println("mr.getOriginalFileName(\"sbfile\"->>>>)"+mr.getOriginalFileName("sbfile"));
				System.out.println("mr.getFilesystemName(\"sbfile\"->>>>)"+mr.getFilesystemName("sbfile"));
				
				ThumnailImg.thumnailFun(filePath, mr.getFilesystemName("sbfile"));
			}catch(Exception e) {
				System.out.println("imgfileUploadSize함수 문제 발생->>>"+e.getMessage());
				System.out.println("mr--->"+ mr);
			}
			return bool;
		}
		public String getParameter(String s){
			return mr.getParameter(s);
		}
		public String[] getParameterValues(String s){
			return mr.getParameterValues(s);		
		}
		public String getFileName(String f){
			return mr.getParameter(f);
		}
		public ArrayList<String> getFileNames(){
			@SuppressWarnings("unchecked")
			Enumeration<String> en = mr.getFileNames();
			ArrayList<String> a = new ArrayList<String>();
			
			while (en.hasMoreElements()){
				String f = en.nextElement().toString();
				a.add(mr.getFilesystemName(f));
			}		
			return a;
		}
		

}
