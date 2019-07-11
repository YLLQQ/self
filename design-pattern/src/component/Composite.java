package component;

import java.util.ArrayList;
import java.util.List;

/**
 * component.Composite
 *
 * @author eleven
 * @date 2019/07/11
 */
public class Composite extends Component {

    private List<Component> list = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public void display(int depth) {
        super.display(depth);

        for (Component component : list) {
            component.display(depth + 2);
        }
    }
}
