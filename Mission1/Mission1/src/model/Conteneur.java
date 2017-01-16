package model;

public class Conteneur {
	TypeCargaison t;

	public Conteneur(TypeCargaison t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}

	public TypeCargaison getType() {
		return t;
	}

	public boolean equals(Conteneur c) {
		return c.getType().equals(t);
	}

	public int toInt() {
		switch (t) {
		case MUNITIONS:
			return 1;
		case ARTILLERIE:
			return 2;
		case COMBATLEGER:
			return 3;
		case VIVRES:
			return 4;
		default:
			return 0;
		}
	}
}
