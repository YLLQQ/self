package self.yang.tools.persistences.mapper;

import org.apache.ibatis.annotations.*;
import self.yang.tools.persistences.dos.BaseDO;
import self.yang.tools.persistences.provider.BaseProvider;

import java.util.ArrayList;

public interface BaseMapper<T extends BaseDO> {

    /**
     * 通过ID修改数据
     *
     * @param baseDO
     * @return
     */
    @UpdateProvider(type = BaseProvider.class, method = "updateTById")
    boolean updateTById(BaseDO baseDO);

    /**
     * 通过主键ID删除对应记录
     *
     * @param tableName
     * @param id
     * @return
     */
    @Delete("delete from ${tableName} where id=#{id}")
    boolean deleteTbyId(
            @Param("tableName") String tableName,
            @Param("id") Integer id
    );

    /**
     * 获取表数据总数
     *
     * @param tableName
     * @return
     */
    @Select("select count(*) from ${tableName}")
    int getAllTCount(@Param("tableName") String tableName);

    /**
     * 获取表中的所有数据
     *
     * @param tableName
     * @return
     */
    @Select("select * from ${tableName}")
    ArrayList<T> getAllT(@Param("tableName") String tableName);

    /**
     * 向数据库中插入数据
     *
     * @param baseDO
     * @return
     */
    @InsertProvider(type = BaseProvider.class, method = "insertT")
    boolean insertT(BaseDO baseDO);

    /**
     * 通过自增ID获取数据
     *
     * @param tableName
     * @param id
     * @return
     */
    @Select("select * from ${tableName} where id=#{id} limit 1")
    T getTbyId(
            @Param("tableName") String tableName,
            @Param("id") Integer id
    );

}
