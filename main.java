package lab_11;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main{
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		Scanner scan = new Scanner(System.in);	
		// DOWNLOAD EXISTS SONGS		
		ArrayList<song> songs = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream("songs.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            while(true) {       
                musicPlatform.addSong((song) objectInputStream.readObject());
            }
        }
        catch(EOFException endOfFileException){
            System.out.println("end of file reached");;
        }
        objectInputStream.close();        
        // END OF SONG'S DOWNLOAD
        
        
        
        // DOWNLOAD PLAYLISTS
        ArrayList<playlist> playlists = new ArrayList<>();
		FileInputStream fileInputPlaylist = new FileInputStream("playlists.txt");
		ObjectInputStream objectInputPlaylist = new ObjectInputStream(fileInputPlaylist);
        try {
            while(true) {       
                musicPlatform.addPlaylist((playlist)objectInputPlaylist.readObject());
                System.out.println(1);
            }
        }
        catch(EOFException endOfFileException){
            System.out.println("end of file reached");;
        }
        objectInputPlaylist.close();
        //END OF DOWNLOAD PLAYLISTS1
        
        
        // DOWNLOAD USERS
		ArrayList<user> users = new ArrayList<>();
		FileInputStream fileInput = new FileInputStream("users.txt");
		ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        try {
            while(true) {       
                musicPlatform.addAccount((user) objectInput.readObject());
            }
        }
        catch(EOFException endOfFileException){
            System.out.println("end of file reached");
        }
        objectInput.close();
        // END OF DOWNLOAD OF USERS
        
        
        // LOGIN/REGISTRATION PART
        boolean loginExit = true;
        boolean userCheck = false;
        String loginCheck;
        String passwordCheck;
        int specialCheck = -1;
        musicPlatform.welcomeWords();
        while(loginExit) {
        	int choice = scan.nextInt();
        	switch(choice) {
        	case 1:
        		System.out.println("Please, enter your login:");
        		loginCheck = scan.next();
        		System.out.println("Please, enter your password:");
        		passwordCheck = scan.next();
        		userCheck = musicPlatform.login(loginCheck, passwordCheck);
        		if(userCheck) {
        			loginExit = false;
        		}
        		break;
        	case 2:
        		System.out.println("Please, enter your new login:");
        		String newLogin = scan.next();
        		System.out.println("Please, enter your new password:");
        		String newPassword = scan.next();
        		musicPlatform.addNewAccount(newLogin, newPassword);
        		break;
        	case 3:
        		System.out.println("Please, enter your login:");
        		loginCheck = scan.next();
        		System.out.println("Please, enter your password:");
        		passwordCheck = scan.next();
        		userCheck = musicPlatform.login(loginCheck, passwordCheck);
        		specialCheck = musicPlatform.verifCodeCheck(userCheck);
        		if(userCheck) {
        			loginExit = false;
        		}
        		break;
        	case 4:
        		loginExit = false;
        		break;
        	default:
        		System.out.println("Wrong operation, please try again");
        	}
        }
        loginExit = true;
        user currentUser = musicPlatform.getCurrentUser();
	        if(userCheck) {
	        	musicPlatform.menu();
	        	if(specialCheck == 1) {
	        		musicPlatform.adminMenu();
	        	}
	        	else if(specialCheck == 2) {
	        		musicPlatform.artistMenu();
	        	}
	        	
	        	while(loginExit) {
	        	int choice = scan.nextInt();
	        	switch(choice) {
	        	case 1:
	        		System.out.println("Playlist's name");
	        		String name = scan.next();
	        		System.out.println("Playlist's category");
	        		String category = scan.next();
	        		musicPlatform.addNewPlaylist(name, category);
	        		break;
	        	case 2:
	        		System.out.println("This command while doesn't work, sorry");
	        		break;
	        	case 3:
		        	if(currentUser.getUsersPlaylist().size() > 0) {
		        		System.out.println("Please, enter playlist to delete: ");
	        			for(int i = 0; i < currentUser.getUsersPlaylist().size(); i++){
		        			System.out.println((i + 1)+ ". " + ((playlist) currentUser.getUsersPlaylist().get(i)).toString());
		        			System.out.println();	
		        		}
	        			int idOfPlaylist = scan.nextInt();
		        		musicPlatform.deletePlaylist(idOfPlaylist);
		        	}
		        	else {
		        		System.out.println("There is no playlist to delete");
		        	}	        		
	        		break;
	        	case 4:
	        		if(currentUser.getUsersPlaylist().size() > 0) {
		        		for(int i = 0; i < currentUser.getUsersPlaylist().size(); i++){
		        			System.out.println((i + 1)+ ". " + ((playlist) currentUser.getUsersPlaylist().get(i)).toString());
		        			System.out.println();	
		        		}
	        		}
	        		else {
		        		System.out.println("There is no playlist");
		        	}
	        		break;
	        	case 5:
	        		System.out.println("1 - all playlist\n"
	        				+ "2 - by name");
	        		int buf = scan.nextInt();
	        		if(buf == 1) {	        			
	        			musicPlatform.printPlaylists();
	        			System.out.println("0 - to exit\n"
	        					+ "ID of playlist - to like it:");
	        			int forLike = scan.nextInt();
	        			musicPlatform.putLike(forLike);
	        		}
	        		else if(buf == 2 ) {
	        			System.out.println("Please, enter login of user: ");
	        			String loginForSearch = scan.next();
	        			musicPlatform.printSpecialPlaylist(loginForSearch);
	        		}
	        		break;
	        	case 6:
	        		loginExit = false;
	        		break;
	        	case 7:
	        		if(specialCheck == -1) {
	        			System.out.println("Wrong operation, please try again");
	        		}
	        		else {
	        			System.out.println("Please, enter the name of new song: ");
	        			String newName = scan.next();
	        			System.out.println("Please, enter the artist's name of new song: ");
	        			String newArtistName = scan.next();
	        			System.out.println("Please, enter the album's name of new song: ");
	        			String newAlbumName = scan.next();
	        			System.out.println("Please, enter the duration of new song: ");
	        			String newDuration = scan.next();
	        			if(newArtistName.equals(currentUser.getLogin())) {
	        				musicPlatform.addNewSong(newName, newArtistName, newAlbumName, newDuration);
	        			}
	        			else {
	        				System.out.println("It's not your song!");
	        			}
	        		}
	        		break;
	        	case 8:
	        		if(specialCheck != 1) {
	        			System.out.println("Wrong operation, please try again");
	        		}
	        		else {
	        			musicPlatform.printSongs();
	        			int deleteSong = scan.nextInt();
	        			musicPlatform.deleteSong(deleteSong);
	        		}
	        		break;
	        	default:
	        		System.out.println("Wrong operation, please try again");
	        	}
	        }
        }
	        
	    System.out.println("Good bye!");
	        
	    
	    
	    //UPLOAD USERS TO TXT
	    users = musicPlatform.getUsers();
	    FileOutputStream fileOutputStream = new FileOutputStream("users.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for(int i = 0; i < users.size(); i++) {
            objectOutputStream.writeObject(users.get(i));
        }
        objectOutputStream.flush();
        objectOutputStream.close();
		scan.close();
		
		
		//UPLOAD PLAYLISTS TO TXT
		playlists = musicPlatform.getPlaylist();
	    FileOutputStream fileOutput = new FileOutputStream("playlists.txt");
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        for(int i = 0; i < playlists.size(); i++) {
            objectOutput.writeObject(playlists.get(i));
        }
        objectOutput.flush();
        objectOutput.close();
		scan.close();
		
		
		
		//UPLOAD SONGS TO TXT
		songs = musicPlatform.getSongs();
	    FileOutputStream fileOutputSong = new FileOutputStream("songs.txt");
        ObjectOutputStream objectOutputSong = new ObjectOutputStream(fileOutputSong);
        for(int i = 0; i < songs.size(); i++) {
            objectOutputSong.writeObject(songs.get(i));
        }
        objectOutputSong.flush();
        objectOutputSong.close();
		scan.close();
	}
}
