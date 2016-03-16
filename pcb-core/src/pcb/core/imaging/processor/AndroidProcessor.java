package pcb.core.imaging.processor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import pcb.core.imaging.ColorImageMapping;
import pcb.core.model.ImageSize;
import pcb.core.util.Common;

public class AndroidProcessor extends AbstractImageProcessor {

	private Bitmap bitmap;
	private Bitmap resized;
	
	@Override
	void preProcess() throws IOException {
		bitmap = BitmapFactory.decodeByteArray(imageFile , 0, imageFile.length);
		
	}

	@Override
	void resize() {
		ImageSize newSize = Common.calculateNewSize(new ImageSize(bitmap.getWidth(), bitmap.getHeight()), paintSize);
		resized = Bitmap.createScaledBitmap(bitmap, newSize.getWidth(), newSize.getHeight(), true);
		
	}

	@Override
	void adjustContrastAndSaturation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	ColorImageMapping createColorMapping() throws IOException {
		ColorImageMapping imageMapping = new ColorImageMapping();
		imageMapping.setOriginalImage(toByteArray(bitmap));
		imageMapping.setResizedImage(toByteArray(resized));
		imageMapping.setSize(paintSize);
		
		return imageMapping;
	}
	
	private static byte[] toByteArray(Bitmap image) throws IOException {
		ByteArrayOutputStream blob = new ByteArrayOutputStream();
		image.compress(CompressFormat.PNG, 0 /*ignored for PNG*/, blob);
		return blob.toByteArray();
	}

	
}
