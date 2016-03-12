package pcb.output;

import pcb.imaging.Drawing;

public class HtmlOutput {
	
	public String output(Drawing drawing) {
		StringBuffer buffer = new StringBuffer();
		String map[][] = drawing.getMappedImage().getColorMapping();
		int number[][] = drawing.getMappedImage().getPencilNumberMapping();
		for(int y = 0; y < map.length; y++) {
			buffer.append("<div class='linha'>");
			for(int x = 0; x < map[y].length; x++) {
				buffer.append("<div class='coluna' style='background-color:");
				buffer.append(map[y][x]);
				buffer.append("'>");
				buffer.append(number[y][x]);
				buffer.append("</div>");
			}
			buffer.append("</div>");
		}
		
		return buffer.toString();
	}

}
