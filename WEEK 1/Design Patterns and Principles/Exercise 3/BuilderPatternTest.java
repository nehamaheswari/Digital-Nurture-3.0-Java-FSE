public class Computer {
    private String cpu;
    private int ram;
    private int storage;
    private String graphicsCard;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    public static class ComputerBuilder {
        private String cpu;
        private int ram;
        private int storage;
        private String graphicsCard;

        public ComputerBuilder(String cpu, int ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;   

        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public   
 int getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }
}

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer computer1 = new Computer.ComputerBuilder("Intel i7", 16)
                .setStorage(512)
                .setGraphicsCard("Nvidia RTX 3080")
                .build();

        Computer computer2 = new Computer.ComputerBuilder("AMD Ryzen 9", 32)
                .setStorage(1024)
                .build();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}
