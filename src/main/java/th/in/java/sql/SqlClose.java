/*
 * โค้ดเสรี, สำหรับไว้คอมไฟล์และรันเท่านั้น ห้ามนำไปรับประทาน
 */
package th.in.java.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author Peerapat Asoktummarungsri, @nuboat
 */
public final class SqlClose {

    private static final Logger LOG = Logger.getLogger(SqlClose.class.getName());

    private SqlClose() {}

    public static void close(final ResultSet rsset) {
        try {
            if (rsset != null && !rsset.isClosed()) {
                rsset.close();
            }
        } catch(final SQLException sqle) {
            LOG.severe(sqle.getMessage());
        }
    }

    public static void close(final Statement statement) {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch(final SQLException sqle) {
            LOG.severe(sqle.getMessage());
        }
    }

    public static void close(final PreparedStatement statement) {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch(final SQLException sqle) {
            LOG.severe(sqle.getMessage());
        }
    }

    public static void close(final Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch(final SQLException sqle) {
            LOG.severe(sqle.getMessage());
        }
    }

}
