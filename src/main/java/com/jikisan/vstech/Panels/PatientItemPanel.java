
package com.jikisan.vstech.Panels;

import com.jikisan.vstech.Forms.Dashboard;
import com.jikisan.vstech.Forms.Homepage;
import com.jikisan.vstech.Model.ActivePatient;
import com.jikisan.vstech.Model.PatientModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import javax.swing.*;

public class PatientItemPanel extends JPanel{

    private JLabel iconLabel;

    public PatientItemPanel(PatientModel patientModel, JFrame parentFrame) {

        String userDir = System.getProperty("user.dir");
        String imagePath = userDir + "\\src\\main\\java\\Images\\user.png"; // Modify as needed
        System.out.println(imagePath);
        ImageIcon icon = new ImageIcon(imagePath);

        iconLabel = new JLabel();
        iconLabel.setSize(50, 50);
        iconLabel.setMaximumSize(new Dimension(50, 50));
        iconLabel.setMinimumSize(new Dimension(50, 50));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setVerticalAlignment(SwingConstants.CENTER);
        iconLabel.setHorizontalTextPosition(JLabel.CENTER);
        iconLabel.setVerticalTextPosition(JLabel.BOTTOM);
        iconLabel.setText(patientModel.getName().toUpperCase(Locale.ROOT));
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
//        add(label, BorderLayout.CENTER);

        // Example mouse listener to handle interactions
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ActivePatient.getInstance().setPatient(patientModel);
                System.out.println(patientModel.getDates());

                new Homepage(patientModel).setVisible(true);
                parentFrame.dispose();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
