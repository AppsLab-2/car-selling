package com.carshop;

import com.carshop.entities.Brand;
import com.carshop.entities.Car;
import com.carshop.entities.Model;
import com.carshop.repositories.BrandRepository;
import com.carshop.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarshopServiceApplication implements CommandLineRunner {

    private CarRepository carRepository;
    private BrandRepository brandRepository;

    public CarshopServiceApplication(CarRepository carRepository, BrandRepository brandRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarshopServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // This initializes the database on startup
        if (carRepository.count() == 0) {
            Brand bmw = new Brand();
            bmw.setName("BMW");
            bmw.setModels(Arrays.asList(new Model("serie 1"), new Model("serie 2"), new Model("serie 3")));
            bmw = brandRepository.save(bmw);

            Brand mercedes = new Brand();
            mercedes.setName("MERCEDES BENZ");
            mercedes.setModels(Arrays.asList(new Model("A Class"), new Model("B Class"), new Model("C Class")));
            mercedes = brandRepository.save(mercedes);

            Brand audi = new Brand();
            audi.setName("AUDI");
            audi.setModels(Arrays.asList(new Model("RS1"), new Model("RS3"), new Model("RS4")));
            audi = brandRepository.save(audi);


            Car car1 = new Car();
            car1.setPrice(90_000);
            car1.setHp(310);
            car1.setBrand(bmw);
            car1.setModel(bmw.getModels().get(0));

            Car car2 = new Car();
            car2.setPrice(80_000);
            car2.setHp(240);
            car2.setBrand(mercedes);
            car2.setModel(mercedes.getModels().get(0));


            Car car3 = new Car();
            car3.setPrice(70_000);
            car3.setHp(220);
            car3.setBrand(audi);
            car3.setModel(audi.getModels().get(0));

            carRepository.saveAll(Arrays.asList(car1, car2, car3));

        }

    }
}
