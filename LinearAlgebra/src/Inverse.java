

public class Inverse {

	
	public static double[][] calcInverse(double[][] matrix) {
		
		for(int i = 0; i < matrix.length; i++) {
		      
			if(matrix[i].length != matrix.length) {
		         
				System.out.println("Invalid matrix: must me nxn");
				return null;
		    } 
		}		
		
		double det = Determinant.calcDeterminant(matrix);
		if(det == 0) {
			System.out.println("Cannot calculate inverse: determinant = 0");
			return null;
		}
		det = 1/det;
		
		double[][] adjugate = Adjugate.calcAdjugate(matrix);
		
		for(int i = 0; i < adjugate.length; i++) {
			
			for(int j = 0; j < adjugate[i].length; j++) {
				
				int indexCount = (i * adjugate.length) + j;
				if(indexCount % 2 == 1) {
					adjugate[i][j] *= -1;
				}
				adjugate[i][j] *= det;
			}
		}
		
		adjugate = Transpose.calcTranspose(adjugate);
		
		return adjugate;
	}
	
	public static void main(String[] args) {
		
		double[][] nums = {
				{1, 2},
				{0, 1}
		};
		
		Util.printMatrix(calcInverse(nums));
	}
	
}
