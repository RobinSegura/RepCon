package model;

import java.util.ArrayList;

public abstract class State {
	
	State parent;
	
	public abstract ArrayList<State> getEnfants();
}
