import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class animalPuzzle{
	static private Comparator<Piece> ascPlacements;
	static ArrayList<Piece> puzzlepieces = new ArrayList<Piece>();
    static Piece[][] winner;
	static {
		ascPlacements = new Comparator<Piece>(){
			@Override
			public int compare(Piece p1, Piece p2){
				return (p2.getNoOfPlaces()) -  p1.getNoOfPlaces();
			}
		};
	}

	
	private static int numberOfPlacements(Piece piece, Piece[][] puzzle){
        int count = 0;
		for(int i = 0; i < puzzle.length; i++){
			for (int j = 0; j < puzzle[0].length; j++){
				if(puzzle[i][j]==null){ // every empty piece
					
					if(!(puzzle[i+1][j]==null) || !(puzzle[i-1][j]==null) //If atleast one neighbour
					|| !(puzzle[i][j-1]==null) || !(puzzle[i][j+1]==null)){ // Is full

						for(int rotation = 0; rotation < piece.getNSides(); rotation++){ //for every rotation
						    piece.rotate();
							
							if((piece.side[0].equals(puzzle[i][j+1].side[2])) && //bottom side == top
                              (piece.side[1].equals(puzzle[i-1][j].side[3])) && //left side == right
                              (piece.side[2].equals(puzzle[i][j-1].side[0])) && //top side == bottom
                              (piece.side[3].equals(puzzle[i+1][j].side[1]))) { //right side == left

                                count++;

                            }
                        }
                    }
                }
            }
        }
        return count;
	}


	private static boolean place (Piece piece, Piece[][] puzzle){
        for(int i = 0; i < puzzle.length; i++){
            for (int j = 0; j < puzzle[0].length; j++){
                if(puzzle[i][j]==null){ // every empty piece

                    if(!(puzzle[i+1][j]==null) || !(puzzle[i-1][j]==null) //If atleast one neighbour
                            || !(puzzle[i][j-1]==null) || !(puzzle[i][j+1]==null)){ // Is full

                        for(int rotation = 0; rotation < piece.getNSides(); rotation++){ //for every rotation
                            piece.rotate();

                            if((piece.side[0].equals(puzzle[i][j+1].side[2])) && //bottom side == top
                                    (piece.side[1].equals(puzzle[i-1][j].side[3])) && //left side == right
                                    (piece.side[2].equals(puzzle[i][j-1].side[0])) && //top side == bottom
                                    (piece.side[3].equals(puzzle[i+1][j].side[1]))) { //right side == left

                                        puzzle[i][j] = piece;
                                        if(solve(puzzle)){
                                            return true;
                                        }


                            }
                        }
                    }
                }
            }
        }
		return false;
	}


	private static boolean solve(Piece[][] puzzle){
		int totalplacements;
		Piece tempPiece;
		if (puzzlepieces.isEmpty()){
            winner = puzzle;
			return true; // Success
		}

		totalplacements = 0;
		for (Piece piece : puzzlepieces){
			piece.setNoOfPlaces(numberOfPlacements(piece,puzzle));
			totalplacements += numberOfPlacements(piece,puzzle);//
		}			
		
		if (totalplacements == 0){
			return false; // failure
		}
		
		Collections.sort(puzzlepieces, ascPlacements);

		tempPiece = puzzlepieces.remove(0);
		

		if(place(tempPiece,puzzle)){
			return true; 
		}

		puzzlepieces.add(tempPiece);
		return false;
	}


	public static void main(String[] args){
		
	
	}
}
