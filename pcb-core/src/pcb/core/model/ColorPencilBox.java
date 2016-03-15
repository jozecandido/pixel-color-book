package pcb.core.model;

import java.util.ArrayList;
import java.util.List;

public class ColorPencilBox {

	private PencilBrand brand;
	private List<Pencil> pencils;
	
	public ColorPencilBox()	{
		brand = PencilBrand.FaberCastell;
		pencils = new ArrayList<Pencil>();
	}
	
	public ColorPencilBox(PencilBrand brand, List<Pencil> pencils)	{
		this.brand = brand;
		this.pencils = pencils;
	}
	
	public Pencil getPencil(int clr) {
        Color pixelColor = new Color(clr);
        
        double smallestDistance = 99999; 
        Pencil bestPencil = null;
        List<Pencil> pencils = this.getPencils();
        for (Pencil pencil : pencils) {
			double distance = distanceTo(pixelColor, pencil.getColor());
			if (distance < smallestDistance) {
				smallestDistance = distance;
				bestPencil = pencil;
			}
		}
        
		return bestPencil;
	}

	private double distanceTo(Color pixelColor, Color pencilColor) {
		double redDistance = pixelColor.getRed() - pencilColor.getRed();
		double greenDistance = pixelColor.getGreen() - pencilColor.getGreen();
		double blueDistance = pixelColor.getBlue() - pencilColor.getBlue();

		double distanceTo = (redDistance * redDistance) 
				+ (greenDistance * greenDistance)
				+ (blueDistance * blueDistance);
		distanceTo = Math.sqrt(distanceTo);

		return distanceTo;
	}
	
	
	public int getSize() {
		return pencils != null ? pencils.size() : 0;
	}
	
	public List<Pencil> getPencils() {
		return pencils;
	}
	
	public String getBrandName() {
		return "";
	}
	public PencilBrand getBrand() {
		return brand;
	}
	
}
