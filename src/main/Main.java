/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import ruang.Balok;
import bidang.PersegiPanjang;
import java.awt.event.*; 
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author MSI1
 */
public class Main {
    public static void main(String[] args) {
         GUI g = new GUI();
    } 
}

class GUI extends JFrame implements ActionListener{
    JTextField fPanjang = new JTextField(10);
    JTextField fLebar = new JTextField(10);
    JTextField fTinggi = new JTextField(10);
    
    JLabel lTitle = new JLabel("Kalkulator Balok");
    JLabel lPanjang = new JLabel("Panjang");
    JLabel lLebar = new JLabel("Lebar");
    JLabel lTinggi = new JLabel("Tinggi");
    
    JButton btnHitung = new JButton("Hitung");
    JButton btnReset = new JButton("Reset");
        
    JLabel hasil = new JLabel("Hasil :");
    JLabel tulisLuas = new JLabel("");
    JLabel tulisKeliling = new JLabel("");
    JLabel tulisVolume = new JLabel("");
    JLabel tulisLuasP = new JLabel("");
    JLabel hasilLuas = new JLabel("");
    JLabel hasilKeliling = new JLabel("");
    JLabel hasilVolume = new JLabel("");
    JLabel hasilLuasP = new JLabel("");
    
    Balok balok = new Balok(0,0,0);
    PersegiPanjang persegiPanjang = new PersegiPanjang(0,0);
    
    public GUI(){
        setTitle("Kalkulator Balok");
        setDefaultCloseOperation(3);
        setSize(400,550);   
        setLayout(null);
        
        add(lTitle);
        add(lPanjang);
        add(fPanjang);
        add(lLebar);
        add(fLebar);
        add(lTinggi);
        add(fTinggi);
        add(btnHitung);
        add(btnReset);
        add(hasil);
        add(tulisLuas);
        add(tulisKeliling);
        add(tulisVolume);
        add(tulisLuasP);
        add(hasilLuas);
        add(hasilKeliling);
        add(hasilVolume);
        add(hasilLuasP);
        
        lTitle.setBounds(150,20,200,10);
        lPanjang.setBounds(50,70,100,20);
        fPanjang.setBounds(140,70,200,20);
        lLebar.setBounds(50,130,100,20);
        fLebar.setBounds(140,130,200,20);
        lTinggi.setBounds(50,190,100,20);
        fTinggi.setBounds(140,190,200,20);
        btnHitung.setBounds(80,480,100,20);
        btnReset.setBounds(220,480,100,20);
        
        btnHitung.addActionListener(this); 
        btnReset.addActionListener(this);
        
        hasil.setBounds(140,220,200,20);
        tulisLuas.setBounds(50,280,200,20);
        hasilLuas.setBounds(300,280,300,20);
        tulisKeliling.setBounds(50,320,200,20);
        hasilKeliling.setBounds(300,320,300,20);
        tulisVolume.setBounds(50,360,200,20);
        hasilVolume.setBounds(300,360,300,20);
        tulisLuasP.setBounds(50,400,200,20);
        hasilLuasP.setBounds(300,400,300,20);
        setVisible(true);  
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnHitung){
            try{
                persegiPanjang.setPanjang(Integer.parseInt(fPanjang.getText()));
                persegiPanjang.setLebar(Integer.parseInt(fLebar.getText()));
                balok.setTinggi(Integer.parseInt(fTinggi.getText()));
                
                PersegiPanjang hitungPP = new PersegiPanjang(persegiPanjang.getPanjang(),persegiPanjang.getLebar());
                Balok hitungB = new Balok(persegiPanjang.getPanjang(),persegiPanjang.getLebar(),balok.getTinggi());
                
                tulisLuas.setText("Luas Persegi Panjang : ");
                hasilLuas.setText(String.format(" %.1f",hitungPP.hitungLuas()));
                tulisKeliling.setText("Keliling Persegi Panjang : ");
                hasilKeliling.setText(String.format(" %.1f",hitungPP.hitungKeliling()));
                tulisVolume.setText("Volume Balok : ");
                hasilVolume.setText(String.format(" %.1f",hitungB.hitungVolume()));
                tulisLuasP.setText("Luas Permukaan Balok : ");
                hasilLuasP.setText(String.format(" %.1f",hitungB.hitungLuasPermukaan())); 
            }
            catch(NullPointerException error){
                showMessageDialog(null,error.getMessage());
            }  
            catch(NumberFormatException error){
                showMessageDialog(null,error.getMessage());
            }
        }
        if(e.getSource()==btnReset){ 
            fPanjang.setText("");
            fLebar.setText("");
            fTinggi.setText("");
            tulisLuas.setText("");
            tulisKeliling.setText("");
            tulisVolume.setText("");
            tulisLuasP.setText("");
            hasilLuas.setText("");
            hasilKeliling.setText("");
            hasilVolume.setText("");
            hasilLuasP.setText("");
        }
    }
}

 
