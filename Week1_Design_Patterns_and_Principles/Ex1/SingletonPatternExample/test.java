public class test {
    public static void main(String[] args) {
        Logger l1=Logger.getInstance();
        System.out.println(l1.hashCode());

        Logger l2=Logger.getInstance();

        System.out.println(l2.hashCode());

        System.out.println((l1==l2? "BOTH ARE SAME OBJECT ": "BOTH ARE NOT SAME OBJECT"));
    }
}
