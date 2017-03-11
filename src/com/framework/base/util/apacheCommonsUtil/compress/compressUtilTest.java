package com.framework.base.util.apacheCommonsUtil.compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;



/**
 * 打包、压缩
 * @author Administrator
 *
 */
public class compressUtilTest {

	/**
	 * @param args
	 *@author lyj [May 27, 2015]
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//创建压缩对象  
	    ZipArchiveEntry entry = new ZipArchiveEntry("CompressTest");  
	      //要压缩的文件  
	      File f=new File("e:\\Test.pdf");
	      FileInputStream fis=new FileInputStream(f);  
	      //输出的对象 压缩的文件  
	      ZipArchiveOutputStream zipOutput=new ZipArchiveOutputStream(new File("e:\\Test.zip"));
	      zipOutput.putArchiveEntry(entry);  
	      int i=0,j;  
	      while((j=fis.read()) != -1)  
	      {   
	       zipOutput.write(j);  
	       i++;  
	       System.out.println(i);  
	      }  
	      zipOutput.closeArchiveEntry();  
	      zipOutput.close();  
	      fis.close();// TODO Auto-generated method stub

	}

}
