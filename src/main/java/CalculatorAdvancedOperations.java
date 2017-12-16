
public class CalculatorAdvancedOperations implements CalculatorAdvancedOperationsInterface {

	@Override
	public double log(double x) {
		return Math.log10(x);
	}

	@Override
	public double square(double x) {
		return Math.pow(x, 2);
	}

	@Override
	public double sqrt(double x) {
		return Math.sqrt(x);
	}

	@Override
	public double absolute(double x) {
		return Math.abs(x);
	}

	@Override
	public double cube(double x) {
		return Math.pow(x, 3);
	}

	@Override
	public double inverse(double x) {
		return 1d/x;
	}

	@Override
	public double power(double x, double y) {
		return Math.pow(x, y);
	}
}
