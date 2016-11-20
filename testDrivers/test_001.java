package SudokuSolver2.testDrivers;

import SudokuSolver2.*;

public class test_001 {

	public static void main(String[] args) {
		int puzzle[] = {7,3,0,0,0,5,0,0,0,0,4,0,0,6,0,0,0,0,0,0,1,0,0,9,0,5,0,0,5,0,0,0,1,0,9,2,0,0,0,0,0,0,0,0,0,0,0,0,0,4,7,5,0,8,3,0,0,0,7,2,0,0,0,6,9,0,0,0,0,2,0,0,0,0,0,6,3,0,4,0,0};
		int solution[] = {7,3,2,8,1,5,9,4,6,5,4,9,7,6,3,8,2,1,8,6,1,4,2,9,3,5,7,4,5,6,3,8,1,7,9,2,2,7,8,5,9,6,1,3,4,9,1,3,2,4,7,5,6,8,3,8,4,9,7,2,6,1,5,6,9,7,1,5,4,2,8,3,1,2,5,6,3,8,4,7,9};
		int solvedBoard[];
		boolean isCorrect = true;
		SudokuSolver2 solveIt = new SudokuSolver2(puzzle);
		if(solveIt.solve()){
			System.out.println("Got a solution after " + solveIt.getIterations() + " iterations.");
			solvedBoard = solveIt.getActiveBoard();
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
	}

}
