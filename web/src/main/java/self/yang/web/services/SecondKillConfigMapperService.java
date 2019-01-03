package self.yang.web.services;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.yang.web.annos.DefineAnnotation;
import self.yang.web.config.TableName;
import self.yang.web.dos.SecondKillConfigDO;
import self.yang.web.mappers.SecondKillConfigMapper;

import java.util.ArrayList;

@Service
public class SecondKillConfigMapperService {

    @Autowired
    private SecondKillConfigMapper secondKillConfigMapper;

    /**
     * 获取所有配置
     *
     * @return
     */
    public boolean deleteSecondKillConfigDO(Integer id) {
        return secondKillConfigMapper.deleteTbyId(TableName.SECOND_KILL_CONFIG, id);
    }

    /**
     * 分页获取配置
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ArrayList<SecondKillConfigDO> getSecondKillConfigDOWithPage(
            int pageNum,
            int pageSize
    ) {
        PageHelper.startPage(pageNum, pageSize);

        return secondKillConfigMapper.getAllT(TableName.SECOND_KILL_CONFIG);
    }

    /**
     * 获取所有配置
     *
     * @return
     */
    public ArrayList<SecondKillConfigDO> getAllSecondKillConfigDO() {
        return secondKillConfigMapper.getAllT(TableName.SECOND_KILL_CONFIG);
    }


    /**
     * 通过主键获取配置
     *
     * @param id
     * @return
     */
    @DefineAnnotation("getSecondKillConfigDO")
    public SecondKillConfigDO getSecondKillConfigDO(Integer id) {
        return secondKillConfigMapper.getTbyId(TableName.SECOND_KILL_CONFIG, id);
    }

    /**
     * 添加秒杀配置
     *
     * @param secondKillConfigDO
     * @return
     */
    public boolean addSecondKillConfig(SecondKillConfigDO secondKillConfigDO) {
        return secondKillConfigMapper.insertT(secondKillConfigDO);
    }
}
