package self.yang.tools.guava;

public class Main {

    public static void main(String[] args) {
        //params length is 0 params is [Ljava.lang.String;@10f87f48
        print();

        //params length is 1 params is [Ljava.lang.String;@b4c966a
        print("");

        //params length is 2 params is [Ljava.lang.String;@2f4d3709
        print(null, null);

        //Exception in thread "main" java.lang.NullPointerException
        //	at self.yang.tools.guava.Main.print(Main.java:19)
        //	at self.yang.tools.guava.Main.main(Main.java:15)
        print(null);
    }

    public static void print(String... params) {
        System.out.println("params length is " + params.length + " params is " + params.toString());
    }
}
