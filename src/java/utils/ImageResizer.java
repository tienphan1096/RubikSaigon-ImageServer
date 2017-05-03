
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
