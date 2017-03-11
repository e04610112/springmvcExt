package com.framework.base.util.apacheCommonsUtil.codec;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class CodecTest {

	/**
	 * @param args
	 *@author lyj [May 27, 2015]
	 */
	public static void main(String[] args) {
		encodeTest("aaaaa");
		decodeTest(encodeTest("aaaaa"));
		System.out.println("MD5:"+encodeMD5("aaaaa"));

	}
	//Base64编解码  
	public static String encodeTest(String str){  
        Base64 base64 = new Base64();  
        try {  
            str = base64.encodeToString(str.getBytes("UTF-8"));  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
            System.out.println("Base64 编码后："+str);  
        return str;  
    }    
	public static void decodeTest(String str){  
        Base64 base64 = new Base64();  
        //str = Arrays.toString(Base64.decodeBase64(str));  
        str = new String(Base64.decodeBase64(str));  
        System.out.println("Base64 解码后："+str);  
    }
    
    public static String encodeMD5(String s){
    	return DigestUtils.md5Hex(s.toUpperCase());
    }
    public static String encodeSHA1(String s){
    	return DigestUtils.shaHex(s.toUpperCase());
    }
}
