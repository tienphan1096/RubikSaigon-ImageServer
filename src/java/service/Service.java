package service;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tien
 */
@ApplicationPath("service")
public class Service extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        
        classes.add(MultiPartFeature.class);
        
        classes.add(ImageService.class);
        
        return classes;
    }
}
