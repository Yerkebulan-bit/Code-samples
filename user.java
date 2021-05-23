package lab_11;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class user<playlist> implements Serializable{
	private String login;
	private String password;
	private ArrayList<playlist> usersPlaylist;
	
	public user(String login, String password, ArrayList<playlist> usersPlaylist) {
		super();
		this.login = login;
		this.password = password;
		this.usersPlaylist = usersPlaylist;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<playlist> getUsersPlaylist() {
		return usersPlaylist;
	}

	public void setUsersPlaylist(ArrayList<playlist> usersPlaylist) {
		this.usersPlaylist = usersPlaylist;
	}

	public int getCode() {
		return (Integer)null;
	}
	
}
