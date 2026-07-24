public class ProxyPatternDemo {
    public static void main(String[] args) {
        System.out.println("-- Creating proxy images (no disk loading yet) --");
        Image img1 = new ProxyImage("photo1.jpg");
        Image img2 = new ProxyImage("photo2.jpg");
        Image img3 = new ProxyImage("photo3.jpg");

        System.out.println("\n-- Displaying img1 (first time - loads from disk) --");
        img1.display();

        System.out.println("\n-- Displaying img1 again (uses cached) --");
        img1.display();

        System.out.println("\n-- Displaying img2 (first time - loads from disk) --");
        img2.display();
        // img3 is never displayed - never loaded (saves memory!)
    }
}
