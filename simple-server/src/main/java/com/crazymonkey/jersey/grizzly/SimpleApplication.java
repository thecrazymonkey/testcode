package com.crazymonkey.jersey.grizzly;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
 
@ApplicationPath("/")
public class SimpleApplication extends Application {
    private static final Class<?>[] ENDPOINT_CLASS_LIST = new Class<?>[] { MyRestEndpoint.class };
    private static final Set<Class<?>> ENDPOINT_CLASS_SET = new HashSet<>(Arrays.asList(ENDPOINT_CLASS_LIST));
    @Override
    public Set<Class<?>> getClasses() {
        return ENDPOINT_CLASS_SET;
    }
}