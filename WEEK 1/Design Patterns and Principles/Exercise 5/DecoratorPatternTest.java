interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override   

    public void send(String message) {
        notifier.send(message);   

    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);   

        System.out.println("Sending  SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override   

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack notification: " + message);
    }
}

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        Notifier slackNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));

        slackNotifier.send("Hello from Decorator Pattern!");
    }
}
