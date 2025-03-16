package Bai10;

public class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard(1000.0);
        PaymentMethod debitCard = new DebitCard(1000.0);
        PaymentMethod cash = new Cash(1000.0);

        System.out.println("--- Credit Card ---");
        System.out.println("Total Payment (CreditCard): " + creditCard.processPayment());
        System.out.println("Processed payment of " + creditCard.amount + " USD with total: " + creditCard.processPayment("USD"));
        System.out.println();

        System.out.println("--- Debit Card ---");
        System.out.println("Total Payment (DebitCard): " + debitCard.processPayment());
        System.out.println("Processed payment of " + debitCard.amount + " EUR with total: " + debitCard.processPayment("EUR"));
        System.out.println();

        System.out.println("--- Cash ---");
        System.out.println("Total Payment (Cash): " + cash.processPayment());
        System.out.println("Processed payment of " + cash.amount + " JPY with total: " + cash.processPayment("JPY"));
    }
}
