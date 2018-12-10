/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ManagerRole;

import Business.EcoSystem;
import Business.Handler.DataHandler;
import Business.Model.Abstract.Person;
import Business.Model.Club;
import Business.Model.Competition;
import Business.Model.Player;
import Business.Model.TeamManager;
import Business.Network.League;
import Business.Organization.Organization;import Business.Service.LeagueDataService;
;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nikitagawde
 */
public class ManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagerWorkAreaJPanel
     */
    private Club club;
    private EcoSystem system;
    private CardLayout layout;
    private DataHandler dh;
    private LeagueDataService ch;
    public ManagerWorkAreaJPanel() {
        initComponents();
    }
    
    public ManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
         initComponents();
         TeamManager manager = (TeamManager) (Person) account.getPerson();
         this.system = business;
         this.club = manager.getClub();
         this.layout = (CardLayout) this.getLayout();
         populateLeagueComboBox();
         dh = new DataHandler();
         ch = new LeagueDataService();
         populatePositionComboBox();
         //populateStandingsTable(dh.getTableofStanding(ch.getStandings(this.club.getLeague().getLeague().getId())));
    }
    
    private void populatePlayersTable(Club c, String Position){
        
        DefaultTableModel model = (DefaultTableModel) clubTable.getModel();    
        model.setRowCount(0);
        if(c.getPlayers().isEmpty()){
            c.setPlayers(dh.getPlayers(c.getId()));
        }
        for( Player player : c.getPlayers()){
           if(player.getPosition() != null && player.getPosition().equals(Position)){
               Object[] row = new Object[3];
                row[0] = player.getName();
                row[1] = c.getName();
                row[2] = Position;
                model.addRow(row);
           }
        }
    }
    
//    public void populateGkComboBox(){
//        gkComboBox.removeAllItems();
//        for (Player player : this.club.getPlayers()){
//            if(player.getPosition() == "Goalkeeper"){
//                gkComboBox.addItem(player);
//            } 
//        }
//    }
//    public void populateDefComboBox(){
//        def1.removeAllItems();
//        def2.removeAllItems();
//        def3.removeAllItems();
//        for (Player player : this.club.getPlayers()){
//            if(player.getPosition() == "Defender"){
//                def1.addItem(player);
//                def2.addItem(player);
//                def3.addItem(player);
//            } 
//        }
//    }
    public void populateSquad1ComboBox(){
        mid1.removeAllItems();
        mid2.removeAllItems();
        mid3.removeAllItems();
        mid4.removeAllItems();
        def1.removeAllItems();
        def2.removeAllItems();
        def3.removeAllItems();
        at1.removeAllItems();
        at2.removeAllItems();
        at3.removeAllItems();
        gkComboBox.removeAllItems();
        for (Player player : this.club.getPlayers()){
            if(player.getPosition().equals("Midfielder")){
                mid1.addItem(player);
                mid2.addItem(player);
                mid3.addItem(player);
                mid4.addItem(player);
            }else if(player.getPosition().equals("Attacker")){
                at1.addItem(player);
                at2.addItem(player);
                at3.addItem(player);
            } else if(player.getPosition().equals("Defender")){
                def1.addItem(player);
                def2.addItem(player);
                def3.addItem(player);
            } else if(player.getPosition().equals("Goalkeeper")){
                gkComboBox.addItem(player);
            } 
        }
    }
    public void populateSquad2ComboBox(){
        midd1.removeAllItems();
        midd2.removeAllItems();
        midd3.removeAllItems();
        deff1.removeAllItems();
        deff2.removeAllItems();
        deff3.removeAllItems();
        att1.removeAllItems();
        att2.removeAllItems();
        att3.removeAllItems();
        deff4.removeAllItems();
        gkComboBox1.removeAllItems();
        for (Player player : this.club.getPlayers()){
            if(player.getPosition().equals("Midfielder")){
                midd1.addItem(player);
                midd2.addItem(player);
                midd3.addItem(player);
                
            }else if(player.getPosition().equals("Attacker")){
                att1.addItem(player);
                att2.addItem(player);
                att3.addItem(player);
                
            } else if(player.getPosition().equals("Defender")){
                deff1.addItem(player);
                deff2.addItem(player);
                deff3.addItem(player);
                deff4.addItem(player);
            } else if(player.getPosition().equals("Goalkeeper")){
                gkComboBox1.addItem(player);
            } 
        }
    }
    public void populateSquad3ComboBox(){
        midf1.removeAllItems();
        midf2.removeAllItems();
        midf3.removeAllItems();
        midf4.removeAllItems();
        defn1.removeAllItems();
        defn2.removeAllItems();
        defn3.removeAllItems();
        defn4.removeAllItems();
        atk1.removeAllItems();
        atk2.removeAllItems();
        gkComboBox2.removeAllItems();
        for (Player player : this.club.getPlayers()){
            if(player.getPosition().equals("Midfielder")){
                midf1.addItem(player);
                midf2.addItem(player);
                midf3.addItem(player);
                midf4.addItem(player);
            }else if(player.getPosition().equals("Attacker")){
                atk1.addItem(player);
                atk2.addItem(player);
            } else if(player.getPosition().equals("Defender")){
                defn1.addItem(player);
                defn2.addItem(player);
                defn3.addItem(player);
                defn4.addItem(player);
            } else if(player.getPosition().equals("Goalkeeper")){
                gkComboBox2.addItem(player);
            } 
        }
    }
    
//    public void populateAtckComboBox(){
//        at1.removeAllItems();
//        at2.removeAllItems();
//        at3.removeAllItems();
//        for (Player player : this.club.getPlayers()){
//            
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ManagerTopJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnViewSquad = new javax.swing.JButton();
        btnSearchPlayer = new javax.swing.JButton();
        btnTraining = new javax.swing.JButton();
        btnContracts = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        SearchPlayerJPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        clubTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        UpdateSquadJpanel = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CheckLeagueJPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        standingTable = new javax.swing.JTable();
        backjButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        squad1 = new javax.swing.JPanel();
        mid2 = new javax.swing.JComboBox();
        at3 = new javax.swing.JComboBox();
        mid1 = new javax.swing.JComboBox();
        at1 = new javax.swing.JComboBox();
        def1 = new javax.swing.JComboBox();
        at2 = new javax.swing.JComboBox();
        mid4 = new javax.swing.JComboBox();
        def2 = new javax.swing.JComboBox();
        mid3 = new javax.swing.JComboBox();
        gkComboBox = new javax.swing.JComboBox();
        def3 = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        backjButton4 = new javax.swing.JButton();
        squad2 = new javax.swing.JPanel();
        att3 = new javax.swing.JComboBox();
        att2 = new javax.swing.JComboBox();
        att1 = new javax.swing.JComboBox();
        midd1 = new javax.swing.JComboBox();
        deff4 = new javax.swing.JComboBox();
        midd2 = new javax.swing.JComboBox();
        midd3 = new javax.swing.JComboBox();
        deff3 = new javax.swing.JComboBox();
        deff2 = new javax.swing.JComboBox();
        deff1 = new javax.swing.JComboBox();
        gkComboBox1 = new javax.swing.JComboBox();
        jButton9 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        backjButton5 = new javax.swing.JButton();
        squad3 = new javax.swing.JPanel();
        midf2 = new javax.swing.JComboBox();
        midf4 = new javax.swing.JComboBox();
        midf1 = new javax.swing.JComboBox();
        atk2 = new javax.swing.JComboBox();
        defn1 = new javax.swing.JComboBox();
        atk1 = new javax.swing.JComboBox();
        defn4 = new javax.swing.JComboBox();
        defn2 = new javax.swing.JComboBox();
        midf3 = new javax.swing.JComboBox();
        gkComboBox2 = new javax.swing.JComboBox();
        defn3 = new javax.swing.JComboBox();
        jButton10 = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        backjButton6 = new javax.swing.JButton();

        jLabel9.setText("GK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.CardLayout());

        ManagerTopJPanel.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Welcome, Manager");

        btnBack.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Match against", "Date", "Time", "Venuel"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Serif", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Upcoming matches");

        btnViewSquad.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnViewSquad.setText("Create LineUp");
        btnViewSquad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSquadActionPerformed(evt);
            }
        });

        btnSearchPlayer.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnSearchPlayer.setText(" Search player to bid");
        btnSearchPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPlayerActionPerformed(evt);
            }
        });

        btnTraining.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnTraining.setText("Schedule training");
        btnTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrainingActionPerformed(evt);
            }
        });

        btnContracts.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnContracts.setText("View Players");
        btnContracts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContractsActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton2.setText("View Previous Match Summary");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton3.setText("Check League Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/manager_banner.jpg"))); // NOI18N

        javax.swing.GroupLayout ManagerTopJPanelLayout = new javax.swing.GroupLayout(ManagerTopJPanel);
        ManagerTopJPanel.setLayout(ManagerTopJPanelLayout);
        ManagerTopJPanelLayout.setHorizontalGroup(
            ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSearchPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTraining)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnContracts)
                        .addGap(481, 481, 481))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManagerTopJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(399, 399, 399))
            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewSquad))
                        .addGap(62, 62, 62))))
        );
        ManagerTopJPanelLayout.setVerticalGroup(
            ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnContracts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewSquad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        add(ManagerTopJPanel, "card2");

        SearchPlayerJPanel.setBackground(new java.awt.Color(51, 51, 51));

        clubTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Player name", "Club Name", "League Name"
            }
        ));
        jScrollPane2.setViewportView(clubTable);

        jButton4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Player Transfers");

        jLabel13.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Select League:");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EPL", "La Liga", "Bundesliga", "Italy Serie A" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Select Position:");

        jLabel16.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Price Offered:");

        jLabel17.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Years of contract:");

        jLabel18.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Select Club:");

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EPL", "La Liga", "Bundesliga", "Italy Serie A" }));

        jButton5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton5.setText("Bid Player");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnBack1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnBack1.setText("<<Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchPlayerJPanelLayout = new javax.swing.GroupLayout(SearchPlayerJPanel);
        SearchPlayerJPanel.setLayout(SearchPlayerJPanelLayout);
        SearchPlayerJPanelLayout.setHorizontalGroup(
            SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel18))
                                .addGap(29, 29, 29)
                                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(37, 37, 37)
                                .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnBack1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(48, 48, 48)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jTextField3))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(351, 351, 351))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))))
        );
        SearchPlayerJPanelLayout.setVerticalGroup(
            SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel12)
                .addGap(49, 49, 49)
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(249, Short.MAX_VALUE))
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(280, 280, 280))))
        );

        add(SearchPlayerJPanel, "card3");

        UpdateSquadJpanel.setBackground(new java.awt.Color(51, 51, 51));

        jButton11.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jButton11.setText("3-4-3");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jButton12.setText("4-3-3");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jButton13.setText("4-4-2");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Select the formation");

        javax.swing.GroupLayout UpdateSquadJpanelLayout = new javax.swing.GroupLayout(UpdateSquadJpanel);
        UpdateSquadJpanel.setLayout(UpdateSquadJpanelLayout);
        UpdateSquadJpanelLayout.setHorizontalGroup(
            UpdateSquadJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateSquadJpanelLayout.createSequentialGroup()
                .addGroup(UpdateSquadJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateSquadJpanelLayout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addGroup(UpdateSquadJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(UpdateSquadJpanelLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel4)))
                .addContainerGap(498, Short.MAX_VALUE))
        );
        UpdateSquadJpanelLayout.setVerticalGroup(
            UpdateSquadJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateSquadJpanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(84, 84, 84)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 348, Short.MAX_VALUE))
        );

        add(UpdateSquadJpanel, "card4");

        CheckLeagueJPanel.setBackground(new java.awt.Color(51, 51, 51));

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

        backjButton3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        backjButton3.setText("<< Back");
        backjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("League Standings");

        javax.swing.GroupLayout CheckLeagueJPanelLayout = new javax.swing.GroupLayout(CheckLeagueJPanel);
        CheckLeagueJPanel.setLayout(CheckLeagueJPanelLayout);
        CheckLeagueJPanelLayout.setHorizontalGroup(
            CheckLeagueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckLeagueJPanelLayout.createSequentialGroup()
                .addGroup(CheckLeagueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CheckLeagueJPanelLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel5))
                    .addGroup(CheckLeagueJPanelLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CheckLeagueJPanelLayout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(backjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        CheckLeagueJPanelLayout.setVerticalGroup(
            CheckLeagueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckLeagueJPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );

        add(CheckLeagueJPanel, "card5");

        squad1.setBackground(new java.awt.Color(51, 51, 51));
        squad1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mid2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(mid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 551, -1, -1));

        at3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(at3, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 551, -1, -1));

        mid1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(mid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, -1, -1));

        at1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(at1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        def1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(def1, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 551, -1, -1));

        at2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(at2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        mid4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(mid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, -1, -1));

        def2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(def2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));

        mid3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(mid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        gkComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gkComboBoxActionPerformed(evt);
            }
        });
        squad1.add(gkComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 670, -1, -1));

        def3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(def3, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 465, -1, -1));

        jLabel25.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 153, 0));
        jLabel25.setText("GoalKeeper");
        squad1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 694, 110, 35));

        jButton14.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton14.setText("Save Squad");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        squad1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 141, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);
        squad1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 780, 10));

        jLabel34.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 153, 0));
        jLabel34.setText("CB");
        squad1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, -1, 35));

        jLabel35.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 153, 0));
        jLabel35.setText("CB");
        squad1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 575, -1, 35));

        jLabel36.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 153, 0));
        jLabel36.setText("CB");
        squad1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 570, -1, 35));

        jLabel37.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 153, 255));
        jLabel37.setText("DM");
        squad1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, 35));

        jLabel38.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("CF");
        squad1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, 35));

        jLabel39.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 153, 255));
        jLabel39.setText("LM");
        squad1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, 35));

        jLabel42.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 153, 255));
        jLabel42.setText("AM");
        squad1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, -1, 35));

        jLabel43.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 153, 255));
        jLabel43.setText("RM");
        squad1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, -1, 35));

        jLabel44.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 0, 0));
        jLabel44.setText("RF");
        squad1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, -1, 35));

        jLabel45.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 0, 0));
        jLabel45.setText("CF");
        squad1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, 35));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Opposition");
        squad1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 120, 30));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("3-4-3 Formation");
        squad1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 260, 40));
        squad1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 0, 510));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        squad1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 60, 520));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        squad1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 60, 520));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        squad1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 217, 780, 10));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setOpaque(true);
        squad1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, 760, -1));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOpaque(true);
        squad1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 760, 10));

        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Attack");
        squad1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, -1, -1));

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Defense");
        squad1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, -1, -1));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Mid Fielders");
        squad1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 510, -1, -1));

        backjButton4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        backjButton4.setText("<< Back");
        backjButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton4ActionPerformed(evt);
            }
        });
        squad1.add(backjButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 109, 110, 40));

        add(squad1, "card6");

        squad2.setBackground(new java.awt.Color(51, 51, 51));
        squad2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        att3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(att3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        att2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(att2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        att1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(att1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, -1, -1));

        midd1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(midd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        deff4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(deff4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, -1, -1));

        midd2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(midd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        midd3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(midd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        deff3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(deff3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, -1, -1));

        deff2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(deff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 580, -1, -1));

        deff1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(deff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, -1, -1));

        gkComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad2.add(gkComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 680, -1, -1));

        jButton9.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton9.setText("Save Squad");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        squad2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 140, 40));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        squad2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 60, 520));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setOpaque(true);
        squad2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 780, 10));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setOpaque(true);
        squad2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 217, 780, 10));

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        squad2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 60, 520));

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator12.setOpaque(true);
        squad2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 482, 760, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setOpaque(true);
        squad2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, 760, -1));

        jLabel40.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 153, 0));
        jLabel40.setText("Goalkeeper");
        squad2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 700, -1, 35));

        jLabel41.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 153, 255));
        jLabel41.setText("DM");
        squad2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, -1, 35));

        jLabel46.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 153, 0));
        jLabel46.setText("RB");
        squad2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, -1, 35));

        jLabel47.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 153, 0));
        jLabel47.setText("CB");
        squad2.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, -1, 35));

        jLabel48.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 153, 0));
        jLabel48.setText("CB");
        squad2.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, -1, 35));

        jLabel49.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 153, 0));
        jLabel49.setText("LB");
        squad2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, -1, 35));

        jLabel50.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 153, 255));
        jLabel50.setText("CM");
        squad2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, -1, 35));

        jLabel51.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 153, 255));
        jLabel51.setText("CM");
        squad2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, -1, 35));

        jLabel52.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 0, 0));
        jLabel52.setText("RW");
        squad2.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, -1, 35));

        jLabel53.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 0, 0));
        jLabel53.setText("CF");
        squad2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, 35));

        jLabel54.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 0, 0));
        jLabel54.setText("LW");
        squad2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, 35));

        jLabel15.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Opposition");
        squad2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("Attack");
        squad2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, -1, -1));

        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setText("Mid Fielders");
        squad2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, -1, -1));

        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("Defense");
        squad2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, -1, -1));

        jLabel20.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("4-3-3 Formation");
        squad2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 260, 40));

        backjButton5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        backjButton5.setText("<< Back");
        backjButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton5ActionPerformed(evt);
            }
        });
        squad2.add(backjButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 109, 110, 40));

        add(squad2, "card7");

        squad3.setBackground(new java.awt.Color(51, 51, 51));
        squad3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        midf2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(midf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        midf4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        midf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midf4ActionPerformed(evt);
            }
        });
        squad3.add(midf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, -1, -1));

        midf1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(midf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, -1, -1));

        atk2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(atk2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        defn1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(defn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, -1, -1));

        atk1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(atk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        defn4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(defn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, -1, -1));

        defn2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(defn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, -1, -1));

        midf3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(midf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, -1, -1));

        gkComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(gkComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 670, -1, -1));

        defn3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad3.add(defn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, -1, -1));

        jButton10.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton10.setText("Save Squad");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        squad3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 129, 37));

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator14.setOpaque(true);
        squad3.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 217, 780, 10));

        jLabel19.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Opposition");
        squad3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, -1));

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setOpaque(true);
        squad3.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 482, 760, 10));

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setOpaque(true);
        squad3.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, 760, -1));

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        squad3.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 60, 520));

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        squad3.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 60, 520));

        jLabel55.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 153, 0));
        jLabel55.setText("Goalkeeper");
        squad3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 700, -1, 35));

        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("Mid Fielders");
        squad3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, -1, -1));

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator19.setOpaque(true);
        squad3.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 780, 10));

        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setText("Attack");
        squad3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, -1, -1));

        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("Defense");
        squad3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, -1, -1));

        jLabel56.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(51, 153, 0));
        jLabel56.setText("CB");
        squad3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, -1, 35));

        jLabel57.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 153, 0));
        jLabel57.setText("CB");
        squad3.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 600, -1, 35));

        jLabel58.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 153, 0));
        jLabel58.setText("RB");
        squad3.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, -1, 35));

        jLabel59.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 153, 0));
        jLabel59.setText("LB");
        squad3.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, -1, 35));

        jLabel60.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 153, 255));
        jLabel60.setText("CM");
        squad3.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, 35));

        jLabel61.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 153, 255));
        jLabel61.setText("LM");
        squad3.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, 35));

        jLabel62.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 153, 255));
        jLabel62.setText("CM");
        squad3.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, -1, 35));

        jLabel63.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 153, 255));
        jLabel63.setText("RM");
        squad3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, 35));

        jLabel64.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 0, 0));
        jLabel64.setText("FW");
        squad3.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, 35));

        jLabel65.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 0, 0));
        jLabel65.setText("FW");
        squad3.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, -1, 35));

        jLabel21.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("4-4-2 Formation");
        squad3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 260, 40));

        backjButton6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        backjButton6.setText("<< Back");
        backjButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton6ActionPerformed(evt);
            }
        });
        squad3.add(backjButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 110, 40));

        add(squad3, "card8");
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewSquadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSquadActionPerformed
        // TODO add your handling code here:
        this.layout.show(this, "card4");
        populateSquad1ComboBox();
        
    }//GEN-LAST:event_btnViewSquadActionPerformed

    private void btnSearchPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPlayerActionPerformed
        // TODO add your handling code here:
          jComboBox11.setPrototypeDisplayValue("select league");
         this.layout.show(this, "card3");
    }//GEN-LAST:event_btnSearchPlayerActionPerformed
    
    private void populateLeagueComboBox(){
        jComboBox11.removeAllItems();
        for (League l : system.getleaguesList()){
            jComboBox11.addItem(l);
        }
    }
    public void populateClubComboBox(League league){
        jComboBox13.removeAllItems();
        if(league != null){
            for (Club c : league.getClubs()){
                jComboBox13.addItem(c);
            }
        }
    }
    public void populatePositionComboBox(){
        jComboBox12.removeAllItems();
        jComboBox12.addItem("Attacker");
        jComboBox12.addItem("Defender");
        jComboBox12.addItem("Midfielder");
        jComboBox12.addItem("Goalkeeper");
    }
    private void btnContractsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContractsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContractsActionPerformed

    private void btnTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrainingActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void backjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton3ActionPerformed
        // TODO add your handling code here:
        layout.show(ManagerTopJPanel,"card2");
    }//GEN-LAST:event_backjButton3ActionPerformed

    private void midf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midf4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        this.layout.show(this, "card6");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        this.layout.show(this, "card6");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        this.layout.show(this, "card6");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        HashMap<Integer,Player> lineUp = new HashMap<>();
        Player a1 = (Player) at1.getSelectedItem();
        checkPlayerSelecetd(a1,lineUp);
        Player a2 = (Player) at2.getSelectedItem();
        checkPlayerSelecetd(a2,lineUp);
        Player a3 = (Player) at3.getSelectedItem();
        checkPlayerSelecetd(a3,lineUp);
        Player m1 = (Player) mid1.getSelectedItem();
        checkPlayerSelecetd(m1,lineUp);
        Player m2 = (Player) mid2.getSelectedItem();
        checkPlayerSelecetd(m2,lineUp);
        Player m3 = (Player) mid3.getSelectedItem();
        checkPlayerSelecetd(m3,lineUp);
        Player m4 = (Player) mid4.getSelectedItem();
        checkPlayerSelecetd(m4,lineUp);
        Player d1 = (Player) def1.getSelectedItem();
        checkPlayerSelecetd(d1,lineUp);
        Player d2 = (Player) def2.getSelectedItem(); 
        checkPlayerSelecetd(d2,lineUp);
        Player d3 = (Player) def3.getSelectedItem();
        checkPlayerSelecetd(d3,lineUp);
        if(lineUp.size() == 10){
             JOptionPane.showMessageDialog(this, "Squad Saved Succesfull");
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        HashMap<Integer,Player> lineUp = new HashMap<>();
        Player a1 = (Player) att1.getSelectedItem();
        checkPlayerSelecetd(a1,lineUp);
        Player a2 = (Player) att2.getSelectedItem();
        checkPlayerSelecetd(a2,lineUp);
        Player a3 = (Player) att3.getSelectedItem();
        checkPlayerSelecetd(a3,lineUp);
        Player m1 = (Player) midd1.getSelectedItem();
        checkPlayerSelecetd(m1,lineUp);
        Player m2 = (Player) midd2.getSelectedItem();
        checkPlayerSelecetd(m2,lineUp);
        Player m3 = (Player) midd3.getSelectedItem();
        checkPlayerSelecetd(m3,lineUp);
        Player d4 = (Player) deff4.getSelectedItem();
        checkPlayerSelecetd(d4,lineUp);
        Player d1 = (Player) deff1.getSelectedItem();
        checkPlayerSelecetd(d1,lineUp);
        Player d2 = (Player) deff2.getSelectedItem(); 
        checkPlayerSelecetd(d2,lineUp);
        Player d3 = (Player) deff3.getSelectedItem();
        checkPlayerSelecetd(d3,lineUp);
        if(lineUp.size() == 10){
             JOptionPane.showMessageDialog(this, "Squad Saved Succesfull");
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        HashMap<Integer,Player> lineUp = new HashMap<>();
        Player a1 = (Player) atk1.getSelectedItem();
        checkPlayerSelecetd(a1,lineUp);
        Player a2 = (Player) atk2.getSelectedItem();
        checkPlayerSelecetd(a2,lineUp);
        Player m4 = (Player) midf4.getSelectedItem();
        checkPlayerSelecetd(m4,lineUp);
        Player m1 = (Player) midf1.getSelectedItem();
        checkPlayerSelecetd(m1,lineUp);
        Player m2 = (Player) midf2.getSelectedItem();
        checkPlayerSelecetd(m2,lineUp);
        Player m3 = (Player) midf3.getSelectedItem();
        checkPlayerSelecetd(m3,lineUp);
        Player d4 = (Player) defn4.getSelectedItem();
        checkPlayerSelecetd(d4,lineUp);
        Player d1 = (Player) defn1.getSelectedItem();
        checkPlayerSelecetd(d1,lineUp);
        Player d2 = (Player) defn2.getSelectedItem(); 
        checkPlayerSelecetd(d2,lineUp);
        Player d3 = (Player) defn3.getSelectedItem();
        checkPlayerSelecetd(d3,lineUp);
        if(lineUp.size() == 10){
             JOptionPane.showMessageDialog(this, "Squad Saved Succesfull");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        // TODO add your handling code here:
        League league = (League) jComboBox11.getSelectedItem();
        populateClubComboBox(league);
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void gkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gkComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gkComboBoxActionPerformed

    private void backjButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backjButton4ActionPerformed

    private void backjButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backjButton5ActionPerformed

    private void backjButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backjButton6ActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack1ActionPerformed
     
    public void checkPlayerSelecetd(Player p,HashMap<Integer,Player> checklist){
       if(p != null){
           if(!checklist.containsKey(p.getId())){
               checklist.put(p.getId(), p);
           }else{
            JOptionPane.showMessageDialog(this, "Same Player is selected multiple times");
            return;
           }
       }else{
           JOptionPane.showMessageDialog(this, "Select All Positions");
           return;
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CheckLeagueJPanel;
    private javax.swing.JPanel ManagerTopJPanel;
    private javax.swing.JPanel SearchPlayerJPanel;
    private javax.swing.JPanel UpdateSquadJpanel;
    private javax.swing.JComboBox at1;
    private javax.swing.JComboBox at2;
    private javax.swing.JComboBox at3;
    private javax.swing.JComboBox atk1;
    private javax.swing.JComboBox atk2;
    private javax.swing.JComboBox att1;
    private javax.swing.JComboBox att2;
    private javax.swing.JComboBox att3;
    private javax.swing.JButton backjButton3;
    private javax.swing.JButton backjButton4;
    private javax.swing.JButton backjButton5;
    private javax.swing.JButton backjButton6;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnContracts;
    private javax.swing.JButton btnSearchPlayer;
    private javax.swing.JButton btnTraining;
    private javax.swing.JButton btnViewSquad;
    private javax.swing.JTable clubTable;
    private javax.swing.JComboBox def1;
    private javax.swing.JComboBox def2;
    private javax.swing.JComboBox def3;
    private javax.swing.JComboBox deff1;
    private javax.swing.JComboBox deff2;
    private javax.swing.JComboBox deff3;
    private javax.swing.JComboBox deff4;
    private javax.swing.JComboBox defn1;
    private javax.swing.JComboBox defn2;
    private javax.swing.JComboBox defn3;
    private javax.swing.JComboBox defn4;
    private javax.swing.JComboBox gkComboBox;
    private javax.swing.JComboBox gkComboBox1;
    private javax.swing.JComboBox gkComboBox2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox13;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox mid1;
    private javax.swing.JComboBox mid2;
    private javax.swing.JComboBox mid3;
    private javax.swing.JComboBox mid4;
    private javax.swing.JComboBox midd1;
    private javax.swing.JComboBox midd2;
    private javax.swing.JComboBox midd3;
    private javax.swing.JComboBox midf1;
    private javax.swing.JComboBox midf2;
    private javax.swing.JComboBox midf3;
    private javax.swing.JComboBox midf4;
    private javax.swing.JPanel squad1;
    private javax.swing.JPanel squad2;
    private javax.swing.JPanel squad3;
    private javax.swing.JTable standingTable;
    // End of variables declaration//GEN-END:variables
}
