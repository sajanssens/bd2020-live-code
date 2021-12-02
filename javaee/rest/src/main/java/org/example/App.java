package org.example;

import org.example.util.PasswordUtils;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// http(s)://serveraddress:serverport/context-root/...
// http://localhost:9080/rest/api/
@ApplicationPath("api")
public class App extends Application {

    // dit is onze "main"

    // @Override
    // public Set<Object> getSingletons() {
    //     Set<Object> singletons = new HashSet<>(super.getSingletons());
    //
    //     singletons.add(BadRequestExceptionMapper.class);
    //     return singletons;
    // }
}
