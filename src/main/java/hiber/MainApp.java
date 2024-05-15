package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Oleg", "Orlov", "orlov@mail.ru");
      User user2 = new User("Ivan", "Ivanov", "Ivanov@mail.ru");
      User user3 = new User("Andrey", "Andreev", "andreev@mail.ru");
      User user4 = new User("Semen", "Semenov", "semen@mail.ru");

      Car car = new Car("Honda", "civic");
      Car car2 = new Car("Volvo", "C90");
      Car car3 = new Car("Ford", "Focus");
      user1.setCar(car);
      user2.setCar(car2);
      user3.setCar(car3);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

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

      List<User> users2 = userService.getBySerialAndCar("Ford", "Focus");
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
