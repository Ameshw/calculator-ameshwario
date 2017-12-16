
public interface CalculatorAdvancedOperationsInterface {

	/**
	 * function to compute log10 of x
	 * @param x input
	 * @return output
	 */
	public double log(double x);
	
	/**
	 * function to compute square of x
	 * @param x input
	 * @return output
	 */
	public double square(double x);
	
	/**
	 * function to compute square-root of x
	 * @param x input
	 * @return output
	 */
	public double sqrt(double x);
	
	/**
	 * function to compute absolute of x
	 * @param x input
	 * @return output
	 */
	public double absolute(double x);
	
	/**
	 * function to compute cube x^3 of x
	 * @param x input
	 * @return output
	 */
	public double cube(double x);
	
	
	/**
	 * function to compute inverse of x
	 * @param x input
	 * @return output
	 */
	public double inverse(double x);
	
	/**
	 * function to compute y power of x (x^y)
	 * @param x input
	 * @param y input power
	 * @return output
	 */
	public double power(double x, double y);
}