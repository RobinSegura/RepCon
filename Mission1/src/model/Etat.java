package model;

import java.util.ArrayList;

import problem.Bateau;

public class Etat {
	Etat etatParent;
	Bateau p;

	public Etat(Etat etatParent, Bateau p) {
		this.etatParent = etatParent;
		this.p = p;
	}
	
	public Etat(Bateau p){
		etatParent = null;
		this.p = p;
	}

	public ArrayList<Bateau> getEnfants() {
		// TODO Auto-generated method stub
		ArrayList<Bateau> al = new ArrayList<>();
		for (short[][] s : p.getEnfants()) {
			al.add(new Bateau(s));
		}
		return al;
	}
	
	public long getClefParent() {
		return etatParent.getClef();
	}
	
	public Integer getClef(){
		return p.toInt();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return p.toString();
	}

	public int getHeuristique() {
		// TODO Auto-generated method stub
		return p.getManathanDist();
	}
	
}
