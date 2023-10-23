package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 10/23/23 - 10:18 AM   
*/

import lk.ijse.thogakade.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerModel {
    public boolean saveCustomer(String id, String name, String address, String tel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);
        pstm.setString(2, name);
        pstm.setString(3, address);
        pstm.setString(4, tel);

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
}
