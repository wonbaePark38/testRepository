package kr.co.neighbor21.keymake.util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class UtilClass {
	
	private static final String HASH_ALGORITHM = "SHA-256";
	private static final String ENCRYPTION_ALGORITHM = "AES"; // AES128
	private static final byte[] SECRET_KEY = new byte[32]; // 16BYTE : 128, 24BYTE : 192, 32BYTE : 256
	//private static final String salt = "saltKey";
	
	public static String timestampToString(long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date(timestamp));
    }
	
	public static String encrypt(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY, ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }
	
	public static String decrypt(String encryptedMessage) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodedMessage = Base64.getDecoder().decode(encryptedMessage);
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY, ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decrypted = cipher.doFinal(decodedMessage);
        return new String(decrypted);
	}
	
	public static String createHash(String message) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
		byte[] encodehash = digest.digest(message.getBytes());
		return bytesToHex(encodehash);
	}
	
	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder();
		for(byte b : hash) {
			String hex = Integer.toHexString(0xff & b);
			if(hex.length() == 1) {
				hexString.append("0");
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
