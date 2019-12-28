package application.executiveClasses;

public class Artist extends Person {

	private double rating;
	private double relevancyIndex;
	private Album[] albums;
	//timeline?
	private String genre;
	private double payPercentage;
	private String pathToArtImage;
	
	public Artist(String username, String password, double rating, double relevancyIndex, Album[] albums,
			 String genre, double payPercentage,String img) {
		super(username,password);
	
		this.rating = rating;
		this.relevancyIndex = relevancyIndex;
		this.albums = albums;
		//this.timeline = timeline;
		this.genre = genre;
		this.payPercentage = payPercentage;
		this.pathToArtImage= img;
	}

	public String getPathToArtImage() {
		return pathToArtImage;
	}

	public void setPathToArtImage(String pathToArtImage) {
		this.pathToArtImage = pathToArtImage;
	}

	@Override
	public String toString() {
		return "Artist [username=" + super.getUsername() + ", password=" + super.getPassword() + ", rating=" + rating + ", relevancyIndex="
				+ relevancyIndex + ", genre=" + genre + ", payPercentage=" + payPercentage + "]";
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getRelevancyIndex() {
		return relevancyIndex;
	}

	public void setRelevancyIndex(double relevancyIndex) {
		this.relevancyIndex = relevancyIndex;
	}

	public Album[] getAlbums() {
		return albums;
	}

	public void setAlbums(Album[] albums) {
		this.albums = albums;
	}



	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPayPercentage() {
		return payPercentage;
	}

	public void setPayPercentage(double payPercentage) {
		this.payPercentage = payPercentage;
	}

	
}