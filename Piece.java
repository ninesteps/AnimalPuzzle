public class Piece {
	int id;
	Side[] side;
	int nSides;

	   static int piece_count = 0;
	   static final Side[] prototype = new Side[0];
	   public Piece(ArrayList<Side> some_sides) {
		   id = ++piece_count;
		   side = some_sides.toArray(prototype);
		   nSides = side.length;
	   }
}
