/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.College;
import java.sql.SQLException;
import java.util.List;
import persistence.CollegePersistence;
import persistence.ICollegePersistence;

/**
 *
 * @author ChalewT
 */
public class CollegeService implements ICollegeService {

    private final ICollegePersistence collegePersistance = (ICollegePersistence) new CollegePersistence();

    @Override
    public boolean register(College college) throws SQLException {
        return collegePersistance.save(college);
    }

    @Override
    public List<String> getAll() throws SQLException {
        return collegePersistance.getAll();
    }
}
