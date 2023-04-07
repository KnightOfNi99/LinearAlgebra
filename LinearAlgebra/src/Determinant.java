/*
 * Author: Austin Barner
 * used this website to figure out how to calculate a determinant: https://www.mathsisfun.com/algebra/matrix-determinant.html
 * used this website to check my answers: https://www.wolframalpha.com/input?i2d=true
 * use the 2D array 'nums' in the main method to define a nxn matrix
 * 
 */


public class Determinant {
  
  public static double calcDeterminant(double[][] matrix) {
    
    //return Double.MIN_VALUE if the matrix is not nxn
    for(int i = 0; i < matrix.length; i++) {
      
      if(matrix[i].length != matrix.length) {
        
        return Double.MIN_VALUE;
      }
      
    }
    
    if(matrix.length == 0) {
      
      return 0.0;
    }
    
    if(matrix.length == 1) {
      
      return matrix[0][0];
    }
    
    //calculate the 2x2 matrix
    if(matrix.length == 2) {
      
      return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }
    
    //recursively process matrices when n > 1
    double sum = 0.0;
    for(int i = 0; i < matrix.length; i++) {
      
      double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];
      int rowIndex = 0;
      int colIndex = 0;
      
      for(int j = 1; j < matrix.length; j++) {
        
        for(int k = 0; k < matrix.length; k++) {
          
          if(k == i) {continue;}
          
          newMatrix[rowIndex][colIndex] = matrix[j][k];
          
          colIndex++;
        }
        rowIndex++;
        colIndex = 0;
      }
      
      if(i % 2 == 1) {
        
        sum -= matrix[0][i] * calcDeterminant(newMatrix);
      } else {
        
        sum += matrix[0][i] * calcDeterminant(newMatrix);
      }
      
    }
    
    return sum;
  }
  
  public static void main(String[] args) {
    
    double[][] nums = {
        {1, 7, 3, 4},
        {4, 3, 5, 1},
        {2, 4, 6, 8},
        {8, 6, 4, 2}
    };
    
    System.out.println("Determinant: " + calcDeterminant(nums));
    
  }

}
