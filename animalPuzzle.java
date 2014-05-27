import java.util.Comparator;

public class animalPuzzle{
	static private Comparator<Piece> ascPlacements;
	static Arraylist<Piece> puzzlepieces = new ArrayList<Piece>();
	static Boolean success = false;	
	static {
		asPlacements = new Comparator<Piece>(){
			@Override
			public int compare(Piece p1, Piece p2){
				return p1.getNoOfPlaces().compareTo(p2.getNoOfPlaces());
			}
		};
	}

	
	private static int numberOfPlacements(Piece piece, Piece[][] puzzle){
		piece.setTimesRotated(0);
		for(int i = 0; i < puzzle.length; i++){
			for (int j = 0; j < puzzle[0].length; j++){
				if(puzzle[i][j]==Null){ // every empty piece
					
					if(!puzzle[i+1][j]==Null || !puzzle[i-1][j]==Null //If atleast one neighbour
					|| !puzzle[i][j-1]==Null || !puzzle[i][j+1]==Null){ // Is full
						for(int side = 0; side < piece.getNSides(); side++){
						
							if(piece[side].equals


	}


	private static Piece[][] place (Piece piece, Piece[][] puzzle){
		
	}


	private static Boolean solve(Piece[][] puzzle){
		int totalplacements;
		Piece tempPiece;
		if (puzzlepieces.isEmpty()){
			return true; // Success
		}

		totalplacements = 0;
		for (piece : puzzlepieces){
			piece.setNoOfPlaces(numberOfPlacements(piece,puzzle));
			totalplacements += numberOfPlacements(piece,puzzle);//
		}			
		
		if (totalplacements == 0){
			return false; // failure
		}
		
		Collections.sort(puzzlepieces, ascPlacements);

		tempPiece = puzzlepieces.remove(0);
		
		
		for (int i = 0; i < tempPiece.getNoOfPlaces(); i++){ //needs to solve for certain rotations too
		if(solve(place(tempPiece,puzzle,i))){
			return true; 
		}
		puzzlepieces.add(tempPiece);
		return false;
	}


	public static void main(String[] args){
		
	
	}
}
