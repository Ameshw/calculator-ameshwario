
public class CalculatorBasicOperations implements CalculatorBasicOperationsInterface {

	@Override
	public double add(double x, double y) {
		return x + y;
	}

	@Override
	public double substract(double x, double y) {
		return x - y;
	}

	@Override
	public double multiply(double x, double y) {
		return x * y;
	}

	@Override
	public double divide(double x, double y) {
		return x / y;
	}

}
