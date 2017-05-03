/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tien
 */
@XmlRootElement
public class ImageFile {
    private String fileName;
    private long lastModified;
    
    public ImageFile(){
    }
    
    public ImageFile(String fileName, long lastModified){
        this.fileName=fileName;
        this.lastModified=lastModified;
    }
    
    public void setFileName(String fileName){
        this.fileName=fileName;
    }
    
    public String getFileName(){
        return fileName;
    }
    
    public void setLastModified(long lastModified){
        this.lastModified=lastModified;
    }
    
    public long getLastModified(){
        return lastModified;
    }
}
