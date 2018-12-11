/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StadiumManager;

import Business.EcoSystem;
import Business.Model.GroundStaff;
import Business.Model.Owner;
import Business.Model.Stadium;
import Business.Model.TicketSeller;
import Business.Organization.Organization;
import Business.Role.GroundStaffManagerRole;
import Business.Role.TicketSellerRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.GroundStaffWorkRequest;
import Business.WorkQueue.MatchWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nikitagawde
 */

public class StadiumManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StadiumManagerWorkAreaJPanel
     */
    private EcoSystem system;
    private Stadium stadium;
    private MatchWorkRequest matchWorkRequest;
    private CardLayout layout;
    
    
    public StadiumManagerWorkAreaJPanel() {
        initComponents();
    }

    public StadiumManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
        initComponents();
        this.system = business;
        Owner o = (Owner) account.getPerson();
        this.layout = (CardLayout) this.getLayout();
        stadium = o.getStadium();
        populatTypeComboBox();
        populateUpcomingMatchesTable();
        
    }
    public void populatTypeComboBox(){
        jComboBox2.removeAllItems();
        jComboBox2.addItem(GroundStaffWorkRequest.RequestType.CateringServices);
        jComboBox2.addItem(GroundStaffWorkRequest.RequestType.GrassMaintenance);
        jComboBox2.addItem(GroundStaffWorkRequest.RequestType.Lighting);
        jComboBox2.addItem(GroundStaffWorkRequest.RequestType.Painting);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StadiumManagerJpanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        createRequest = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        GroundStaffJPanel = new javax.swing.JPanel();
        passwordJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        backjButton1 = new javax.swing.JButton();
        createUserJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        GsNameTextField = new javax.swing.JTextField();
        TicketSellerJPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TSNameTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nameJTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        passwordJTextField1 = new javax.swing.JTextField();
        backjButton2 = new javax.swing.JButton();
        createUserJButton1 = new javax.swing.JButton();
        Organization = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        StadiumManagerJpanel.setBackground(new java.awt.Color(102, 51, 0));
        StadiumManagerJpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel5.setText("Stadium Name: ");
        StadiumManagerJpanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 428, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel6.setText("Requests issued:");
        StadiumManagerJpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 489, 180, 33));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Home Team", "Away Team", "Date", "Venue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        StadiumManagerJpanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 464, 124));

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("Accept Match");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        StadiumManagerJpanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, 237, 49));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel8.setText("Stadium Manager Work area");
        StadiumManagerJpanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/stadiumBanner.jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");
        StadiumManagerJpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 79, 994, 275));

        jComboBox2.setToolTipText("");
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        StadiumManagerJpanel.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 700, 120, -1));

        createRequest.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        createRequest.setText("Create request");
        createRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRequestActionPerformed(evt);
            }
        });
        StadiumManagerJpanel.add(createRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 700, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel7.setText("Select Department:");
        StadiumManagerJpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton1.setText("Manage Organizations");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        StadiumManagerJpanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 230, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel10.setText("Funds Allocated");
        StadiumManagerJpanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, -1, -1));
        StadiumManagerJpanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 740, 120, -1));

        add(StadiumManagerJpanel, "card2");

        GroundStaffJPanel.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Password");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("User Name");

        backjButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        createUserJButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Ground Staff Name");

        javax.swing.GroupLayout GroundStaffJPanelLayout = new javax.swing.GroupLayout(GroundStaffJPanel);
        GroundStaffJPanel.setLayout(GroundStaffJPanelLayout);
        GroundStaffJPanelLayout.setHorizontalGroup(
            GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroundStaffJPanelLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(GroundStaffJPanelLayout.createSequentialGroup()
                        .addComponent(backjButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createUserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroundStaffJPanelLayout.createSequentialGroup()
                        .addGroup(GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(79, 79, 79)
                        .addGroup(GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GroundStaffJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(GsNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(530, 571, Short.MAX_VALUE))
        );
        GroundStaffJPanelLayout.setVerticalGroup(
            GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GroundStaffJPanelLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(GsNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(GroundStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backjButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(521, Short.MAX_VALUE))
        );

        add(GroundStaffJPanel, "card3");

        TicketSellerJPanel.setBackground(new java.awt.Color(51, 51, 51));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Ticket Seller Name");

        jLabel11.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("User Name");

        jLabel12.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Password");

        backjButton2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        backjButton2.setText("<< Back");
        backjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton2ActionPerformed(evt);
            }
        });

        createUserJButton1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        createUserJButton1.setText("Create");
        createUserJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TicketSellerJPanelLayout = new javax.swing.GroupLayout(TicketSellerJPanel);
        TicketSellerJPanel.setLayout(TicketSellerJPanelLayout);
        TicketSellerJPanelLayout.setHorizontalGroup(
            TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketSellerJPanelLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TicketSellerJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TSNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TicketSellerJPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(40, 40, 40)
                        .addGroup(TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TicketSellerJPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(backjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createUserJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(607, Short.MAX_VALUE))
        );
        TicketSellerJPanelLayout.setVerticalGroup(
            TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketSellerJPanelLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TSNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(passwordJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(TicketSellerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createUserJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(400, Short.MAX_VALUE))
        );

        add(TicketSellerJPanel, "card4");

        jButton2.setText("Create Ground StaffManager");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Create TicketSeller");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OrganizationLayout = new javax.swing.GroupLayout(Organization);
        Organization.setLayout(OrganizationLayout);
        OrganizationLayout.setHorizontalGroup(
            OrganizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrganizationLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addGroup(OrganizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        OrganizationLayout.setVerticalGroup(
            OrganizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrganizationLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        add(Organization, "card5");
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.getLayout();
        layout.show(this,"card2");
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        String clubName = GsNameTextField.getText();
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        GroundStaff gs = new GroundStaff(clubName,stadium);
        system.getUserAccountDirectory().createUserAccount(userName, password, new GroundStaffManagerRole(),gs);
        JOptionPane.showMessageDialog(null,"Ground Staff manager created!");
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void backjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton2ActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.getLayout();
        layout.show(this,"card2");
    }//GEN-LAST:event_backjButton2ActionPerformed

    private void createUserJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButton1ActionPerformed
        // TODO add your handling code here:
        String stadiumName = TSNameTextField.getText();
        String userName = nameJTextField1.getText();
        String password = passwordJTextField1.getText();
        TicketSeller  ts = new TicketSeller(stadiumName,stadium);
        system.getUserAccountDirectory().createUserAccount(userName, password, new TicketSellerRole(),ts);
        JOptionPane.showMessageDialog(null,"Ticket Seller created!");
    }//GEN-LAST:event_createUserJButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void createRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRequestActionPerformed
        GroundStaffWorkRequest gr = null;
        String text = jTextField1.getText();
        if(text.length() != 0){
            if(jComboBox2.getSelectedItem().equals(GroundStaffWorkRequest.RequestType.CateringServices)){
                gr = new GroundStaffWorkRequest();
                gr.setRequestType(GroundStaffWorkRequest.RequestType.CateringServices);
            }
            else if(jComboBox2.getSelectedItem().equals(GroundStaffWorkRequest.RequestType.GrassMaintenance)){
                gr = new GroundStaffWorkRequest();
                gr.setRequestType(GroundStaffWorkRequest.RequestType.GrassMaintenance);
            }
            else if(jComboBox2.getSelectedItem().equals(GroundStaffWorkRequest.RequestType.Lighting)){
                gr = new GroundStaffWorkRequest();
                gr.setRequestType(GroundStaffWorkRequest.RequestType.Lighting);
            }
            else if(jComboBox2.getSelectedItem().equals(GroundStaffWorkRequest.RequestType.Painting)){
                gr = new GroundStaffWorkRequest();
                gr.setRequestType(GroundStaffWorkRequest.RequestType.Painting);
            }
        }
        try{
        gr.setFundsAllocated(Integer.parseInt(text));        
        gr.setStatus("REQUESTED");
        this.stadium.getGroundStaff().getWorkQueue().getWorkRequestList().add(gr);
        JOptionPane.showMessageDialog(null,"Request created");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Please enter valid input");
        }
    }//GEN-LAST:event_createRequestActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if(selectedRow>= 0){
            MatchWorkRequest matchWork =  (MatchWorkRequest)  jTable2.getValueAt(selectedRow, 2);
            this.matchWorkRequest = matchWork;
            this.matchWorkRequest.setStatus("Match finished");
            this.stadium.getWorkQueue().getWorkRequestList().remove(matchWorkRequest);
        }else JOptionPane.showMessageDialog(null, "Please select a match!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       this.layout.show(this, "card5");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.layout.show(this, "card3");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.layout.show(this, "card4");
    }//GEN-LAST:event_jButton4ActionPerformed
    
    public void populateUpcomingMatchesTable(){
         DefaultTableModel model = (DefaultTableModel) jTable2.getModel();    
        model.setRowCount(0);
        for(WorkRequest wr : this.stadium.getWorkQueue().getWorkRequestList()){
            if(wr instanceof MatchWorkRequest){
                Object[] row = new Object[4];
                MatchWorkRequest matchWr = (MatchWorkRequest) wr;
                row[0] = matchWr.getAwayClub();
                row[1] = matchWr.getHomeClub();
                row[2] =  matchWr.getMatch().getUtcDate();
                row[3] =  matchWr;
                model.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GroundStaffJPanel;
    private javax.swing.JTextField GsNameTextField;
    private javax.swing.JPanel Organization;
    private javax.swing.JPanel StadiumManagerJpanel;
    private javax.swing.JTextField TSNameTextField;
    private javax.swing.JPanel TicketSellerJPanel;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton backjButton2;
    private javax.swing.JButton createRequest;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JButton createUserJButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField nameJTextField1;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JTextField passwordJTextField1;
    // End of variables declaration//GEN-END:variables
}
