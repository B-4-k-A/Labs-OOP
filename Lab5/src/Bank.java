import Account.*;
import Client.Client;
import Operation.*;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    public double debitPercent;
    public HashMap<Integer, Double> depositPercents;
    public double creditPercent;

    public double unfinishedClientLimit;
    public double creditLimit;
    public Calendar lastUpdate = Calendar.getInstance();
    public List<Client> clientsList = new ArrayList<>();
    public HashMap<String, List<Account>> accountsById = new HashMap<>();
    public List<Operation> operationsList = new ArrayList<>();

    public Bank(double debitPercent, HashMap<Integer, Double> depositPercents,
                double creditPercent, double unfinishedClientLimit, double creditLimit) {
        this.debitPercent = debitPercent;
        if (depositPercents == null) {
            throw new NullPointerException("Deposit percents HashMap is null");
        }
        this.depositPercents = depositPercents;
        this.creditPercent = creditPercent;
        this.unfinishedClientLimit = unfinishedClientLimit;
        this.creditLimit = creditLimit;
    }

    public void addClient(Client client) {
        clientsList.add(client);
        accountsById.put(client.id, new ArrayList<>());
    }

    public boolean hasClient(String clientId) {
        Optional<Client> option = clientsList.stream().
                filter(c -> c.id == clientId).findFirst();
        return option.isPresent();
    }

    public Client getClient(String clientId) throws Exception {
        if (!hasClient(clientId)) {
            throw new Exception("Client with " + clientId + " ID hasn't found");
        }
        return clientsList.stream().filter(c -> c.id == clientId).
                findFirst().get();
    }

    public void openNewAccount(Client client, Account account) throws Exception {
        if (!clientsList.contains(client)) {
            throw new Exception(" " + client + " isn't a client of " + this + " bank");
        }
        accountsById.get(client.id).add(account);
    }

    public DebitAccount createDebitAccount(double balance) {
        return new DebitAccount(balance, debitPercent);
    }

    public DepositAccount createDepositAccount(double balance, int period) {
        double percent = 0;
        Set<Integer> keys = depositPercents.keySet();
        int last = 0;
        for (int stage : keys) {
            if (balance <= stage) {
                percent = depositPercents.get(stage);
                break;
            }
            last = stage;
        }
        if (percent == 0) {
            percent = depositPercents.get(last);
        }
        return new DepositAccount(balance, percent, period);
    }

    public CreditAccount createCreditAccount(double balance) {
        return new CreditAccount(balance, creditLimit, creditPercent);
    }

    public boolean hasAccount(String clientId, String accountId) {
        if (hasClient(clientId)) {
            Optional<Account> option = accountsById.get(clientId).stream().
                    filter(ac -> ac.id == accountId).findFirst();
            return option.isPresent();
        }
        return false;
    }

    public Account getAccount(String clientId, String accountId) throws Exception {
        if (!hasAccount(clientId, accountId)) {
            throw new Exception("Account hasn't found");
        }
        return accountsById.get(clientId).stream().
                filter(ac -> ac.id == accountId).findFirst().get();
    }

    private void clearBonus(Calendar lastDate, Calendar newDate) {
        if (Math.abs(lastDate.get(Calendar.MONTH) - newDate.get(Calendar.MONTH)) != 0) {
            for (List<Account> accountList : accountsById.values()) {
                for (Account account : accountList) {
                    account.clearPercent();
                }
            }
        }
    }

    public void goTo(Calendar newDate) {
        if (newDate.compareTo(lastUpdate) == -1) {
            List<Operation> operations = operationsList.stream().
                    filter(op -> op.date.compareTo(newDate) == 1).
                    collect(Collectors.toList());
            for (Operation op : operations) {
                op.undoOperation();
                operationsList.remove(op);
            }
            clearBonus(lastUpdate, newDate);
        }
        Calendar currentDate = (Calendar) lastUpdate.clone();
        while (currentDate.compareTo(newDate) < 0) {
            for (var accountList : accountsById.values()) {
                for (var ac : accountList) {

                    Calendar temp = (Calendar) currentDate.clone();
                    temp.add(Calendar.DAY_OF_WEEK, 1);
                    if (temp.get(Calendar.DAY_OF_MONTH) == 1) {
                        Operation op = new TopUpBalance(ac, lastUpdate, ac.payPercent());
                        op.doOperation();
                        operationsList.add(op);
                    }
                    if (ac instanceof DepositAccount && ((DepositAccount) ac).period != 0) {
                        ((DepositAccount) ac).period--;
                    }
                    ac.calcPercent();
                }
            }
            currentDate.add(Calendar.DAY_OF_WEEK, 1);
        }
        this.lastUpdate = (Calendar) newDate.clone();
    }

    private boolean trustClient(String clientId) throws Exception {
        Client client = getClient(clientId);
        return !((client.getAddress() == null || client.getAddress().isBlank()) ||
                (client.getPassport() == null || client.getPassport().isBlank()));
    }

    public String topUpBalance(String clientId, String accountId, double sum) throws Exception {
        Account account = getAccount(clientId, accountId);
        Operation op = new TopUpBalance(account, lastUpdate, sum);
        op.doOperation();
        operationsList.add(op);
        return op.id;
    }

    public String getCash(String clientId, String accountId, double sum) throws Exception {
        Account account = getAccount(clientId, accountId);
        if ((!trustClient(clientId) & sum > unfinishedClientLimit) ||
                !account.canPay(sum)) {
            throw new Exception("You cannot get " + sum + " cash");
        }
        if (account instanceof DepositAccount && ((DepositAccount) account).period != 0) {
            throw new Exception("You cannot get " + sum + " cash, because period of " +
                    "your deposit account hasn't ended");
        }
        Operation op = new GetCash(account, lastUpdate, sum);
        op.doOperation();
        operationsList.add(op);
        return op.id;
    }

    public String transferTo(Account sender, Account receiver, double sum) throws Exception {
        String senderClientId = "";
        for (String id : accountsById.keySet()) {
            long count = accountsById.get(id).stream().
                    filter(ac -> ac.id.equals(sender.id)).count();
            if (count != 0) {
                senderClientId = id;
                break;
            }
        }
        if ((!trustClient(senderClientId) & sum > unfinishedClientLimit) ||
                !sender.canPay(sum)) {
            throw new Exception("You cannot transfer " + sum + " money");
        }
        Operation op = new Transaction(sender, receiver, lastUpdate, sum);
        op.doOperation();
        operationsList.add(op);
        return op.id;
    }

    public void undoOperation(String id) throws Exception {
        Optional<Operation> option = operationsList.stream().
                filter(ac -> ac.id == id).findFirst();
        if (!option.isPresent()) {
            throw new Exception("Operation with this " + id + " hasn't found");
        }
        option.get().undoOperation();
        operationsList.remove(option.get());
    }
}