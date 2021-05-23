package lab_11;
import java.io.Serializable;
import java.util.ArrayList;

public class playlist<song> implements Serializable{
	private String name;
	private Object dateCreated;
	private String category;
	private ArrayList<song> amountOfSongs;
	private int amountOfLikes;
	private String ownerName;
	
	public playlist(String name, Object dateCreated, String category, ArrayList<song> amountOfSongs, int amountOfLikes, String ownerName) {
		this.name = name;
		this.dateCreated = dateCreated;
		this.category = category;
		this.amountOfSongs = amountOfSongs;
		this.amountOfLikes = amountOfLikes;
		this.ownerName = ownerName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Object getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Object dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public ArrayList<song> getAmountOfSongs() {
		return amountOfSongs;
	}
	
	public void setAmountOfSongs(ArrayList<song> amountOfSongs) {
		this.amountOfSongs = amountOfSongs;
	}
	
	public int getAmountOfLikes() {
		return amountOfLikes;
	}
	
	public void setAmountOfLikes(int amountOfLikes) {
		this.amountOfLikes = amountOfLikes;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String toString() {
		return "Playlist's name: " + name + "\n DateCreated: " + dateCreated + "\n Category: " + category + "\n Number of songs: "
				+ amountOfSongs.size() + "\n AmountOfLikes: " + amountOfLikes + "\n OwnerName: " + ownerName;
	}
	
	
}
