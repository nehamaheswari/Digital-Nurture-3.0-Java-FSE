interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private double price;
    private List<Observer> observers = new ArrayList<>();

    public StockMarket(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void   
 removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);   

        }
    }
}

interface Observer {
    void update(double price);
}

class MobileApp implements Observer {
    @Override
    public void update(double price) {
        System.out.println("Mobile App: Price changed to " + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(double price) {
        System.out.println("Web App: Price changed to " + price);
    }
}

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket(100.0);

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice(120.0);

        stockMarket.removeObserver(webApp);

        stockMarket.setPrice(150.0);
    }
}
