/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdmin;

import Business.EcoSystem;
import Business.Handler.DataHandler;
import Business.Model.Club;
import Business.Model.Director;
import Business.Network.League;
import Business.Organization.Organization;
import Business.Role.LeagueDirectorRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author akash
 */
public class SuperAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SuperAdminWorkAreaJPanel
     */
    private EcoSystem system;
    private JPanel userProcessContainer;
    private DataHandler ch;
    private CardLayout cl;
    private League selectedLeague;
    
    public SuperAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.system = system;
        this.userProcessContainer = userProcessContainer;
    }

    public SuperAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
       initComponents();
       this.createPanel.setVisible(false);
       this.system = business;
       cl = (CardLayout) this.getLayout();
       ch = new DataHandler();
        if(this.system.getleaguesList().isEmpty()){
            this.system.setleaguesList(ch.getChampionsLeague());
        }
        this.userProcessContainer = userProcessContainer;
        populateTable();
        populateTree();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChampionsLeaguePanel = new javax.swing.JPanel();
        createLeague = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel5 = new javax.swing.JLabel();
        ManageLeague = new javax.swing.JPanel();
        createPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        leagueNameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        leagueNameAdminText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        leagueAdminUsernameText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        leagueAdminPassword = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        createLeagueAdmin = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        ChampionsLeaguePanel.setBackground(new java.awt.Color(51, 51, 51));

        createLeague.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        createLeague.setForeground(new java.awt.Color(0, 0, 51));
        createLeague.setText("Manage Leagues");
        createLeague.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLeagueActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setRootVisible(false);
        jScrollPane1.setViewportView(jTree1);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/uefa-champions-league-ball.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout ChampionsLeaguePanelLayout = new javax.swing.GroupLayout(ChampionsLeaguePanel);
        ChampionsLeaguePanel.setLayout(ChampionsLeaguePanelLayout);
        ChampionsLeaguePanelLayout.setHorizontalGroup(
            ChampionsLeaguePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChampionsLeaguePanelLayout.createSequentialGroup()
                .addGroup(ChampionsLeaguePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChampionsLeaguePanelLayout.createSequentialGroup()
                        .addContainerGap(539, Short.MAX_VALUE)
                        .addComponent(createLeague, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(ChampionsLeaguePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        ChampionsLeaguePanelLayout.setVerticalGroup(
            ChampionsLeaguePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChampionsLeaguePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(ChampionsLeaguePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ChampionsLeaguePanelLayout.createSequentialGroup()
                        .addComponent(createLeague, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        add(ChampionsLeaguePanel, "card2");

        ManageLeague.setBackground(new java.awt.Color(51, 51, 51));
        ManageLeague.setPreferredSize(new java.awt.Dimension(818, 737));

        createPanel.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel6.setText("Create League Admin");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("League Name :");

        leagueNameText.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("League admin name :");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("League admin username :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("League admin password :");

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 51));
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createPanelLayout = new javax.swing.GroupLayout(createPanel);
        createPanel.setLayout(createPanelLayout);
        createPanelLayout.setHorizontalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createPanelLayout.createSequentialGroup()
                        .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(leagueAdminPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(leagueAdminUsernameText, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(leagueNameAdminText)
                            .addComponent(leagueNameText))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 68, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(95, 95, 95))
        );
        createPanelLayout.setVerticalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leagueNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leagueNameAdminText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leagueAdminUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leagueAdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "League name", "League Admin name"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        createLeagueAdmin.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        createLeagueAdmin.setText("Create League admin");
        createLeagueAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLeagueAdminActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageLeagueLayout = new javax.swing.GroupLayout(ManageLeague);
        ManageLeague.setLayout(ManageLeagueLayout);
        ManageLeagueLayout.setHorizontalGroup(
            ManageLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageLeagueLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(ManageLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ManageLeagueLayout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createLeagueAdmin))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(createPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(448, Short.MAX_VALUE))
        );
        ManageLeagueLayout.setVerticalGroup(
            ManageLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageLeagueLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ManageLeagueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createLeagueAdmin)
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addComponent(createPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        add(ManageLeague, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void createLeagueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLeagueActionPerformed
        cl.show(this, "card3");
    }//GEN-LAST:event_createLeagueActionPerformed

    private void createLeagueAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLeagueAdminActionPerformed
    int selectedRow = jTable1.getSelectedRow();
        if(selectedRow>= 0){
            this.createPanel.setVisible(true);
            this.selectedLeague = (League)jTable1.getValueAt(selectedRow, 0);
            leagueNameText.setText(this.selectedLeague.getLeague().getName());
        }else JOptionPane.showMessageDialog(null, "Please select a League!");
    }//GEN-LAST:event_createLeagueAdminActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       cl.previous(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String leagueAdminName = leagueNameAdminText.getText().trim();
    String userName = leagueAdminUsernameText.getText().trim();
    String password = leagueAdminPassword.getText().trim();
    if(!leagueAdminName.equalsIgnoreCase("") && !userName.equalsIgnoreCase("") && !password.equalsIgnoreCase("")){
        if(system.checkIfUserIsUnique(userName)){
            Director l = new Director(leagueAdminName,this.selectedLeague);
            this.selectedLeague.setLeagueAdmin(l);
            system.getUserAccountDirectory().createUserAccount(userName, password, new LeagueDirectorRole(),l);
            JOptionPane.showMessageDialog(this,"League Admin Created Succesfully!");
            this.createPanel.setVisible(false);
            leagueNameAdminText.setText("");
             leagueAdminUsernameText.setText("");
            leagueAdminPassword.setText("");
            populateTable();
        }else JOptionPane.showMessageDialog(null, "Username already exists");
            }else JOptionPane.showMessageDialog(null, "Please enter a valid input");
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        for(League l : system.getleaguesList()){
        Object[] row = new Object[2];
                row[0] = l;
                if(l.getLeagueAdmin() == null){
                    row[1] = "Admin Not Created";
                }
                else row[1] = l.getLeagueAdmin();
                dtm.addRow(row);
        }
    }

     public void populateTree(){
        DefaultMutableTreeNode leagueNode;
        DefaultMutableTreeNode clubNode;
        League league;
        Club club;
        DefaultTreeModel model=(DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode leagues=new DefaultMutableTreeNode(this.system.getChampionsLeague());
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        model.setRoot(root);
        root.insert(leagues, 0);
        for(int i = 0;i<this.system.getleaguesList().size();i++){
            league=this.system.getleaguesList().get(i);
            leagueNode=new DefaultMutableTreeNode(league.getLeague().getName());
            leagues.insert(leagueNode, i);
            ArrayList<Club> topClubs = ch.getTopFourTeams(ch.getStandings(league.getLeague().getId()));
            for(int j= 0; j<topClubs.size();j++){
                club = topClubs.get(j);
                clubNode = new DefaultMutableTreeNode(club.getName());
                leagueNode.insert(clubNode,j);
            }
        }
         model.reload();
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChampionsLeaguePanel;
    private javax.swing.JPanel ManageLeague;
    private javax.swing.JButton createLeague;
    private javax.swing.JButton createLeagueAdmin;
    private javax.swing.JPanel createPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField leagueAdminPassword;
    private javax.swing.JTextField leagueAdminUsernameText;
    private javax.swing.JTextField leagueNameAdminText;
    private javax.swing.JTextField leagueNameText;
    // End of variables declaration//GEN-END:variables
}
