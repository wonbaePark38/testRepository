package kr.co.neighbor21.keymake.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;



public class HmacSha256 {
	public static String encrypt(String secret, String data) {
			SecretKeySpec secretKey = null;
			//2. 지정된  MAC 알고리즘을 구현하는 Mac 객체를 작성합니다.
			Mac hasher = null;
			try {
				//1. SecretKeySpec 클래스를 사용한 키 생성 
				secretKey = new SecretKeySpec(secret.getBytes("utf-8"), "HmacSHA256");
				
				//1. SecretKeySpec 클래스를 사용한 키 생성 
				hasher = Mac.getInstance("HmacSHA256");
				
				//3. 키를 사용해 이 Mac 객체를 초기화
				hasher.init(secretKey);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeyException ie) {
				ie.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//3. 암호화 하려는 데이터의 바이트의 배열을 처리해 MAC 조작을 종료
			byte[] hash = hasher.doFinal(data.getBytes());
			//return Base64.encodeBase64String(hash);
			return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
			
			//base64.
			//4. Base 64 Encode to String
			//return Base64.encodeBase64String(hash);
	}
	
	public static void encrypt2(String secret, String data) {
		SecretKeySpec secretKey = null;
		data = "qewrt";
		//2. 지정된  MAC 알고리즘을 구현하는 Mac 객체를 작성합니다.
		Mac hasher = null;
		try {
			//1. SecretKeySpec 클래스를 사용한 키 생성 
			secretKey = new SecretKeySpec(secret.getBytes("utf-8"), "HmacSHA256");
			
			//1. SecretKeySpec 클래스를 사용한 키 생성 
			hasher = Mac.getInstance("HmacSHA256");
			
			//3. 키를 사용해 이 Mac 객체를 초기화
			hasher.init(secretKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException ie) {
			ie.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//3. 암호화 하려는 데이터의 바이트의 배열을 처리해 MAC 조작을 종료
		byte[] hash = hasher.doFinal(data.getBytes());
		//return Base64.encodeBase64String(hash);
		
		//base64.
		//4. Base 64 Encode to String
		//return Base64.encodeBase64String(hash);
}
}
