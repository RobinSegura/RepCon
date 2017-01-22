package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import problem.TypeCargaison;

public class Bateau {

	Conteneur conteneurs[][];
	ArrayList<Conteneur> docks;
	
	public Bateau(Conteneur conteneurs[][]) {
		this.conteneurs = conteneurs;
	}

	public Bateau(short artill, short vivres, short muniti, short cLeger) {
		conteneurs = new Conteneur[9][4];
		docks = new ArrayList<>();
		for (int i = 0; i < artill; i++) {
			docks.add(new Conteneur(TypeCargaison.ARTILLERIE));
		}
		for (int i = 0; i < vivres; i++) {
			docks.add(new Conteneur(TypeCargaison.VIVRES));
		}
		for (int i = 0; i < muniti; i++) {
			docks.add(new Conteneur(TypeCargaison.MUNITIONS));
		}
		for (int i = 0; i < cLeger; i++) {
			docks.add(new Conteneur(TypeCargaison.COMBATLEGER));
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (Conteneur[] cs : conteneurs) {
			for (Conteneur c : cs) {
				str += c + " ";
			}
			str += "\n";
		}
		return str;
	}

	public int toInt() {
		int i =1, r=0;
		for (Conteneur[] conteneurs2 : conteneurs) {
			for (Conteneur conteneur : conteneurs2) {
				if (conteneur!=null) {
					r+=(conteneur.toInt()*i);
				}
				i*=10;
			}
		}
		return r;
	}

	public Conteneur[][] getTableau() {
		return conteneurs;
	}

	private Conteneur[][] getCopy() {
		Conteneur[][] out = new Conteneur[3][3];
		for (short x = 0; x < 3; x++) {
			for (short y = 0; y < 3; y++) {
				out[x][y] = conteneurs[x][y];
			}
		}
		return out;
	}

	public ArrayList<short[][]> getEnfants() {
		ArrayList<short[][]> e = new ArrayList<>();
		// Placer un conteneur
		//return e;
	}

	private boolean placer(Conteneur c, short emplacement, short z) {
		// si respecte contraintes

	}

	private short[][] echange(short in[][], short x1, short y1, int x2, int y2) {
		short out[][] = in;
		short tr = out[x1][y1];
		out[x1][y1] = out[x2][y2];
		out[x2][y2] = tr;
		return out;
	}
}
