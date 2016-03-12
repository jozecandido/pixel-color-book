package pcb.model;

public class Color {
	private int red;
	private int green;
	private int blue;
	private int rgb;
	
	
	
	public Color(int rgb) {
		setRGB(rgb);
	}

	public Color(int r, int g, int b) {
		setRed(r);
		setGreen(g);
		setBlue(b);
	}
	
	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getRGB() {
		rgb = ((red&0x0ff)<<16)|((green&0x0ff)<<8)|(blue&0x0ff);
		return rgb;
	}
	public void setRGB(int rgb) {
		this.rgb = rgb;
		setRed((rgb >> 16) & 0xFF);
		setGreen((rgb >> 8) & 0xFF);
		setBlue(rgb & 0xFF);
	}
	
	public String getHex() {
		return String.format("#%02x%02x%02x", red, green, blue);
	}
}
