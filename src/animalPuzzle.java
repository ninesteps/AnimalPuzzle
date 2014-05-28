import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
        boolean up,down,left,right;
		for(int i = 1; i < puzzle.length-1; i++){
			for (int j = 1; j < puzzle[0].length-1; j++){
				if(puzzle[i][j]==null){ // every empty piece
					
					if(!(puzzle[i+1][j]==null) || !(puzzle[i-1][j]==null) //If atleast one neighbour
					|| !(puzzle[i][j-1]==null) || !(puzzle[i][j+1]==null)){ // Is full

						for(int rotation = 0; rotation < piece.getNSides(); rotation++){ //for every rotation
						    piece.rotate();

                            try{
                                down = (piece.side[0].equals(puzzle[i][j+1].side[2]));
                            } catch (NullPointerException e){
                                down = true;
                            }
                            try{
                                left = (piece.side[1].equals(puzzle[i-1][j].side[3]));
                            } catch (NullPointerException e){
                                left = true;
                            }
                            try{
                                up = (piece.side[2].equals(puzzle[i][j-1].side[0]));
                            } catch (NullPointerException e){
                                up = true;
                            }
                            try{
                                right = (piece.side[3].equals(puzzle[i+1][j].side[1]));
                            } catch (NullPointerException e){
                                right = true;
                            }





							
							if(up && down && left && right) {

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
        boolean up,down,left,right;
        for(int i = 1; i < puzzle.length-1; i++){
            for (int j = 1; j < puzzle[0].length-1; j++){
                if(puzzle[i][j]==null){ // every empty piece

                    if(!(puzzle[i+1][j]==null) || !(puzzle[i-1][j]==null) //If atleast one neighbour
                            || !(puzzle[i][j-1]==null) || !(puzzle[i][j+1]==null)){ // Is full

                        for(int rotation = 0; rotation < piece.getNSides(); rotation++){ //for every rotation
                            piece.rotate();

                            try{
                                down = (piece.side[0].equals(puzzle[i][j+1].side[2]));
                            } catch (NullPointerException e){
                                down = true;
                            }
                            try{
                                left = (piece.side[1].equals(puzzle[i-1][j].side[3]));
                            } catch (NullPointerException e){
                                left = true;
                            }
                            try{
                                up = (piece.side[2].equals(puzzle[i][j-1].side[0]));
                            } catch (NullPointerException e){
                                up = true;
                            }
                            try{
                                right = (piece.side[3].equals(puzzle[i+1][j].side[1]));
                            } catch (NullPointerException e){
                                right = true;
                            }






                            if(up && down && left && right) {

                                        puzzle[i][j] = piece;
                                        if(solve(puzzle)){
                                            return true;
                                        } else {
                                            puzzle[i][j] = null;
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



    public static void printPuzzle(Piece[][] puzzle){
        Piece up=null,down=null,left=null,right=null;
        for(int i = 0; i < puzzle.length; i++){
            for (int j = 0; j < puzzle[0].length; j++){
                if(!(puzzle[i][j]==null)){
                    if(!(puzzle[i][j-1]==null)) up=puzzle[i][j-1];
                    if(!(puzzle[i][j+1]==null)) down=puzzle[i][j+1];
                    if(!(puzzle[i-1][j]==null)) left=puzzle[i][j-1];
                    if(!(puzzle[i+1][j]==null)) right=puzzle[i][j-1];




                    System.out.println("Piece Number: " + puzzle[i][j].id + " Connects to Pieces: " +
                            (down==null?"":down.id + " ") + (left==null?"":left.id + " ") +
                            (up==null?"":up.id + " ") + (right==null?"":right.id + " ") +
                            "Via " +
                            (down==null?"":puzzle[i][j].side[0] + " ") +
                            (left==null?"":puzzle[i][j].side[1] + " ") +
                            (up==null?"":puzzle[i][j].side[2] + " ") +
                            (right==null?"":puzzle[i][j].side[3] + " "));

                }
            }
        }
    }



	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("inputsquares.txt"));
        Piece[][] puzzle = new Piece[100][100];
        while(sc.hasNextLine()){
            ArrayList<Side> some_sides = new ArrayList<Side>();
            String line = sc.nextLine();
            Scanner scline = new Scanner(line);

            while (scline.hasNext()){
                some_sides.add(new Side(scline.next()));
            }

            puzzlepieces.add(new Piece(some_sides));
        }

        puzzle[50][50] = puzzlepieces.remove(0);
        if(solve(puzzle)){
            printPuzzle(winner);
        } else {
            System.out.println("No Solution");
        }
	}
}
