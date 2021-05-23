package lab_11;

import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

public class musicPlatform {
	private static ArrayList<user> users = new ArrayList<>();
	private static ArrayList<song> songs = new ArrayList<>();
	private static ArrayList<playlist> playlists = new ArrayList<>();
	
	static int buf = -1;
	static Scanner scan = new Scanner(System.in);
	private static user currentUser = null;
	
	public static void addSong(song song) {
		songs.add(song);
	}
	
	public static void addAccount(user user) {
		users.add(user);
	}
	
	public static void addPlaylist(playlist playlist) {
		playlists.add(playlist);
	}
	
	public static ArrayList<playlist> getPlaylist() {
		return playlists;
	}
	
	public static ArrayList<user> getUsers() {
		return users;
	}
	
	public static ArrayList<song> getSongs(){
		return songs;
	}
	
	public static boolean login(String login, String password) {
		String passwordCheck = "";
		for(int i = 0; i < users.size(); i++) {
			String loginCheck = users.get(i).getLogin();
			if(loginCheck.equals(login)) {
				buf = i;
				passwordCheck = users.get(i).getPassword();
				break;
			}
		}
		
		if(buf > -1 && passwordCheck.equals(password)) {
			System.out.println("Welcome, " + users.get(buf).getLogin());
			currentUser = users.get(buf);
			return true;
		}
		System.out.println("Incorrect password or login");
		return false;
	}
	
	public static user getCurrentUser() {
		return currentUser;
	}
	
	public static void addNewAccount(String newLogin, String newPassword) {
			users.add(new ordinaryUser(newLogin, newPassword, new ArrayList<playlist>()));
			System.out.println("New account has been added");
	}
	
	public static int verifCodeCheck(boolean userCheck) {
		if(userCheck){
			System.out.println("Please,enter your verification code");
			int code = scan.nextInt();
			if(code == users.get(buf).getCode()) {
				System.out.println("Access is allowed ");
				if(currentUser instanceof admin) {
					return 1;
				}
				else {
					return 2;
				}
			}
			System.out.println("Wrong code");
			return 0;
		}
		return 0;
	}
	
	public static void welcomeWords() {
		System.out.println("Welcome to music platform!\n"
        		+ "1 - login;\n"
        		+ "2 - registration;\n"
        		+ "3 - special user verification(artist/admin);\n"
        		+ "4 - exit");
	}
	
	public static void menu() {
		System.out.println("Welcome to the menu!\n"
        		+ "1 - add new playlist;\n"
        		+ "2 - edit exists playlist;\n"
        		+ "3 - delete playist;\n"
        		+ "4 - list of playlist\n"
        		+ "5 - watch for someone's playlist's\n"
        		+ "6 - exit");
	}
	
	public static void adminMenu() {
		System.out.println("7 - add new song\n"
				+ "8 - delete song");
	}
	
	public static void addNewSong(String name, String artistName, String albumName, String duration) {
		songs.add(new song(name, artistName, duration, albumName));
		System.out.println("New song has been added");
	}
	
	public static void deleteSong(int i) {
		songs.remove(i - 1);
		System.out.println("Song with ID: "+ i + " has been deleted");
	}
	
	public static void artistMenu() {
		System.out.println("7 - add new song\n");
	}
	
	public static void printSongs() {
		for(int i = 0; i < songs.size(); i++) {
			System.out.println((i + 1) + " \"" + songs.get(i).getName() 
					+ "\", " + songs.get(i).getArtistName() 
					+ ", " + songs.get(i).getDuration() 
					+ ", " + songs.get(i).getAlbumName());
		}
	}
	
	public static void addNewPlaylist(String name, String category) {
		Object dateCreated = LocalDateTime.now();
		ArrayList<song> amountOfSongs = new ArrayList<>();
		int amountOfLikes = 0;
		String ownerName = currentUser.getLogin();
		System.out.println("Please, enter songs which will be added to the new playlist:");
		printSongs();
		System.out.println("Please, enter amount of songs: ");
		int numberOfSongs = scan.nextInt();
		for(int i = 0; i < numberOfSongs; i++) {
			int idOfSong = scan.nextInt() - 1;
			amountOfSongs.add(songs.get(idOfSong));
		}
		playlist newPlaylist = new playlist(name, dateCreated, category, amountOfSongs, amountOfLikes, ownerName);
		playlists.add(newPlaylist);
		currentUser.getUsersPlaylist().add(newPlaylist);
		System.out.println("Playlist has been added");
	}
	
	public static void deletePlaylist(int i) {
		currentUser.getUsersPlaylist().remove(i - 1);
		System.out.println("Playlist has been deleted");
	}
	
	public static void printPlaylists() {
		for(int i = 0; i < playlists.size(); i++) {
			System.out.println((i + 1) + ". " + playlists.get(i).toString() + "\n");
		}
	}
	
	public static void printSpecialPlaylist(String login) {
		int buf = -1;
		for(int i = 0; i < users.size(); i++) {
			if(login.equals(users.get(i).getLogin())) {
				buf = i;
			}
		}
		if(buf > -1) {
			for(int i = 0; i < users.get(buf).getUsersPlaylist().size(); i++) {
				System.out.println(users.get(buf).getUsersPlaylist().get(i).toString());
			}
		}
	}
	
	public static void putLike(int forLike) {
		if(forLike > 0) {
			playlists.get(forLike - 1).setAmountOfLikes(playlists.get(forLike - 1).getAmountOfLikes() + 1);
			System.out.println("You liked this playlist " + playlists.get(forLike - 1).getName());
		}
	}
}
