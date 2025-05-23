/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAOdatauser.datauserDAO;
import DAOImplement.datauserimplement;
import model.*;
import hotelmanagementsystem.signup;
import hotelmanagementsystem.login;
import javax.swing.JOptionPane;
import java.sql.*;
import pj.connector;


public class datausercontroller {
    private signup signupFrame;
    private login loginFrame;
    private datauserimplement impldatauser;
    private List<dataUser> dataUserList;

    public datausercontroller(signup signupFrame) {
        this.signupFrame = signupFrame;
        this.impldatauser = new datauserDAO();
    }
    
    public datausercontroller(login loginFrame){
        this.loginFrame = loginFrame;
        this.impldatauser = new datauserDAO();
    }
    
    public void signup() {
        try{
            // Validasi input
            String username = signupFrame.getJTxtUsername().getText().trim();
            String email = signupFrame.getJTxtEmail().getText().trim();
            String password = new String(signupFrame.getjPasswordField().getPassword()).trim();

            if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            dataUser user = new dataUser();
            user.setUsername(username);
            user.setEmail_user(email);
            user.setPassword_user(password);
            
            impldatauser.signup(user);
            
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void login(){
        String username = loginFrame.getjTxtUsername().getText().trim();
        String password = loginFrame.getjTxtPassword().getText().trim();

        if(username.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dataUser user = new dataUser();
        user.setUsername(username);
        user.setPassword_user(password);

        if(impldatauser.login(user)){
            JOptionPane.showMessageDialog(null, "Login berhasil.");
            // lanjut ke frame utama
            // new MainFrame().setVisible(true);
            // loginFrame.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Username atau Password Salah!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
