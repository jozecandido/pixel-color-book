package pcb.output;

import pcb.imaging.Drawing;

public class HtmlOutput {
	
	private static final String TEMPLATE_ROW = "<div class'pixelrow' style='height:5px;width:auto;display:table-row;font-size:2pt;color:#EEEEEE;vertical-align;text-align:center;'>%s</div>";
	private static final String TEMPLATE_COLUMN = "<div class'pixelcol' style='background-color:%s;height:5px;width:5px;display:table-cell;border:.5px solid #EEEEEE;'>%s</div>";
	public String output(Drawing drawing) {
		
		StringBuffer htmlBuffer = new StringBuffer();
		StringBuffer rowBuffer = new StringBuffer();
		
		String color[][] = drawing.getMappedImage().getColorMapping();
		String number[][] = drawing.getMappedImage().getPencilNumberMapping();
		for(int y = 0; y < color.length; y++) {
			for(int x = 0; x < color[y].length; x++) {
				rowBuffer.append(addCol(color[y][x], number[y][x]));
			}
			htmlBuffer.append(addRow(rowBuffer.toString()));
			rowBuffer = new StringBuffer();
		}
		
		return htmlBuffer.toString();
	}
	
	private String addRow(String rowContent){
		return String.format(TEMPLATE_ROW, rowContent);
	}
	
	private String addCol(String color, String content) {
		return String.format(TEMPLATE_COLUMN, color, content);
	}

}
