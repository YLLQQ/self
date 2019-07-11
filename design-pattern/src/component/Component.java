package component;

/**
 * component.Component
 *
 * @author eleven
 * @date 2019/07/11
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    /**
     * 添加子节点
     *
     * @param component
     */
    public abstract void add(Component component);

    /**
     * 删除子节点
     *
     * @param component
     */
    public abstract void remove(Component component);

    /**
     * 展示
     *
     * @param depth
     */
    public void display(int depth) {
        StringBuilder pre = new StringBuilder("-");

        for (int i = 0; i < depth; i++) {
            pre.append("-");
        }

        System.out.println(pre + this.name);
    }

}
