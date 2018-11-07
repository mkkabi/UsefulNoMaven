package Java8inAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.*;

public class Transaction {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		Currency usd = new USD();
		Currency eur = new EUR();

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300, eur),
				new Transaction(raoul, 2012, 1000, eur),
				new Transaction(raoul, 2011, 400, usd),
				new Transaction(mario, 2012, 710, usd),
				new Transaction(mario, 2012, 700, usd),
				new Transaction(alan, 2012, 950, eur)
		);
// ========= FILTERING WITH STREAMS  =======		
//		transactions.stream().map(Transaction::getYear).forEach(System.out::println);
//		transactions.stream().filter(t->t.getTrader().getCity().equals("Milan")).findAny();
//		transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).forEach(System.out::println);
		
		/*
		 Grouping transactions by currency in imperative style
		 */
		Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap();
		for (Transaction transaction : transactions) {
			Currency currency = transaction.getCurrency();
			List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
			if (transactionsForCurrency == null) {
				transactionsForCurrency = new ArrayList<>();
				transactionsByCurrencies.put(currency, transactionsForCurrency);
			}
			transactionsForCurrency.add(transaction);
		}
// =================================
		/*
		 Grouping transactions by currency in Stream style
		 */
		Map<Currency, List<Transaction>> transactionsByCurrenciesS
				= transactions.stream().collect(groupingBy(Transaction::getCurrency));

		transactionsByCurrenciesS.forEach((c, t) -> {
			System.out.println(c.toString());
			for (Transaction tt : t) {
				System.out.println(tt.toString());
			}
		});
// ========= COLLECTORS  =======		
		System.out.println(transactions.stream().collect(averagingInt(Transaction::getValue)).intValue());
		//System.out.println(transactions.stream().map(Transaction::getTrader).collect(joining(", "))+" ");
		System.out.println("using Joining method");
		System.out.println(transactions.stream().map(t->t.getTrader().getName()).collect(joining(", ")));
		System.out.println("printing highest transaction with Collector");
		Optional<Transaction> highestTransaction = 
				transactions.stream().collect(reducing((d1,d2)->d1.getValue()>d2.getValue()?d1:d2));
		System.out.println(highestTransaction.get().value);
		
		
	}

	private final Trader trader;
	private final int year;
	private final int value;
	private final Currency currency;

	public Transaction(Trader trader, int year, int value, Currency currency) {
		this.trader = trader;
		this.year = year;
		this.value = value;
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return "{" + this.trader + ", "
				+ "year: " + this.year + ", "
				+ "value:" + this.value + ", "
				+ "currency:" + this.currency + "}";
	}
}

class Trader {

	private final String name;
	private final String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public String toString() {
		return "Trader:" + this.name + " in " + this.city;
	}
}

class Currency {

	private String name;

	@Override
	public String toString() {
		return "Currency{" + "name=" + name + '}';
	}

	public String getName() {
		return name;
	}
}

class USD extends Currency {

	String name = "USD";

	@Override
	public String toString() {
		return "Currency{" + "name=" + name + '}';
	}
}

class EUR extends Currency {

	String name = "EUR";

	@Override
	public String toString() {
		return "Currency{" + "name=" + name + '}';
	}
}
