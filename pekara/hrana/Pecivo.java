package hrana;

public class Pecivo {
	  private String nazivPeciva = null;
	  private int cenaPeciva = 0;
	  private int brojPeciva = 0;
	public Pecivo(String nazivPeciva, int cenaPeciva, int brojPeciva) {
		super();
		this.nazivPeciva = nazivPeciva;
		this.cenaPeciva = cenaPeciva;
		this.brojPeciva = brojPeciva;
	}
	public int getCenaPeciva() {
		return cenaPeciva;
	}
	public void setCenaPeciva(int cenaPeciva) {
		if(cenaPeciva<0)
			throw new RuntimeException("Cena peciva ne sme biti manja od nula");
		this.cenaPeciva = cenaPeciva;
	}
	public String getNazivPeciva() {
		return nazivPeciva;
	}
	public void setNazivPeciva(String nazivPeciva) {
		if(nazivPeciva == null)
			throw new RuntimeException("Morate uneti naziv peciva");
		this.nazivPeciva = nazivPeciva;
	}
	public int getBrojPeciva() {
		return brojPeciva;
	}
	public void setBrojPeciva(int brojPeciva) {
		if(brojPeciva < 0) {
			throw new RuntimeException("Broj komada peciva mora biti veci od nula");
		}
		this.brojPeciva = brojPeciva;
		
	}
	public double ukupnaCena() {
		return(this.brojPeciva * this.cenaPeciva);
	}
	public boolean viseOdPedeset() {
		if (this.brojPeciva>50)
			return true;
		else
			return false;
		
	}
	@Override
	public String toString() {
		return "Pecivo [nazivPeciva=" + nazivPeciva + ", cenaPeciva=" + cenaPeciva + ", brojPeciva=" + brojPeciva + "]";
	}




	  
	}
