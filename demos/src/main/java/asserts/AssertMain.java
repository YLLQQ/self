package asserts;

public class AssertMain {

    public static void main(String[] args) {
        printException();
    }

    public static void printException() {
        Assert.stringIsEmpty(" ");

        System.out.println(true);
    }
}
