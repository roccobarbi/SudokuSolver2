/*
 * Saves a Sudoku board and implements a set of methods to solve it.
 */

package SudokuSolver2;

public class SudokuSolver2 {
	private static final int BOARD_LENGTH = 81;
	
	private int[] activeBoard;
	private final int[] startingBoard;
	private boolean[] fixedPositions;
	private long iterations; // how many iterations were needed to solve the puzzle
	private long timeStart; // timestamp in milliseconds
	private long timeEnd; // timestamp in milliseconds
	private long duration; // time that it took to solve the puzzle in milliseconds
	private boolean isSolved;
	
	// Constructors
	
	/*
	 * SudokuSolver2
	 * Stub that exits after displaying an error. In future versions it will prompt the
	 * user to enter a board (possibly in a variety of formats).
	 */
	public SudokuSolver2(){
		startingBoard = null;
		System.out.println("ERROR: a board must be provided to initialise the SudokuSolver2 class. "
				+ "A backup creator that prompts the user to enter the board will be "
				+ "provided in future versions.");
		System.exit(0);
	}
	
	/*
	 * SudokuSolver2(int[] board)
	 * It requires an array of 81 integer values that represents the Sudoku board.
	 * Empty cells must be represented with 0.
	 */
	public SudokuSolver2(int[] board){
		startingBoard = board;
		activeBoard = new int[BOARD_LENGTH];
		setActiveBoard();
		fixedPositions = new boolean[BOARD_LENGTH];
		setFixedPositions();
		iterations = 0;
		timeStart = 0;
		timeEnd = 0;
		duration = 0;
		isSolved = false;
		if(board.length != BOARD_LENGTH){
			System.out.println("ERROR: the board that was provided had not " + BOARD_LENGTH
					+ " elements. That exact number of elements is required.");
			System.exit(0);
		}
	}
	
	// Private accessors
	
	private void setActiveBoard(){
		for(int i = 0; i < BOARD_LENGTH; i++){
			activeBoard[i] = startingBoard[i];
		}
	}
	
	private void setFixedPositions(){
		for(int i = 0; i < BOARD_LENGTH; i++){
			fixedPositions[i] = startingBoard[i] == 0 ? false : true;
		}
	}
	
	// Public accessors
	/*
	 * int[] getStartingBoard()
	 * 
	 * Returns the starting board.
	 */
	public int[] getStartingBoard(){
		return startingBoard;
	}
	
	/*
	 * int[] getActiveBoard()
	 * 
	 * Returns the current board.
	 */
	public int[] getActiveBoard(){
		return activeBoard;
	}
	
	public long getIterations(){
		return iterations;
	}
	
	public long getTimeStart(){
		return timeStart;
	}
	
	public long getTimeEnd(){
		return timeEnd;
	}
	
	public long getDuration(){
		return duration;
	}
	
	public boolean getIsSolved(){
		return isSolved;
	}
	
	// Private Methods
	
	// checkPosition(int index, int value) 
	// Checks if value has already been entered in the row, column and box for index. 
	// Returns true if value can be entered at position index.

	private boolean checkPosition(int index, int value){
		boolean result = true;
		if(fixedPositions[index]){
			if(startingBoard[index] != value) result = false;
		}
		else{
			if(checkRow(index, value)) result = false;
			if(result && checkColumn(index, value)) result = false; // Short-circuit evaluation to avoid unnecessary computations
			if(result && checkBox(index, value)) result = false; // Short-circuit evaluation to avoid unnecessary computations
		}
		return result;
	}
	
	// checkColumn(int index, int value)
	// Returns true if value is found in the column for index
	private boolean checkColumn(int index, int value){
		boolean result = false;
		int column = index % 9, position = 0;
		for(int i = 0; i < 9; i++){
			position = i * 9 + column;
			if(position != index){
				if(activeBoard[position] == value) result = true;
			}
		}
		return result;
	}
	
	// checkRow(int index, int value)
	// Returns true if value is found in the row for index
	private boolean checkRow(int index, int value){
		boolean result = false;
		int row = index / 9, position = 0;
		for(int i = 0; i < 9; i++){
			position = row * 9 + i;
			if(position != index){
				if(activeBoard[position] == value) result = true;
			}
		}
		return result;
	}
	
	// checkBox(int index, int value)
	// Stup
	// Returns true if value is found in the box for index
	private boolean checkBox(int index, int value){
		boolean result = false;
		// Logic here
		return result;
	}
	
	// solvePosition(int index, int value) 
	// Recursive algorithm to solve Sudoku puzzles. 
	// Returns true if value can be entered at position index.

	private boolean solvePosition(int index, int value){
		if(checkPosition(index, value)){
			if(index == activeBoard.length - 1){
				if(!fixedPositions[index]) activeBoard[index] = value;
				return true;
			}
			else{
				if(!fixedPositions[index]) activeBoard[index] = value;
				for(int i = 1; i < 10; i++){
					if(solvePosition(index + 1, i)) return true;
				}
			}
		}
		if(!fixedPositions[index]) activeBoard[index] = 0;
		return false;
	}
	
	// Public Methods
	
	/*
	 * boolean solve()
	 * 
	 * Uses a recursive backtracking algorithm to solve the Sudoku.
	 * Returns true when the puzzle is solved, false if it was unable to solve it.
	 */
	public boolean solve(){
		return solvePosition(1, 1);
	}
	
	/*
	 * String toString()
	 * 
	 * Returns the current state of the board as a string.
	 * Rows are semicolon-separated, all other cells are comma-separated;
	 */
	public String toString(){
		String output = "";
		for(int i = 0; i < BOARD_LENGTH; i++){
			if(i > 0){
				if(i % 9 != 0){
					output += ",";
				}
				else{
					output += ";";
				}
			}
			output += Integer.toString(activeBoard[i]);
		}
		return output;
	}
	
	/*
	 * prettyPrint()
	 * 
	 * Stub
	 * 
	 * Will return the current board in a form that is more legible to humans
	 */
	public String prettyPrint(){
		return "";
	}
}
