package self.yang.web.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import self.yang.tools.persistences.mapper.BaseMapper;
import self.yang.web.dos.SecondKillConfigDO;

@Mapper
@Component
public interface SecondKillConfigMapper extends BaseMapper<SecondKillConfigDO> {

}
