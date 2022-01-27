package a.b.c.com.common;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

public abstract class ThumnailImg {
	
	public static void thumnailFun(String uploadPath, String filename) {
		System.out.println("ThumnailImg.thumnailFun() 진입");
		System.out.println("uploadPath->>>"+uploadPath);
		System.out.println("filename->>>>"+filename);
		File file= null;
		try {
			ParameterBlock pb = new ParameterBlock();
			pb.add(uploadPath+"\\"+filename);
			
			RenderedOp rOp = JAI.create("fileupload", pb);
			BufferedImage bi = rOp.getAsBufferedImage();
			
			BufferedImage thumb = new BufferedImage(50, 50, BufferedImage.TYPE_INT_BGR);
			Graphics2D g = thumb.createGraphics();
			
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 50, 50);
			g.drawImage(bi,0,0,50,50,null);
			
			file = new File(uploadPath+"\\sm_"+filename);
			ImageIO.write(thumb,"jpg",file);
			System.out.println("uploadPath/"+file.getName());
		}catch(Exception e) {
			System.out.println("썸내일 문제 발생 ->>"+e.getMessage());
		}
		
	}
	

}
