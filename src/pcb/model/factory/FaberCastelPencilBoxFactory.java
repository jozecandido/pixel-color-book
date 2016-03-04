package pcb.model.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import pcb.exception.BoxSizeException;
import pcb.model.ColorPencilBox;
import pcb.model.Pencil;
import pcb.model.PencilBrand;

class FaberCastelPencilBoxFactory {
	
	public static ColorPencilBox createColorPencilBox(int size) throws BoxSizeException {
		List<Pencil> pencils = null;
		
		switch (size) {
		case 12:
			pencils = create12ColorPencilBox();
			break;
		case 24:
			pencils = create24ColorPencilBox();
			break;
		case 36:
			pencils = create36ColorPencilBox();
			break;
		case 48:
			pencils = create48ColorPencilBox();
			break;
		case 60:
			pencils = create60ColorPencilBox();
			break;
		default:
			throw new BoxSizeException();
		}
		
		return new ColorPencilBox(PencilBrand.FaberCastell, pencils);
	}
	
	/**
	 * Returns a sorted list of pencils in the box of 12 color pencil box.
	 * @return
	 */
	private static List<Pencil> create12ColorPencilBox() {

		List<Pencil> box = new ArrayList<Pencil>();

		box.add(new Pencil(5, "Amarelo Canário", 252, 226, 0));
		box.add(new Pencil(9, "Laranja", 243, 111, 33));
		box.add(new Pencil(17, "Rosa Chiclete", 242, 124, 162));
		box.add(new Pencil(21, "Vermelho", 218, 32, 40));
		box.add(new Pencil(32, "Rosa Claro", 247, 160, 139));
		box.add(new Pencil(34, "Carmim", 94, 47, 125));
		box.add(new Pencil(43, "Azul Cobalto", 5, 42, 108));
		box.add(new Pencil(47, "Azul", 0, 165, 228));
		box.add(new Pencil(63, "Verde", 0, 81, 44));
		box.add(new Pencil(70, "Verde Folha", 50, 165, 67));
		box.add(new Pencil(76, "Marrom", 76, 18, 0));
		box.add(new Pencil(99, "Preto", 0, 21, 34));
		
		Collections.sort(box);
		
		return box;
	}
	
	/**
	 * Returns a sorted list of pencils in the box of 24 color pencil box.
	 * @return
	 */
	private static List<Pencil> create24ColorPencilBox() {

		List<Pencil> box = new ArrayList<Pencil>();

		box.addAll(create12ColorPencilBox());
		box.add(new Pencil(1, "Branco", 255, 255, 255));
		box.add(new Pencil(13, "Laranja Claro", 243, 111, 33));
		box.add(new Pencil(27, "Vermelho Escuro", 140, 46, 69));
		box.add(new Pencil(29, "Vermelho Violeta", 178, 64, 121));
		box.add(new Pencil(37, "Violeta", 60, 48, 135));
		box.add(new Pencil(61, "Verde Água", 0, 173, 149));
		box.add(new Pencil(71, "Verde Claro", 111, 191, 84));
		box.add(new Pencil(74, "Verde Pinho", 85, 139, 57));
		box.add(new Pencil(89, "Canela", 115, 74, 56));
		box.add(new Pencil(91, "Bordô", 154, 64, 64));
		box.add(new Pencil(97, "Cinza Escuro", 83, 91, 97));
		box.add(new Pencil(696, "Prata", 167, 169, 171));
		
		Collections.sort(box);
		
		return box;
	}
	
	/**
	 * Returns a sorted list of pencils in the box of 36 color pencil box.
	 * @return
	 */
	private static List<Pencil> create36ColorPencilBox() {

		List<Pencil> box = new ArrayList<Pencil>();

		box.addAll(create24ColorPencilBox());
		box.add(new Pencil(7, "Amarelo", 255, 203, 4));
		box.add(new Pencil(15, "Laranja Escuro", 240, 80, 34));
		box.add(new Pencil(33, "Vinho", 146, 55, 87));
		box.add(new Pencil(46, "Azul Céu", 104, 146, 204));
		box.add(new Pencil(51, "Azul Turquesa", 0, 26, 75));
		box.add(new Pencil(55, "Verde Turquesa", 0, 115, 106));
		box.add(new Pencil(59, "Verde Escuro", 0, 54, 26));
		box.add(new Pencil(75, "Sépia", 44, 4, 0));
		box.add(new Pencil(77, "Marrom Escuro", 84, 43, 32));
		box.add(new Pencil(82, "Ocre", 163, 148, 70));
		box.add(new Pencil(83, "Marrom Claro", 185, 144, 50));
		box.add(new Pencil(604, "Ouro", 169, 145, 85));
		
		Collections.sort(box);

		return box;
	}
	
	/**
	 * Returns a sorted list of pencils in the box of 48 color pencil box.
	 * @return 
	 */
	private static List<Pencil> create48ColorPencilBox() {

		List<Pencil> box = new ArrayList<Pencil>();

		box.addAll(create36ColorPencilBox());
		box.add(new Pencil(4, "Amarelo Limão", 237, 231, 9));
		box.add(new Pencil(10, "Areia", 239, 207, 190));
		box.add(new Pencil(23, "Fúcsia", 166, 43, 71));
		box.add(new Pencil(31, "Salmão", 242, 112, 89));
		box.add(new Pencil(35, "Roxo", 43, 40, 111));
		box.add(new Pencil(38, "Lilás", 151, 107, 174));
		box.add(new Pencil(39, "Cinza Azulado", 94, 145, 167));
		box.add(new Pencil(48, "Azul Real", 0, 125, 189));
		box.add(new Pencil(54, "Azul Claro", 85, 197, 207));
		box.add(new Pencil(56, "Verde Mar", 0, 124, 107));
		box.add(new Pencil(68, "Verde Oliva", 44, 72, 40));
		box.add(new Pencil(81, "Cinza Quente", 129, 128, 115));
		
		Collections.sort(box);
		
		return box;
	}

	/**
	 * Returns list of pencils in the box of 60 color pencil box.
	 * @return
	 */
	private static List<Pencil> create60ColorPencilBox() {

		List<Pencil> box = new ArrayList<Pencil>();

		box.addAll(create48ColorPencilBox());
		
		// Remove 2 pencils
		Iterator<Pencil> iterator = box.iterator();
		while (iterator.hasNext()) {
			Pencil pencil = (Pencil) iterator.next();
			if (pencil.getNumber() == 77 || pencil.getNumber() == 89) {
				iterator.remove();
			}
		}
		
		box.add(new Pencil(8, "Ocre Alaranjado", 224, 134, 26));
		box.add(new Pencil(19, "Vinho Claro", 162, 100, 110));
		box.add(new Pencil(20, "Rosa Pétala", 244, 153, 180));
		box.add(new Pencil(53, "Turquesa Azulado", 0, 128, 190));
		box.add(new Pencil(86, "Terra", 83, 51, 29));
		box.add(new Pencil(87, "Ocre Queimado", 200, 129, 101));
		box.add(new Pencil(96, "Cinza Gelo", 154, 196, 195));
		box.add(new Pencil(414, "Laranja Neon", 243, 111, 33));
		box.add(new Pencil(427, "Rosa Neon", 239, 80, 128));
		box.add(new Pencil(638, "Roxo Metálico", 114, 60, 150));
		box.add(new Pencil(646, "Azul Metálico", 41, 54, 144));
		box.add(new Pencil(665, "Verde Metálico", 148, 200, 61));
		box.add(new Pencil(672, "Lima Metálico", 216, 224, 34));
		box.add(new Pencil(689, "Bronze", 193, 120, 106));
		
		Collections.sort(box);
		
		return box;
	}
}
