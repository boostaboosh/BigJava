import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class IconTest
{
    public static void main(String[] args) throws MalformedURLException {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());

        ImageIcon pizzaIcon = new ImageIcon(new URL("https://imgs.search.brave.com/AV6c9DfjmMq2scoswldFuTWMuY80gbIoUFaDkCC5_q0/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly90NC5m/dGNkbi5uZXQvanBn/LzEyLzEyLzM2LzI3/LzM2MF9GXzEyMTIz/NjI3MzRfV3BjTW1H/a3F1M2ZOV3B4ejIw/OHVUU0NyaG9Bbm1z/VzcuanBn"));
        pizzaIcon = new ImageIcon(pizzaIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        ImageIcon catIcon = new ImageIcon(new ImageIcon(new URL("https://imgs.search.brave.com/WOhQEFTPBl8FtZ5mAn_owpNyMoVJ3CRe8t1bTSvBlCw/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9henVy/ZTIud2dwLWNkbi5j/by51ay9hcHAteW91/cmNhdC9wb3N0cy9j/cmVhdGUtYS1jYXQt/ZnJpZW5kbHktZ2Fy/ZGVuLmpwZz8md2lk/dGg9NzAwJmhlaWdo/dD00MjAmYmdjb2xv/cj1mZmZmZmYmbW9k/ZT1jcm9wJnNjYWxl/PWJvdGgmZm9ybWF0/PXdlYnAmd2VicC5x/dWFsaXR5PTQw")).getImage().getScaledInstance(32,32,Image.SCALE_DEFAULT));

        JRadioButton radioButton = new JRadioButton("radio button");
        radioButton.setIcon(pizzaIcon);
        radioButton.setSelectedIcon(catIcon);
        radioButton.setBorderPainted(true);
        radioButton.setContentAreaFilled(true);
        radioButton.setFocusPainted(true);

        JCheckBox checkBox = new JCheckBox("checkbox", catIcon);
        checkBox.setSelectedIcon(pizzaIcon);
        checkBox.setBorderPainted(true);
        checkBox.setFocusPainted(true);

        JComboBox<ImageIcon> comboBox = new JComboBox<>();
        comboBox.addItem(catIcon);
        comboBox.addItem(pizzaIcon);

        panel.add(radioButton, BorderLayout.WEST);
        panel.add(checkBox, BorderLayout.CENTER);
        panel.add(comboBox, BorderLayout.EAST);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(new JLabel(pizzaIcon), BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
    }
}