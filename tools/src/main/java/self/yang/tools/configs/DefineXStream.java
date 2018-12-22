package self.yang.tools.configs;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * 自定义XStream，忽略不存在节点映射报错
 */
public class DefineXStream extends XStream {

    public DefineXStream(DomDriver domDriver) {
        super(domDriver);
    }

    @Override
    protected MapperWrapper wrapMapper(MapperWrapper next) {
        return new MapperWrapper(next) {

            @Override
            public boolean shouldSerializeMember(
                    @SuppressWarnings("rawtypes") Class definedIn,
                    String fieldName
            ) {
                if (definedIn == Object.class) {
                    return false;
                }

                return super.shouldSerializeMember(definedIn, fieldName);
            }
        };
    }
}