package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {
    List<Driver> getAllDrivers();
    Driver getDriver(int index);
    Driver deleteDriver(int index);
    boolean addDriver(Driver driver);
    boolean updateDriver(Driver driver);
}
