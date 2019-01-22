package mate.academy.service;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("userService")
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("Impl of userservice");
    }

    public void printMyName() {
        System.out.println("Bond");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("DESTROYED");
    }
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("PROPERTIES SET");
    }
}
