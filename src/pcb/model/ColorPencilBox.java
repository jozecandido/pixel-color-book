package pcb.model;

import java.util.ArrayList;
import java.util.List;

public class ColorPencilBox {

	private PencilBrand brand;
	private List<Pencil> pencils;
	
	public ColorPencilBox()	{
		brand = PencilBrand.FaberCastel;
		pencils = new ArrayList<Pencil>();
	}
	
	public ColorPencilBox(PencilBrand brand, List<Pencil> pencils)	{
		this.brand = brand;
		this.pencils = pencils;
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
