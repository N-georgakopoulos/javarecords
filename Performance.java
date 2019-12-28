package application.executiveClasses;

public class Performance {
		private static Venue venue;
		private static double ticketPrice;
		private static double ticketSales;
		private static String AlbumPlayed1;
		private static String AlbumPlayed2;
		
		private static double distanceVenueArtist = venue.getdistanceVenueArtist();

	public Performance(Venue venue, double price, double sales, String album1, String album2) { //Creates Performance Object
		this.venue = venue;
		this.ticketPrice = price;
		this.ticketSales = sales;
		this.AlbumPlayed1 = album1;
		this.AlbumPlayed2 = album2;
	}

	public static double calculateProjectedRevenue(double price, double sales) {
		double revenue = 0;
		try {
			revenue = price * sales;
			if (revenue<0) {
				throw new IllegalArgumentException("Price and Sales must be greater than 0!");	
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		double cut = venue.getcut();
		revenue = revenue - (revenue * cut);
		return revenue;
	}

		public static double calculateCost(){
			double cost = 0;
			double CostOfTravel = (distanceVenueArtist/10)*3;

			try {
				if (CostOfTravel<0){
					throw new IllegalArgumentException("Distance must be greater than 0!");
				}
			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
			cost = cost + CostOfTravel;
			return cost;
		}

		public static double calculateProjectedProfit( double revenue, double cost){
			double ProjectedProfit = 0;
			Performance.calculateProjectedRevenue(Performance.ticketPrice, Performance.ticketSales);
			Performance.calculateCost();
			ProjectedProfit = revenue - cost;
			return ProjectedProfit;
		}
		
		public static double getLiveScore(){
			int capacity = venue.getcapacity();
			double LiveScore = 0;
			if (capacity <= 1000) {
				LiveScore = (Performance.ticketSales / capacity) * 0.7 * 100;
			} else if (capacity <= 10000) {
				LiveScore = (Performance.ticketSales / capacity) * 0.9 * 100;
			} else if (capacity <= 100000) {
				LiveScore = (Performance.ticketSales / capacity) * 100;
			}
			return LiveScore;
		}

		public static double[] ProfitPerAlbum(){
		 	double revenue = Performance.calculateProjectedRevenue(Performance.ticketPrice, Performance.ticketSales);
			double cost = Performance.calculateCost();
			double profit = calculateProjectedProfit(revenue,cost);
			double score1 = 0;
			double score2 = 0;
			String a = null;
			if (Performance.AlbumPlayed2.contentEquals(a) == true) {
				score1 = profit;
			} else {
				score1 = profit/2;
				score2 = profit/2;
			}
			double[] score = {score1,score2};
			return score;
			
		}


}