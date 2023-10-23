package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 10/23/23 - 4:03 PM   
*/

import lk.ijse.thogakade.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderModel {
    public List<String> loadCustomerIds() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT id FROM customer";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }
}
