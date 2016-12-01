/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleprint2;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Eudy
 */
public class AdminTheme extends javax.swing.JFrame {

    String pathImagen1 = "";
    String pathImagen2 = "";
    String pathImagen3 = "";
    private String headBody ="<html><head></head><body><p>";//"<html><head></head><body><pre>"
    private String footerBody ="</p></body></html>";//"</pre></body></html>"
    private AdminTheme thisClass;
    private Boolean willClick = true;

    /**
     * Creates new form AdminTheme
     */
    public AdminTheme() {
        initComponents();
        this.ponerIconoJFrame();
    }
    
    public void ponerIconoJFrame(){
       ImageIcon imagen = new ImageIcon(getClass().getResource("/img/iconoapp.jpg")); 
       this.setIconImage(imagen.getImage());
    }
    
    public String organizarTextoBody(String text){
        String newText = "";
        boolean entregarLinea = true;
        try {
             //System.out.println( text /*this.jTextArea1.getSelectedText()*/);
            System.out.println(  text);
            String[] lineas = text/*this.jTextArea1.getText()*/.split("\n");
            
            int totalCaracteres = 74;
            for(int i = 0 ; i < lineas.length/*this.jTextArea1.getLineCount()*/ ; i++){
                 entregarLinea = true;
                System.out.println("Entro en el for");
                if(lineas[i].length() >= totalCaracteres){
                     System.out.println("entrar en el if si es mayor a x");
                    int dividir = lineas[i].length() /totalCaracteres;
                    for(int c = 0 ; c < dividir ; c++){
                      //  newText += lineas[i].substring(c, (totalCaracteres * (c+1)))+"<br/>";  
                    newText += lineas[i].substring((totalCaracteres * c), (totalCaracteres * (c+1)))+"<br/>";   

                    }
                    
                     //System.out.println(newText);
                     //System.out.println( dividir+"Linea "+i+" "+lineas[i].length()+" -| "+lineas[i] );
                      entregarLinea = false;
                }
                if(entregarLinea){
                 newText += lineas[i]+"<br/>";
                
                }
               // System.out.println( "Linea "+i+" -| "+lineas[i] );
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return newText ;
    }
  /*  public void setImage1(String path){
        this.pathImagen1 = path;
        this.ScaleImage(this.jLabel1,path);
        System.out.println(this.pathImagen1);
    }*/
    public void setImage2(String path){
        this.pathImagen2 = path;
        this.ScaleImage(this.jLabel2,path);
        System.out.println(this.pathImagen2);
    }
    public void setImage3(String path){
        this.pathImagen3 = path;
        this.ScaleImage(this.jLabel3,path);
        System.out.println(this.pathImagen3);
    }
    public void ScaleImage(JLabel jLabel,String path){
        try{
            jLabel.setText("");
            ImageIcon imagen = new ImageIcon(path); 
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(jLabel.getWidth(),jLabel.getHeight(),Image.SCALE_DEFAULT));
            //Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(this.jLabel1.getWidth(),this.jLabel1.getHeight(),Image.SCALE_DEFAULT)); 
            jLabel.setIcon(icono); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error "+e);
        }
    }
    
    public boolean esvacio(JTextField s,String campo){
        if(s.getText().isEmpty()){
            int dialogResult = JOptionPane.showConfirmDialog (null, "El campo "+campo+" esta vacio, desea continuar?","Warning",JOptionPane.YES_NO_OPTION);
           if(dialogResult == JOptionPane.YES_OPTION){
               s.setText(" ");
               return false;
            }else{
               return true;
           }
            //JOptionPane.showMessageDialog(null, "El campo "+campo+" esta vacio");
           
        }else{
            return false;
        }
    }
    public boolean esvacio(JTextArea s,String campo){
        if(s.getText().isEmpty()){
            int dialogResult = JOptionPane.showConfirmDialog (null, "El campo "+campo+" esta vacio, desea continuar?","Warning",JOptionPane.YES_NO_OPTION);
           if(dialogResult == JOptionPane.YES_OPTION){
               s.setText(" ");
               return false;
            }else{
               return true;
           }
            //JOptionPane.showMessageDialog(null, "El campo "+campo+" esta vacio");
           
        }else{
            return false;
        }
    }
    
    public boolean validarVacios(){
        if(esvacio(this.jTextField1,"Numero examen fisico")){
            return true;
        }
        if(esvacio(this.jTextField2,"Médico legista")){
            return true;
        }
        if(esvacio(this.jTextField3,"Exequátur No.")){
            return true;
        }
        if(esvacio(this.jTextField4,"Acta No.")){
            return true;
        }
        /*if(esvacio(this.jTextField5,"Fecha")){
            return true;
        }*/
        if(esvacio(this.jTextField6,"Persona afectada")){
            return true;
        }
        if(esvacio(this.jTextField7,"Cedula")){
            return true;
        }
       /* if(esvacio(this.jTextField8,"OTROS No.")){
            return true;
        }*/
        if(esvacio(this.jTextField9,"Edad")){
            return true;
        }
        if(esvacio(this.jTextField10,"Dominiciliado en")){
            return true;
        }
        if(esvacio(this.jTextField11,"Estado afectado")){
            return true;
        }
        if(esvacio(this.jTextArea1,"Diagnóstico")){
            return true;
        }
        if(esvacio(this.jTextField12,"Conclusiones")){
            return true;
         
        }
        if(esvacio(this.jTextField13,"Fecha en la parte de abajo")){
            return true;
            
        }
        if(esvacio(this.jTextField5,"Hora")){
            return true;
            
        }
            return false;
       
    }
    
    
    public void printIntoTheme(){
         if(!this.validarVacios()){
        View4 v = new View4();
        v.setImage1(pathImagen1, pathImagen2, pathImagen3);
        String body = organizarTextoBody(this.jTextArea1.getText());
        System.out.println(body);
        body= this.headBody+" "+body+" "+this.footerBody;
        System.out.println(body);
        v.setTexts(this.jTextField1.getText().toString(), this.jTextField2.getText().toString(), this.jTextField3.getText().toString(), this.jTextField4.getText().toString(), this.jTextField6.getText().toString(), this.jTextField7.getText().toString(), this.jTextField9.getText().toString(), this.jTextField10.getText().toString(), this.jTextField11.getText().toString(), this.jTextField12.getText().toString(), this.jTextField13.getText().toString(), body,this.jTextField5.getText().toString());
        v.setVisible(true);
        v.createPrint();
         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Certificado Medico Legal");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click para agregar imagen2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Click para agregar imagen3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jTextField1.setText("644-601");

        jTextField2.setText("EDWIN JESUS PEÑA URBAEZ");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("5066");

        jTextField4.setText("De la Procuraduría ");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField6.setText("DENCY JUNIOR HERNANDEZ CORDERO");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setText("223-0129027-0");

        jTextField9.setText("13");

        jTextField10.setText("C/ RESPP. GRAL. RODRIGUEZ REYES N. 62 P/A ARROTO HONDO");

        jTextField11.setText("AMBULATORIO");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("HOMOLOGAMOS DIAGNOSTICO DEL HOSPITAL \nREGIONAL GRAL. DR. MARCELINO VÉLEZ \nSANTANA DE DR. RAFAEL DE LOS SANTOS \nEXEQUATUR NO. 00-00, DE FECHA 17/07/2015:\n   \n1.- FRACTURA DE CLAVICULA DERECHA. \n2.- FRACTURA DE CODO IZQUIERDO. \n3.- FRACTURA CON EDEMA CRANEAL.  \n4.- TRAUMA LUMBAR. RADIOGRAFICAMENTE \nSE OBSERVAN LESIONES OSEAS EN \nCLVICULA DERECHA Y CODO IZQUIERDO.");
        jScrollPane1.setViewportView(jTextArea1);

        jTextField12.setText("LESIONES CURABLES DE 2 A 3 MESES.-");
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jTextField13.setText("lunes, 20 de julio de 2015");

        jButton1.setText("Imprimir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel4.setText("Numero examen fisico");

        jLabel5.setText("Médico legista");

        jLabel6.setText("Exequátur No.");

        jLabel7.setText("Requerimiento de");

        jLabel9.setText("Persona afectada");

        jLabel10.setText("Cedula");

        jLabel12.setText("Edad");

        jLabel13.setText("Dominiciliado en");

        jLabel14.setText("Estado afectado");

        jLabel15.setText("Diagnóstico");

        jLabel16.setText("Conclusiones");

        jLabel17.setText("Fecha");

        jButton2.setText("Limpiar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel8.setText("Hora");

        jTextField5.setText("a las 15:56:41 horas  .");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addComponent(jTextField6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel12)
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField12)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        if(willClick){
            waitForUpdate startChooser = new waitForUpdate(this.thisClass,2);
            startChooser.start();
            willClick = false;
       }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        if(willClick){
            waitForUpdate startChooser = new waitForUpdate(this.thisClass,3);
            startChooser.start();
            willClick = false;
       }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.printIntoTheme();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.emtpyAll();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    public void emtpyAll(){
        this.jTextField1.setText("");this.jTextField2.setText("");this.jTextField3.setText("");
        this.jTextField4.setText("");this.jTextField6.setText("");
        this.jTextField7.setText("");this.jTextField9.setText("");
        this.jTextField10.setText("");this.jTextField11.setText("");this.jTextField12.setText("");
        this.jTextField13.setText("");this.jTextArea1.setText("");
        this.jTextField5.setText("");
       // this.jLabel1.setIcon(null);
        //this.jLabel1.setText("Click para agregar imagen1");
        this.jLabel3.setIcon(null);        this.jLabel3.setText("Click para agregar imagen3");

        this.jLabel2.setIcon(null);
                this.jLabel2.setText("Click para agregar imagen2");


    }
    public void restartWillClick(){
        this.willClick = true;
    }
    
    public void setThisClass(AdminTheme thisClass){
        this.thisClass = thisClass;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminTheme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminTheme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminTheme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminTheme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               AdminTheme admin = new AdminTheme();
               admin.setThisClass(admin);
               admin.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
