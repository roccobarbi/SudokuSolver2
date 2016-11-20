package SudokuSolver2.testDrivers;

import SudokuSolver2.*;

public class test_002 {

	public static void main(String[] args) {
		// Hard puzzle
		int puzzle[] = {8,0,0,0,6,0,3,9,7,9,1,0,2,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,7,9,0,0,0,0,0,0,0,4,0,0,0,0,2,5,2,0,0,6,7,0,0,0,0,0,0,0,0,9,1,0,0,0,4,0,0,0,0,0,0,3,0,0,0,0,0,0,0,6,1,0};
		int solution[] = {8,4,2,1,6,5,3,9,7,9,1,5,2,3,7,8,4,6,7,3,6,4,8,9,1,5,2,1,8,7,9,5,2,4,6,3,6,9,4,3,1,8,7,2,5,2,5,3,6,7,4,9,8,1,3,6,8,5,9,1,2,7,4,4,7,1,8,2,6,5,3,9,5,2,9,7,4,3,6,1,8};
		int solvedBoard[];
		boolean isCorrect = true;
		SudokuSolver2 solveIt = new SudokuSolver2(puzzle);
		solvedBoard = solveIt.getActiveBoard();
		if(solveIt.solve()){
			System.out.println("Got a solution after " + solveIt.getIterations() + " iterations.");
			for(int i = 0; i < solvedBoard.length; i++){
				if(solvedBoard[i] != solution[i]){
					isCorrect = false;
				}
			}
			System.out.println("The solution is " + (isCorrect ? "correct" : "false") + ".");
		}
		else{
			System.out.println("Unable to solve the puzzle after " + solveIt.getIterations() + " iterations.");
		}
		
		System.out.println("It took " + solveIt.getDuration() + " milliseconds to solve this puzzle.");
		System.out.println();
		for(int i = 0; i < 9; i++){
			for(int k = 0; k < 9; k++){
				System.out.print(solvedBoard[i * 9 + k] + " ");
			}
			System.out.println();
		}
	}

}
