package model;

import java.util.ArrayList;

import problem.Plateau;

public class Etat {
	Etat etatParent;
	Plateau p;

	public Etat(Etat etatParent, Plateau p) {
		this.etatParent = etatParent;
		this.p = p;
	}
	
	public Etat(Plateau p){
		etatParent = null;
		this.p = p;
	}

	public ArrayList<Plateau> getEnfants() {
		// TODO Auto-generated method stub
		ArrayList<Plateau> al = new ArrayList<>();
		for (short[][] s : p.getEnfants()) {
			al.add(new Plateau(s));
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
