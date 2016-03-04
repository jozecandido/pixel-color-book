package pcb.model;

import java.awt.Color;

public class Pencil implements Comparable<Pencil> {

	private int number;
	private String name;
	private Color color;
	
	public Pencil(int number, String name, int r, int g, int b) {
		this.number = number;
		this.name = name;
		this.color = new Color(r, g, b);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return this.number == ((Pencil) obj).number;
	}
	
	@Override
	public String toString() {
		return this.getNumber() + " - " + this.getName() + " - RGB(" + this.getColor().getRed() +
				", " + this.getColor().getGreen() + ", " + this.getColor().getBlue() + ")";
	}

	@Override
	public int compareTo(Pencil o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if (this.getNumber() > o.getNumber()) {
	    	return AFTER;
	    }
	    if (this.getNumber() < o.getNumber()) {
	    	return BEFORE;
	    }
    	return EQUAL;
	}
}