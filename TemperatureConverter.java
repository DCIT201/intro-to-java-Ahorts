// We import the scanner class to support user input

import java.util.Scanner;

// These define constraints
private static final double MIN_FAHRENHEIT = -459.67;
private static final double MAX_FAHRENHEIT = 2_000_000.0;
private static final double MIN_CELSIUS = -273.15;
private static final double MAX_CELSIUS = 2_000_000.0;


public static void main() {
    TempConvert convert = new TempConvert();
    Scanner input = new Scanner(System.in);


    System.out.println("This program converts temperatures between Celsius and Fahrenheit ");
    System.out.print("Enter the temperature: ");

// This checks the input to make sure it is a number
    double temp;
    try {
        temp = input.nextDouble();
    } catch (Exception e) {
        System.out.println("Invalid temperature input");
        input.close();
        return;
    }


    convert.setTemperature(temp);

    System.out.println("The provided temperature should be converted to ...");
    System.out.println("1. Celsius");
    System.out.println("2. Fahrenheit");

// checks for string input
    byte selection;
    try {
        selection = input.nextByte();
    } catch (Exception e) {
        System.out.println("Invalid selection");
        input.close();
        return;
    }


// Determines the method to call based on user input. It checks for validity.
    switch (selection) {
        case 1:
            if (isValidFahrenheit(temp)) {
                System.out.println(convert.getTemperature() + " Fahrenheit is " + convert.fahrenheitToCelsius() +
                        " Celsius");
            } else {
                System.out.println("Invalid Fahrenheit temperature");
            }
            break;

        case 2:
            if (isValidCelsius(temp)) {
                System.out.println(convert.getTemperature() + " Celsius is " + convert.celsiusToFahrenheit() +
                        " Fahrenheit");
            } else {
                System.out.println("Invalid Celsius temperature");
            }
            break;

        default:
            System.out.println("Invalid selection");
    input.close();
    }
}

// This class holds the temperature value and manipulates it
private static class TempConvert {
    private double temperature;

    public double celsiusToFahrenheit() {
        return (temperature * 9.0 / 5.0) + 32;
    }

    public double fahrenheitToCelsius() {
        return (temperature - 32) * 5.0 / 9.0;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}

// Methods to check if the temperature is within range
private static boolean isValidFahrenheit(double temp) {
    return temp >= MIN_FAHRENHEIT && temp <= MAX_FAHRENHEIT;
}

private static boolean isValidCelsius(double temp) {
    return temp >= MIN_CELSIUS && temp <= MAX_CELSIUS;
}

