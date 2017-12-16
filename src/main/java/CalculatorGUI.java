import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.awt.event.ActionEvent;

public class CalculatorGUI {

	// Decimal Format
	private final DecimalFormat formatter = new DecimalFormat("0.00");
	
	// main window
	private JFrame frame;
	// buttons panel
	private JPanel panel;
	// input field
	private JTextField textField;
	// background input value
	private String input;
	// captured input 1
	private Double input1;
	// captured input 2
	private Double input2;
	// captured operation
	private BiFunction<Double, Double, Double> operation;

	// Basic Calculator Operations
	CalculatorBasicOperationsInterface basic;
	// Advanced Calculator Operations
	CalculatorAdvancedOperationsInterface advanced;
	

	/**
	 * Create the application.
	 */
	public CalculatorGUI() {
		input = "";
		basic = new CalculatorBasicOperations();
		advanced = new CalculatorAdvancedOperations();
		initialize();	
	}
	
	/**
	 * Show Dialog
	 */
	public void show() {
		frame.setVisible(true);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Create frame
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add input / output text field
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		textField.setPreferredSize(new Dimension(300, 50));
		// text right aligned
		textField.setHorizontalAlignment(JTextField.RIGHT);
		
		// add panel for buttons
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		addButtons();
	}

	/**
	 * Add buttons to the calculator
	 */
	private void addButtons() {
		addOneInputActionButton("x^2", x -> advanced.square(x));
		addOneInputActionButton("sqrt", x -> advanced.sqrt(x));
		addOneInputActionButton("|x|", x -> advanced.absolute(x));
		addInputButton("<-");
		addInputButton("CE");
		addOneInputActionButton("x^3", x -> advanced.cube(x));
		addTwoInputActionButton("/", (x, y) -> basic.divide(x, y));
		addInputButton("7");
		addInputButton("8");
		addInputButton("9");
		addTwoInputActionButton("x^y", (x, y) -> advanced.power(x, y));
		addTwoInputActionButton("*", (x, y) -> basic.multiply(x, y));
		addInputButton("4");
		addInputButton("5");
		addInputButton("6");
		addOneInputActionButton("1/x", x -> advanced.inverse(x));
		addTwoInputActionButton("-", (x, y) -> basic.substract(x, y));
		addInputButton("1");
		addInputButton("2");
		addInputButton("3");
		addOneInputActionButton("log", x -> advanced.log(x));
		addTwoInputActionButton("+", (x, y) -> basic.add(x, y));
		addInputButton("0");
		addInputButton(".");
		addActionButton("=");
		
		update();
	}
	
	/**
	 * Update textField based on input value
	 */
	private void update() {
		this.textField.setText(format(input));
	}
	
	/**
	 * Format string for example 0. is 0.00, etc.
	 * @param value non-formatted value
	 * @return formatted String
	 */
	private String format(String value) {
		value = value + ((value.isEmpty() || value.endsWith(".") ? "0" : ""));
		return formatter.format(parse(value)); 	
	}
	
	/**
	 * parse double value
	 * @param value String
	 * @return Double
	 */
	private Double parse(String value) {
		return Double.parseDouble(value);
	}
	
	/**
	 * reset state
	 */
	private void reset() {
		input = "";
		input1 = null;
		input2 = null;
		operation = null;
	}
	
	/**
	 * compute and update output based on input1, input2 and operation
	 */
	private void operate() {
		if (null == operation) return;
		input2 = parse(textField.getText());
		Double output = operation.apply(input1, input2);
		input = formatter.format(output);
		update();
		operation = null;
	}
	
	/**
	 * Create JButton with fixed width and height
	 * @param label button label
	 * @return JButton
	 */
	private JButton createButton(final String label) {
		JButton button = new JButton(label);
		button.setPreferredSize(new Dimension(50, 50));
		return button;
	}
	
	/**
	 * Add input button - to support number input, backspace or reset (CE)
	 * @param value input value
	 */
	private void addInputButton(final String value) {
		JButton button = createButton(value);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("<-".equals(value)) {
					input = (input.length() > 0) ? input.substring(0, input.length()-1) : input;
				}
				else if ("CE".equals(value)) {
					
					reset();
				}
				else if (input.contains(".") && ".".equals(value)) {
					// do nothing
				}
				else {
					input += value;
				}
				update();
			}
		});
		panel.add(button);
	}
	
	/**
	 * Add action button - to support = function
	 * @param label button label
	 * @param function execution
	 */
	private void addActionButton(final String label) {
		JButton button = createButton(label);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				operate();
				input = "";
			}
			
		});
		panel.add(button);
	}
	
	/**
	 * Add input button requiring one input for action
	 * @param label button label
	 * @param function execution
	 */
	private void addOneInputActionButton(final String label, final Function<Double, Double> function) {
		JButton button = createButton(label);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				operate();
				Double output = function.apply(parse(textField.getText()));
				input = formatter.format(output);
				update();
				input = "";
			}
	
		});
		panel.add(button);
	}
	
	/**
	 * Add input button requiring two inputs for action
	 * @param label button label
	 * @param function execution
	 */
	private void addTwoInputActionButton(final String label, final BiFunction<Double, Double, Double> function) {
		JButton button = createButton(label);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				operate();
				input1 = parse(textField.getText());
				operation = function; 
				input = "";
			}
	
		});
		panel.add(button);
	}
	
}
