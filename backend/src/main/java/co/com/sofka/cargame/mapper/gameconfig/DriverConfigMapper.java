package co.com.sofka.cargame.mapper.gameconfig;

import co.com.sofka.cargame.dto.gameconfig.DriverConfigDTO;
import co.com.sofka.cargame.entity.Car;
import co.com.sofka.cargame.entity.Driver;
import co.com.sofka.cargame.entity.Lane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DriverConfigMapper {

    public static Lane toLane(DriverConfigDTO driverConfigDTO){
        Lane lane = new Lane();
        lane.setNumberLane(driverConfigDTO.getNumberLane());
        return lane;
    }

    public static Driver toDriver(DriverConfigDTO driverConfigDTO){
        Driver driver = new Driver();
        driver.setName(driverConfigDTO.getName());
        return driver;
    }

    public static DriverConfigDTO toDriverConfigDTO(Driver driver){
        DriverConfigDTO toDriverConfigDTO = new DriverConfigDTO();
        toDriverConfigDTO.setId(driver.getId());
        toDriverConfigDTO.setName(driver.getName());
        toDriverConfigDTO.setBrandCar(driver.getCar().getBrand());
        toDriverConfigDTO.setModelCar(driver.getCar().getModel());
        toDriverConfigDTO.setScore(driver.getCar().getScore());
        toDriverConfigDTO.setNumberLane(driver.getCar().getLane().getNumberLane());
        return toDriverConfigDTO;
    }

    public static List<DriverConfigDTO> toListDriverConfigDTO(List<Driver> driverList){
        List<DriverConfigDTO> list = new ArrayList(driverList.size());
        Iterator driverIterator = driverList.iterator();

        while(driverIterator.hasNext()) {
            Driver driver = (Driver) driverIterator.next();
            list.add(DriverConfigMapper.toDriverConfigDTO(driver));
        }
        return list;
    }


    public static Car toCar(DriverConfigDTO driverConfigDTO){
        Car car = new Car();
        car.setBrand(driverConfigDTO.getBrandCar());
        car.setModel(driverConfigDTO.getModelCar());
        return car;
    }
}
