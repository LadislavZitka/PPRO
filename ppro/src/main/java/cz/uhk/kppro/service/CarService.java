package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAllCars();
    Car getCar(Long id);
    boolean addCar(Car car);
    boolean updateCar(Car car);
    Car deleteCar(Long id);
}
