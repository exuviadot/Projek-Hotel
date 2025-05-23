/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelmanagementsystem;

import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author Bagaskara
 */
public class HotelManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        signup signupFrame = new signup();
        signupFrame.setPreferredSize(new Dimension(1366, 768));
        signupFrame.pack();
        signupFrame.setVisible(true);
        signupFrame.setLocationRelativeTo(null);
    }
    
}