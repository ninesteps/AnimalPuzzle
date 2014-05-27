public class Piece {
	int id;
	Side[] side;
	private int nSides;
	private int noOfPlaces;
	private int timesRotated
	

	public static int getNSides(){
		return nSides;
	}

	public static int getNoOfPlaces(){
		return noOfPlaces;
	}
	public static void setNoOfPlaces(int noOfPlaces){
		noOfPlaces = this.noOfPlaces;
	}

	public static void setTimesRotated(int times){//Set times rotated clockwise
		timesRotated = times;
	}
	public static int getTimesRotated(){
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
