package org.tarena.cloudnote.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {

	/**
	 * 封装密码加密
	 * @param str
	 * @return
	 */
	public static String md5(String str){
		//md5与Base64双重处理
		try {
			//将str利用md5处理，处理结果是byte[]
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] input=str.getBytes();
			byte[] output=md.digest(input);
			//利用Base64将byte[]处理成字符串返回
			return Base64.encodeBase64String(output);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "系统错误";
		}
	}
	
	/**
	 * 封装用户ID自动生成
	 * @return
	 */
	public static String createId(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
}