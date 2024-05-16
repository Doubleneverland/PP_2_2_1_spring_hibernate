package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru"));


      carService.add(new Car("Honda", "Civic"));
      carService.add(new Car("Volvo", "C90"));
      carService.add(new Car("Ford", "Focus"));
      carService.add(new Car("Fiat", "Linea"));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car = " + user.getCar().getModel());
            System.out.println("Series = " + user.getCar().getSeries());
         } else {
            System.out.println("Car = user don`t have a car");
         }
      }

      List<Car> cars = carService.listCar();
      for (Car car : cars) {
         System.out.println("Id = " + car.getId());
         System.out.println("Model = " + car.getModel());
         System.out.println("Serial = " + car.getSeries());
      }

      //Распределение авто по юзерам
      for (int i = 1; i < users.size(); i++) {
         if (i < cars.size()) {
            users.get(i).setCar(cars.get(i));
            userService.add(users.get(i));
         }
      }

      List<User> usersWithCar = userService.listUsers();
      for (User user : usersWithCar) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car = " + user.getCar().getModel());
            System.out.println("Series = " + user.getCar().getSeries());
         } else {
            System.out.println("Car = user don`t have a car");
         }
      }

      List<User> users2 = carService.getBySerialAndCar("Ford", "Focus");
      for (User user : users2) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getModel());
         System.out.println("Series = " + user.getCar().getSeries());
      }
      context.close();
   }
}
