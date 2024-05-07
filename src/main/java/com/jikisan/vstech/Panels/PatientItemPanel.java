
package com.jikisan.vstech.Panels;

import com.jikisan.vstech.Model.PatientModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PatientItemPanel extends JPanel{

    private JLabel label, iconLabel;

    public PatientItemPanel(PatientModel patientModel) {

        String userDir = System.getProperty("user.dir");
        String imagePath = userDir + "src/main/java/com/jikisan/vstech/Images/user.png"; // Modify as needed
        System.out.println(imagePath);
        ImageIcon icon = new ImageIcon(imagePath);

        this.label = new JLabel(patientModel.getName());
        label.setSize(100, 100);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        iconLabel = new JLabel();
        iconLabel.setSize(50, 50);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setIcon(icon);



        // Set up the panel's layout and components
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setMinimumSize(new Dimension(150, 150));
        setMaximumSize(new Dimension(150, 150));
        setPreferredSize(new Dimension(150, 150));
        setSize(new Dimension(150, 150));

        // Add icon and label to the panel
        add(iconLabel, BorderLayout.CENTER);
        add(label, BorderLayout.CENTER);

        // Example mouse listener to handle interactions
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Custom behavior on click
                System.out.println("Panel clicked: " + patientModel.getName());
            }
        });
    }

    public void setLabelText(String text) {
        this.label.setText(text); // Allow changing the label text
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
