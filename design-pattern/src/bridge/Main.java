package bridge;

/**
 * bridge.Main
 *
 * @author eleven
 * @date 2019/07/11
 */
public class Main {
    public static void main(String[] args) {
        Color blue = new ColorBlue();
        Color red = new ColorRed();

        Brush big = new BrushBig();
        Brush middle = new BrushMiddle();

        big.setColor(blue);
        big.write();

        big.setColor(red);
        big.write();

        middle.setColor(blue);
        middle.write();

        middle.setColor(red);
        middle.write();
    }
}
