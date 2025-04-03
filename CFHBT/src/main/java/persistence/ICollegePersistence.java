/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence;

import domain.College;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ChalewT
 */
public interface ICollegePersistence {

    boolean save(College college) throws SQLException;

    List<String> getAll() throws SQLException;
}
