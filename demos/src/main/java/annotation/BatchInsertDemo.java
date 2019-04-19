package annotation;

import lombok.Data;

/**
 * annotation.BatchInsertDemo
 *
 * @author eleven
 * @date 2019/04/19
 */
@Data
@TableName("test")
public class BatchInsertDemo {

    @ColumnName("column1")
    private String column1;
}
