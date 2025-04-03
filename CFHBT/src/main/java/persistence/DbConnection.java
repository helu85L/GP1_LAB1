package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author ChalewT
 */
public class DbConnection {
    public static Connection getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@localhost:1521/FreePDB1");
        ods.setUser("jsims");
        ods.setPassword("0raPassword");
        Connection conn = ods.getConnection();
        return conn;
    }
}
