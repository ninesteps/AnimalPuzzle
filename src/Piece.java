import java.util.ArrayList;

public class Piece {
	int id;
	public Side[] side;
	private int nSides;
	private int noOfPlaces;
	private int timesRotated;
	

	public int getNSides(){
		return nSides;
	}

    public void rotate(){
        Side temp = side[nSides - 1];
        for(int i = nSides -1; i>0; i--){
            side[i] = side[i-1];
        }
        side[0] = temp;
    }

	public int getNoOfPlaces(){
		return noOfPlaces;
	}

	public void setNoOfPlaces(int noOfPlaces){
		this.noOfPlaces = noOfPlaces;
	}

	public void setTimesRotated(int times){//Set times rotated clockwise
		timesRotated = times;
	}
	public int getTimesRotated(){
		return timesRotated;
	}

	   static int piece_count = 0;
	   static final Side[] prototype = new Side[0];
	   public Piece(ArrayList<Side> some_sides) {
		   id = ++piece_count;
		   side = some_sides.toArray(prototype);
		   nSides = side.length;
	   }
}
