package self.yang.web.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import self.yang.web.enums.DataSourceEnum;

public class DynamicDataSourceConfig extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<>();

    public static void setDataSourceKey(DataSourceEnum dataSourceEnum) {
        dataSourceKey.set(dataSourceEnum.name());
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
