package model;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class Graphe {
	TreeMap<Integer, Etat> graphe;
	Etat init;
	
	public void add(Bateau p) {
		// TODO Auto-generated method stub

	}

	public Graphe() {
		graphe = new TreeMap<Integer, Etat>();
		Bateau p = new Bateau();
		init = new Etat(p);
	}
	
	public void solveBFS(){
		Stack<Etat> childsToTreat = new Stack<>();
		childsToTreat.push(init);
		int i = 0;
		while (!graphe.containsKey(87654321) && !childsToTreat.isEmpty()) {
			Etat etat = childsToTreat.pop();
			graphe.put(etat.getClef(), etat);
			System.out.println(i + "\n" + etat);
			i++;
			for (Bateau p : etat.getEnfants()) {
				if (!graphe.containsKey(p.toInt())) {
					Etat stt = new Etat(etat, p);
					childsToTreat.push(stt);
				}
			}
		}
		System.out.println(childsToTreat.size() + "\n" + graphe.get(87654321));
	}
	
	public void solveDFS(){
		
	}
	
	public void solveAstar(){
		System.out.println(init+"\n"+init.getHeuristique());
		Comparator<Etat> sC = new StateComparator();
		Queue<Etat> childsToTreat = new PriorityQueue<Etat>(1,sC);
		childsToTreat.add(init);
		
		int i = 0;
		while (!graphe.containsKey(87654321) && !childsToTreat.isEmpty()) {
			Etat etat = childsToTreat.poll();
			graphe.put(etat.getClef(), etat);
			System.out.println(i + "\n" + etat);
			i++;
			for (Bateau p : etat.getEnfants()) {
				if (!graphe.containsKey(p.toInt())) {
					Etat stt = new Etat(etat, p);
					childsToTreat.offer(stt);
				}
			}
		}
		System.out.println(childsToTreat.size() + "\n" + graphe.get(87654321));
	}
}
