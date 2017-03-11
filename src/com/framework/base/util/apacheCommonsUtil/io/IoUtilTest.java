package com.framework.base.util.apacheCommonsUtil.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class IoUtilTest {

	/**
	 * @param args
	 *@author lyj [May 27, 2015]
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		//标准代码：  
		InputStream in = new URL( "http://jakarta.apache.org" ).openStream();  
		try {  
		       InputStreamReader inR = new InputStreamReader( in );  
		       BufferedReader buf = new BufferedReader( inR );  
		       String line;  
		       while ( ( line = buf.readLine() ) != null ) {  
		          System.out.println( line );  
		       }  
		  } finally {  
		    in.close();  
		  }  
		  
		//使用IOUtils  
		  
		InputStream in1 = new URL( "http://jakarta.apache.org" ).openStream();  
		try {  
		    System.out.println( IOUtils.toString( in1 ) );  
		} finally {  
		    IOUtils.closeQuietly(in);  
		}  
		  
		//2．读取文件  
		File file = new File("/commons/io/project.properties");  
		List lines = FileUtils.readLines(file, "UTF-8");  
		//3．察看剩余空间  
		long freeSpace = FileSystemUtils.freeSpace("C:/");  // TODO Auto-generated method stub

	}

}
