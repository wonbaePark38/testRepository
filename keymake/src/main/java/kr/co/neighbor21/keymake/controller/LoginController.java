package kr.co.neighbor21.keymake.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.neighbor21.keymake.service.CreateApiKeyService;
import kr.co.neighbor21.keymake.util.AesDecrypt;
import kr.co.neighbor21.keymake.util.AesEncrypt;
import kr.co.neighbor21.keymake.util.HmacSha256;
import kr.co.neighbor21.keymake.util.SHA1;
import kr.co.neighbor21.keymake.util.UtilClass;
import kr.co.neighbor21.keymake.vo.UserInfo;

@Controller
public class LoginController {
	@Autowired
	private CreateApiKeyService service;
	
	final String secretKey = "secret";
    
    
	@GetMapping("/login")
	public String viewLoginPage(HttpServletRequest request) {
		System.out.println("컨트롤러 등장!");
		return "/login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public UserInfo loginProc(@RequestBody UserInfo vo, HttpSession session) {
		StringBuilder sb = new StringBuilder();
		session.setAttribute("LOGIN_ID", vo.getUserId());
		String serviceName = "Login";
		
		 String hash ="";
		 String sha1 = "";
		
		//long timeStamp = System.currentTimeMillis();
		//String now = UtilClass.timestampToString(timeStamp);
		String originalString = sb.append("[").append(vo.getUserId()).append("]")
								  .append("[").append(serviceName).append("]")
								  .toString();
		/* aes-256
		final String encryptedString = AesEncrypt.encrypt(originalString, secretKey);
	    final String decryptedString = AesDecrypt.decrypt(encryptedString, secretKey);
	    
	    
	    System.out.println("[Encrypted String] : " + encryptedString + " [length] : " + encryptedString.length());
	    System.out.println("[Decrypted String] : " + decryptedString);
	    
	    vo.setUserId((String)session.getAttribute("LOGIN_ID"));
	    vo.setAesKey(originalString);
	    System.out.println("로그인 세션 id > " + (String)session.getAttribute("LOGIN_ID"));
	    System.out.println("[Original String] : " + originalString);
	    */
		
		/* sha-256
		 * try {
			hash = UtilClass.createHash(originalString);
			System.out.println("hash length : " + hash.length() + " hash : " + hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		
		/*sha-1
		sha1 = SHA1.encrypt(originalString);
		System.out.println("sha1 length : " + sha1.length() + " sha1 : " + sha1);
		vo.setHashKey(hash);
		*/
		
		/*String apiHashKey = service.makeHashKey(vo.getUserId());
		String apiAesKey = service.makeAesKey(vo.getUserId(), "LoginService");
		
		System.out.println("hashKey length > " + apiHashKey.length());
		System.out.println("aeskey length > " + apiAesKey.length());
		vo.setHashKey(apiHashKey);
		vo.setAesKey(apiAesKey);*/
		
		/*hs256*/
		String hmac = HmacSha256.encrypt(secretKey, originalString);
		System.out.println("hmac length : " + hmac.length() + " hmac : " + hmac);
		vo.setHashKey(hmac);
		return vo;
	}
}
