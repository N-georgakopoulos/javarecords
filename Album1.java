public class Album {
	//this class cosists of many song objects
	private String Name;
	private double Price;
	private int PhysicalSales;
	private int DigitalSales;
	//private boolean isSingle; //might be a method counting number of songs found, to declare whether single or not
	//need some list of sorts for songs arranged by artist,album,name,success
	
	//Setters and Getters for all constants
	public	void setName(String AlbumName) {
        this.Name = AlbumName;
    }
	
	public int getName() {
        return this.Name;
    }
    
	public void setPrice(double AlbumPrice) {
        this.Price = AlbumPrice;
    }
	
	public int getPrice() {
        return this.Price;
    }
	
	public void setPhysicalSales(int Physical) {
        this.PhysicalSales = Physical;
    }
	
	public int getPhysicalSales() {
        return this.PhysicalSales;
    }
    
    public void setDigitalSales(int Digital) {
        this.DigitalSales = Digital;
    }
	
	public int getDigitalSales() {
        return this.DigitalSales;
    }
	
	//public methods of Album class
	public Popularity(song,views){} //what about views, what is thie method going to be about, what constants etc
	public AlbumSales(PhysicalSales,DigitalSales){}
	public AlbumRevenue(PhysicalSales,PriceP,DigitalSales,PriceD){} //declare prices and set an equation for the revenue
	public TotalCost(Katerina's production class){}
	
}
