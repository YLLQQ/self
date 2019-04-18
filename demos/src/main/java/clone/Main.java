package clone;

/**
 * clone.Main
 *
 * @author eleven
 * @date 2019/04/09
 */
public class Main {

    public static void main(String[] args) {
        Model model = new Model();

        model.setAge("11");
        model.setName("11");

        System.out.println(model);

        Model model1 = null;

        try {
            model1 = (Model) model.clone();

            System.out.println(model1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        model.setName("222");

        System.out.println(model);
        System.out.println(model1);
    }
}
