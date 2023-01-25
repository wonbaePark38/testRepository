package kr.co.neighbor21.keymake.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {
	public static String encrypt(String message) {
	    MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte[] digest = messageDigest.digest(message.getBytes());
	    
	    StringBuilder hexString = new StringBuilder();
	    for (byte b : digest) {
	        hexString.append(String.format("%02x", b));
	    }
	    return hexString.toString();
	}
}
