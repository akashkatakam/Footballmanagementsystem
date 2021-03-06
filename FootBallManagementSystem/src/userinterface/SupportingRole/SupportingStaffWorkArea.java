/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SupportingRole;

import Business.EcoSystem;
import Business.Model.Club;
import Business.Model.Player;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TrainingWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akash
 */
public class SupportingStaffWorkArea extends javax.swing.JPanel {
    private Club currentClub;
    private TrainingWorkRequest selectedWorkRequest;

    /**
     * Creates new form SupportingStaffWorkArea
     */
    public SupportingStaffWorkArea() {
        initComponents();
    }

    public SupportingStaffWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
        initComponents();
        Player p = (Player) account.getPerson();
        this.currentClub = p.getClub();
        jLabel2.setText(this.currentClub.getName());
        populateUpcomingMatches();
    }
    private void populateUpcomingMatches(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();    
        model.setRowCount(0);
        for(WorkRequest wr : this.currentClub.getSupporttingStaff().getWorkQueue().getWorkRequestList()){
            if(wr instanceof TrainingWorkRequest){
                Object[] row = new Object[6];
                TrainingWorkRequest trRequest = (TrainingWorkRequest) wr;
                if(!trRequest.getMatch().getAwayClub().getId().equals(this.currentClub.getId())){
                     row[0] =  trRequest.getMatch().getAwayClub();
                }else{
                     row[0] =  trRequest.getMatch().getHomeClub();
                }
                row[1] =  trRequest.getDribblingHours();          
                row[2] =  trRequest.getShootingours();
                row[3] =  trRequest.getDefensiveHours();
                row[4] =  trRequest.getFitnessHours();
                row[5] =  trRequest;
                model.addRow(row);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UpcomingMatch", "Dribbling (Hours)", "Shooting  (Hours)", "Defesive  (Hours)", "Fitness  (Hours)", "Passing  (Hours)"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton1.setText("Accept Work Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("Supporting Staff Work Area");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(92, 92, 92))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow>= 0){
            TrainingWorkRequest trWork =  (TrainingWorkRequest)  jTable1.getValueAt(selectedRow, 5);
            JOptionPane.showMessageDialog(null, "Training  Completed!");
            this.currentClub.getSupporttingStaff().getWorkQueue().getWorkRequestList().remove(trWork);
            populateUpcomingMatches();
            trWork.getMatch().setStatus("Training Finished");
        }else JOptionPane.showMessageDialog(null, "Please select a Match!");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
