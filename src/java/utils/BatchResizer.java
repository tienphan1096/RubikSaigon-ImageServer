/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;

/**
 *
 * @author Tien
 */
public class BatchResizer {
    public static void main(String[] args){
        String imageFolderPath="C:\\img";
        File imageFolder=new File(imageFolderPath);
        File[] fileList=imageFolder.listFiles();
        for(int i=0;i<fileList.length;i++){
            ImageResizer.processThumbnail(imageFolder.getAbsolutePath(), fileList[i].getName());
        }
    }
}
