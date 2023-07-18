
import comp_decomp.compressor;
import comp_decomp.decompressor;
import comp_decomp.compressor;
import comp_decomp.decompressor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setSize(1000, 700);
        this.getContentPane().setBackground(Color.yellow);
        this.setVisible(true);

        compressButton = new JButton("Compress File");
        compressButton.setBounds(400, 150, 200, 50);
        compressButton.addActionListener(this);
        this.add(compressButton);

        decompressButton = new JButton("Decompress File");
        decompressButton.setBounds(400, 250, 200, 50);
        decompressButton.addActionListener(this);
        this.add(decompressButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if (e.getSource() == decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}