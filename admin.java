package lab_11;

import java.util.ArrayList;

public class admin extends user{
	int code;
	public admin(String login ,String password, ArrayList usersPlaylist, int code) {
		super(login, password, usersPlaylist);
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
