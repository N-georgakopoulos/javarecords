package application.executiveClasses;

public class Venue {
	/* This class has the venue costs */
	private String name;
	private int capacity;
	private String OrganizerName;
	private int OrganizerPhone;
	private String type; /* eg festival, ballroom, tour etc */
	private String style; /* indoors, outdoors */
	private String location; /* address */
	private double clean;
	private double install;
	private int day;
	private double duration;
	private double distanceVenueArtist; /* h klm pou eixes zhthsei */
	private double cut; /* to meridio pou pairnei to venue, px 50% ws 0,5 */

	public double crew() {
		/* Crew cost */
		return clean * 0.5 + install * 0.5;
	}

	public double rent() {
		/*Renting fee*/
		double fee = 0.0;
		switch(day)
        {
            case 1:
                fee += 60;
                break;
            case 2:
            	fee += 40;
                break;
            case 3:
            	fee += 40;
                break;
            case 4:
            	fee += 50;
                break;
            case 5:
            	fee += 90;
                break;
            case 6:
            	fee += 90;
                break;
            case 7:
            	fee += 70;
                break;
            default:
                System.out.println("wrong input");
                break;
        }
		if(duration <= 30) {
			fee += 10;
		} else if(duration <= 60) {
			fee += 20;
		} else if(duration <= 90) {
			fee += 40;
		} else {
			fee += 60;
		}
		fee *= 100;
		return (fee);
	}
	// Setters and Getters for all constants

	public void setname(String VenueName) {
		this.name = VenueName;
	}

	public String getname() {
		return this.name;
	}

	public void setcapacity(int VenueCapacity) {
		this.capacity = VenueCapacity;
	}

	public int getcapacity() {
		return this.capacity;
	}

	public void setOrganizerName(String VenueOrganizerName) {
		this.OrganizerName = VenueOrganizerName;
	}

	public String getOrganizerName() {
		return this.OrganizerName;
	}

	public void setOrganizerPhone(int VenueOrganizerPhone) {
		this.OrganizerPhone = VenueOrganizerPhone;
	}

	public int getOrganizerPhone() {
		return this.OrganizerPhone;
	}

	public void settype(String VenueType) {
		this.type = VenueType;
	}

	public String gettype() {
		return this.type;
	}

	public void setstyle(String VenueStyle) {
		this.style = VenueStyle;
	}

	public String getstyle() {
		return this.style;
	}

	public void setlocation(String VenueLocation) {
		this.location = VenueLocation;
	}

	public String getlocation() {
		return this.location;
	}

	public void setclean(double VenueClean) {
		this.clean = VenueClean;
	}

	public double getclean() {
		return this.clean;
	}

	public void setinstall(double VenueInstall) {
		this.install = VenueInstall;
	}

	public double getinstall() {
		return this.install;
	}

	public void setday(int VenueDay) {
		this.day = VenueDay;
	}

	public int getday() {
		return this.day;
	}

	public void setduration(double VenueDuration) {
		this.duration = VenueDuration;
	}

	public double getduration() {
		return this.duration;
	}

	public void setdistanceVenueArtist(double VenueDistanceVenueArtist) {
		this.distanceVenueArtist = VenueDistanceVenueArtist;
	}

	public double getdistanceVenueArtist() {
		return this.distanceVenueArtist;
	}

	public void setcut(double VenueCut) {
		this.cut = VenueCut;
	}

	public double getcut() {
		return this.cut;
	}
}