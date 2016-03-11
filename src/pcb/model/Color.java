package pcb.model;

public class Color {
	private int red;
	private int green;
	private int blue;
	private int rgb;
	
	private double l;
	private double b;
	private double a;
	
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
	
	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public void convertToLab() {
		double var_R = ( red / 255 );        //R from 0 to 255
		double	var_G = ( green / 255 );        //G from 0 to 255
		double	var_B = ( blue / 255 );        //B from 0 to 255

		if ( var_R > 0.04045 ) 
			var_R = Math.pow( ( var_R + 0.055 ) / 1.055 , 2.4);
		else                   
			var_R = var_R / 12.92;
		
		if ( var_G > 0.04045 ) 
			var_G = Math.pow( ( var_G + 0.055 ) / 1.055, 2.4);
		else                   
			var_G = var_G / 12.92;
		
		if ( var_B > 0.04045 ) 
			var_B = Math.pow( ( var_B + 0.055 ) / 1.055, 2.4);
		else                   
			var_B = var_B / 12.92;

		var_R = var_R * 100;
		var_G = var_G * 100;
		var_B = var_B * 100;

		//Observer. = 2°, Illuminant = D65
		double X = var_R * 0.4124 + var_G * 0.3576 + var_B * 0.1805;
		double Y = var_R * 0.2126 + var_G * 0.7152 + var_B * 0.0722;
		double Z = var_R * 0.0193 + var_G * 0.1192 + var_B * 0.9505;
	
		double ref_X = 95.047;
		double ref_Y = 100.000;
		double ref_Z = 108.883;
		
		double var_X = X / ref_X;          //ref_X =  95.047   Observer= 2°, Illuminant= D65
		double var_Y = Y / ref_Y;          //ref_Y = 100.000
		double var_Z = Z / ref_Z;          //ref_Z = 108.883

		if ( var_X > 0.008856 ) 
			var_X = Math.pow(var_X, ( 1/3 ));
		else                    
			var_X = ( 7.787 * var_X ) + ( 16 / 116 );
		
		if ( var_Y > 0.008856 )
			var_Y = var_X = Math.pow(var_Y,( 1/3 ));
		else                    
			var_Y = ( 7.787 * var_Y ) + ( 16 / 116 );
		if ( var_Z > 0.008856 ) 
			var_Z = var_X = Math.pow(var_Z,( 1/3 ));
		else                    
			var_Z = ( 7.787 * var_Z ) + ( 16 / 116 );

		double L = ( 116 * var_Y ) - 16;
		double A = 500 * ( var_X - var_Y );
		double B = 200 * ( var_Y - var_Z );
		
		setL(L);
		setA(A);
		setB(B);
	}
}
