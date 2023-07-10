package util;

import javax.mail.*;

public class Gmail extends Authenticator{
	
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("rbxo0032@gmail.com", "nelrkhunamunozjp");
	}
	
}
