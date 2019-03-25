package lesson_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSwingWindow {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends JFrame {
    JLabel lbName = new JLabel();
    JLabel lbSurname = new JLabel();
    public MyWindow() {
        setTitle("Test window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        EditWindow editWindow = new EditWindow(this);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int sizeWidth = 800;
        int sizeHeight = 600;

        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;

        setBounds(locationX, locationY, sizeWidth, sizeHeight);

        JPanel jPanel = new JPanel(new GridLayout(1,2));
        JButton jbtSend = new JButton("Edit");

        jPanel.add(lbName);
        jPanel.add(lbSurname);

        add(jPanel, BorderLayout.NORTH);
        add(jbtSend, BorderLayout.SOUTH);

        jbtSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editWindow.setVisible(true);
            }
        });
        setResizable(false);
        setVisible(true);
    }

    void setValue(String name, String surname){
        lbName.setText(" " + name);
        lbSurname.setText(" " + surname);
    }
}

class EditWindow extends JFrame{
    MyWindow window;
    public EditWindow(MyWindow window) {
        this.window=window;
        setTitle("Edit");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int sizeWidth = 600;
        int sizeHeight = 450;

        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;

        setBounds(locationX, locationY, sizeWidth, sizeHeight);

        JPanel jPanel = new JPanel(new GridLayout(1,2));
        JTextField lbName = new JTextField();
        JTextField lbSurname = new JTextField();

        JButton jbtSend = new JButton("Go");
        jPanel.add(lbName);
        jPanel.add(lbSurname);
        add(jPanel, BorderLayout.NORTH);
        add(jbtSend, BorderLayout.SOUTH);

        jbtSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setValue(lbName.getText(), lbSurname.getText());
                setVisible(false);

            }
        });
        setResizable(false);
    }
}