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
import Business.Model.Contract;
import Business.Model.Goal;
import Business.Model.Match;
import Business.Model.Player;
import Business.Model.TeamManager;
import Business.Network.League;
import Business.Organization.Organization;import Business.Service.LeagueDataService;
;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ContractWorkRequest;
import Business.WorkQueue.MatchWorkRequest;
import Business.WorkQueue.TrainingWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagerWorkAreaJPanel
     */
    private Club club;
    private EcoSystem system;
    private CardLayout layout;
    private DataHandler dh;
    private LeagueDataService dataService;
    private MatchWorkRequest selectedWorkRequest;
    private ArrayList<Match> clubMatches;
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
         dataService = new LeagueDataService();
         this.clubMatches = dataService.getTeamMatches(this.club.getId());
         populatePositionComboBox();
         populateUpcomingMatches();
         //populateStandingsTable(dh.getTableofStanding(ch.getStandings(this.club.getLeague().getLeague().getId())));
    }
    
    private void populatePlayersTable(Club c, String Position){
        
        DefaultTableModel model = (DefaultTableModel) clubTable.getModel();    
        model.setRowCount(0);
        if(c.getClubPlayers().getPlayers().isEmpty()){
            c.setPlayers(dh.getPlayers(c.getId()));
        }
        for( Player player : c.getPlayers()){
           if(player.getPosition() != null && player.getPosition().equals(Position)){
               Object[] row = new Object[3];
                row[0] = player;
                row[1] = c.getName();
                row[2] = Position;
                model.addRow(row);
           }
        }
    }
    
    private void populateUpcomingMatches(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();    
        model.setRowCount(0);
        for(WorkRequest wr : this.club.getManagerOrganization().getWorkQueue().getWorkRequestList()){
            if(wr instanceof MatchWorkRequest){
                Object[] row = new Object[3];
                MatchWorkRequest matchWr = (MatchWorkRequest) wr;
                if(!matchWr.getAwayClub().getId().equals(this.club.getId())){
                     row[0] =  matchWr.getAwayClub();
                }else{
                     row[0] =  matchWr.getHomeClub();
                }
                row[1] =  matchWr.getMatch().getVenue().getName();
                row[2] =  matchWr;
                model.addRow(row);
                //row[2] = matchWr.getMatch().getUtcDate();
            }
        }
    }
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
        for (Player player : this.club.getClubPlayers().getPlayers()){
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
        jComboBox1 = new javax.swing.JComboBox();
        ManagerTopJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnViewSquad = new javax.swing.JButton();
        btnSearchPlayer = new javax.swing.JButton();
        btnTraining = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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
        btnBack2 = new javax.swing.JButton();
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
        TrainingScheduleJpanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        btnBack3 = new javax.swing.JButton();
        MatchSummary = new javax.swing.JPanel();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setLayout(new java.awt.CardLayout());

        ManagerTopJPanel.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
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

            },
            new String [] {
                "Match against", "Venuel", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
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

        jButton3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton3.setText("Check League Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/manager_banner.jpg"))); // NOI18N

        jButton2.setText("PlayersStatistics");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addContainerGap()
                        .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnViewSquad)
                                    .addComponent(jButton3)))
                            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                                .addComponent(btnSearchPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnTraining, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                    .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        ManagerTopJPanelLayout.setVerticalGroup(
            ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagerTopJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ManagerTopJPanelLayout.createSequentialGroup()
                        .addComponent(btnViewSquad)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(ManagerTopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchPlayer)
                    .addComponent(btnTraining)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
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

        jButton5.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton5.setText("Send Contract");
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
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel13))
                        .addGap(29, 29, 29)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox11, 0, 130, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox12, 0, 130, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                            .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(48, 48, 48)
                            .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(jTextField3)))
                        .addComponent(btnBack1)))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPlayerJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(351, 351, 351))
        );
        SearchPlayerJPanelLayout.setVerticalGroup(
            SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel12)
                .addGap(49, 49, 49)
                .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SearchPlayerJPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SearchPlayerJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(30, 30, 30)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(139, Short.MAX_VALUE))))
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
                .addContainerGap(377, Short.MAX_VALUE))
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
                .addGap(0, 337, Short.MAX_VALUE))
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
                .addContainerGap(195, Short.MAX_VALUE))
        );
        CheckLeagueJPanelLayout.setVerticalGroup(
            CheckLeagueJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckLeagueJPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );

        add(CheckLeagueJPanel, "card5");

        squad1.setBackground(new java.awt.Color(51, 51, 51));
        squad1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mid2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(mid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, -1));

        at3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(at3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, -1, -1));

        mid1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(mid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, -1, -1));

        at1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(at1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        def1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(def1, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 551, -1, -1));

        at2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(at2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

        mid4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(mid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, -1, -1));

        def2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        squad1.add(def2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, -1, -1));

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
        squad1.add(def3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, -1, -1));

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
        squad1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 141, 40));

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
        squad1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, 35));

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
        squad1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, 35));

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

        btnBack2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnBack2.setText("<<Back");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        squad1.add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 40));

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
                .addGap(0, 87, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
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
                .addContainerGap(339, Short.MAX_VALUE))
            .addGroup(squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                    .addContainerGap(800, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(105, 105, 105)))
        );
        squad3Layout.setVerticalGroup(
            squad3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, squad3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
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
                    .addContainerGap(636, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(88, 88, 88)))
        );

        add(squad3, "card8");

        jLabel15.setText("Shooting");

        jButton1.setText("Send TrainRequest");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel27.setText("Dribbling");

        jLabel28.setText("Passing");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel29.setText("Defensive");

        jLabel30.setText("Fitness");

        btnBack3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnBack3.setText("<<Back");
        btnBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TrainingScheduleJpanelLayout = new javax.swing.GroupLayout(TrainingScheduleJpanel);
        TrainingScheduleJpanel.setLayout(TrainingScheduleJpanelLayout);
        TrainingScheduleJpanelLayout.setHorizontalGroup(
            TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrainingScheduleJpanelLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack3)
                    .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1)
                        .addComponent(jLabel30)
                        .addGroup(TrainingScheduleJpanelLayout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addGap(59, 59, 59)
                            .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addComponent(jTextField6)))
                        .addGroup(TrainingScheduleJpanelLayout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addGap(71, 71, 71)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(TrainingScheduleJpanelLayout.createSequentialGroup()
                            .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel27))
                            .addGap(64, 64, 64)
                            .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField4)
                                .addComponent(jTextField1)))))
                .addContainerGap(551, Short.MAX_VALUE))
        );
        TrainingScheduleJpanelLayout.setVerticalGroup(
            TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrainingScheduleJpanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(TrainingScheduleJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnBack3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(381, Short.MAX_VALUE))
        );

        add(TrainingScheduleJpanel, "card9");

        javax.swing.GroupLayout MatchSummaryLayout = new javax.swing.GroupLayout(MatchSummary);
        MatchSummary.setLayout(MatchSummaryLayout);
        MatchSummaryLayout.setHorizontalGroup(
            MatchSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        MatchSummaryLayout.setVerticalGroup(
            MatchSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );

        add(MatchSummary, "card10");
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewSquadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSquadActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow>= 0){
            MatchWorkRequest matchWork =  (MatchWorkRequest)  jTable1.getValueAt(selectedRow, 2);
            this.selectedWorkRequest = matchWork;
            this.layout.show(this, "card4");
            populateSquad1ComboBox();
        }else JOptionPane.showMessageDialog(null, "Please select a Club!");
        
        
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
    private void btnTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrainingActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow >= 0){
            MatchWorkRequest matchWrkRqst =  (MatchWorkRequest) jTable1.getValueAt(selectedRow, 2);
            this.selectedWorkRequest = matchWrkRqst;
            if(this.selectedWorkRequest.getMatch().getAwayTeam().getId().equals(this.club.getId())){
                if(this.selectedWorkRequest.getMatch().getAwayTeam().getLineup().size() > 10 ){
                     this.layout.show(this, "card9");
                }
            }
            if(this.selectedWorkRequest.getMatch().getHomeTeam().getId().equals(this.club.getId())){
               if(this.selectedWorkRequest.getMatch().getHomeTeam().getLineup().size() > 0 ){
                     this.layout.show(this, "card9");
                }
            }
        }else JOptionPane.showMessageDialog(null, "Please select a Match for Training!");
    }//GEN-LAST:event_btnTrainingActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Club club = (Club) jComboBox13.getSelectedItem();
        String pos = (String) jComboBox12.getSelectedItem();
        populatePlayersTable(club,pos);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            Collection<Player> players = lineUp.values();
            ArrayList<Player> lineUp1 = new ArrayList<Player>(players);
            if(this.selectedWorkRequest.getMatch().getAwayTeam().getId().equals(this.club.getId())){
                this.selectedWorkRequest.getMatch().getAwayTeam().setLineup((lineUp1) );
            }
            if(this.selectedWorkRequest.getMatch().getHomeTeam().getId().equals(this.club.getId())){
                this.selectedWorkRequest.getMatch().getHomeTeam().setLineup((lineUp1));
            }
            this.club.getClubPlayers().getWorkQueue().getWorkRequestList().add(this.selectedWorkRequest);
            this.selectedWorkRequest.setStatus("LineUpCreated");
            JOptionPane.showMessageDialog(this, "Squad Saved Succesfully");
            this.layout.show(this, "card2");
            populateUpcomingMatches();
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
        String price = jTextField2.getText();
        int selectedRow = clubTable.getSelectedRow();
        if(selectedRow>= 0){
            Player p = (Player)clubTable.getValueAt(selectedRow, 0);
            Club fromClub = (Club) jComboBox13.getSelectedItem();
            if(p.getClub() == null){                                                 
                p.setClub(fromClub);
            }
            Contract c = new Contract(p,fromClub,this.club,price);
            ContractWorkRequest contractWr = new ContractWorkRequest(c);
            contractWr.setStatus("Initiated");
            fromClub.getClubPlayers().getWorkQueue().addWorkQueue(contractWr);
            fromClub.getManagerOrganization().getWorkQueue().addWorkQueue(contractWr);
            JOptionPane.showMessageDialog(this, "Contract Send Succesfull");
        }else JOptionPane.showMessageDialog(null, "Please select a Club!"); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void gkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gkComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gkComboBoxActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String shootHrs = jTextField1.getText();
        String DribbleHrs = jTextField4.getText();
        String passingHrs = jTextField5.getText();
        String defHrs = jTextField6.getText();
        String fitHrs = jTextField7.getText();
        TrainingWorkRequest Twr = new TrainingWorkRequest();
        Twr.setShootingours(Integer.parseInt(shootHrs));
        Twr.setDribblingHours(Integer.parseInt(DribbleHrs));
        Twr.setPassingHours(Integer.parseInt(passingHrs));
        Twr.setDefensiveHours(Integer.parseInt(defHrs));
        Twr.setFitnessHours(Integer.parseInt(fitHrs));
        Twr.setMatch(this.selectedWorkRequest);
        this.club.getSupporttingStaff().getWorkQueue().addWorkQueue(Twr);
        this.club.getClubPlayers().getWorkQueue().addWorkQueue(Twr);
        Twr.setStatus("Initiated");
        
        JOptionPane.showMessageDialog(this, "Training Work Request sent Succesfully");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack3ActionPerformed
        // TODO add your handling code here:
        this.layout.show(this, "card2");
    }//GEN-LAST:event_btnBack3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<Integer,Integer> playerGoalsMap = new HashMap<>();
        HashMap<Integer,Integer> playerAssistsMap = new HashMap<>();
        for(Match m : this.clubMatches){
            for(Goal g : m.getGoals()){
                int scorer = g.getScorer().getId();
                if(g.getAssist() != null){
                    int assist = g.getAssist().getId();
                    if(playerAssistsMap.containsKey(assist)){
                        playerAssistsMap.put(assist, playerAssistsMap.get(assist)+1);
                    }else playerAssistsMap.put(assist, 1);
                }
                if(playerGoalsMap.containsKey(scorer)){
                    playerGoalsMap.put(scorer, playerGoalsMap.get(scorer)+1);
                }else playerGoalsMap.put(scorer, 1);
            }
        }
        for(Player p: this.club.getClubPlayers().getPlayers()){
            for(int i : playerAssistsMap.keySet()){
                if(p.getId()== i){
                    dataset.addValue(playerAssistsMap.get(i), p.getName(), "Assists");
                }
            }
            for(int j : playerGoalsMap.keySet()){
                if(p.getId()== j){
                    dataset.addValue(playerGoalsMap.get(j), p.getName(), "Goals");
                }
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart("Player performance",
            "Category",
            "Score",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);
        ChartFrame frame = new ChartFrame("Pie chart",barChart);
        frame.setVisible(true);
        frame.setSize(450,500);
    }//GEN-LAST:event_jButton2ActionPerformed
     
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
    private javax.swing.JPanel MatchSummary;
    private javax.swing.JPanel SearchPlayerJPanel;
    private javax.swing.JPanel TrainingScheduleJpanel;
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
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnBack3;
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
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
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
