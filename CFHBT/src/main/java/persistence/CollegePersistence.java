/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import domain.College;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ChalewT
 */
public class CollegePersistence implements ICollegePersistence {

    @Override
    public boolean save(College college) throws SQLException {
        int affectedRow;
        String query = "Insert into college (name) Values(?)";
        try (Connection conn = DbConnection.getConnection()) {
            try (PreparedStatement prepare = conn.prepareStatement(query)) {
                prepare.setString(1, college.getName());
                affectedRow = prepare.executeUpdate();
            }
        }
        return affectedRow > 0;
    }

    @Override
    public List<String> getAll() throws SQLException {
        List<String> colleges = new ArrayList<String>();
        String sql = "Select * from college Order By name ASC";
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rslt = stmt.executeQuery();
        while (rslt.next()) {
            colleges.add(rslt.getInt("id") + ":" + rslt.getString("name"));
        }

        return colleges;
    }

}
