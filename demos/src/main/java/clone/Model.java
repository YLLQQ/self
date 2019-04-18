package clone;

import lombok.Data;

/**
 * clone.Model
 *
 * @author eleven
 * @date 2019/04/09
 */
@Data
public class Model implements Cloneable {

    private String name;

    private String age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
