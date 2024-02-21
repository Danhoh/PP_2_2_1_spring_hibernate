package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(
                new User(
                        "User1",
                        "Lastname1",
                        "user1@mail.ru",
                        new Car("BMW", 1)
                )
        );
        userService.add(
                new User(
                        "User2",
                        "Lastname2",
                        "user1@mail.ru",
                        new Car("Lada", 2)
                )
        );
        userService.add(
                new User(
                        "User3",
                        "Lastname3",
                        "user1@mail.ru",
                        new Car("Mazda", 3)
                )
        );
        userService.add(
                new User(
                        "User1",
                        "Lastname1",
                        "user1@mail.ru",
                        new Car("BMW", 4)
                )
        );


        List<User> users = userService.listUsers();
        System.out.println("Added and fetched users from db: ");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
        System.out.println("Getting user by car model = 'BMW' series = '1':");
        System.out.println(userService.getUserByCar("BMW", 1));
        context.close();
    }
}
