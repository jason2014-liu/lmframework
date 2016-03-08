/**
* TODO
* @Project: lmframework
* @Title: CryptographyUtils.java
* @Package com.lmstudio.framework.bss.security
* @author jason.liu
* @Date 2015年12月29日 上午10:45:35
* @Copyright
* @Version 
*/
package com.lmstudio.framework.bss.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

/**
* TODO
* @ClassName: CryptographyUtils
* @author jason.liu
*/
public class CryptographyUtils {
	
	/**
	* TODO MD5 encrypt
	* @Title: encryptWithMD5
	* @param inputStr
	* @return
	 */
	public static String encryptWithMD5(String inputStr){
		String resultStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(inputStr.getBytes());
			resultStr = Hex.encodeHexString(bytes);
			System.out.println(new String(bytes));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resultStr);
		return resultStr;
	}
	
	/**
	* TODO
	* @Title: main
	* @param args
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		encryptWithMD5("qweess");
	}

}
