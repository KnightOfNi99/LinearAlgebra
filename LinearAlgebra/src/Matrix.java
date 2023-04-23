

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
	
	public void multipleRowByConstant(int rowIndex, double constant) {
		
		if(rowIndex < 0 || rowIndex >= rows) {
			System.out.println("invalid row index");
			return;
		}
		
		for(int i = 0; i < matrix[rowIndex].length; i++) {
			matrix[rowIndex][i] *= constant;
		}
		
	}
	
	public void swapRows(int row0Index, int row1Index) {
		
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
	
	public double[][] getMatrix() {return matrix;}
	
	public static void main(String[] args) {
		
		double[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		Matrix m = new Matrix(matrix);
		Util.printMatrix(m.getMatrix());
		
		m.swapRows(0, 2);
		Util.printMatrix(m.getMatrix());
		
	}

}
