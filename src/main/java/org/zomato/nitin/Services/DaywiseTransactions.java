package org.zomato.nitin.Services;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaywiseTransactions {


    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2025-01-01", 100),
                new Transaction("2025-01-01", 200),
                new Transaction("2025-01-02", 300),
                new Transaction("2025-01-02", 400),
                new Transaction("2025-01-03", 500)
        );

        Map<String, Integer> dateWiseSum = transactions.stream()
                .collect(Collectors.groupingBy(
                                Transaction::getDate,        //fetching the particular date
                                Collectors.summingInt(Transaction::getAmount)    //fetching the particular amount
                        )
                );
        dateWiseSum.forEach((date, sum) ->
                System.out.println("Date: " + date + ", Total: " + sum));
    }

}

class Transaction{

    private String date;
    private int amount;
    public Transaction(String date, int i) {
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}
