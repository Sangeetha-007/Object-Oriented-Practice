
public class DriverProgram {
	public static void main(String[] args){
		
		Queen lastQueen = null;
		for(int i = 1; i <= 10; i++)  //originally it said i<=8
		{
			lastQueen = new Queen(i,lastQueen);
		}
		//System.out.print("No solution");
		lastQueen.print();
	}
}
