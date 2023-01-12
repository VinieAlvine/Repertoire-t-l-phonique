
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Myfunc {
    
    public ImageIcon resizePic(String picPath,byte[]  BLOBpic, int wdth, int hgt){
        ImageIcon myImg;
        
        if(picPath != null ){
            myImg = new ImageIcon(picPath); } 
        else{
            myImg = new ImageIcon(BLOBpic); 
        }
        
        Image img = myImg.getImage().getScaledInstance( wdth, hgt, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }
    
    
     public String browseImage(JLabel lbl){
        
        String path = null ;
         
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
       
       // extention du fichier
       
       FileNameExtensionFilter fileFilter = new  FileNameExtensionFilter ( " *.Images","jpg", "png", "gif");
       filec.addChoosableFileFilter(fileFilter);
       
       int fileState = filec.showSaveDialog(null);
       
       // si l’utilisateur sélectionne un fichier 
       if(fileState == JFileChooser.APPROVE_OPTION){
           
           File selectedFile = filec.getSelectedFile();
           path = selectedFile.getAbsolutePath();
          // imagePth = path;
           // afficher l’image dans le jlabel en utilisant redimensionner l’image 
           
           lbl.setIcon(resizePic(path, null, lbl.getWidth(),lbl.getHeight()));
           //jLabelImage.setIcon(new ImageIcon(path));
       } 
       // si l’utilisateur annule
       else if(fileState == JFileChooser.CANCEL_OPTION) {
           
           System.out.println("Aucune image selectionée");
       }
           
           
            return path;
      
    }                                      
   
    
    }
    
    

