public class BuilderPatternDemo {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel i9-13900K", "32GB DDR5")
                .storage("2TB NVMe SSD")
                .GPU("NVIDIA RTX 4090")
                .bluetooth(true)
                .wifi(true)
                .build();
        System.out.println("Gaming PC: " + gamingPC);

        Computer officePC = new Computer.Builder("Intel i5-13400", "16GB DDR4")
                .storage("512GB SSD")
                .build();
        System.out.println("Office PC: " + officePC);
    }
}
