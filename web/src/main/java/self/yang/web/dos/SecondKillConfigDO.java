package self.yang.web.dos;

import self.yang.web.consts.TableName;
import self.yang.tools.persistences.dos.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class SecondKillConfigDO extends BaseDO implements Serializable {

    @Override
    public String tableName() {
        return TableName.SECOND_KILL_CONFIG;
    }

    /**
     * 主键编号
     */
    @Column(name = "id")
    private Integer id;

    /**
     * 秒杀商品编号
     */
    @Column(name = "kill_product_id")
    private Integer killProductId;

    /**
     * 秒杀商品库存
     */
    @Column(name = "kill_product_stock")
    private Integer killProductStock;

    /**
     * 秒杀活动开始时间
     */
    @Column(name = "kill_start_time")
    private Date killStartTime;

    /**
     * null
     */
    @Column(name = "kill_update_time")
    private Date killUpdateTime;

}
