interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalPaymentGateway {
    public void chargePayPal(double amount) {
        System.out.println("Charging PayPal: $" + amount);
    }
}

class StripePaymentGateway {
    public void chargeStripe(double amount) {
        System.out.println("Charging Stripe: $" + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalPaymentGateway gateway;

    public PayPalAdapter(PayPalPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void   
 processPayment(double amount) {
        gateway.chargePayPal(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripePaymentGateway gateway;

    public StripeAdapter(StripePaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.chargeStripe(amount);
    }
}

public class AdapterPatternTest {
    public static void main(String[] args) {
        PayPalPaymentGateway paypalGateway = new PayPalPaymentGateway();
        StripePaymentGateway stripeGateway = new StripePaymentGateway();

        PaymentProcessor paypalAdapter = new PayPalAdapter(paypalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        paypalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(50.0);
    }
}
