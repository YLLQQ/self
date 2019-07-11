package component;

/**
 * component.Main
 *
 * @author eleven
 * @date 2019/07/11
 */
public class Main {
    public static void main(String[] args) {
        Component root = new Composite("root");

        root.add(new Leaf("A"));
        root.add(new Leaf("B"));

        Composite composite1 = new Composite("Composite1");

        composite1.add(new Leaf("1-A"));
        composite1.add(new Leaf("1-B"));
        composite1.add(new Leaf("1-C"));

        Composite composite12 = new Composite("Composite12");

        composite12.add(new Leaf("1-2-A"));
        composite12.add(new Leaf("1-2-B"));
        composite12.add(new Leaf("1-2-C"));

        composite1.add(composite12);

        root.add(composite1);

        root.add(new Leaf("C"));

        root.display(1);


    }
}
