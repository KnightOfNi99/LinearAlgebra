

public class Adjugate {

	  public static double[][] calcAdjugate(double[][] matrix) {
		
	    for(int i = 0; i < matrix.length; i++) {
	      
	      if(matrix[i].length != matrix.length) {
		         
	        return matrix;
		      } 
	    }
		
	    double[][] rtrn = new double[matrix.length][matrix.length];
		
	    for(int i = 0; i < rtrn.length; i++) {
			
	      for(int j = 0; j < rtrn[i].length; j++) {
				
	        int rowIndex = 0;
	        int colIndex = 0;
	        double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];
				
	          for(int k = 0; k < matrix.length; k++) {
					
	            for(int l = 0; l < matrix[k].length; l++) {
						
	              if(i == k || j == l) {
	                continue;
	              }
						
	              newMatrix[colIndex][rowIndex] = matrix[k][l];
						
	              if(rowIndex == newMatrix.length - 1) {
	                rowIndex = 0;
	                colIndex++;
	              } else {
	                rowIndex++;
	              }
						
	            }
					
	          }
				
	          rtrn[i][j] = Determinant.calcDeterminant(newMatrix);
	      }
	    }
		
	    return rtrn;
	  }
	
	  public static void main(String[] args) {
		
	    double[][] nums = {
	        {1, 0, 5},
	        {2, 1, 6},
	        {3, 4, 0}
	    };
		
	    Util.printMatrix(calcAdjugate(nums));
		
	  }
	
}
