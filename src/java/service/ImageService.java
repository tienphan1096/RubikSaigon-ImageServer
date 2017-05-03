
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.File;

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
        ImageResizer.resizeImageUsingThumbnailator();
        return new File("C:\\Users\\Tien\\Documents\\NetBeansProjects\\WebApplication1\\web\\resizedImage.jpg");
    }
}
