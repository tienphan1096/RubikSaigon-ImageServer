package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import utils.ImageResizer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tien
 */
@Path("image")
public class ImageService {
    
    @GET
    @Path("getsample")
    @Produces("image/jpg")
    public File getImage(){
        String folderPath="C:\\Users\\Tien\\Documents\\NetBeansProjects\\ImageSevice\\web\\res\\img";
        String fileName="image.jpg";
        ImageResizer.processThumbnail(folderPath, fileName);
        return new File("C:\\Users\\Tien\\Documents\\NetBeansProjects\\ImageSevice\\web\\res\\img\\thumbnail_image.jpg");
    }
    
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public StreamingOutput uploadImage(@FormDataParam("file") InputStream uploadedFileStream,
                                        @FormDataParam("file") FormDataContentDisposition fileDetail){
        
        
        
        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                output.write("Hi!".getBytes());
            }
        };
    }
}
