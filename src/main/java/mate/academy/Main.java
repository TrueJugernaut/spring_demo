package mate.academy;

import mate.academy.config.Config;
import mate.academy.dao.PersonDao;
import mate.academy.model.Developer;
import mate.academy.model.Person;
import mate.academy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Spring initializer");
        UserService userService = context.getBean(UserService.class);
        userService.printMyName();
        System.out.println("application context closed");

        PersonDao personDao = context.getBean(PersonDao.class);
        Person person = personDao.getById(1);
        Integer personId = personDao.createUser("Yehor", "Nesterov", 12);
        System.out.println(personDao.getById(2).toString());
        System.out.println(personId.toString());
        ((ConfigurableApplicationContext)context).close();

        Developer developer = new Developer();
        developer.builder().name("Yehor").age(17).salary(1020.0).build();
    }
}
