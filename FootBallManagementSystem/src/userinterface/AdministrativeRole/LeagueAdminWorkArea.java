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
import Business.Model.Match;
import Business.Model.Stadium;
import Business.Model.Standing;
import Business.Model.Table;
import Business.Organization.Organization;
import Business.Role.ClubOwnerRole;
import Business.Role.StadiumManagerRole;
import Business.Service.LeagueDataService;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MatchWorkRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private League currentLeague;
    private EcoSystem system;
    private CardLayout layout;
    private LeagueDataService ch;
    private DataHandler dh;
    private Standing standing;
    private Club selectedClub;
    private Stadium selectedStadium;
    public LeagueAdminWorkArea() {
        initComponents();
        this.currentLeague = currentLeague;
        this.layout = (CardLayout) LeagueAdminTopJPanel.getLayout();
    }

    public LeagueAdminWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
        initComponents();
        Director l = (Director) account.getPerson();
        this.system = business;
        this.currentLeague = l.getLeague();
        dh = new DataHandler();
        if(this.currentLeague.getStadiums() == null){
            this.currentLeague.setStadiums(this.currentLeague.getClubs());
        } 
        this.layout = (CardLayout) LeagueAdminTopJPanel.getLayout();
        this.leagueNameJLabel.setText(this.currentLeague.getLeague().getName());
        this.revalidate();
        populateClubsTable(this.currentLeague);
        populateStadiumsTable(this.currentLeague);
        populateTree();
        populateStandingsTable(dh.getTableofStanding(dh.getStandings(this.currentLeague.getLeague().getId())));
        this.clubCreate.setVisible(false);
        this.stadiumCreate.setVisible(false);
    }
    public void populateTree(){
        DefaultMutableTreeNode clubNode;
        DefaultMutableTreeNode stadiumNode;
        Club club;
        Stadium s;
        DefaultTreeModel model=(DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode MainLeague = new DefaultMutableTreeNode(this.currentLeague.getLeague().getName());
        DefaultMutableTreeNode clubs = new DefaultMutableTreeNode("AllClubs");
        DefaultMutableTreeNode stadiums = new DefaultMutableTreeNode("AllStadiums");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        model.setRoot(root);
        root.insert(MainLeague, 0);
        for(int i = 0;i<this.currentLeague.getClubs().size();i++){
            club = this.currentLeague.getClubs().get(i);
            clubNode=new DefaultMutableTreeNode(club.getName());
            clubs.insert(clubNode, i); 
        }
        MainLeague.insert(clubs, 0);
        for(int i = 0;i<this.currentLeague.getStadiums().size();i++){
            s = this.currentLeague.getStadiums().get(i);
            stadiumNode = new DefaultMutableTreeNode(s.getName());
            stadiums.insert(stadiumNode, i);
        }
        MainLeague.insert(stadiums, 1);
        model.reload();
     }
    public void populateClubComboBox(){
        homeTeam.removeAllItems(); 
        awayTeam.removeAllItems();
        for (Club club : this.currentLeague.getClubs()){
            homeTeam.addItem(club);
            awayTeam.addItem(club);
        }
    }
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
            row[0] = s;
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
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        leagueNameJLabel = new javax.swing.JLabel();
        clubIcon = new javax.swing.JLabel();
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
        backjButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        stadiumTable = new javax.swing.JTable();
        stadiumCreate = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        StadiumNameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        StadiumManagerTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nameJTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passwordJTextField1 = new javax.swing.JTextField();
        submitStadiumManager = new javax.swing.JButton();
        createStadiumLogin = new javax.swing.JButton();
        LeagueTable = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        standingTable = new javax.swing.JTable();
        backjButton3 = new javax.swing.JButton();
        MatchCreation = new javax.swing.JPanel();
        homeTeam = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        awayTeam = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jButton8 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setForeground(new java.awt.Color(0, 0, 51));
        setLayout(new java.awt.BorderLayout());

        LeagueAdminTopJPanel.setBackground(new java.awt.Color(0, 0, 0));
        LeagueAdminTopJPanel.setPreferredSize(new java.awt.Dimension(818, 938));
        LeagueAdminTopJPanel.setLayout(new java.awt.CardLayout());

        LeagueAdminJPanel.setBackground(new java.awt.Color(51, 51, 51));
        LeagueAdminJPanel.setForeground(new java.awt.Color(51, 51, 0));
        LeagueAdminJPanel.setPreferredSize(new java.awt.Dimension(818, 938));
        LeagueAdminJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userJButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        userJButton1.setForeground(new java.awt.Color(0, 0, 102));
        userJButton1.setText("Manage Stadiums");
        userJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButton1ActionPerformed(evt);
            }
        });
        LeagueAdminJPanel.add(userJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 147, 170, 36));

        manageEmployeeJButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        manageEmployeeJButton1.setForeground(new java.awt.Color(0, 0, 102));
        manageEmployeeJButton1.setText("Manage Clubs");
        manageEmployeeJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButton1ActionPerformed(evt);
            }
        });
        LeagueAdminJPanel.add(manageEmployeeJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, 147, 34));

        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 102));
        jButton4.setText("Check League Standings");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        LeagueAdminJPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 294, 210, 37));

        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 102));
        jButton5.setText("Schedule Matches");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        LeagueAdminJPanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 294, 220, 37));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("League Tasks:");
        LeagueAdminJPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 244, -1, -1));
        LeagueAdminJPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setRootVisible(false);
        jScrollPane4.setViewportView(jTree1);

        LeagueAdminJPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 147, 261, 535));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        leagueNameJLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        leagueNameJLabel.setForeground(new java.awt.Color(204, 204, 204));
        leagueNameJLabel.setText("League Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clubIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(leagueNameJLabel)
                .addContainerGap(494, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clubIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(leagueNameJLabel)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        LeagueAdminJPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 801, -1));

        LeagueAdminTopJPanel.add(LeagueAdminJPanel, "card2");

        ManageClubsJPanel.setBackground(new java.awt.Color(51, 51, 51));
        ManageClubsJPanel.setPreferredSize(new java.awt.Dimension(818, 938));
        ManageClubsJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backjButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(0, 0, 102));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        ManageClubsJPanel.add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, -1, 41));

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

        ManageClubsJPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 62, 468, 268));

        createUserJButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        createUserJButton2.setForeground(new java.awt.Color(0, 0, 102));
        createUserJButton2.setText("Create Login");
        createUserJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButton2ActionPerformed(evt);
            }
        });
        ManageClubsJPanel.add(createUserJButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 343, 202, 42));

        clubCreate.setBackground(new java.awt.Color(153, 153, 153));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Club Name");

        createUserJButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        createUserJButton3.setForeground(new java.awt.Color(0, 0, 102));
        createUserJButton3.setText("Submit");
        createUserJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButton3ActionPerformed(evt);
            }
        });

        ClubNameTextField.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Club Owner");

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("Password");

        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
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
                    .addGroup(clubCreateLayout.createSequentialGroup()
                        .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addGap(32, 32, 32)
                        .addGroup(clubCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clubCreateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createUserJButton3)
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addComponent(createUserJButton3)
                .addContainerGap())
        );

        ManageClubsJPanel.add(clubCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 425, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 102));
        jButton2.setText("Create Club");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        ManageClubsJPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 343, 202, 40));

        LeagueAdminTopJPanel.add(ManageClubsJPanel, "card3");

        ManageStadiumsJPanel.setBackground(new java.awt.Color(51, 51, 51));
        ManageStadiumsJPanel.setPreferredSize(new java.awt.Dimension(818, 938));

        backjButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        backjButton2.setForeground(new java.awt.Color(0, 0, 102));
        backjButton2.setText("<< Back");
        backjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton2ActionPerformed(evt);
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

        stadiumCreate.setBackground(new java.awt.Color(102, 102, 102));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setText("Stadium Name");

        StadiumNameTextField.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("Stadium Owner");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setText("User Name");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setText("Password");

        submitStadiumManager.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        submitStadiumManager.setForeground(new java.awt.Color(0, 0, 102));
        submitStadiumManager.setText("Submit");
        submitStadiumManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitStadiumManagerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stadiumCreateLayout = new javax.swing.GroupLayout(stadiumCreate);
        stadiumCreate.setLayout(stadiumCreateLayout);
        stadiumCreateLayout.setHorizontalGroup(
            stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stadiumCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(stadiumCreateLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StadiumNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(stadiumCreateLayout.createSequentialGroup()
                            .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)))
                            .addGap(40, 40, 40)
                            .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(StadiumManagerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(submitStadiumManager))
                .addContainerGap())
        );
        stadiumCreateLayout.setVerticalGroup(
            stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stadiumCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(StadiumNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(StadiumManagerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nameJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(stadiumCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(passwordJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(submitStadiumManager)
                .addContainerGap())
        );

        createStadiumLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        createStadiumLogin.setForeground(new java.awt.Color(0, 0, 102));
        createStadiumLogin.setText("Create Login");
        createStadiumLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStadiumLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManageStadiumsJPanelLayout = new javax.swing.GroupLayout(ManageStadiumsJPanel);
        ManageStadiumsJPanel.setLayout(ManageStadiumsJPanelLayout);
        ManageStadiumsJPanelLayout.setHorizontalGroup(
            ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stadiumCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(createStadiumLogin)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        ManageStadiumsJPanelLayout.setVerticalGroup(
            ManageStadiumsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageStadiumsJPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createStadiumLogin)
                .addGap(9, 9, 9)
                .addComponent(stadiumCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(345, Short.MAX_VALUE))
        );

        LeagueAdminTopJPanel.add(ManageStadiumsJPanel, "card4");

        LeagueTable.setBackground(new java.awt.Color(51, 51, 51));

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

        backjButton3.setBackground(new java.awt.Color(204, 204, 204));
        backjButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        backjButton3.setForeground(new java.awt.Color(0, 0, 102));
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
                .addGroup(LeagueTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeagueTableLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(backjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LeagueTableLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        LeagueTableLayout.setVerticalGroup(
            LeagueTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeagueTableLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(backjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );

        LeagueAdminTopJPanel.add(LeagueTable, "card5");

        MatchCreation.setBackground(new java.awt.Color(51, 51, 51));

        homeTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeTeamActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Select Home Team:");

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Select Date:");

        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 102));
        jButton7.setText("Create Match");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Select Away Team:");

        jButton8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 102));
        jButton8.setText("<< Back");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MatchCreationLayout = new javax.swing.GroupLayout(MatchCreation);
        MatchCreation.setLayout(MatchCreationLayout);
        MatchCreationLayout.setHorizontalGroup(
            MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MatchCreationLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MatchCreationLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(homeTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(MatchCreationLayout.createSequentialGroup()
                            .addGroup(MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MatchCreationLayout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(MatchCreationLayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addGap(86, 86, 86)))
                            .addGroup(MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addGroup(MatchCreationLayout.createSequentialGroup()
                                    .addComponent(awayTeam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(2, 2, 2))))
                        .addGroup(MatchCreationLayout.createSequentialGroup()
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 388, Short.MAX_VALUE))
        );
        MatchCreationLayout.setVerticalGroup(
            MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MatchCreationLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(homeTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(awayTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(MatchCreationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(425, Short.MAX_VALUE))
        );

        LeagueAdminTopJPanel.add(MatchCreation, "card6");

        add(LeagueAdminTopJPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        populateTree();
        layout.show(LeagueAdminTopJPanel,"card2");
    }//GEN-LAST:event_backjButton1ActionPerformed

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

    private void createUserJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButton3ActionPerformed
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        String clubName = ClubNameTextField.getText();
        String clubOwnerName = ClubOwnerTextField.getText();
        if(!userName.equalsIgnoreCase("") && !password.equalsIgnoreCase("") && !clubOwnerName.equalsIgnoreCase("")){
            if(system.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
                if(this.selectedClub == null){
                Club club = new Club(clubName,clubOwnerName);
                 currentLeague.addClub(club); 
                 system.getUserAccountDirectory().createUserAccount(userName, password, new ClubOwnerRole(),club.getOwner());
                 JOptionPane.showMessageDialog(null, "Club created succesfully!");
                }else {
                    ClubNameTextField.setText(this.selectedClub.getName());
                    Owner o = new Owner(clubOwnerName,this.selectedClub);
                    this.selectedClub.setOwner(o);
                    this.selectedClub.setLeague(currentLeague);
                    system.getUserAccountDirectory().createUserAccount(userName, password, new ClubOwnerRole(),o);
                    JOptionPane.showMessageDialog(null, "Club owner created succesfully!");
                    this.selectedClub = null;
                }
                populateClubsTable(currentLeague);
                ClubNameTextField.setText("");
                ClubOwnerTextField.setText("");
                nameJTextField.setText("");
                passwordJTextField.setText(""); 
                this.clubCreate.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null ,"UserName Already Exists!");
            }
        }else{
           JOptionPane.showMessageDialog(null ,"Please Enter a Valid Input!");
        }
    }//GEN-LAST:event_createUserJButton3ActionPerformed

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void backjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton3ActionPerformed
        // TODO add your handling code here:
        layout.show(LeagueAdminTopJPanel,"card2");
    }//GEN-LAST:event_backjButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.clubCreate.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void submitStadiumManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitStadiumManagerActionPerformed
        String stadiumName = StadiumNameTextField.getText();
        String stadiumOwnerName = StadiumManagerTextField.getText();
        String userName = nameJTextField1.getText();
        String password = passwordJTextField1.getText();
        if(this.selectedStadium == null){
            JOptionPane.showMessageDialog(null, "Please Select a Stadium!");
        }else {
            if(!userName.equalsIgnoreCase("") && !password.equalsIgnoreCase("") && !stadiumOwnerName.equalsIgnoreCase("")){
                if(system.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
                    Owner o = new Owner(stadiumOwnerName,this.selectedStadium);
                    this.selectedStadium.setOwner(o);
                    system.getUserAccountDirectory().createUserAccount(userName, password, new StadiumManagerRole(),o);
                    JOptionPane.showMessageDialog(null, "Stadium Manager Created Succesfully!");
                    this.selectedStadium = null;
                }else{
                    JOptionPane.showMessageDialog(null ,"Username Alreay Exists");
                }
           }else{
               JOptionPane.showMessageDialog(null ,"Please Enter a Valid Name!");
           }
        }
        StadiumNameTextField.setText("");
        StadiumManagerTextField.setText("");
        nameJTextField1.setText("");
        passwordJTextField1.setText("");
        stadiumCreate.setVisible(false);
        populateStadiumsTable(currentLeague);
    }//GEN-LAST:event_submitStadiumManagerActionPerformed

    private void createStadiumLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStadiumLoginActionPerformed
        int selectedRow = stadiumTable.getSelectedRow();
        if(selectedRow>= 0){
            this.stadiumCreate.setVisible(true);
            this.selectedStadium = (Stadium)stadiumTable.getValueAt(selectedRow, 0);
            StadiumNameTextField.setText(this.selectedStadium.getName());
        }else JOptionPane.showMessageDialog(null, "Please select a Stadium!");
    }//GEN-LAST:event_createStadiumLoginActionPerformed

    private void homeTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeTeamActionPerformed
        // TODO add your handling code here:
//                League league = (League) homeTeam.getSelectedItem();
//                populateClubComboBox(league);
    }//GEN-LAST:event_homeTeamActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Club hTeam = (Club) homeTeam.getSelectedItem();
        
//        if(hTeam.getStadium() == null){
//            hTeam.setStadium(new Stadium(hTeam.getVenue(), null));
//        }
        Club awaTeam = (Club) awayTeam.getSelectedItem();
        if(hTeam !=null && awaTeam !=null && this.dateChooser.getDate()!=null){
            Match m = new Match();
            m.setVenue(hTeam.getStadium());
            m.getHomeTeam().setId(hTeam.getId());
            m.getAwayTeam().setId(awaTeam.getId());
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            String date = fmt.format(this.dateChooser.getDate()); //jdatechooser
            m.setUtcDate(date);
            MatchWorkRequest wr = new MatchWorkRequest(m);
            wr.setMatch(m);
            wr.setStatus("Initiated");
            wr.setHomeClub(hTeam);
            wr.setAwayClub(awaTeam);
            hTeam.getManagerOrganization().getWorkQueue().addWorkQueue(wr);
            awaTeam.getManagerOrganization().getWorkQueue().addWorkQueue(wr);
            hTeam.getStadium().getWorkQueue().addWorkQueue(wr);
            JOptionPane.showMessageDialog(null, "Match succesfully created");
            dateChooser.setDate(null);
        }else{
            JOptionPane.showMessageDialog(null, "Please Select Valid Input");
            dateChooser.setDate(null);
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.layout.show(LeagueAdminTopJPanel, "card6");
        populateClubComboBox();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        layout.show(LeagueAdminTopJPanel,"card5");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void manageEmployeeJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButton1ActionPerformed
        // TODO add your handling code here:
        layout.show(LeagueAdminTopJPanel,"card3");
    }//GEN-LAST:event_manageEmployeeJButton1ActionPerformed

    private void userJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButton1ActionPerformed
        // TODO add your handling code here:
        layout.show(LeagueAdminTopJPanel,"card4");
    }//GEN-LAST:event_userJButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        layout.show(LeagueAdminTopJPanel, "card2");
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClubNameTextField;
    private javax.swing.JTextField ClubOwnerTextField;
    private javax.swing.JPanel LeagueAdminJPanel;
    private javax.swing.JPanel LeagueAdminTopJPanel;
    private javax.swing.JPanel LeagueTable;
    private javax.swing.JPanel ManageClubsJPanel;
    private javax.swing.JPanel ManageStadiumsJPanel;
    private javax.swing.JPanel MatchCreation;
    private javax.swing.JTextField StadiumManagerTextField;
    private javax.swing.JTextField StadiumNameTextField;
    private javax.swing.JComboBox awayTeam;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton backjButton2;
    private javax.swing.JButton backjButton3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel clubCreate;
    private javax.swing.JLabel clubIcon;
    private javax.swing.JTable clubTable;
    private javax.swing.JButton createStadiumLogin;
    private javax.swing.JButton createUserJButton2;
    private javax.swing.JButton createUserJButton3;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JComboBox homeTeam;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel leagueNameJLabel;
    private javax.swing.JButton manageEmployeeJButton1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField nameJTextField1;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JTextField passwordJTextField1;
    private javax.swing.JPanel stadiumCreate;
    private javax.swing.JTable stadiumTable;
    private javax.swing.JTable standingTable;
    private javax.swing.JButton submitStadiumManager;
    private javax.swing.JButton userJButton1;
    // End of variables declaration//GEN-END:variables
}
