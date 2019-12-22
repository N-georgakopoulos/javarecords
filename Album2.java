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
	
	ισως να βαζαμε την list of songs δώ αν εξυπηρετεί απλά να μου πεις
	τι μορφή θες να έχει και γενικά καποιες έξτρα πληροφορίες για να την γτιάξω 
	γιατί αυτές τις μέρες μελέτησα τις λίστες
	επειδή λεγαμε με την κατερίνα να έχω εγω τη λίστα στις υποχρεώσεις μου
	αρά αν θες πες μπυ ό,τι να'ναι να σε διευκολύνω.
	
	 public double AlbumPopularity(things) {
	 	double popularity = SongPopularity * NumberOfSongs;
	 	// μαλλον κατι τετοιο φανταζομαι , αλλα κατι ειχε ειπωθεί για σταθμισμένο μέσο όρο δεν ξερω τι ακριβως ειχατε φανταστει οτι εξυπηρετεί
	 	return popularity;
	 }
	 
	 αυτά μπορούν να τεθούν και για συζήτηση με όλους ή κι αν βρεις ότι μια λύση ειναι πιο βολική shoot δεν έχω θέμα, όσο πιο γρηγορα μου πεις τι θες σε βοηθάω και τελειωσαμε
	 */
}