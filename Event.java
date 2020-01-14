public class Event {

	private int artistid;
	private int imera;
	private int minas;
	private String kind;

	public Event(int artistid, int imera, int minas, String kind) {// creates an Event
		super();
		this.artistid = artistid;
		this.imera = imera;
		this.minas = minas;
		this.kind = kind;
	}

	// setters and getters
	public int getArtistid() {
		return artistid;
	}

	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}

	public int getImera() {
		return imera;
	}

	public void setImera(int imera) {
		this.imera = imera;
	}

	public int getMinas() {
		return minas;
	}

	public void setMinas(int minas) {
		this.minas = minas;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Event [artistid=" + artistid + ", imera=" + imera + ", minas=" + minas + ", kind=" + kind + "]";
	}

}
