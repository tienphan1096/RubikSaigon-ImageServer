package service;

import domainmodel.ImageFile;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @GET
    @Path("getImageList")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ImageFile> getImageList(){
        File imageFolder=new File("C:\\img");
        File[] fileList=imageFolder.listFiles();
        
        ArrayList<ImageFile> imageList=new ArrayList<>();
        for(int i=0; i<fileList.length; i++){
            ImageFile imageFile=new ImageFile(fileList[i].getName(), fileList[i].lastModified());
            imageList.add(imageFile);
        }
        
        return imageList;
    }
    
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public StreamingOutput uploadImage(@FormDataParam("file") InputStream uploadedFileStream,
                                        @FormDataParam("file") FormDataContentDisposition fileDetail){
        
        try {
            String folderPath = "C:\\img";
            String uploadedFileLocation = folderPath + "\\" + fileDetail.getFileName();
            saveToFile(uploadedFileStream, uploadedFileLocation);
            ImageResizer.processThumbnail(folderPath, fileDetail.getFileName());
            
            return new StreamingOutput() {
                @Override
                public void write(OutputStream output) throws IOException, WebApplicationException {
                    output.write("Image uploaded successfully".getBytes());
                }
            };
        } catch (IOException ex) {
            Logger.getLogger(ImageService.class.getName()).log(Level.SEVERE, null, ex);
            
            return new StreamingOutput() {
                @Override
                public void write(OutputStream output) throws IOException, WebApplicationException {
                    output.write("Failed to upload image".getBytes());
                }
            };
        }
    }
    
    private void saveToFile(InputStream uploadedFileStream, String uploadedFileLocation) throws FileNotFoundException, IOException {
        
        int read=0;
        byte[] bytes = new byte[1024];
        OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
        
        while((read = uploadedFileStream.read(bytes)) != -1){
            out.write(bytes, 0, read);  
        }
        
        out.flush();
        out.close();
    }
}
