package bridge;

/**
 * bridge.Brush
 *
 * @author eleven
 * @date 2019/07/11
 */
public abstract class Brush {
    private Color color;

    /**
     * 获取尺寸
     *
     * @return
     */
    public abstract String getSize();

    public void write() {
        System.out.println(String.format("size is %s and color is %s", getSize(), this.color.getColor()));
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
