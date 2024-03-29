package utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.coobird.thumbnailator.Thumbnails;




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
    
    public static void resizeAll(){
        String imageFolderPath = "C:\\img";
        File imageFolder = new File(imageFolderPath);
        File[] fileList = imageFolder.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if(!isThumbnail(fileList[i].getName()) && !thumbnailExists(imageFolderPath, fileList[i].getName())){
                ImageResizer.processThumbnail(imageFolderPath, fileList[i].getName());
            }
        }
    }
    
    /**
     * Method to create a thumbnail of an image, save it under thumbnail_<image name> in the same folder.
     * 
     * @param folderPath folder of the original image, thumbnail will be saved in this as well
     * @param fileName file name of the image to be processed, including extension.
     */
    public static void processThumbnail(String folderPath, String fileName){
        String sourcePath=folderPath+"\\"+fileName;
        String destinationPath=folderPath+"\\thumbnail_"+fileName;
        
        if(!isThumbnail(fileName) && !thumbnailExists(folderPath, fileName)){
            int newWidth = 600;
            int newHeight = 450;
            resizeAndSave(sourcePath, destinationPath, newWidth, newHeight);
        }
    }
    
    private static boolean thumbnailExists(String folderPath, String fileName){
        String destinationPath=folderPath+"\\thumbnail_"+fileName;
        File thumbnailFile=new File(destinationPath);
        if(thumbnailFile.exists()){
            return true;
        }else{
            System.out.println(fileName);
            return false;
        }
    }
    
    private static boolean isThumbnail(String fileName){
        System.out.println(fileName.substring(0, 10));
        return (fileName.substring(0, 10).equals("thumbnail_"));
    }
    
    /**
     * 
     * @param sourcePath path of original image file, including file name & extension
     * @param destinationPath path to save thumbnail, including file name & extension
     * @param newWidth
     * @param newHeight 
     */
    private static void resizeAndSave(String sourcePath, String destinationPath, int newWidth, int newHeight){
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
