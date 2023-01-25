package kr.co.neighbor21.keymake.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import kr.co.neighbor21.keymake.util.UtilClass;

@Service
public class CreateApiKeyService {
	public String makeHashKey(String id) {
		String hash = "";
		try {
			hash = UtilClass.createHash(id); // hash 생성
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}
	
	public String makeAesKey(String id, String serviceName) {
		String aesKey = "";
		StringBuilder sb = new StringBuilder();
		
		long timeStamp = System.currentTimeMillis();
		String now = UtilClass.timestampToString(timeStamp);
		String orgnMsg = sb.append("[").append(now).append("]")
			.append("[").append(id).append("]")
			.append("[").append(serviceName).append("]")
			.toString();
		
		try {
			aesKey = UtilClass.encrypt(orgnMsg);
			String orgnDecrypted = UtilClass.decrypt(aesKey);
			System.out.println("[AES] before encrypt > " + orgnDecrypted);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return aesKey;
	}
	
}
