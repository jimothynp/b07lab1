
import java.util.Arrays;
import java.lang.Double;

public class Polynomial {
	private double[] coefficients;
	
	public Polynomial() {
		coefficients = new double[]{0};
	}
	
	public Polynomial(double[] coeffs) {
		coefficients = Arrays.copyOf(coeffs, coeffs.length);
	}
	
	public Polynomial add(Polynomial addTo) {
		int lenP1 = this.coefficients.length;
		int lenP2 = addTo.coefficients.length;
		int minLen, maxLen;
		Polynomial P = new Polynomial();
		if (lenP1 < lenP2) {
			maxLen = lenP2;
		}
		else {
			maxLen = lenP1;
		}
		
		P.coefficients = Arrays.copyOf(this.coefficients, maxLen);
		
		for (int i=0;i<addTo.coefficients.length;i++) {
			P.coefficients[i] += addTo.coefficients[i];
		}
		return P;
	}
	
	public double evaluate(double x) {
		double sum = 0;
		for (int i=0;i<this.coefficients.length;i++) {
			sum += this.coefficients[i] * Math.pow(x, i);
		}
		return sum;
	}
	
	public boolean hasRoot(double x) {
		return Double.compare(evaluate(x), 0) == 0;
	}
}
