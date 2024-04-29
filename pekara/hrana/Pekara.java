package hrana;

import java.util.LinkedList;

import hrana.Pecivo;

public class Pekara {
	public static LinkedList<Pecivo> lista=new LinkedList<Pecivo>();
	public static void dodajPecivo(Pecivo a) {
		if(a == null)
			throw new NullPointerException("Pecivo ne sme biti null");
		if(lista.contains(a))
			throw new RuntimeException("Pecivo vec postoji");
			lista.add(a);
		}
	
	public static LinkedList<Pecivo> pronadjiPecivo(int cenaPeciva){
		if(cenaPeciva == 0)
			return null;
		LinkedList<Pecivo> novaLista=new LinkedList<Pecivo>();
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).getCenaPeciva() == cenaPeciva)
				novaLista.add(lista.get(i));
		return novaLista;

}
}
