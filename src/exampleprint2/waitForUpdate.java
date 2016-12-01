/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleprint2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eudy
 */
public class waitForUpdate extends Thread{
    
    private Boolean wait;
    private AdminTheme adminTheme;
    private int selectImg;
    
    public waitForUpdate(AdminTheme adminTheme){
        this.adminTheme = adminTheme;
        this.selectImg = 1;
    }
    public waitForUpdate(AdminTheme adminTheme,int selectImg){
        this.adminTheme = adminTheme;
        this.selectImg = selectImg;
    }
    
    public void run(){
         viewSelectFile chooser = new viewSelectFile();
        chooser.setVisible(true);
        this.wait =chooser.getWait();
        while(this.wait){
             try {
                 Thread.sleep(10000);
                 this.wait =chooser.getWait();
             } catch (InterruptedException ex) {
                 Logger.getLogger(waitForUpdate.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        String path = chooser.getNameFile();
        this.assignImg( path);
        chooser.dispose();
        this.adminTheme.restartWillClick();
    }
    
    public void assignImg(String path){

        switch( this.selectImg){
            case 1:
            //  this.adminTheme.setImage1(path);
            break;
            case 2:
              this.adminTheme.setImage2(path);
            break;
            case 3:
              this.adminTheme.setImage3(path);
            break;
        }
    }
}
