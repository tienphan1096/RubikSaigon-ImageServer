
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.coobird.thumbnailator.Thumbnails;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tien
 */
public class ImageResizer {
    
    public static void resizeImageUsingGraphics2D(){
        
        int newWidth = 400;
        int newHeight = 300;
        
        File imageFile = new File("C:\\Users\\Tien\\Documents\\NetBeansProjects\\WebApplication1\\web\\image.jpg");
        File outputFile = new File("C:\\Users\\Tien\\Documents\\NetBeansProjects\\WebApplication1\\web\\resizedImage.jpg");
        
        try {
            BufferedImage orignalImage = ImageIO.read(imageFile);
            
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D resizedGraphic = resizedImage.createGraphics();
            
            resizedGraphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            resizedGraphic.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            resizedGraphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            resizedGraphic.drawImage(orignalImage, 0, 0, newWidth, newHeight, null);
            resizedGraphic.dispose();

            
            ImageIO.write(resizedImage, "png", outputFile);
        } catch (IOException ex) {
            Logger.getLogger(ImageResizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void resizeImageUsingScalr(){
        int newWidth = 600;
        int newHeight = 450;

        File imageFile = new File("C:\\Users\\Tien\\Documents\\NetBeansProjects\\WebApplication1\\web\\image.jpg");
        File outputFile = new File("C:\\Users\\Tien\\Documents\\NetBeansProjects\\WebApplication1\\web\\resizedImage.jpg");
        
        try {
            BufferedImage orignalImage = ImageIO.read(imageFile);

            BufferedImage resizedImage = Scalr.resize(orignalImage, Method.ULTRA_QUALITY, newHeight, newWidth);
            ImageIO.write(resizedImage, "png", outputFile);
        } catch (IOException ex) {
            Logger.getLogger(ImageResizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void resizeAndSave(String sourcePath, String destinationPath, int newWidth, int newHeight){

        try {
            Thumbnails.of(sourcePath)
                    .size(newWidth, newHeight)
                    .outputQuality(0.9)
                    .toFile(destinationPath);
        } catch (IOException ex) {
            Logger.getLogger(ImageResizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
