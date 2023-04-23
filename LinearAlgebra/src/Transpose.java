

public class Transpose {

	public static double[][] calcTranspose(double[][] matrix) {
		
		for(int i = 0; i < matrix.length; i++) {
		      
			if(matrix[i].length != matrix.length) {
		         
				return matrix;
		    } 
		}
		
		double[][] rtrn = new double[matrix.length][matrix.length];
		
		for(int i = 0; i < matrix.length; i++) {
			
			for(int j = 0; j < matrix.length; j++) {
				
				rtrn[i][j] = matrix[j][i];
			}
		}
		
		return rtrn;
	}
	
	public static void main(String[] args) {
		
		double[][] nums = {
		        {1, 2, 3},
		        {0, 1, 4},
		        {5, 6, 0}
		};
		
		Util.printMatrix(calcTranspose(nums));
		
	}
}



