import Performance;

public class Album {
	
	//variables of album
	private String name;
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
	
	//Table Songs
	String[] Songs;
	int NumberOfSongs = Songs.length;
	
	// Album recording score 
	public double RecordingScore(physical, digital, NumberOfSongs) {
		double recScore = (0.1 * physical + 0.9 * digital) / NumberOfSongs;
		recScore = recScore * 100;
		return recScore;
	}
	
	// Album live score
	double liveScore = Performance.getLiveScore();
	liveScore = liveScore / NumberOfSongs;
	
	// Album Profit Score
	public double ProfitScore(recScore, liveScore) {
		double prScore = 0.5 * recScore + 0.5 * liveScore;
		return prScore;
	}
}
