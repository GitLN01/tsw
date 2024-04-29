package artikal;

public class Artikal {
	private String naziv= null;
	private int cena= 0;
	private int broj= 0;

	public Artikal(String naziv, int cena, int broj) {
		super();
		this.naziv= naziv;
		this.cena= cena;
		this.broj= broj;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		if (cena< 0)
			throw new RuntimeException("Cena artikla ne sme biti manja od 0");
		this.cena= cena;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		if (broj< 0)
			throw new RuntimeException("Broj komada artikala mora biti veci od 0");
		this.broj= broj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv== null)
			throw new RuntimeException("Morate uneti naziv artikla");
		this.naziv= naziv;
	}

	public double ukupnaCena() {
		return (this.broj * this.cena * 1.18);
	}

	public boolean viseOdJedan() {
		if (this.broj > 1)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Artikal [naziv=" + naziv+ ", cena =" + cena + ", broj =" + broj+ "]";
	}

}
 
