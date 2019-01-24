package mate.academy.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MvcShowCaseApp implements WebApplicationInitializer {

    public void onStartup(final ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext root =
                new AnnotationConfigWebApplicationContext();

        root.scan("mate.academy");
        servletContext.addListener(new ContextLoaderListener(root));

        ServletRegistration.Dynamic appservlet =
                servletContext.addServlet("mvc", new DispatcherServlet(
                        new GenericWebApplicationContext()));
        appservlet.setLoadOnStartup(1);
        appservlet.addMapping("/");
    }
}
