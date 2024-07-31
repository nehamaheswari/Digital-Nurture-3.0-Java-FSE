interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;   

        loadFromDisk(fileName); // Simulating loading image from disk
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
        // Simulate loading image from disk
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();   

    }
}

public class ProxyPatternTest   
 {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_100.jpg");

        // Image will be loaded from disk
        image.display();

        // Image will not be loaded again
        image.display();
    }
}
