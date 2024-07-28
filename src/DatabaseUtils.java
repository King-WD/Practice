import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;

public class DatabaseUtils {
    private static BasicDataSource dataSource;

    // 初始化数据源
    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/grade?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("WEi36847256$");

        // 额外的配置（可选）
        dataSource.setInitialSize(5); // 初始连接数
        dataSource.setMaxTotal(10); // 最大连接数
        dataSource.setMinIdle(5); // 最小空闲连接数
        dataSource.setMaxIdle(10); // 最大空闲连接数
        dataSource.setMaxWaitMillis(10000); // 最大等待时间（毫秒）
    }

    // 获取数据源
    public static DataSource getDataSource() {
        return dataSource;
    }
}
