package com.framework.base.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public final static String MD5(String pwd) {
		String Digest = "";
		try {
			MessageDigest currentAlgorithm = MessageDigest.getInstance("md5");
			currentAlgorithm.reset();
			byte[] mess = pwd.getBytes();// 获取要加密的byte数组
			byte[] hash = currentAlgorithm.digest(mess);// 获取加密以后的byte数组
			for (int i = 0; i < hash.length; i++) {
				int v = hash[i];
				if (v < 0) {
					v = 256 + v; // 如果 v < 0 > 0 的数，否则不好转换成字符，哪有ASC代码<0的呀
				}
				if (v < 16) {
					Digest += "0"; // 如果该v<1616进制数就是只有个位，例如15转换就成长度就相等了
				}
				Digest += Integer.toString(v, 16).toUpperCase();
			}
			mess = null;
			hash = null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return Digest;
	}
	/**
	 * @param args
	 *@author lyj [Jun 6, 2014]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MD5("000000"));

	}

}
