package asserts;

public class AssertMain {

    public static void main(String[] args) {
        printException();
    }

    public static void printException() {
        Assert.isTrue(false, "has false condition");
    }
}
