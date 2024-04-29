package knjiga;
import java.util.LinkedList;

public class Knjizara{
	public static LinkedList<Knjiga> knjiga = new LinkedList<Knjiga>();

	public void dodajKnjigu(Knjiga a) {
		if (a == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		if (knjiga.contains(a))
			throw new RuntimeException("Knjiga vec postoji");
		knjiga.add(a);
	}
	
	public LinkedList<Knjiga> pronadjiKnjiga(String naslov) {
		if (naslov == null)
			return null;
		LinkedList<Knjiga> novaLista = new LinkedList<Knjiga>();
		for (int i = 0; i < knjiga.size(); i++)
			if (knjiga.get(i).getNaslov().equals(naslov))
				novaLista.add(knjiga.get(i));
		return novaLista;
	}
}


