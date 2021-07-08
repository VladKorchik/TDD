package ru.netology;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class CreditCalcTest<L> {
    //  Приведённые ниже формулы абстрактны. У меня получается,
    //  что итоговая сумма выплат не зависит от срока кредита, а это неверно.
    //  например, по-хорошему ежемесячная выпалата должна считаться так:
    //  К*(П/(1+П)-М-1), где К – сумма кредита, П – процентная ставка, М – количество месяцев.
    //  Но раз задание творческое, то я немного упростил задачу и не стал забивать тесты большим количеством формул.

    Random random = new Random();
    final static int MIN_CREDIT = 5_000;
    final static int MAX_CREDIT = 1_500_000;
    final static double MIN_CREDIT_PERCENT = 7.2;
    final static double MAX_CREDIT_PERCENT = 17.5;
    final static int MAX_TIME_OF_CREDIT_IN_MONTH = 120;

    @Test
    public void countMonthPaymentTest() {
        CreditCalc creditCalc = new CreditCalc();

        int diffCredit = MAX_CREDIT - MIN_CREDIT;
        int randomCreditSum = random.nextInt(diffCredit + 1);
        randomCreditSum += MIN_CREDIT;

        double ramdomCreditPercent = ((Math.random() * (MAX_CREDIT_PERCENT - MIN_CREDIT_PERCENT)) + MIN_CREDIT_PERCENT);
        int randomTimeOfCredit = random.nextInt(MAX_TIME_OF_CREDIT_IN_MONTH) + 1;

        double methodsResult = creditCalc.countMonthPayment (randomCreditSum, ramdomCreditPercent, randomTimeOfCredit );
        double waitingResult = randomCreditSum * (ramdomCreditPercent / 100) / randomTimeOfCredit;
        Assert.assertTrue("Неверно рассчитана сумма ежемесячного платежа для процента "
                + ramdomCreditPercent + ", на сумму " + randomCreditSum + ", на срок "
                + randomTimeOfCredit + " месяцев." , methodsResult == waitingResult);
    }

    @Test
    public void countTotalSumTest () {
        CreditCalc creditCalc = new CreditCalc();

        int diffCredit = MAX_CREDIT - MIN_CREDIT;
        int randomCreditSum = random.nextInt(diffCredit + 1);
        randomCreditSum += MAX_CREDIT;
        double ramdomCreditPercent = ((Math.random() * (MAX_CREDIT_PERCENT - MIN_CREDIT_PERCENT)) + MIN_CREDIT_PERCENT);

        double methodsResult = creditCalc.countTotalSum(randomCreditSum, ramdomCreditPercent);
        double waitingResult = randomCreditSum * (ramdomCreditPercent / 100 + 1);
        Assert.assertTrue("Неверно рассчитан результат для суммы " + randomCreditSum
                + " под процент " + ramdomCreditPercent , waitingResult == methodsResult);
    }

    @Test
    public void countTotalOverpaymentsTest () {
        CreditCalc creditCalc = new CreditCalc();

        int diffCredit = MAX_CREDIT - MIN_CREDIT;
        int randomCreditSum = random.nextInt(diffCredit + 1);
        randomCreditSum += MAX_CREDIT;
        double ramdomCreditPercent = ((Math.random() * (MAX_CREDIT_PERCENT - MIN_CREDIT_PERCENT)) + MIN_CREDIT_PERCENT);

        double methodsResult = creditCalc.countTotalOverpayments(randomCreditSum, ramdomCreditPercent);
        double waitingResult = (randomCreditSum * (ramdomCreditPercent / 100 + 1)) - randomCreditSum;
        Assert.assertTrue("Неверно рассчитан результат для суммы " + randomCreditSum
                + " под процент " + ramdomCreditPercent , waitingResult == methodsResult);
    }
}
