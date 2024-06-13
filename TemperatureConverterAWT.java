import java.awt.*;
import java.awt.event.*;

public class TemperatureConverterAWT extends Frame implements ActionListener {
    private TextField inputField;
    private Choice unitChoice;
    private Label resultLabelCelsius, resultLabelFahrenheit, resultLabelKelvin;

    public TemperatureConverterAWT() {
        setLayout(new FlowLayout());

        Label inputLabel = new Label("Enter temperature value:");
        add(inputLabel);

        inputField = new TextField(10);
        add(inputField);

        Label unitLabel = new Label("Select unit:");
        add(unitLabel);

        unitChoice = new Choice();
        unitChoice.add("Celsius");
        unitChoice.add("Fahrenheit");
        unitChoice.add("Kelvin");
        add(unitChoice);

        Button convertButton = new Button("Convert");
        convertButton.addActionListener(this);
        add(convertButton);

        resultLabelCelsius = new Label("Celsius: ");
        add(resultLabelCelsius);

        resultLabelFahrenheit = new Label("Fahrenheit: ");
        add(resultLabelFahrenheit);

        resultLabelKelvin = new Label("Kelvin: ");
        add(resultLabelKelvin);

        setTitle("Temperature Converter");
        setSize(300, 200);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    public void actionPerformed(ActionEvent ae) {
        double value = Double.parseDouble(inputField.getText());
        String unit = unitChoice.getSelectedItem();

        double celsius, fahrenheit, kelvin;

        switch (unit) {
            case "Celsius":
                celsius = value;
                fahrenheit = celsiusToFahrenheit(celsius);
                kelvin = celsiusToKelvin(celsius);
                break;
            case "Fahrenheit":
                fahrenheit = value;
                celsius = fahrenheitToCelsius(fahrenheit);
                kelvin = fahrenheitToKelvin(fahrenheit);
                break;
            case "Kelvin":
                kelvin = value;
                celsius = kelvinToCelsius(kelvin);
                fahrenheit = kelvinToFahrenheit(kelvin);
                break;
            default:
                resultLabelCelsius.setText("Invalid unit");
                resultLabelFahrenheit.setText("");
                resultLabelKelvin.setText("");
                return;
        }

        resultLabelCelsius.setText(String.format("Celsius: %.2f", celsius));
        resultLabelFahrenheit.setText(String.format("Fahrenheit: %.2f", fahrenheit));
        resultLabelKelvin.setText(String.format("Kelvin: %.2f", kelvin));
    }

    public static void main(String[] args) {
        new TemperatureConverterAWT();
    }
}
