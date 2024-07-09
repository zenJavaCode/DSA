package designPatterns.structural.adaptor.paymentExample;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor oldProcessor = new BillDeskPaymentProcessor();
        oldProcessor.processPayment(100.0);
        PaymentProcessor processor = new RazorPaymentAdaptor(new RazorPaymentProcessor());
        processor.processPayment(123.23);
    }
    /*TODO Question 1: What is the Adapter Design Pattern, and why is it used?
                ``Answer:
                The Adapter Design Pattern is a structural design pattern that allows objects with incompatible interfaces to work together.
                It acts as a bridge between two interfaces, converting the interface of a class into another interface that a client expects.
                Question 2:     Why it is used?
                To integrate new functionality into an existing system without modifying the existing code.
                To work with legacy code or third-party libraries that have different interfaces.
                To enable the reuse of existing classes that don't match the target interface.
                Question 2: Can you provide a real-world example where the Adapter Design Pattern might be used?
                Answer:
                A real-world example of the Adapter Pattern is the use of a card reader to access data from different
                types of memory cards (SD, microSD, etc.) through a USB port. The card reader acts as an adapter,
                 converting the memory card's interface to the USB interface that a computer expects.*/


}
