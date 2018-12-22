**java 方面的一些个人实践，总结一下，以备后用**

`功能性封装：`
   
    1，持久化
    
    依赖mybatis，建立基础mapper封装结构
        
    self.yang.tools.persistences.dos.BaseDO约束新的DO对象，保证结构稳定
    self.yang.tools.persistences.mapper.BaseMapper实现基础数据动作封装
    self.yang.tools.persistences.provider.BaseProvider实现基本自定义数据动作封装
    
    使用方案：
        新建DO继承BaseDO
            DO对象属性采用封装类型，规避基本数据类型
        新建Mapper接口继承BaseMapper
            如有需要Mapper可自定义
        
        完成初始化数据配置，调用即可
    
    
    