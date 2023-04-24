
public class Number {
	
	  private int num = 0;
	  private int den = 1;
	
	  public Number(int num, int den) {
		
	    if(den == 0) {
	      System.out.println("den cannot be 0, changing den to 1 instead");
	      den = 1;
	    }
		
	    this.num = num;
	    this.den = den;
	  }
	
	  public int getNumberator() {return num;}
	
	  public int getDenominator() {return den;}
	
	  public Number(int num) {
		
	    this.num = num;
	  }
	
	  public String getNumber() {
		
	    if(num == den) {
	      return 1 + "";
	    }
		
	    if(den == 1) {
	      return num + "";
			
	    } else {
			
	      if(num < 0 && den < 0) {
				
	        return Math.abs(num) + "/" + Math.abs(den);
	      }
			
	      if (den < 0) {
				
	        return (-1 * num) + "/" + den;
	      }
	    }
		
	    return num + "/" + den;
	  }
	
	  public Number add(Number val) {
		
	    if(den == val.getDenominator()) {
	      return new Number(num + val.getNumberator(), den);
	    }
		
	    int temp = den;
		
	    num *= val.getDenominator();
	    den *= val.getDenominator();
		
	    int valNum = val.getNumberator() * temp;
		
	    return new Number(num + valNum, den);
	  }
	
	  public Number multiply(Number val) {
		
	    return new Number(num * val.getNumberator(), den * val.getDenominator());
	  }
	
	
	  public static void main(String[] args) {
		
	    Number num1 = new Number(5);
	    Number num2 = new Number(1, 3);
	    Number num3 = new Number(3, 1);
		
	    System.out.println(num2.multiply(num3).getNumber());
	    System.out.println(num2.getNumber());
		    System.out.println(num2.multiply(num2).getNumber());
	  }

}
