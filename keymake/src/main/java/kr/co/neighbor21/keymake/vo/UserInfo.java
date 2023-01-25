package kr.co.neighbor21.keymake.vo;

public class UserInfo {
	public String userId;
	public String hashKey;
	public String aesKey;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", hashKey=" + hashKey + ", aesKey=" + aesKey + "]";
	}
}
