import Account.Account;
import Account.DebitAccount;
import Account.DepositAccount;
import Client.*;

import java.util.*;


public class Main {

    public static String format(double value) {
        return String.format("%.2f", value);
    }

    public static void main(String[] args) {
        HashMap<Integer, Double> depositPercent = new HashMap<Integer, Double>() {{
            put(50000, 3.0);
            put(100000, 3.5);
            put(100001, 4.0);
        }};
        try {
            HashMap<String, Stack<String>> operationsId = new HashMap<>();
            Calendar date = Calendar.getInstance();
            Bank bank = new Bank(1.5, depositPercent, 5,
                    15000, 10000);
            ClientBuilder clientBuilder = new ClientBuilder();
            Client anton = clientBuilder.setName("anton").setSurname("antonov").build();
            Client ivan = clientBuilder.setName("ivan").setSurname("ivanov").build();
            Client sasha = clientBuilder.setName("Aleksandr").setSurname("Aleksandrov").build();
            bank.addClient(anton);
            bank.addClient(ivan);
            bank.addClient(sasha);


            Account antonDebit = bank.createDebitAccount(0);
            operationsId.put(antonDebit.id, new Stack<>());
            bank.openNewAccount(anton, antonDebit);


            Account ivanDeposit = bank.createDepositAccount(150000, 0);
            operationsId.put(ivanDeposit.id, new Stack<>());
            bank.openNewAccount(ivan, ivanDeposit);

            Account sashaCredit = bank.createCreditAccount(0);
            operationsId.put(sasha.id, new Stack<>());
            bank.openNewAccount(sasha, sashaCredit);

            operationsId.get(antonDebit.id).add(bank.topUpBalance(anton.id, antonDebit.id, 20000));
//            operationsId.get(ivanDeposit.id).add(bank.transferTo(ivanDeposit, antonDebit, 16000));
            operationsId.get(sasha.id).add(bank.getCash(sasha.id, sashaCredit.id, 9000));

            date.add(Calendar.DAY_OF_WEEK, 11);
            bank.goTo(date);
            System.out.println("antonDebit account\n" + format(antonDebit.balance));
            System.out.println("ivanDeposit account\n" + format(ivanDeposit.balance));
            System.out.println("sashaCredit account\n" + format(sashaCredit.balance));
//            System.out.println("ivanDeposit account\n" + ivanDeposit.period);


//            newDate.add(Calendar.DAY_OF_WEEK, 3);
//            bank.goTo(newDate);
//            bank.getCash(anton.id, antonDebit.id, 15000);
//            System.out.println(newDate.getTime());
//            System.out.println(antonDebit.balance);

//            newDate.add(Calendar.DAY_OF_WEEK, -3);
//            System.out.println(newDate.getTime());
//            bank.goTo(newDate);
//            System.out.println(String.format("%.2f",antonDebit.balance));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
