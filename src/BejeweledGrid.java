import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BejeweledGrid {
	/**
	 * The 2D array of jewels
	 */
	private Jewel[][] jewels;
	/** Offsets for drawing the grid of Jewels*/
	public static final int OFFSET_X = 40, OFFSET_Y = 20; 
	public boolean firstClick = true;
	public static final int SQUARE_SIZE = 64;
	public BejeweledGrid() {
		jewels = new Jewel[8][8];
		refill();
	}
	
	/** directs each Jewel to draw itself.  The Jewel knows its row
	 * and column and can ask the grid for the offset info
	 * @param g Graphics context onto which the Jewels will draw themselves
	 */
	public void draw(Graphics g) {
		for(Jewel[] row :jewels) {
			for(Jewel c:row) {
				if(c!=null) {
					c.draw(g);
				}
			}
		}
		
	}
	
	/** swaps the Jewels at the specified locations.  Also must
	 * tell the Jewels to set their rows and cols appropriately.
	 * @param r1 row of Jewel 1
	 * @param c1 col of Jewel 1
	 * @param r2 row of Jewel 2
	 * @param c2 col of Jewel 2
	 */
	public void swap(int r1, int c1, int r2, int c2) {
		Jewel temp = jewels[r1][c1];
		jewels[r1][c1] = jewels[r2][c2];
		jewels[r2][c2] = temp;
		
		// more of course tell the Jewels they are changing locations
	}
	
	/**
	 * Creates an ArrayList<Jewel> of all Jewels that are part of a
	 * three-in-a-row.  The same Jewel may appear in the List more than
	 * once.
	 * @return
	 */
	public ArrayList<Jewel> _3InARow() {
		ArrayList<Jewel> list = _3InARowHor();
		list.addAll(_3InARowVert());
		return list;
	}

	/**
	 * 
	 * @return returns an ArrayList of Jewels that make up three or more in 
	 *         a row vertically or an empty list if fewer than 3 in a row exist
	 */
	private ArrayList<? extends Jewel> _3InARowVert() {
		
		return null;
	}
	/**  
	 * @return returns an ArrayList of Jewels that make up three or more in 
	 *         a row horizontally or an empty list if fewer than 3 in a row exist
	 */
	private ArrayList<Jewel> _3InARowHor() {
		
		return null;
	}
	/**
	 * This method drops all Jewels that should drop...
	 * Basically, any Jewel that has no Jewel below it needs to 
	 * be in a higher row.  Lots of ways to approach this.
	 */
	public void drop() {
		for(int r = 0; r < jewels.length - 1;r++) {
			for(int c = 0; c < jewels[r].length;c++) {
				if(jewels[r+1][c] == null) {
					for(int k = r; k >=0; k--) {
						jewels[k+1][c] = jewels[k][c];
					}
				}
			}
		}
	}
	
	/**
	 * Fill in any empty positions in the grid with randomly selected Jewel
	 */
	public void refill() {
		for(int r = 0; r < jewels.length;r++) {
			for(int c = 0; c < jewels[r].length;c++) {
				if(jewels[r][c] == null) {
					jewels[r][c] = randomJewel(r,c);
				}
			}
		}
	}

	/**
	 * Generates a random Jewel that will have its starting location
	 * at the specified row and col.
	 * @param r row where the Jewel will be placed
	 * @param c col where the Jewel will be placed
	 * @return random type of Jewel constructed at r,c
	 */
	private Jewel randomJewel(int r, int c) {
		int random = (int) (Math.random() * 7);
		if(random == 0) {
			return new Amethyst(r, c);
		}else if (random == 1 ) {
			return new Diamond(r, c);
		}else if (random == 2 ) {
			return new Emerald(r, c);
		}else if (random == 3 ) {
			return new Garnet(r, c);
		}else if (random == 4 ) {
			return new Pearl(r, c);
		}else if (random == 5 ) {
			return new Diamond(r, c);
		}else if (random == 6 ) {
			return new Sapphire(r, c);
		}
		return null;
	}
	/**
	 * This method is called by the game when a click has been made 
	 * on the panel.  Must determine if the click makes sense (is it 
	 * a valid location, is there a Jewel at the location, can that 
	 * Jewel be clicked).  If it is the first click, then note it and
	 * the next click will attempt a move (maybe).
	 * @param me
	 */
	public boolean isClicked() {
		
		
		return false;
		
	}
	public int[] justClicked(MouseEvent me) {
		int x = me.getX();
		int y = me.getY();
		int endX = OFFSET_X + 10*SQUARE_SIZE;
		int endY = OFFSET_Y + 10*SQUARE_SIZE;
		int t = (x-OFFSET_X)/SQUARE_SIZE;
		int k = (y - OFFSET_Y)/SQUARE_SIZE;
		if(x> OFFSET_X && y > OFFSET_Y) {
			if(x < endX && y < endY) {
				
				jewels[t][k].setBoolJewel(true);
				invisibleStuff();
			
				
				
			}
		}
		int[] retu = {t,k};
		return retu;
		
	
	}
	public void invisibleStuff() {
		for(int i = 0; i < jewels.length;i++) {
			for(int c= 0; c<jewels[i].length;c++) {
				if (jewels[i][c].getBoolJewel() == true) jewels[i][c] = ;
			}
		}
	}



	
}
