import java.util.Scanner;

public class RewardsConverter {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Credit Card Rewards Converter!");

        while (true) {
            System.out.print("Please enter a cash value to convert to miles (or 'exit' to quit): ");
            String input_value = scanner.nextLine();

            if (input_value.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                double cashValue = Double.parseDouble(input_value);
                System.out.println("Converting $" + cashValue + " to miles");
                double milesValue = RewardValue.cashToMiles(cashValue);
                System.out.println("$" + cashValue + " is worth " + milesValue + " miles");
            } catch (NumberFormatException exception) {
                System.out.println("Could not parse input value as a double. Please try again.");
            }
        }

        System.out.println("Thank you for using the Credit Card Rewards Converter!");
    }
}

class RewardValue {
    private static final double CASH_TO_MILES_RATE = 0.0035;

    public static double cashToMiles(double cashValue) {
        return cashValue / CASH_TO_MILES_RATE;
    }

    public static double milesToCash(double milesValue) {
        return milesValue * CASH_TO_MILES_RATE;
    }
}
