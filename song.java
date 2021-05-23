package lab_11;

import java.io.Serializable;

public class song implements Serializable{
	private String name;
	private String artistName;
	private String duration;
	private String albumName;
	
	public song(String name, String artistName, String duration, String albumName) {
		this.name = name;
		this.artistName = artistName;
		this.duration = duration;
		this.albumName = albumName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
}