package ru.netology;

public class CreditCalc {

    public double countMonthPayment (int randomCreditSum, double ramdomCreditPercent, int randomTimeOfCredit ) {
        double result = randomCreditSum * (ramdomCreditPercent / 100) / randomTimeOfCredit;
        return result;
    }


    public double countTotalSum (int randomCreditSum, double ramdomCreditPercent) {
        double result = randomCreditSum * (ramdomCreditPercent / 100 + 1);
        return result;
    }

    public double countTotalOverpayments (int randomCreditSum,double ramdomCreditPercent) {
        double result = (randomCreditSum * (ramdomCreditPercent / 100 + 1)) - randomCreditSum;
        return result;
    }


}
