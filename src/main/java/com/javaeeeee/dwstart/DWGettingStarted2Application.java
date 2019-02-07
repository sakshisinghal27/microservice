package com.javaeeeee.dwstart;

import com.javaeeeee.dwstart.auth.GreetingAuthenticator;
import com.javaeeeee.dwstart.core.Employee;
import com.javaeeeee.dwstart.core.User;
import com.javaeeeee.dwstart.db.EmployeeDAO;
import com.javaeeeee.dwstart.resources.EmployeesResource;
import com.javaeeeee.dwstart.resources.HelloXRes;
import com.javaeeeee.dwstart.resources.MainHelloRes;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DWGettingStarted2Application extends Application<DWConfig> {

    public static void main(final String[] args) throws Exception {
        new DWGettingStarted2Application().run(args);
    }

    private final HibernateBundle<DWConfig> hibernate = new HibernateBundle<DWConfig>(Employee.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(DWConfig configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<DWConfig> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public String getName() {
        return "DWGettingStarted2";
    }


    @Override
    public void run(final DWConfig configuration,
                    final Environment environment) {

        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new GreetingAuthenticator())
                        .setRealm("SECURITY REALM")
                        .buildAuthFilter()));

        final MainHelloRes resource = new MainHelloRes();

        final EmployeeDAO employeeDAO= new EmployeeDAO(hibernate.getSessionFactory());

        environment.jersey().register(resource);
        environment.jersey().register(new HelloXRes());
        environment.jersey().register(new EmployeesResource(employeeDAO));

    }

}
