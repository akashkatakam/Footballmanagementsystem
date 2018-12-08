/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Model.Club;
import Business.Model.Owner;
import Business.Network.League;
import java.awt.CardLayout;
import Business.EcoSystem;
import Business.Handler.DataHandler;
import Business.Model.Competition;
import Business.Model.Director;
import Business.Model.Stadium;
import Business.Model.Standing;
import Business.Model.Table;
import Business.Organization.Organization;
import Business.Role.ClubOwnerRole;
import Business.Role.StadiumManagerRole;
import Business.Service.LeagueDataService;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author nikitagawde
 */
public class LeagueAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form LeagueAdminWorkArea
     */
    private Competition competition;
    private League league;
    private EcoSystem system;
    private CardLayout layout;
    private LeagueDataService ch;
    private DataHandler dh;
    private Standing standing;
    private Club selectedClub;
    public LeagueAdminWorkArea() {
        initComponents();
        this.league = league;
        this.layout = (CardLayout) LeagueAdminTopJPanel.getLayout();
    }

    public LeagueAdminWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
        initComponents();
        Director l = (Director) account.getPerson();
        this.system = business;
        this.league = l.getLeague();
        ch = new LeagueDataService();
        dh = new DataHandler();
//        if(this.system.getleaguesList().isEmpty()){
//            this.system.setleaguesList(dh.getChampionsLeague());
//        }
        if(this.league.getStadiums() == null){
            this.league.setStadiums(this.league.getClubs());
        } 
        this.layout = (CardLayout) LeagueAdminTopJPanel.getLayout();
        countryNameJText.setText(this.league.getLeague().getName());
        this.revalidate();
        populateClubsTable(this.league);
        populateStadiumsTable(this.league);
        populateTree();
        //populateClubComboBox();
        populateStandingsTable(dh.getTableofStanding(ch.getStandings(this.league.getLeague().getId())));
        this.clubCreate.setVisible(false);
        //this.loginCreate.setVisible(false);
    }
     public void populateTree(){
        DefaultMutableTreeNode leagueNode;
        DefaultMutableTreeNode clubNode;
        DefaultMutableTreeNode stadiumNode;
        League league;
        Club club;
        Stadium s;
        DefaultTreeModel model=(DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode MainLeague = new DefaultMutableTreeNode(this.league.getLeague().getName());
        DefaultMutableTreeNode clubs = new DefaultMutableTreeNode("AllClubs");
        DefaultMutableTreeNode stadiums = new DefaultMutableTreeNode("AllStadiums");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        model.setRoot(root);
        root.insert(MainLeague, 0);
        for(int i = 0;i<this.league.getClubs().size();i++){
            club = this.league.getClubs().get(i);
            clubNode=new DefaultMutableTreeNode(club.getName());
            clubs.insert(clubNode, i); 
        }
        MainLeague.insert(clubs, 0);
        for(int i = 0;i<this.league.getStadiums().size();i++){
            s = this.league.getStadiums().get(i);
            stadiumNode = new DefaultMutableTreeNode(s.getName());
            stadiums.insert(stadiumNode, i);
        }
        MainLeague.insert(stadiums, 1);
        model.reload();
     }
//     public void populateClubComboBox(){
//        jComboBox1.removeAllItems();       
//        for (Club club : this.league.getClubs()){
//            jComboBox1.addItem(club);
//        }
//    }
    private void populateClubsTable(League league){
        DefaultTableModel model = (DefaultTableModel) clubTable.getModel();
        model.setRowCount(0);
        for (Club club : league.getClubs()){
            Object[] row = new Object[2];
            row[0] = club;
            row[1] = club.getOwner();
            model.addRow(row);
        }
    }
    
    private void populateStadiumsTable(League l){
        DefaultTableModel model = (DefaultTableModel) stadiumTable.getModel();
        model.setRowCount(0);
        for (Stadium s : l.getStadiums()){
            Object[] row = new Object[2];
            row[0] = s.getName();
            row[1] = s.getOwner();
            model.addRow(row);
        }
    }
    
    private void populateStandingsTable(ArrayList<Table> s){
        DefaultTableModel model = (DefaultTableModel) standingTable.getModel();
        model.setRowCount(0);
        for (Table t : s){
            Object[] row = new Object[3];
            row[0] = t.getClub().getName();
            row[1] = t.getPosition();
            row[2] = t.getPoints();
            model.addRow(row);
        }
    }
    
    
    public void resetTextFields(){
        ClubNameTextField.setText("");
        ClubOwnerTextField.setText("");
        nameJTextField.setText("");
        passwordJTextField.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        LeagueAdminTopJPanel = new javax.swing.JPanel();
        LeagueAdminJPanel = new javax.swing.JPanel();
        userJButton1 = new javax.swing.JButton();
        manageEmployeeJButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        countryNameJText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        ManageClubsJPanel = new javax.swing.JPanel();
        backjButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clubTable = new javax.swing.JTable();
        createUserJButton2 = new javax.swing.JButton();
        clubCreate = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        createUserJButton3 = new javax.swing.JButton();
        ClubNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ClubOwnerTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        passwordJTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        ManageStadiumsJPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        StadiumNameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        StadiumManagerTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nameJTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passwordJTextField1 = new javax.swing.JTextField();
        backjButton2 = new javax.swing.JButton();
        createUserJButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        stadiumTable = new javax.swing.JTable();
        LeagueTable = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        standingTable = new javax.swing.JTable();
        backjButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        LeagueAdminTopJPanel.setBackground(new java.awt.Color(0, 0, 0));
        LeagueAdminTopJPanel.setLayout(new java.awt.CardLayout());

        userJButton1.setText("Manage Stadiums");
        userJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButton1ActionPerformed(evt);
            }
        });

        manageEmployeeJButton1.setText("Manage Clubs");
        manageEmployeeJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("League Admin Work Area");

        jButton4.setText("Check League Table");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Schedule Matches");

        jButton6.setText("Select Date of Tournament");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel11.setText("League Name:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("League Tasks:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("League Analytics:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Best Goalkeeper:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Top Goal Scorer:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Best Manager:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Relegated Teams:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Wins", "Losses", "Points"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane4.setViewportView(jTree1);

        javax.swing.GroupLayout LeagueAdminJPanelLayout = new javax.swing.GroupLayout(LeagueAdminJPanel);
        LeagueAdminJPanel.setLayout(LeagueAdminJPanelLayout);
        LeagueAdminJPanelLayout.setHorizontalGroup(
            LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(countryNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageEmployeeJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel10))
                            .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13)
                                    .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField6)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                            .addComponent(jTextField8))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        LeagueAdminJPanelLayout.setVerticalGroup(
            LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LeagueAdminJPanelLayout.createSequentialGroup()
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addGap(49, 49, 49)
                                .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(countryNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(LeagueAdminJPanelLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(manageEmployeeJButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userJButton1)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5)
                            .addComponent(jButton4))
                        .addGap(44, 44, 44)
                        .addComponent(jLabel13)
                        .addGap(23, 23, 23)
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LeagueAdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        LeagueAdminTopJPanel.add(LeagueAdminJPanel, "card2");

        backjButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        clubTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Club name", "Club owner"
            }
        ));
        jScrollPane1.setViewportView(clubTable);

        createUserJButton2.setText("Create Login");
        createUserJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Club Name");

        createUserJButton3.setText("Create Club");
        createUserJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Club Owner");

        jLabel20.setText("Password");

        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });

        jLabel19.setText("User Name");

        javax.swing.GroupLayout clubCreateLayout = new javax.swing.GroupLayout(clubCreate);
        clubCreate.setLayout(clubCreateLayout);
        clubCreateLayout.setHorizontalGroup(
            clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clubCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clubCreateLayout.createSequentialGroup()
                        .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClubOwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClubNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(createUserJButton3)
                    .addGroup(clubCreateLayout.createSequentialGroup()
                        .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addGap(32, 32, 32)
                        .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        clubCreateLayout.setVerticalGroup(
            clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clubCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ClubNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ClubOwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(36, 36, 36)
                .addComponent(createUserJButton3)
                .addContainerGap())
        );

        jButton2.setText("Create Club");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageClubsJPanelLayout = new javax.swing.GroupLayout(ManageClubsJPanel);
        ManageClubsJPanel.setLayout(ManageClubsJPanelLayout);
        ManageClubsJPanelLayout.setHorizontalGroup(
            ManageClubsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageClubsJPanelLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addGroup(ManageClubsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clubCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ManageClubsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(ManageClubsJPanelLayout.createSequentialGroup()
                            .addComponent(createUserJButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(287, Short.MAX_VALUE))
        );
        ManageClubsJPanelLayout.setVerticalGroup(
            ManageClubsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageClubsJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ManageClubsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUserJButton2)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clubCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(backjButton1)
                .addGap(101, 101, 101))
        );

        LeagueAdminTopJPanel.add(ManageClubsJPanel, "card3");

        jLabel5.setText("Stadium Name");

        jLabel6.setText("Stadium Owner");

        jLabel7.setText("User Name");

        jLabel8.setText("Password");

        backjButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backjButton2.setText("<< Back");
        backjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton2ActionPerformed(evt);
            }
        });

        createUserJButton1.setText("Create");
        createUserJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButton1ActionPerformed(evt);
            }
        });

        stadiumTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Stadium ", "Stadium manager"
            }
        ));
        jScrollPane3.setViewportView(stadiumTable);

        javax.swing.GroupLayout ManageStadiumsJPanelLayout = new javax.swing.GroupLayout(ManageStadiumsJPanel);
        ManageStadiumsJPanel.setLayout(ManageStadiumsJPanelLayout);
        ManageStadiumsJPanelLayout.setHorizontalGroup(
            ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StadiumNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                                    .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)))
                                    .addGap(40, 40, 40)
                                    .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(StadiumManagerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                                .addComponent(backjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(createUserJButton1))))
                    .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        ManageStadiumsJPanelLayout.setVerticalGroup(
            ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(StadiumNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(StadiumManagerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(passwordJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createUserJButton1)
                    .addComponent(backjButton2))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        LeagueAdminTopJPanel.add(ManageStadiumsJPanel, "card4");

        standingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Club Name", "Position"
            }
        ));
        jScrollPane5.setViewportView(standingTable);

        backjButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backjButton3.setText("<< Back");
        backjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeagueTableLayout = new javax.swing.GroupLayout(LeagueTable);
        LeagueTable.setLayout(LeagueTableLayout);
        LeagueTableLayout.setHorizontalGroup(
            LeagueTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeagueTableLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(LeagueTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(452, Short.MAX_VALUE))
        );
        LeagueTableLayout.setVerticalGroup(
            LeagueTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeagueTableLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(backjButton3)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        LeagueAdminTopJPanel.add(LeagueTable, "card5");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(617, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(263, 263, 263))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LeagueAdminTopJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jButton1)
                .addContainerGap(367, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LeagueAdminTopJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButton1ActionPerformed
        // TODO add your handling code here:
        layout.show(LeagueAdminTopJPanel,"card4");
    }//GEN-LAST:event_userJButton1ActionPerformed

    private void manageEmployeeJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButton1ActionPerformed
        // TODO add your handling code here:
        layout.show(LeagueAdminTopJPanel,"card3");
    }//GEN-LAST:event_manageEmployeeJButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        populateTree();
        layout.show(LeagueAdminTopJPanel,"card2");
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void createUserJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButton1ActionPerformed
        // TODO add your handling code here:
        String stadiumName = StadiumNameTextField.getText();
        String stadiumOwnerName = StadiumManagerTextField.getText();
        String userName = nameJTextField1.getText();
        String password = passwordJTextField1.getText();
        Owner stadiumOwner  = new Owner(stadiumOwnerName);
        Stadium  stadium = new Stadium(stadiumName,stadiumOwner);
       // league.addStadium(stadium);
        system.getUserAccountDirectory().createUserAccount(userName, password, new StadiumManagerRole(),stadiumOwner);
        //populateStadiumsTable(league);
        StadiumNameTextField.setText("");
        StadiumManagerTextField.setText("");
        nameJTextField1.setText("");
        passwordJTextField1.setText("");
    }//GEN-LAST:event_createUserJButton1ActionPerformed

    private void backjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton2ActionPerformed
         layout.show(LeagueAdminTopJPanel,"card2");
         populateTree();
    }//GEN-LAST:event_backjButton2ActionPerformed

    private void StadiumNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StadiumNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StadiumNameTextFieldActionPerformed

    private void createUserJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = clubTable.getSelectedRow();
        if(selectedRow>= 0){
            this.clubCreate.setVisible(true);
            this.selectedClub = (Club)clubTable.getValueAt(selectedRow, 0);
            ClubNameTextField.setText(this.selectedClub.getName());
        }else JOptionPane.showMessageDialog(null, "Please select a Club!");
    }//GEN-LAST:event_createUserJButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        layout.show(LeagueAdminTopJPanel,"card5");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void createUserJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButton3ActionPerformed
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        String OwnerName = ClubOwnerTextField.getText();
        String clubName = ClubNameTextField.getText();
        String clubOwnerName = ClubOwnerTextField.getText();
        if(this.selectedClub == null){
           Club club = new Club(clubName,clubOwnerName);
            league.addClub(club); 
            system.getUserAccountDirectory().createUserAccount(userName, password, new ClubOwnerRole(),club.getOwner());
            JOptionPane.showMessageDialog(null, "Club created succesfully!");
        }else {
            ClubNameTextField.setText(this.selectedClub.getName());
            Owner o = new Owner(clubOwnerName,this.selectedClub);
            this.selectedClub.setOwner(o);
            system.getUserAccountDirectory().createUserAccount(userName, password, new ClubOwnerRole(),o);
            JOptionPane.showMessageDialog(null, "Club owner created succesfully!");
            this.selectedClub = null;
        }
        populateClubsTable(league);
        ClubNameTextField.setText("");
        ClubOwnerTextField.setText("");
        nameJTextField.setText("");
        passwordJTextField.setText(""); 
        this.clubCreate.setVisible(false);
    }//GEN-LAST:event_createUserJButton3ActionPerformed

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void backjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton3ActionPerformed
        // TODO add your handling code here:
        layout.show(LeagueAdminTopJPanel,"card2");
    }//GEN-LAST:event_backjButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.clubCreate.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClubNameTextField;
    private javax.swing.JTextField ClubOwnerTextField;
    private javax.swing.JPanel LeagueAdminJPanel;
    private javax.swing.JPanel LeagueAdminTopJPanel;
    private javax.swing.JPanel LeagueTable;
    private javax.swing.JPanel ManageClubsJPanel;
    private javax.swing.JPanel ManageStadiumsJPanel;
    private javax.swing.JTextField StadiumManagerTextField;
    private javax.swing.JTextField StadiumNameTextField;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton backjButton2;
    private javax.swing.JButton backjButton3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel clubCreate;
    private javax.swing.JTable clubTable;
    private javax.swing.JTextField countryNameJText;
    private javax.swing.JButton createUserJButton1;
    private javax.swing.JButton createUserJButton2;
    private javax.swing.JButton createUserJButton3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton manageEmployeeJButton1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField nameJTextField1;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JTextField passwordJTextField1;
    private javax.swing.JTable stadiumTable;
    private javax.swing.JTable standingTable;
    private javax.swing.JButton userJButton1;
    // End of variables declaration//GEN-END:variables
}
