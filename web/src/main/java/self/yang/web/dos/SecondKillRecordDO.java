package self.yang.web.dos;

import self.yang.web.consts.TableName;
import self.yang.tools.persistences.dos.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class SecondKillRecordDO extends BaseDO implements Serializable {

    @Override
    public String tableName() {
        return TableName.SECOND_KILL_RECORD;
    }

    /**
     * 主键编号
     */
    @Column(name = "id")
    private Integer id;

    /**
     * 秒杀产品编号
     */
    @Column(name = "kill_product_id")
    private Integer killProductId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

}
