

public class Matrix {
	
	  private boolean valid = true;
	
	  private int rows = 0;
	  private int cols = 0;
	
	  private double[][] matrix = null;
	
	  public Matrix(double[][] matrix) {
		
		    for(int i = 0; i < matrix.length; i++) {
		      
		      if(matrix[i].length != matrix[0].length) {
		        
		        System.out.println("Invalid matrix --- Different row sizes!");
		        valid = false;
		        break;
		      }
		    }
		
		    if(valid) {
		    
		      this.rows = matrix.length;
		      this.cols = matrix[0].length;
		      this.matrix = matrix;
		    }
		  
	  }
	  
	  //returns the matrix as a 2D array of doubles
  public double[][] getMatrix() {return matrix;}
	  
	  //returns the number of rows
	  public int getRowCount() {return rows;}
	  
	  //returns the number of columns
	  public int getColumnCount() {return cols;}
	  
	  //returns whether or not the matrix is valid
	  public boolean isValid() {return valid;}
	  
	  //returns a row at a specific index
	  public double[] getRow(int rowIndex) {
	    
	    if(!valid) {
      System.out.println("invalid matrix");
      return null;
    }
	    
	    if(rowIndex < 0 || rowIndex >= rows) {
      System.out.println("invalid row index");
      return null;
    }
	    
	    double[] rtrn = new double[cols];
	    for(int i = 0; i < cols; i++) {
	      rtrn[i] = matrix[rowIndex][i];
	    }
	    
	    return rtrn;
	    
	  }
	  
	  //returns a column at a specific index
	  public double[] getColumn(int colIndex) {
	    
	    if(!valid) {
      System.out.println("invalid matrix");
      return null;
    }
    
    if(colIndex < 0 || colIndex >= cols) {
      System.out.println("invalid column index");
      return null;
    }
    
    double[] rtrn = new double[rows];
    for(int i = 0; i < rows; i++) {
      rtrn[i] = matrix[i][colIndex];
    }
    
    return rtrn;
	  }
	
	  //multiply a row by a constant
	  public void multipleRowByConstant(int rowIndex, double constant) {
	    
	    if(!valid) {
	      System.out.println("invalid matrix");
	      return;
	    }
	    
	    if(constant == 0) {
	      System.out.println("cannot multiple row by constant 0");
	      return;
	    }
		
	    if(rowIndex < 0 || rowIndex >= rows) {
	      System.out.println("invalid row index");
	      return;
	    }
		
	    for(int i = 0; i < matrix[rowIndex].length; i++) {
	      matrix[rowIndex][i] *= constant;
	    }
		
	  }
	  
	  //swap two rows
	  public void swapRows(int row0Index, int row1Index) {
	    
	    if(!valid) {
      System.out.println("invalid matrix");
      return;
    }
		
	    if(row0Index < 0 || row0Index >= rows || row1Index < 0 || row1Index >= rows || row0Index == row1Index) {
	      System.out.println("invalid row index/indices");
	      return;
	    }
		
	    double[] temp = matrix[row0Index].clone();
		
	    for(int i = 0; i < matrix[row0Index].length; i++) {
	      matrix[row0Index][i] = matrix[row1Index][i];
	      matrix[row1Index][i] = temp[i];
	    }
		
	  }
	  
	  //add one row to another
	  //the row matrix[row0Index] is added to the row matrix[row1Index]
	  public void addRows(int row0Index, int row1Index) {
	    
	    if(!valid) {
      System.out.println("invalid matrix");
      return;
    }
	    
	    if(row0Index < 0 || row0Index >= rows || row1Index < 0 || row1Index >= rows || row0Index == row1Index) {
      System.out.println("invalid row index/indices");
      return;
    }
	    
	    for(int i = 0; i < matrix[row1Index].length; i++) {
	      matrix[row1Index][i] += matrix[row0Index][i];
	    }
	    
	  }
	  
	  //add one row to another with a constant which the values of matrix[row0Index] are multiplied by
  //the row matrix[row0Index] is added to the row matrix[row1Index]
  public void addRows(int row0Index, double constant, int row1Index) {
    
    if(!valid) {
      System.out.println("invalid matrix");
      return;
    }
    
    if(row0Index < 0 || row0Index >= rows || row1Index < 0 || row1Index >= rows || row0Index == row1Index) {
      System.out.println("invalid row index/indices");
      return;
    }
    
    for(int i = 0; i < matrix[row1Index].length; i++) {
      matrix[row1Index][i] += (matrix[row0Index][i] * constant);
    }
    
  }
	  
	  //multiple two matrices together
	  public static Matrix multiplyMatrices(Matrix m0, Matrix m1) {
	    
	    if(!m0.isValid() || !m1.isValid()) {
	      System.out.println("invalid matrix/matrices");
	      return null;
	    }
	    
	    if(m0.getColumnCount() != m1.getRowCount()) {
	      System.out.println("the number of columns in m0 must equal the number of rows in m1 inorder to multiply the matrices");
	      return null;
	    }
	    
	    double[][] m = new double[m0.getRowCount()][m1.getColumnCount()];
	    
	    for(int i = 0; i < m0.getRowCount(); i++) {
	      
	      for(int j = 0; j < m1.getColumnCount(); j++) {
	        
	        m[i][j] = dotProduct(m0.getRow(i), m1.getColumn(j));
	        
	      }
	    }
	    
	    return new Matrix(m);
	    
	  }
	  
	  private static double dotProduct(double[] v0, double[] v1) {
	    
	    if(v0.length != v1.length) {
	      System.out.println("dot product can not be determined, because the length of v0 does not equal the length of v1");
	      return 0;
	    }
	    
	    double sum = 0;
	    
	    for(int i = 0; i < v0.length; i++) {
	      sum += (v0[i] * v1[i]);
	    }
	    
	    return sum;
	  }
	
	  public static void main(String[] args) {
		
	    double[][] matrix0 = {
	        {0, 3, 5},
	        {5, 5, 2}
	    };
	    
	    double[][] matrix1 = {
        {3, 4},
        {3, -2},
        {4, -2}
    };
	    
	    
	    Matrix m0 = new Matrix(matrix0);
	    Matrix m1 = new Matrix(matrix1);
	    
	    Util.printMatrix(Matrix.multiplyMatrices(m0, m1).getMatrix());
	    
    System.out.println();
    
    
	  }

}
