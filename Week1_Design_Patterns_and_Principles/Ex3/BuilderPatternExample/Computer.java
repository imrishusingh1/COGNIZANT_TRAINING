public class Computer {
    // Required fields
    private final String CPU;
    private final String RAM;
    // Optional fields
    private final String storage;
    private final String GPU;
    private final boolean bluetooth;
    private final boolean wifi;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.bluetooth = builder.bluetooth;
        this.wifi = builder.wifi;
    }

    @Override
    public String toString() {
        return "Computer{CPU='" + CPU + "', RAM='" + RAM + "', Storage='" + storage +
               "', GPU='" + GPU + "', Bluetooth=" + bluetooth + ", WiFi=" + wifi + "}";
    }

    public static class Builder {
        private final String CPU;
        private final String RAM;
        private String storage = "512GB SSD";
        private String GPU = "Integrated";
        private boolean bluetooth = false;
        private boolean wifi = true;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }
        public Builder storage(String storage) { this.storage = storage; return this; }
        public Builder GPU(String GPU) { this.GPU = GPU; return this; }
        public Builder bluetooth(boolean bluetooth) { this.bluetooth = bluetooth; return this; }
        public Builder wifi(boolean wifi) { this.wifi = wifi; return this; }
        public Computer build() { return new Computer(this); }
    }
}
