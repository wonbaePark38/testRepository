package kr.co.neighbor21.keymake;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KeymakeApplication {
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		SpringApplication.run(KeymakeApplication.class, args);
		System.out.println("코드수정!!!!!!");
		System.out.println("코드수정!!!!!!");
		System.out.println("코드수정!!!!!!");
		System.out.println("코드수정 by 메롱!!!!!!");
		/*new SecureRandom().nextBytes(SECRET_KEY);
		String message = "wonbae";
		String encryptedMessage = encrypt(message);
		System.out.println("encryptedMessage > " + encryptedMessage);
		
		String hash = createHash(encryptedMessage+salt);
		System.out.println("hash > " + hash);
		
		String dectyptedMessage = decrypt(encryptedMessage);
		System.out.println("dectyptedMessage > " + dectyptedMessage);
		*/
	}
}
