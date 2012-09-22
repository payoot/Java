/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import th.in.java.io.SafeClose;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public class PreparedQuery {

    private transient final Connection connection;
    private transient final PreparedStatement statement;

    private static final Logger LOG = Logger.getLogger(SafeClose.class.getName());

    public PreparedQuery(final Connection connection, final String query)
        throws SQLException {
        this.connection = connection;
        this.statement = connection.prepareStatement(query);
    }

    public long update(final List<Object> params)
        throws SQLException{
        do {
            if (params == null) {
                break;
            }

            for (int i=0; i<params.size(); i++) {
                if (params.get(i) instanceof String) {
                    statement.setString(i+1, (String) params.get(i));
                } else if (params.get(i) instanceof Long) {
                    statement.setLong(i+1, (Long) params.get(i));
                } else if (params.get(i) instanceof BigDecimal) {
                    statement.setBigDecimal(i+1, (BigDecimal) params.get(i));
                } else if (params.get(i) instanceof Date) {
                    statement.setDate(i+1, (Date) params.get(i));
                } else {
                    LOG.log(Level.SEVERE, "Does not support parameter: {0}", params.get(i).getClass().getName());
                    throw new SQLException("Does not support parameter type.");
                }
            }
        } while(false);

        return (long) statement.executeUpdate();
    }

    public void release() {
        SqlClose.close(statement);
        SqlClose.close(connection);
    }

}
