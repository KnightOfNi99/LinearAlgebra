

public class Util {

	
	public static void printMatrix(double[][] matrix) {
		
		if(matrix == null) {return;}
		
		for(int i = 0; i < matrix.length; i++) {
			
			for(int j = 0; j < matrix[i].length; j++) {
				
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
