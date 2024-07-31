public class FinancialForecast {
    public double forecastValueRecursive(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        } else {
            return forecastValueRecursive(initialValue * (1 + growthRate), growthRate, periods - 1);
        }
    }

    public double forecastValueIterative(double initialValue, double growthRate, int periods) {
        double futureValue = initialValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        FinancialForecast forecast = new FinancialForecast();

        double initialValue = 1000;
        double growthRate = 0.05;
        int periods = 5;

        // Recursive calculation
        double recursiveResult = forecast.forecastValueRecursive(initialValue, growthRate, periods);
        System.out.println("Recursive forecast: " + recursiveResult);

        // Iterative calculation
        double iterativeResult = forecast.forecastValueIterative(initialValue, growthRate, periods);
        System.out.println("Iterative forecast: " + iterativeResult);
    }
}
