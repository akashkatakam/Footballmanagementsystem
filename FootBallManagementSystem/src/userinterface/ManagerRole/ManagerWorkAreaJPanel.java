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
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox();
        UpdateSquadJpanel = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        CheckLeagueJPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        standingTable = new javax.swing.JTable();
        backjButton3 = new javax.swing.JButton();
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
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
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
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Welcome, Manager");

        btnBack.setText("Back");
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Upcoming matches");

        btnViewSquad.setText("Create LineUp");
        btnViewSquad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSquadActionPerformed(evt);
            }
        });

        btnSearchPlayer.setText(" Search player to bid");
        btnSearchPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPlayerActionPerformed(evt);
            }
        });

        btnTraining.setText("Schedule training");
        btnTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrainingActionPerformed(evt);
            }
        });

        btnContracts.setText("View Players");
        btnContracts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContractsActionPerformed(evt);
            }
        });

        jButton2.setText("View Previous Match Summary");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Check League Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManagerTopJPanelLayout = new javax.swing.GroupLayout(ManagerTopJPanel);
        ManagerTopJPanel.setLayout(ManagerTopJPanelLayout);
        ManagerTopJPanelLayout.setHorizontalGroup(
            ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1))
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnBack))
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewSquad)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addComponent(btnSearchPlayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnContracts)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        ManagerTopJPanelLayout.setVerticalGroup(
            ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addComponent(btnViewSquad)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchPlayer)
                    .addComponent(btnTraining)
                    .addComponent(btnContracts))
                .addGap(78, 78, 78)
                .addComponent(btnBack)
                .addGap(31, 31, 31))
        );

        add(ManagerTopJPanel, "card2");

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

        jButton4.setText("Bid Player");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Player Transfers");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("Select League:");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EPL", "La Liga", "Bundesliga", "Italy Serie A" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Select Position:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setText("Price Offered:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("Years of contract:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setText("Select Club:");

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EPL", "La Liga", "Bundesliga", "Italy Serie A" }));

        javax.swing.GroupLayout SearchPlayerJPanelLayout = new javax.swing.GroupLayout(SearchPlayerJPanel);
        SearchPlayerJPanel.setLayout(SearchPlayerJPanelLayout);
        SearchPlayerJPanelLayout.setHorizontalGroup(
            SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18))
                        .addGap(29, 29, 29)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(jComboBox12, 0, 166, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel12)))
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(244, 244, 244))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(43, 43, 43)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        SearchPlayerJPanelLayout.setVerticalGroup(
            SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addGap(300, 300, 300))
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(96, 96, 96))))
        );

        add(SearchPlayerJPanel, "card3");

        jButton11.setText("3-4-3");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("4-3-3");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("4-4-2");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpdateSquadJpanelLayout = new javax.swing.GroupLayout(UpdateSquadJpanel);
        UpdateSquadJpanel.setLayout(UpdateSquadJpanelLayout);
        UpdateSquadJpanelLayout.setHorizontalGroup(
            UpdateSquadJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateSquadJpanelLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jButton11)
                .addGap(68, 68, 68)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jButton13)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        UpdateSquadJpanelLayout.setVerticalGroup(
            UpdateSquadJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateSquadJpanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(UpdateSquadJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addGap(0, 470, Short.MAX_VALUE))
        );

        add(UpdateSquadJpanel, "card4");

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

        javax.swing.GroupLayout CheckLeagueJPanelLayout = new javax.swing.GroupLayout(CheckLeagueJPanel);
        CheckLeagueJPanel.setLayout(CheckLeagueJPanelLayout);
        CheckLeagueJPanelLayout.setHorizontalGroup(
            CheckLeagueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckLeagueJPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(CheckLeagueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(364, Short.MAX_VALUE))
        );
        CheckLeagueJPanelLayout.setVerticalGroup(
            CheckLeagueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckLeagueJPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(backjButton3)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        add(CheckLeagueJPanel, "card5");

        mid2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        at3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        mid1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        at1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        def1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        at2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        mid4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        def2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        mid3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        gkComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        def3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setText("GK");

        jLabel27.setText("GK");

        jLabel28.setText("GK");

        jLabel29.setText("GK");

        jLabel30.setText("GK");

        jLabel31.setText("GK");

        jLabel32.setText("GK");

        jLabel33.setText("GK");

        jButton14.setText("Save Squad");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout squad1Layout = new javax.swing.GroupLayout(squad1);
        squad1.setLayout(squad1Layout);
        squad1Layout.setHorizontalGroup(
            squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(squad1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(squad1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(squad1Layout.createSequentialGroup()
                        .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(at2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(def1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(squad1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(def2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(at1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gkComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(def3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(at3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad1Layout.createSequentialGroup()
                .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(squad1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(mid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(mid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(mid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(squad1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(squad1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mid4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(squad1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton14)
                .addGap(47, 47, 47))
            .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad1Layout.createSequentialGroup()
                    .addContainerGap(684, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(105, 105, 105)))
        );
        squad1Layout.setVerticalGroup(
            squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(at1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(squad1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mid4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(def2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(def3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(def1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(gkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(squad1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(at2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(at3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(mid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addGroup(squad1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad1Layout.createSequentialGroup()
                    .addContainerGap(460, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(88, 88, 88)))
        );

        add(squad1, "card6");

        att3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        att2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        att1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        midd1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        deff4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        midd2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        midd3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        deff3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        deff2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        deff1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        gkComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setText("Save Squad");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout squad2Layout = new javax.swing.GroupLayout(squad2);
        squad2.setLayout(squad2Layout);
        squad2Layout.setHorizontalGroup(
            squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(squad2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(deff4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deff1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(deff2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(deff3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(squad2Layout.createSequentialGroup()
                .addGroup(squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(squad2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(att2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240)
                        .addComponent(att1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(squad2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(midd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(att3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gkComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(midd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(564, 564, 564)
                        .addComponent(midd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(70, 70, 70))
        );
        squad2Layout.setVerticalGroup(
            squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(squad2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(att3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad2Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deff1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deff2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(squad2Layout.createSequentialGroup()
                        .addGroup(squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(squad2Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(midd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(squad2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(att2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(att1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(midd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(midd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(52, 52, 52)
                        .addGroup(squad2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deff4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deff3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65)
                .addComponent(gkComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        add(squad2, "card7");

        midf2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        midf4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        midf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midf4ActionPerformed(evt);
            }
        });

        midf1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        atk2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        defn1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        atk1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        defn4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        defn2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        midf3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        gkComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        defn3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("GK");

        jLabel20.setText("GK");

        jLabel21.setText("GK");

        jLabel22.setText("GK");

        jLabel23.setText("GK");

        jLabel24.setText("GK");

        jLabel26.setText("GK");

        jButton10.setText("Save Squad");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout squad3Layout = new javax.swing.GroupLayout(squad3);
        squad3.setLayout(squad3Layout);
        squad3Layout.setHorizontalGroup(
            squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(squad3Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gkComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(squad3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(81, 81, 81))
            .addGroup(squad3Layout.createSequentialGroup()
                .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(squad3Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(defn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(defn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(defn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(squad3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(midf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(defn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(squad3Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(midf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(atk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(atk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(squad3Layout.createSequentialGroup()
                                        .addComponent(midf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(midf4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                    .addContainerGap(684, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(105, 105, 105)))
        );
        squad3Layout.setVerticalGroup(
            squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                        .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                                .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                                        .addComponent(atk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                                        .addComponent(atk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)))
                                .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(midf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(midf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                                .addComponent(midf4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                        .addComponent(midf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(squad3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(defn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(defn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(squad3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(defn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(defn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(gkComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                    .addContainerGap(460, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(88, 88, 88)))
        );

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Club club = (Club) jComboBox13.getSelectedItem();
        String pos = (String) jComboBox12.getSelectedItem();
        populatePlayersTable(club,pos);
    }//GEN-LAST:event_jButton1ActionPerformed
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
    private javax.swing.JButton btnBack;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
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
