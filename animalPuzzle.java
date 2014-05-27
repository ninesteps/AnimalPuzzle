
public class animalPuzzle{

	private static int numberOfPlacements(Piece piece){
		int count = 0;


	}


	private static void place(){
		int totalplacements;

		if (puzzlepieces.isEmpty()){
			return; // Success
		}

		totalplacements = 0;
		for (piece : puzzlepieces){
			piece.setNumberOfPlacements(numberOfPlacements(piece));
			totalplacements += numberOfPlacements(piece);//
		}			
		
		if (totalplacements == 0){
			return; // failure
		}
		
		//Sort By NumberOfPlacements



	}


	public static void main(String[] args){
		
	
	}
}
