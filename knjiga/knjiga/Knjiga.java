package knjiga;

public class Knjiga {
	private String naslov = null;
	private int brKnjiga = 0;
	private int cena = 0;

	public Knjiga(String naslov, int brKnjiga, int cena) {
		super();
		this.naslov = naslov;
		this.brKnjiga = brKnjiga;
		this.cena = cena;
	}

	public int getBrKnjiga() {
		return brKnjiga;
	}

	public void setBrKnjiga(int brKnjiga) {
		if (brKnjiga < 0)
			throw new RuntimeException("Broj knjiga ne sme biti manji od 0");
		this.brKnjiga = brKnjiga;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		if (cena < 0 )
			throw new RuntimeException("Cena mora biti veca od 0");
		this.cena = cena;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		if (naslov == null)
			throw new RuntimeException("Morate uneti naslov");
		this.naslov = naslov;
	}

	public double profit() {
		return (this.brKnjiga * this.cena)*0.2;
	}

	public boolean maliProfit() {
		if (this. profit() <= 20.000)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", brKnjiga=" + brKnjiga + ", cena knjige =" + cena + "]";
	}
}
