package GUI;

import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Mateusz
 */
public class DataPanel extends javax.swing.JPanel {

    File inputFile;
    File outputFile;

    public DataPanel() {
        initComponents();
        jTextFieldInputFilePath.setEditable(false);
        jTextFieldOutputFilePath.setEditable(false);
    }

    public int getdt() throws IllegalArgumentException {
        int ret;
        try {
            ret = Integer.parseInt(jTextField2.getText());
            if (ret <= 0) {
                throw new IllegalArgumentException("Wpisałeś ujemny krok czasowy.");
            }
        } catch (NumberFormatException e) {
            String exceptionmessage;
            if (jTextField2.getText().isEmpty()) {
                exceptionmessage = "Nie wpisałeś długości kroku czasowego.";
            } else {
                exceptionmessage = "Wpisałeś niepoprawną długość kroku czasowego.";
            }
            throw new IllegalArgumentException(exceptionmessage);
        }
        if (jRadioButtonStepSec.isSelected()) {
            return ret;
        } else if (jRadioButtonStepMin.isSelected()) {
            return ret * 60;
        } else if (jRadioButtonStepHour.isSelected()) {
            return ret * 60 * 60;
        } else if (jRadioButtonStepDay.isSelected()) {
            return ret * 60 * 60 * 24;
        } else {
            throw new IllegalArgumentException("Nie wybrałeś jednostki czasu kroku czasowego.");
        }
    }

    public int getSimLength() throws IllegalArgumentException {
        int ret;
        try {
            ret = Integer.parseInt(jTextField3.getText());
            if (ret <= 0) {
                throw new IllegalArgumentException("Wpisałeś ujemną długość symulacji.");
            }
        } catch (NumberFormatException e) {
            String exceptionmessage;
            if (jTextField3.getText().isEmpty()) {
                exceptionmessage = "Nie wpisałeś długości symulacji.";
            } else {
                exceptionmessage = "Wpisałeś niepoprawną długość symulacji.";
            }
            throw new IllegalArgumentException(exceptionmessage);
        }
        if (jRadioButtonSimSec.isSelected()) {
            ;
        } else if (jRadioButtonSimMin.isSelected()) {
            ret *= 60;
        } else if (jRadioButtonSimHour.isSelected()) {
            ret *= 60 * 60;
        } else if (jRadioButtonSimDay.isSelected()) {
            ret *= 60 * 60 * 24;
        } else {
            throw new IllegalArgumentException("Nie wybrałeś jednostki czasu długości symulacji.");
        }
        if (getdt() > ret) {
            throw new IllegalArgumentException("Krok symulacji nie moze byc wiekszy od czasu calkowitej symulacji.");
        }
        return ret;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldInputFilePath = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jRadioButtonStepSec = new javax.swing.JRadioButton();
        jRadioButtonStepMin = new javax.swing.JRadioButton();
        jRadioButtonStepHour = new javax.swing.JRadioButton();
        jRadioButtonStepDay = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jRadioButtonSimSec = new javax.swing.JRadioButton();
        jRadioButtonSimMin = new javax.swing.JRadioButton();
        jRadioButtonSimHour = new javax.swing.JRadioButton();
        jRadioButtonSimDay = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldOutputFilePath = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jPanel1.setToolTipText("");

        jLabel1.setText("Input File");

        jTextFieldInputFilePath.setFocusable(false);
        jTextFieldInputFilePath.setName(""); // NOI18N

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldInputFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldInputFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Step Length"));

        jRadioButtonStepSec.setText("sec");
        jRadioButtonStepSec.setFocusable(false);
        jRadioButtonStepSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStepSecActionPerformed(evt);
            }
        });

        jRadioButtonStepMin.setText("min");
        jRadioButtonStepMin.setFocusable(false);
        jRadioButtonStepMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStepMinActionPerformed(evt);
            }
        });

        jRadioButtonStepHour.setText("hour");
        jRadioButtonStepHour.setFocusable(false);
        jRadioButtonStepHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStepHourActionPerformed(evt);
            }
        });

        jRadioButtonStepDay.setText("day");
        jRadioButtonStepDay.setFocusable(false);
        jRadioButtonStepDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStepDayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonStepSec)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonStepMin)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonStepHour)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonStepDay))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonStepSec)
                    .addComponent(jRadioButtonStepMin)
                    .addComponent(jRadioButtonStepHour)
                    .addComponent(jRadioButtonStepDay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Simulation Length"));

        jRadioButtonSimSec.setText("sec");
        jRadioButtonSimSec.setFocusable(false);
        jRadioButtonSimSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSimSecActionPerformed(evt);
            }
        });

        jRadioButtonSimMin.setText("min");
        jRadioButtonSimMin.setFocusable(false);
        jRadioButtonSimMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSimMinActionPerformed(evt);
            }
        });

        jRadioButtonSimHour.setText("hour");
        jRadioButtonSimHour.setFocusable(false);
        jRadioButtonSimHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSimHourActionPerformed(evt);
            }
        });

        jRadioButtonSimDay.setText("day");
        jRadioButtonSimDay.setFocusable(false);
        jRadioButtonSimDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSimDayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonSimSec)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonSimMin)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonSimHour)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonSimDay))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonSimSec)
                    .addComponent(jRadioButtonSimMin)
                    .addComponent(jRadioButtonSimHour)
                    .addComponent(jRadioButtonSimDay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(79, 52));

        jLabel2.setText("Output File");

        jTextFieldOutputFilePath.setFocusable(false);

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextFieldOutputFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOutputFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.removeChoosableFileFilter(fc.getFileFilter());
        fc.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        FileFilter ff = new FileFilter() {
            @Override
            public boolean accept(File f) {
                String str = f.getName();
                int pos = str.lastIndexOf(".");
                return pos == -1;
            }

            @Override
            public String getDescription() {
                return "Without extensions";
            }
        };
        fc.addChoosableFileFilter(ff);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selected = fc.getSelectedFile();
            if (fc.accept(selected) && selected.exists()) {
                inputFile = selected;
                jTextFieldInputFilePath.setText(inputFile.getName());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButtonStepSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStepSecActionPerformed
        jRadioButtonStepMin.setSelected(false);
        jRadioButtonStepHour.setSelected(false);
        jRadioButtonStepDay.setSelected(false);
    }//GEN-LAST:event_jRadioButtonStepSecActionPerformed

    private void jRadioButtonStepMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStepMinActionPerformed
        jRadioButtonStepSec.setSelected(false);
        jRadioButtonStepHour.setSelected(false);
        jRadioButtonStepDay.setSelected(false);
    }//GEN-LAST:event_jRadioButtonStepMinActionPerformed

    private void jRadioButtonStepHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStepHourActionPerformed
        jRadioButtonStepSec.setSelected(false);
        jRadioButtonStepMin.setSelected(false);
        jRadioButtonStepDay.setSelected(false);
    }//GEN-LAST:event_jRadioButtonStepHourActionPerformed

    private void jRadioButtonStepDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStepDayActionPerformed
        jRadioButtonStepSec.setSelected(false);
        jRadioButtonStepMin.setSelected(false);
        jRadioButtonStepHour.setSelected(false);
    }//GEN-LAST:event_jRadioButtonStepDayActionPerformed

    private void jRadioButtonSimSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSimSecActionPerformed
        jRadioButtonSimMin.setSelected(false);
        jRadioButtonSimHour.setSelected(false);
        jRadioButtonSimDay.setSelected(false);
    }//GEN-LAST:event_jRadioButtonSimSecActionPerformed

    private void jRadioButtonSimMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSimMinActionPerformed
        jRadioButtonSimSec.setSelected(false);
        jRadioButtonSimHour.setSelected(false);
        jRadioButtonSimDay.setSelected(false);
    }//GEN-LAST:event_jRadioButtonSimMinActionPerformed

    private void jRadioButtonSimHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSimHourActionPerformed
        jRadioButtonSimSec.setSelected(false);
        jRadioButtonSimMin.setSelected(false);
        jRadioButtonSimDay.setSelected(false);
    }//GEN-LAST:event_jRadioButtonSimHourActionPerformed

    private void jRadioButtonSimDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSimDayActionPerformed
        jRadioButtonSimSec.setSelected(false);
        jRadioButtonSimMin.setSelected(false);
        jRadioButtonSimHour.setSelected(false);
    }//GEN-LAST:event_jRadioButtonSimDayActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.removeChoosableFileFilter(fc.getFileFilter());
        fc.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        File file = new File(fc.getCurrentDirectory().getAbsolutePath() + "/untitled.txt");
        for (int i = 1; file.exists(); i++) {
            file = new File(fc.getCurrentDirectory().getAbsolutePath() + "/untitled" + i + ".txt");
        }
        fc.setSelectedFile(file);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selected = fc.getSelectedFile();
            if (fc.accept(selected)) {
                outputFile = selected;
                jTextFieldOutputFilePath.setText(outputFile.getName());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonSimDay;
    private javax.swing.JRadioButton jRadioButtonSimHour;
    private javax.swing.JRadioButton jRadioButtonSimMin;
    private javax.swing.JRadioButton jRadioButtonSimSec;
    private javax.swing.JRadioButton jRadioButtonStepDay;
    private javax.swing.JRadioButton jRadioButtonStepHour;
    private javax.swing.JRadioButton jRadioButtonStepMin;
    private javax.swing.JRadioButton jRadioButtonStepSec;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldInputFilePath;
    private javax.swing.JTextField jTextFieldOutputFilePath;
    // End of variables declaration//GEN-END:variables
}