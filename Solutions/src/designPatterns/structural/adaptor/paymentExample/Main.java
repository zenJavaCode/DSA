package designPatterns.structural.adaptor.paymentExample;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor oldProcessor = new BillDeskPaymentProcessor();
        oldProcessor.processPayment(100.0);
        PaymentProcessor processor = new RazorPaymentAdaptor(new RazorPaymentProcessor());
        processor.processPayment(123.23);
    }
}
