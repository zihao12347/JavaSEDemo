package enumdemo;

import java.util.EnumMap;

/**
 * @Author yanghao
 * @Date 2022/2/24 10:50
 */
enum DatabaseType{
    //创建枚举
    MYSQL,ORACLE,MD2,SQLSERVER
}
class DatabaseInfo{
    //创建EnumMap，key为枚举类型，
    private EnumMap<DatabaseType,String> urls=new EnumMap<DatabaseType, String>(DatabaseType.class);
    public DatabaseInfo() {
        urls.put(DatabaseType.MYSQL,"jdbc:mysql://localhost/mydb");
        urls.put(DatabaseType.MD2,"jdbc:db2://localhost:5000/sample");
        urls.put(DatabaseType.ORACLE,"jdbc:oracle:thin:@localhost:1521:sample");
        urls.put(DatabaseType.SQLSERVER,"jdbc:microsoft:sqlserver://sql:1433;Database=mydb");
    }
    public String getUrl(DatabaseType type){
        return this.urls.get(type);
    }
}
public class TestEnumMap {
    public static void main(String[] args) {
        DatabaseInfo databaseInfo = new DatabaseInfo();
        String mysqlUrl = databaseInfo.getUrl(DatabaseType.MYSQL);
        System.out.println(mysqlUrl);
    }
}
