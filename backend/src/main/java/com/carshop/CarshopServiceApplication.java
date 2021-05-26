package com.carshop;

import com.carshop.entities.Brand;
import com.carshop.entities.Car;
import com.carshop.entities.Model;
import com.carshop.entities.User;
import com.carshop.repositories.BrandRepository;
import com.carshop.repositories.CarRepository;
import com.carshop.repositories.UserRepository;
import com.carshop.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class CarshopServiceApplication implements CommandLineRunner {

    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public CarshopServiceApplication(CarRepository carRepository, BrandRepository brandRepository, UserRepository userRepository,UserService userService, PasswordEncoder passwordEncoder) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarshopServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {

        if(this.userRepository.count() == 0) {
            User user = new User();
            user.setUsername("user");
            user.setPassword(this.passwordEncoder.encode("password"));
            this.userService.addUser(user);
        }

        // This initializes the database on startup
        if (carRepository.count() == 0) {
            Brand bmw = new Brand();
            bmw.setName("BMW");
            bmw.setModels(Arrays.asList(new Model("E90"), new Model("430d")));
            bmw = brandRepository.save(bmw);

            Brand nissan = new Brand();
            nissan.setName("Nissan");
            nissan.setModels(Collections.singletonList(new Model("GT-R")));
            nissan = brandRepository.save(nissan);

            Brand audi = new Brand();
            audi.setName("Audi");
            audi.setModels(Collections.singletonList(new Model("RS-6")));
            audi = brandRepository.save(audi);

            Brand ford = new Brand();
            ford.setName("Ford");
            ford.setModels(Arrays.asList(new Model("Focus"), new Model("Mustang"), new Model("F-150")));
            ford = brandRepository.save(ford);

            Brand lamborghini = new Brand();
            lamborghini.setName("Lamborghini");
            lamborghini.setModels(Collections.singletonList(new Model("Urus")));
            lamborghini = brandRepository.save(lamborghini);

            Brand mazda = new Brand();
            mazda.setName("Mazda");
            mazda.setModels(Collections.singletonList(new Model("RX-8")));
            mazda = brandRepository.save(mazda);


            Car car1 = new Car();
            car1.setBrand(nissan);
            car1.setDescription("Nissan GT-R NISMO is a car that has a 2 door coupé body style with a front mounted engine supplying power to all four wheels. The Nissan GT-R NISMO is one of the R35 range of cars from Nissan. Its 6 cylinder, double overhead camshaft turbocharged engine has 4 valves per cylinder and a volume of 3.8 litres. For this model it develops power and torque figures of 592 bhp (600 PS/441 kW) at 6800 rpm and 652 Nm (481 lbft/66.5 kgm) at 3600-5600 rpm respectively. The engine transmits power to the wheels via a 6 speed automatic gearbox. Its claimed weight at the kerb is 1778 kg.");
            car1.setTransmission("Automatic");
            car1.setFuel("Gasoline");
            car1.setType("Coupé");
            car1.setModel(nissan.getModels().get(0));
            car1.setPrice(215000);
            car1.setHp(592);
            car1.setProductionYear(2020);
            car1.setImage("https://www-europe.nissan-cdn.net/content/dam/Nissan/global/vehicles/gt-r/r35/eulhd/2_minor_change/nismo/16tdieulhd_GT-R_NISMO_Helios_002.jpg.ximg.l_12_m.smart.jpg");

            Car car2 = new Car();
            car2.setBrand(bmw);
            car2.setDescription("This vehicle has a 4 door saloon (sedan) body style with a front located engine supplying power to the rear wheels. The BMW 320d belongs to the G20 model family from BMW. The power is produced by a turbocharged engine of 2 litre capacity. This unit features double overhead camshaft valve gear, 4 cylinder layout, and 4 valves per cylinder. It develops 187.5 bhp (190 PS/140 kW) of power at 4000 rpm, and maximum torque of 400 N·m (295 lb·ft/40.8 kgm) at 1750-2500 rpm. This power is delivered to the wheels via an 8 speed automatic gearbox. It weighs a claimed 1615 kg at the kerb. Maximum claimed speed is 240 km/h (149 mph), official fuel consumption figures are 4.5/3.7/4.0 l/100km 90 km/h / 120 km/h / city, and carbon dioxide emissions are 105.0 g/km.");
            car2.setTransmission("Automatic");
            car2.setFuel("Diesel");
            car2.setType("Sedan");
            car2.setModel(bmw.getModels().get(0));
            car2.setPrice(41000);
            car2.setHp(188);
            car2.setProductionYear(2020);
            car2.setImage("https://p6.focus.de/img/fotos/id_765072/p0048552.jpg?im=Crop%3D%280%2C125%2C1500%2C750%29%3BResize%3D%281200%2C627%29&hash=3ab5ab26ab9d9670574bca007c9e6440ef5cc9451ab81dbc15f97ef3c5a674c1");

            Car car3 = new Car();
            car3.setBrand(lamborghini);
            car3.setDescription("The Urus is a four wheel drive suv/sports utility vehicle motor car with a front positioned engine, from Lamborghini. Its engine is a turbocharged petrol, 4 litre, double overhead camshaft 90 degree V 8 cylinder with 4 valves per cylinder. This unit has an output of 641 bhp (650 PS/478 kW) of power at 6000 rpm, and maximum torque of 850 N·m (627 lb·ft/86.7 kgm) at 2250-4500 rpm. The engine transmits power to the wheels via an 8 speed automatic transmission. It weighs a claimed 2197 kg at the kerb. Maximum speed claimed is 305 km/h (190 mph), officially stated fuel consumption figures are 16.7/9.7/12.3 l/100km urban/extra-urban/combined, and carbon dioxide emissions are 279.0 g/km.");
            car3.setTransmission("Automatic");
            car3.setFuel("Diesel");
            car3.setType("SUV");
            car3.setModel(lamborghini.getModels().get(0));
            car3.setPrice(220000);
            car3.setHp(641);
            car3.setProductionYear(2018);
            car3.setImage("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-lamborghini-urus-mmp-1-1592423712.jpg?crop=0.994xw:0.745xh;0,0.123xh&resize=1200:*");

            Car car4 = new Car();
            car4.setBrand(ford);
            car4.setDescription("The Raptor's long-travel suspension gives it both awesome off-road capability and impressive ride comfort. Its 450-hp twin-turbo V-6 and 10-speed automatic transmission can shoot it to 60 mph in as little as 5.1 seconds. While its massive dimensions make it a bear to maneuver in tight quarters, it also can roll over pesky parking curbs with ease.");
            car4.setTransmission("Automatic");
            car4.setFuel("Gasoline");
            car4.setType("Pick-up truck");
            car4.setModel(ford.getModels().get(2));
            car4.setPrice(55000);
            car4.setHp(450);
            car4.setProductionYear(2020);
            car4.setImage("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-ford-f-150-raptor-114-1612285324.jpg?crop=0.522xw:0.748xh;0.0897xw,0.193xh&resize=1200:*");

            Car car5 = new Car();
            car5.setBrand(ford);
            car5.setDescription("Ford Mustang GT is a car that has a 2 door coupé body style with a front located engine supplying power to the rear wheels. Power is produced by a double overhead camshaft, 5 litre naturally aspirated 8 cylinder motor, with 4 valves per cylinder that provides power and torque figures of 460 bhp (466 PS/343 kW) at 7500 rpm and 570 N·m (420 lb·ft/58.1 kgm) at 4600 rpm respectively. A 6 speed manual 'box supplies the power to the driven wheels. Claimed kerb weight is 1692 kg. Maximum speed stated is 249 km/h, which is 155 mph, official fuel consumption figures are 15/24/18 US MPG EPA city/highway/combined.");
            car5.setTransmission("Manual");
            car5.setFuel("Gasoline");
            car5.setType("Coupé");
            car5.setModel(ford.getModels().get(1));
            car5.setPrice(52000);
            car5.setHp(460);
            car5.setProductionYear(2021);
            car5.setImage("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-ford-mustang-mach-1-109-1592231891.jpg?crop=0.801xw:0.601xh;0.159xw,0.156xh&resize=1200:*");

            Car car6 = new Car();
            car6.setBrand(ford);
            car6.setDescription("Ford Focus 1.0 Active is a car that has a 5 door hatchback type body with a front positioned engine that delivers power to the front wheels. Power is produced by a double overhead camshaft, 1 litre turbocharged 3 cylinder engine, with 4 valves per cylinder that produces power and torque figures of 123 bhp (125 PS/92 kW) at 6000 rpm and 200 N·m (148 lb·ft/20.4 kgm) at 1400-4500 rpm respectively. A 6 speed manual transmission transfers the power to the wheels. The Ford Focus 1.0 Active weighs a stated 1322 kg at the kerb. Maximum stated speed is 196 km/h (122 mph), officially stated fuel consumption figures are 6.0/4.3/4.9 l/100km urban/extra-urban/combined, and carbon dioxide emissions are 111.0 g/km.");
            car6.setTransmission("Manual");
            car6.setFuel("Gasoline");
            car6.setType("Hatchback");
            car6.setModel(ford.getModels().get(0));
            car6.setPrice(14000);
            car6.setHp(123);
            car6.setProductionYear(2018);
            car6.setImage("https://hips.hearstapps.com/hmg-prod/amv-prod-cad-assets/images/14q2/584477/2015-ford-focus-sedan-photos-and-info-news-car-and-driver-photo-587376-s-original.jpg?fill=2:1&resize=1200:*");

            Car car7 = new Car();
            car7.setBrand(bmw);
            car7.setDescription("This automobile has a 2 door convertible/cabriolet body style with a front located engine supplying power to the rear wheels. The BMW 430d Cabrio is one of the F33 model family from BMW. Powering the BMW 430d Cabrio is a double overhead camshaft, 3 litre turbocharged 6 cylinder powerplant, with 4 valves per cylinder that develops power and torque figures of 254.5 bhp (258 PS/190 kW) at 4000 rpm and 560 N·m (413 lb·ft/57.1 kgm) at 1500-3000 rpm respectively. An 8 speed automatic gearbox supplies the power to the driven wheels. Quoted kerb weight is 1845 kg. It is said to be able to achieve a top speed of 250 km/h which is 155 mph, official fuel consumption figures are 6.1/4.8/5.3 l/100km urban/extra-urban/combined, and carbon dioxide emissions are 139.0 g/km.");
            car7.setTransmission("Automatic");
            car7.setFuel("Diesel");
            car7.setType("Cabrio");
            car7.setModel(bmw.getModels().get(1));
            car7.setPrice(20000);
            car7.setHp(255);
            car7.setProductionYear(2017);
            car7.setImage("https://hips.hearstapps.com/hmg-prod/amv-prod-cad-assets/images/13q4/543506/2014-bmw-4-series-cabriolet-photos-and-info-news-car-and-driver-photo-545918-s-original.jpg?fill=2:1&resize=1200:*");

            Car car8 = new Car();
            car8.setBrand(mazda);
            car8.setDescription("The Mazda RX-8 is a coupé with 4 doors and a front mounted engine which supplies the power through the rear wheels. It is powered by a naturally aspirated Wankel rotary engine of 2.6 (rotary equivalent) litre capacity. This unit features 2 rotary chamber layout,. It produces 228 bhp (231 PS/170 kW) of power at 8200 rpm, and maximum torque of 211 N·m (156 lb·ft/21.5 kgm) at 5500 rpm. The engine transmits power to the wheels via a 6 speed manual transmission. Stated kerb weight is 1390 kg. Top quoted speed is 234 km/h, or 145 mph, official fuel consumption figures are 15.7/9.1/11.5 l/100km urban/extra-urban/combined, and carbon dioxide emissions are 299.0 g/km.");
            car8.setTransmission("Manual");
            car8.setFuel("Gasoline");
            car8.setType("Coupé");
            car8.setModel(mazda.getModels().get(0));
            car8.setPrice(17000);
            car8.setHp(228);
            car8.setProductionYear(2009);
            car8.setImage("https://hips.hearstapps.com/roa.h-cdn.co/assets/16/18/mazda_rx-8_2008_photos_8_1600x1200.jpg?crop=1xw:1.0xh;center,top&resize=1200:*");

            Car car9 = new Car();
            car9.setBrand(audi);
            car9.setDescription("The RS 6 Avant performance is a motor vehicle from Audi, with all wheel drive, a front mounted engine and a 5 door estate/station wagon body style. The 8 cylinder, double overhead camshaft turbocharged engine has 4 valves per cylinder and a volume of 4 litres. In this application it provides power and torque figures of 597 bhp (605 PS/445 kW) at 6100-6800 rpm and 750 Nm (553 lbft/76.5 kgm) at 2500-5500 rpm respectively. An 8 speed automatic gearbox transfers the power to the wheels. Its claimed weight at the kerb is 2025 kg. Top stated speed is 305 km/h (190 mph), claimed fuel consumption figures are 13.4/7.4/9.6 l/100km urban/extra-urban/combined, and carbon dioxide emissions are 223.0 g/km.");
            car9.setTransmission("Automatic");
            car9.setFuel("Gasoline");
            car9.setType("Estate");
            car9.setModel(audi.getModels().get(0));
            car9.setPrice(120000);
            car9.setHp(597);
            car9.setProductionYear(2015);
            car9.setImage("https://i.pinimg.com/originals/d1/cd/b5/d1cdb57d8c80539dbf3c53c527c17ea2.jpg");

            carRepository.saveAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9));

        }

    }
}
