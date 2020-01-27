import java.awt.Color;
import java.awt.Image;

public class Pearl extends Jewel{
	static Image pearlImage;
	// I found the locations below by a little bit of guess and 
	// check to find a rectangle that bounded the image of the 
	// Emerald.
	static final int EM_X=1198, EM_Y=183, EM_W = 120, EM_H=100;
	
	public Pearl(int r, int co) {
		super(Color.WHITE, getImage(), r, co);
	}

	private static Image getImage() {
		if(pearlImage == null)
			pearlImage= openImageFromSpriteSheet(EM_X, EM_Y, EM_W, EM_H);
		return pearlImage;
	}
}
