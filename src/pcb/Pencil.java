package pcb;

import java.awt.Color;

public class Pencil {

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
}