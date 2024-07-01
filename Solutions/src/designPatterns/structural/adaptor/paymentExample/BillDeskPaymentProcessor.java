package designPatterns.structural.adaptor.paymentExample;

public class BillDeskPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {


        System.out.println("making a payment through Bill Desk Payment Processor.");
    }

    // TODO now let's say another payment gateway came in to the picture. for example Razor pay. now to implement the razor pay
}
