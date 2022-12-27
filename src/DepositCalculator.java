import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateResult();
    }

    void calculateResult() {
        int period;
        int action;
        int depositAmount;
        double savingsResult;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");

        depositAmount = userInput.nextInt();
        System.out.println("Введите срок вклада в годах:");

        period = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = userInput.nextInt();

        savingsResult = 0;
        if (action == 1) {
            savingsResult = calculateSimplePercent(depositAmount, 0.06, period);
        } else if (action == 2) {
            savingsResult = calculateComplexPercent(depositAmount, 0.06, period);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + period + " лет превратятся в " + savingsResult);
    }

    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double pay;
        pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return round(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale;
        scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
