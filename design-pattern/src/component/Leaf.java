package component;

/**
 * component.Leaf
 *
 * @author eleven
 * @date 2019/07/11
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("cannot add leaf");
    }

    @Override
    public void remove(Component component) {
        System.out.println("cannot remove leaf");
    }

    @Override
    public void display(int depth) {
        super.display(depth);
    }
}
