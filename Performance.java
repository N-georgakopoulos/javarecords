c class Performance {
		private static double ticketPrice;
			private static double ticketSales;

				public Performance(double price, double sales) { // Creates a Performance object
							this.ticketPrice = price;
									this.ticketSales = sales;
										}

					public static double calculateProjectedRevenue(double price, double sales) {
								double revenue = 0;
										try {
														revenue = price * sales;
																	if (revenue < 0) {
																						throw new IllegalArgumentException("Price and Sales must be greater than 0!");
																									}
																			} catch (IllegalArgumentException e) {
																							System.out.println(e.getMessage());
																									}
												revenue = revenue - (revenue * Venue.Percent);
														return revenue;
															}

						public static double calculateCost(Venue.Distance) {
									double cost = 0;
											try {
														double CostOfTravel= (Venue.Distance/10)*3;
																if (CostOfTravel<0) {
																				throw new IllegalArgumentException("Distance must be greater than 0!");
																						}
																		} catch (IllegalArgumentException e) {
																						System.out.println(e.getMessage());
																								}
													cost = cost + CostOfTravel;
															return cost;
																}

							public static double calculateProjectedProfit(double revenue, double cost) {
										double ProjectedProfit = 0;
												Performance.calculateProjectedRevenue(Performance.ticketPrice, Performance.ticketSales);
														Performance.calculateCost(Venue.Distance);
																ProjectedProfit = revenue - cost;
																		return ProjectedProfit;
																			}

}
