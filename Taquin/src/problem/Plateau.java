package problem;

import java.util.ArrayList;
import java.util.Collections;

public class Plateau {
	short tableau[][];

	public Plateau(short tableau[][]) {
		super();
		this.tableau = tableau;
	}

	public Plateau() {
		super();
		tableau = new short[3][3];
		ArrayList<Short> al = new ArrayList<>();
		for (short i = 0; i < 9; i++) {
			al.add(i);
		}
		Collections.shuffle(al);
		for (short x = 0; x < 3; x++) {
			for (short y = 0; y < 3; y++) {
				tableau[x][y] = al.remove(0);
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (short[] pions : tableau) {
			for (short pion : pions) {
				str += pion + " ";
			}
			str += "\n";
		}
		return str;
	}

	public int toInt() {
		int n = 0, o = 1;
		for (short[] s : tableau) {
			for (short pion : s) {
				n += (o * pion);
				o *= 10;
			}
		}
		return n;
	}

	public short[][] getTableau() {
		return tableau;
	}

	private short[][] getCopy() {
		short out[][] = new short[3][3];
		for (short x = 0; x < 3; x++) {
			for (short y = 0; y < 3; y++) {
				out[x][y] = tableau[x][y];
			}
		}
		return out;
	}

	private short[][] up() {
		short out[][] = getCopy();
		for (short x = 1; x < 3; x++) {
			for (short y = 0; y < 3; y++) {
				if (out[x][y] == 0) {
					return echange(out, x, y, (x - 1), y);
				}
			}
		}
		return null;
	}

	private short[][] down() {
		short out[][] = getCopy();
		for (short x = 0; x < 2; x++) {
			for (short y = 0; y < 3; y++) {
				if (out[x][y] == 0) {
					return echange(out, x, y, (x + 1), y);
				}
			}
		}
		return null;
	}

	private short[][] left() {
		short out[][] = getCopy();
		for (short x = 0; x < 3; x++) {
			for (short y = 1; y < 3; y++) {
				if (out[x][y] == 0) {
					return echange(out, x, y, x, (y - 1));
				}
			}
		}
		return null;
	}

	private short[][] right() {
		short out[][] = getCopy();
		for (short x = 0; x < 3; x++) {
			for (short y = 0; y < 2; y++) {
				if (out[x][y] == 0) {
					return echange(out, x, y, x, (y + 1));
				}
			}
		}
		return null;
	}

	public ArrayList<short[][]> getEnfants() {
		ArrayList<short[][]> e = new ArrayList<>();
		if (up() != null) {
			e.add(up());
		}
		if (down() != null) {
			e.add(down());
		}
		if (left() != null) {
			e.add(left());
		}
		if (right() != null) {
			e.add(right());
		}
		return e;
	}

	private short[][] echange(short in[][], short x1, short y1, int x2, int y2) {
		short out[][] = in;
		short tr = out[x1][y1];
		out[x1][y1] = out[x2][y2];
		out[x2][y2] = tr;
		return out;
	}

	public int getManathanDist() {
		short out[][] = getCopy();
		int d=0;
		for (short x = 0; x < 3; x++) {
			for (short y = 0; y < 3; y++) {
				switch (out[x][y]){
					case 0:
						d+=2-x+2-y;
						break;
					case 1:
						d+=x+y;
						break;
					case 2:
						d+=x+Math.abs(1-y);
						break;
					case 3:
						d+=x+2-y;
						break;
					case 4:
						d+=Math.abs(1-x)+y;
						break;
					case 5:
						d+=Math.abs(1-x)+Math.abs(1-y);
						break;
					case 6:
						d+=Math.abs(1-x)+2-y;
						break;
					case 7:
						d+=2-x+y;
						break;
					case 8:
						d+=2-x+Math.abs(1-y);
						break;
				}
			}
		}
		return d;
	}
}
