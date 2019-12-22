public class Album {
	
	//variables of album
	private String name
	private double pricep;
	private double priced;
	private double physical;
	private double digital;
	
	//setters and getters
	public	void setname(String AlbumName) {
        this.name = AlbumName;
    }
	
	public String getname() {
        return this.name;
    }
	
	public	void setpricep(double pricephy) {
        this.pricep = pricephy;
    }
	
	public double getpricep() {
        return this.pricep;
    }
	
	public	void setpriced(double pricedig) {
        this.priced = pricedig;
    }
	
	public double getpriced() {
        return this.priced;
    }
	
	public	void setphysical(double physic) {
        this.physical = physic;
    }
	
	public double getphysical() {
        return this.physical;
    }
	
	public	void setdigital(double digit) {
        this.digital = digit;
    }
	
	public double getdigital() {
        return this.digital;
    }
	
	//Album sales
	public double AlbumSales(physical, digital) {
		double sales = physical + digital;
		return sales;
	}
	
	// Album revenue
	public double AlbumRevenue(physical, pricep, digital, priced) {
		double revenue = physical * pricep + digital * priced;
		return revenue;
	}
	
	//Album popularity
	
	/*in desperate need of method SongPopularity of Song class
	song has views, downloads, release date and method SongPopularity
	probably its a list of songs that contains all info idk
	
	Album needs the popularity of a song,
	plus the number of songs that this album is supposed to have
	so that the average will be somewhat like this
	
	 public double AlbumPopularity(things) {
	 	double popularity = SongPopularity * NumberOfSongs; //stathmismenos MO say whaaaat idk
	 	return popularity;
	 }
	 */
}