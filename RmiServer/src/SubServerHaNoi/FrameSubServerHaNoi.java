/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubServerHaNoi;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import rmiserver.*;

/**
 *
 * @author Administrator
 */
public class FrameSubServerHaNoi extends javax.swing.JFrame {

    private SubServerHaNoiImpl sshn;
    private ClientInterFace client;
    public ServerBackupInterface serverBK = null;
    private String timeBK;

    /**
     * Creates new form FrameSubServerHaNoi
     */
    public FrameSubServerHaNoi() {
        initComponents();
        this.setTitle("Server Hà Nội");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        timeBK = "23:59:00";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonStart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jKhungHienThi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListClient = new javax.swing.JList<>();
        jButtonClose = new javax.swing.JButton();
        jButtonSaoLuu = new javax.swing.JButton();
        jButtonXemLai = new javax.swing.JButton();
        jLabelTime = new javax.swing.JLabel();
        jHour = new javax.swing.JSpinner();
        jMinute = new javax.swing.JSpinner();
        jButtonDatGio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jKhungHienThi.setEditable(false);
        jKhungHienThi.setColumns(20);
        jKhungHienThi.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jKhungHienThi.setRows(5);
        jScrollPane1.setViewportView(jKhungHienThi);

        jListClient.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListClientValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListClient);

        jButtonClose.setText("X");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonSaoLuu.setText("Sao Lưu");
        jButtonSaoLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaoLuuActionPerformed(evt);
            }
        });

        jButtonXemLai.setText("Xem Các Bảng Sao Lưu");
        jButtonXemLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXemLaiActionPerformed(evt);
            }
        });

        jLabelTime.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabelTime.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTime.setToolTipText("");

        jHour.setModel(new javax.swing.SpinnerNumberModel(23, 0, 23, 1));

        jMinute.setModel(new javax.swing.SpinnerNumberModel(59, 0, 59, 1));

        jButtonDatGio.setText("Đặt giờ");
        jButtonDatGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDatGioActionPerformed(evt);
            }
        });

        jLabel2.setText("Giờ Hiện Tại :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSaoLuu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonXemLai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jHour, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDatGio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonSaoLuu, jButtonStart});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTime)
                            .addComponent(jMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDatGio)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonStart)
                            .addComponent(jButtonClose)
                            .addComponent(jButtonSaoLuu)
                            .addComponent(jButtonXemLai))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        try { //Hàm bắt đầu Server
            Registry r = LocateRegistry.createRegistry(1111);
            sshn = new SubServerHaNoiImpl(this);
            r.bind("rmi://localhost/HaNoi", sshn);
            JOptionPane.showMessageDialog(this, "Server Hà Nội đã sẵn sàng !.");
            jKhungHienThi.setText("Server Hà Nội đã sẵn sàng !");
            send("--------------------------------------------------------------------");
            setTimeBackup();
        } catch (RemoteException | AlreadyBoundException | HeadlessException e) {
        }
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jListClientValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListClientValueChanged
        if (!evt.getValueIsAdjusting()) {  // Hàm chọn Client trong danh sách
            try {
                client = sshn.getClientSubServer(jListClient.getSelectedIndex());
            } catch (RemoteException ex) {
                Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jListClientValueChanged

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        try { // Hàm xử lý đóng một client
            if (client != null) {
                client.closeChat();
                Date St = new Date(System.currentTimeMillis());
                String TimePenalty = St.getDate() + " " + (St.getMonth() + 1) + " " + (St.getYear() + 1900) + " " + (St.getHours()) + ":" + (St.getMinutes()) + ":" + (St.getSeconds());
                sshn.addClientCloseSubServer(client.getID() + "-" + TimePenalty);
                sshn.disClientSubServer(client);
                client = null;
                jListClient.clearSelection();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonDatGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDatGioActionPerformed
        // Hàm xử lý thời gian Sao lưu
        int h = Integer.parseInt(jHour.getValue().toString());
        int m = Integer.parseInt(jMinute.getValue().toString());
        String gio = "" + h, phut = "" + m;
        if (h < 10) {
            gio = "0" + h;
        }
        if (m < 10) {
            phut = "0" + m;
        }
        timeBK = gio + ":" + phut + ":00";
        JOptionPane.showMessageDialog(this, "Đặt giờ sao lưu thành công " + timeBK + " !");
    }//GEN-LAST:event_jButtonDatGioActionPerformed

    private void jButtonSaoLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaoLuuActionPerformed
        try {// Hàm sao lưu bằng tay
            if (!jKhungHienThi.getText().toString().equals("")) {
                if (serverBK == null) {
                    Registry r = LocateRegistry.getRegistry("localhost", 4444);
                    serverBK = (ServerBackupInterface) r.lookup("rmi://localhost/Backup");
                }
                byte[] utf8Bytes = jKhungHienThi.getText().getBytes("UTF16");
                String data = new String(utf8Bytes, "Cp1252");
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String time = sdf.format(date);
                if (serverBK.BackupData(time, data, sshn.getNameSubServer())) {
                    send("Hệ thống đã Sao Lưu  vào lúc :  " + date.toLocaleString() + "");
                    send("--------------------------------------------------------------------");
                    JOptionPane.showMessageDialog(this, "Sao Lưu thành công !");
                }
            }
        } catch (RemoteException | NotBoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSaoLuuActionPerformed

    private void jButtonXemLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXemLaiActionPerformed
        try { // Hàm gọi Form Xem lại các bảng Sao Lưu
            if (serverBK == null) {
                Registry r = LocateRegistry.getRegistry("localhost", 4444);
                serverBK = (ServerBackupInterface) r.lookup("rmi://localhost/Backup");
            }
            FrameViewBackup fvb = new FrameViewBackup(this);
            fvb.setVisible(true);
        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(this, "Không thể kết nối tới Server Backup !.");
            Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonXemLaiActionPerformed

    public void send(String x) { // Hàm hiển thị lên Khung Hiển Thị
        jKhungHienThi.append("\n" + x);
    }

    public void updateList(Vector v) throws RemoteException { // Hàm cập nhật danh sách Client
        DefaultListModel<String> listModel = new DefaultListModel();
        if (!v.isEmpty()) {
            Enumeration e = v.elements();
            while (e.hasMoreElements()) {
                ClientInterFace c = (ClientInterFace) e.nextElement();
                listModel.addElement("[" + c.getID() + "] - " + c.getUserName());
            }
            jListClient.setModel(listModel);
        } else {
            jListClient.setModel(listModel);
        }
    }

    public void setTimeBackup() {// Hàm setTimeBackup , Hàm Backup tự động
        Timer ti = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");// Định dạng ngày tháng Giờ:Phút:giây
                String timeHT = sdf.format(date);// Đặt thời gian hiện tại
                jLabelTime.setText(timeHT);// Hiện Thị Đồng Hồ Điện Tử
                if (timeHT.equals(timeBK)) {
                    try {
                        if (serverBK == null) { // Phương thức kết nối tới ServerBackup
                            Registry r = LocateRegistry.getRegistry("localhost", 4444);
                            serverBK = (ServerBackupInterface) r.lookup("rmi://localhost/Backup");
                        }
                        byte[] utf8Bytes = jKhungHienThi.getText().getBytes("UTF16");//lấy nội dung trong Khung Hiển Thị chuyển về mã UTF16
                        String data = new String(utf8Bytes, "Cp1252");//Dùng bộ mã Cp1252 chuyển về chuổi String
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String time = sdf1.format(date);
                        if (serverBK.BackupData(time, data, sshn.getNameSubServer())) {
                            send("Hệ thống đã Sao Lưu tự động vào lúc :  " + date.toLocaleString() + "");
                            send("--------------------------------------------------------------------");
                        }
                    } catch (RemoteException | NotBoundException | UnsupportedEncodingException ex) {
                        JOptionPane.showMessageDialog(jMinute, "Không thể kết nối tới Server Backup !.");
                        Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        ti.start();
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
            java.util.logging.Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSubServerHaNoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSubServerHaNoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDatGio;
    private javax.swing.JButton jButtonSaoLuu;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonXemLai;
    private javax.swing.JSpinner jHour;
    private javax.swing.JTextArea jKhungHienThi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JList<String> jListClient;
    private javax.swing.JSpinner jMinute;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}