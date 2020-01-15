package application.executiveClasses;
public class Song {

	private String songname;
	private String albumName;

	public Song(String songname, String albumName) {//create a song
		super();
		this.songname = songname;
		this.albumName = albumName;
	}

//setters and getters 
	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	@Override
	public String toString() {
		return "Song [songname=" + songname + ", albumName=" + albumName + "]";
	}

}
