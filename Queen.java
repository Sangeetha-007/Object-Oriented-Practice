
public class Queen {
	private int column;
	private int row;
	private Queen neighbor;
	
	public Queen(int c, Queen n)
	{
		column = c;
		row = 1;
		neighbor = n;
	}
	
	public boolean canAttack(int testRow,int testColumn){
		//returns true if it can attack the given position or if its neighbor can attack the position
		{
			if(row == testRow)
				return true;
			if(((testRow - row) == (testColumn - column)||(testRow - row) == (testColumn - column)))
				return true;
			if(neighbor != null && neighbor.canAttack(testRow, testColumn))
				return true;
			
			return false;

		}
	}
}
