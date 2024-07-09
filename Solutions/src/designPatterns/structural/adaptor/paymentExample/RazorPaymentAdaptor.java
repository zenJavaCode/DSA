package designPatterns.structural.adaptor.paymentExample;

public class RazorPaymentAdaptor implements  PaymentProcessor{

private final RazorPaymentProcessor razorPaymentProcessor;

    public RazorPaymentAdaptor(RazorPaymentProcessor razorPaymentProcessor) {
        this.razorPaymentProcessor = razorPaymentProcessor;
    }

    @Override
    public void processPayment(double amount) {
        razorPaymentProcessor.makePayment(amount);
    }
}
