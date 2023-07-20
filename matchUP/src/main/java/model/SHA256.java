package model;

import java.security.MessageDigest;
import java.util.Arrays;


// 가입할 때 입력한 이메일 주소를 해시처리한 값과 인증을 시도하는 이메일을 해시처리한 값을 비교해 사용자 인증을 하기 위함 
public class SHA256 {
	public static String getSHA256(String input) {
		StringBuffer result = new StringBuffer();
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			byte[] salt = "Hello Salt".getBytes();			
			digest.reset();
			digest.update(salt);
			byte[] chars = digest.digest(input.getBytes("UTF-8"));
			
			for(int i = 0; i < chars.length; i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				if(hex.length() == 1) result.append("0");
				result.append(hex);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}
    public static boolean verifyPassword(String inputPassword, String hashedPassword) {
        String inputHashedPassword = getSHA256(inputPassword);
        return Arrays.equals(hexStringToByteArray(hashedPassword), hexStringToByteArray(inputHashedPassword));
    }
    
    public static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] byteArray = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            byteArray[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return byteArray;
    }
}
