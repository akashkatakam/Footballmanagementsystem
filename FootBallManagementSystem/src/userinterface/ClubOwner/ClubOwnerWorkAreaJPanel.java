/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ClubOwner;

import Business.EcoSystem;
import Business.Handler.DataHandler;
import Business.Model.Club;
import Business.Model.Goal;
import Business.Model.Match;
import Business.Model.Owner;
import Business.Model.Player;
import Business.Model.Staff;
import Business.Model.Table;
import Business.Model.TeamManager;
import Business.Organization.Organization;
import Business.Role.ManagerRole;
import Business.Role.PlayerRole;
import Business.Role.SupportingStaffManagerRole;
import Business.Service.LeagueDataService;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
/**
 *
 * @author nikitagawde
 */
public class ClubOwnerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ClubOwnerWorkAreaJPanel
     */
    private EcoSystem system;
    private Club currentClub;
    private DataHandler dh;
    private Player player;
    private LeagueDataService dataService;
    private ArrayList<Match> clubMatches;
    private CardLayout cl;
    private HashMap<Integer,Integer> playerGoalsMap;
    public ClubOwnerWorkAreaJPanel() {
        initComponents();
    }

    public ClubOwnerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business) {
        this.system = business;
        playerGoalsMap = new HashMap<>();
        dh = new DataHandler();
        dataService = new LeagueDataService();
        Owner o = (Owner) account.getPerson();
        this.currentClub = o.getClub();
        if(this.currentClub.getPlayers().size()== 0){
            this.currentClub.setPlayers(dh.getPlayers(this.currentClub.getId()));
        }
        initComponents();
        clubNameJLabel.setText(currentClub.getName());
//        URL url;
//        try {
//            String path = this.currentClub.getCrestUrl();
//            url = new URL(path);
//            BufferedImage image = ImageIO.read(url);
//            Image reSizedimage = image.getScaledInstance(clubIcon.getWidth(), clubIcon.getHeight(),Image.SCALE_SMOOTH);
//            ImageIcon finalIcon = new ImageIcon(reSizedimage);
//            clubIcon.setIcon(finalIcon);
//        } catch (Exception ex) {
//           ex.printStackTrace();
//        }
        this.clubMatches = dataService.getTeamMatches(this.currentClub.getId());
        this.cl = (CardLayout) this.getLayout();
        populatePlayerTable();
        populateTree();
        populateSupportingStaffComboBox();
        populateStandingsTable(dh.getTableofStanding(dh.getStandings(this.currentClub.getLeague().getLeague().getId())));
        jPanel7.setVisible(false);
    }
    private  LinkedHashMap<Integer, Integer> sortHashMapByValues(HashMap<Integer,Integer> map){
        List<Integer> mapKeys = new ArrayList<>(map.keySet());
        List<Integer> mapValues = new ArrayList<>(map.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);
        Iterator<Integer> valueIt = mapValues.iterator();
        LinkedHashMap<Integer, Integer> sortedMap =
        new LinkedHashMap<>();
        while (valueIt.hasNext()) {
            int val = valueIt.next();
            Iterator<Integer> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Integer key = keyIt.next();
                Integer comp1 = map.get(key);
                int comp2 = val;
                if(comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
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
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane5 = new javax.swing.JScrollPane();
        standingTable = new javax.swing.JTable();
        pieChatButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        clubNameJLabel = new javax.swing.JLabel();
        clubIcon = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        supportingStaffPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        supportingStaffName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        supportingStaffuserName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        supportingStaffPwd = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        submitSupportingStaffManager = new javax.swing.JButton();
        supportingStaff = new javax.swing.JComboBox<String>();
        jButton4 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        fName = new javax.swing.JTextField();
        submitPlayer = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fName1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        submitManager = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(818, 938));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton3.setText("Manage Organization");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        standingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Club Name", "Position"
            }
        ));
        jScrollPane5.setViewportView(standingTable);

        pieChatButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        pieChatButton.setText("Club Analysis");
        pieChatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieChatButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jButton2.setText("Players Assesment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        clubNameJLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        clubNameJLabel.setForeground(new java.awt.Color(204, 204, 204));
        clubNameJLabel.setText("Club name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(clubIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(clubNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(clubNameJLabel)
                .addGap(23, 23, 23))
            .addComponent(clubIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pieChatButton)))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pieChatButton)
                            .addComponent(jButton2))
                        .addGap(26, 26, 26)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        add(jPanel1, "ownerMain");

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jButton8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton8.setText("Create Player");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton9.setText("Create Supporting Staff");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton10.setText("Create Manager");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(770, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addGap(23, 23, 23)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(222, 222, 222))
        );

        add(jPanel9, "card4");

        supportingStaffPanel.setBackground(new java.awt.Color(51, 51, 51));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("First name :");

        supportingStaffName.setText("                                  ");
        supportingStaffName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supportingStaffNameActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("User name :");

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("Password :");

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Create Supporting staff");

        submitSupportingStaffManager.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        submitSupportingStaffManager.setText("Submit");
        submitSupportingStaffManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitSupportingStaffManagerActionPerformed(evt);
            }
        });

        supportingStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supportingStaffActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout supportingStaffPanelLayout = new javax.swing.GroupLayout(supportingStaffPanel);
        supportingStaffPanel.setLayout(supportingStaffPanelLayout);
        supportingStaffPanelLayout.setHorizontalGroup(
            supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supportingStaffPanelLayout.createSequentialGroup()
                .addGroup(supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(supportingStaffPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel21))
                    .addGroup(supportingStaffPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addGroup(supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supportingStaff, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supportingStaffName, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                    .addGroup(supportingStaffPanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(supportingStaffPanelLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(25, 25, 25)
                                .addComponent(supportingStaffPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(supportingStaffPanelLayout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitSupportingStaffManager, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(supportingStaffPanelLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(supportingStaffuserName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(585, Short.MAX_VALUE))
        );
        supportingStaffPanelLayout.setVerticalGroup(
            supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supportingStaffPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel21)
                .addGap(48, 48, 48)
                .addComponent(supportingStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(supportingStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(supportingStaffuserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(supportingStaffPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(supportingStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitSupportingStaffManager, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(400, Short.MAX_VALUE))
        );

        add(supportingStaffPanel, "card5");

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Create Player");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player Name", "Position"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton1.setText("Create Player login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel8.setText("User name :");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel5.setText("Full name :");

        fName.setText("                                  ");
        fName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameActionPerformed(evt);
            }
        });

        submitPlayer.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        submitPlayer.setText("Submit");
        submitPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPlayerActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel9.setText("Password :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(13, 13, 13)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(fName))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitPlayer)
                .addContainerGap())
        );

        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel4)
                .addGap(271, 535, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(67, 67, 67)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addGap(32, 32, 32)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        add(jPanel11, "card6");

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setPreferredSize(new java.awt.Dimension(590, 526));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Create Manager login");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Full Name");

        fName1.setText("                                  ");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("User name :");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Passoword :");

        submitManager.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        submitManager.setText("Submit");
        submitManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitManagerActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(411, 411, 411))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fName1))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitManager, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel14)
                .addGap(31, 31, 31)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitManager)
                    .addComponent(jButton6))
                .addContainerGap(265, Short.MAX_VALUE))
        );

        add(jPanel13, "card7");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cl.show(this, "card6");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        fName1.setText(this.currentClub.getManagerOrganization().getTm().getManager().toString());
        cl.show(this, "card7");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void supportingStaffNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportingStaffNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supportingStaffNameActionPerformed

    private void submitSupportingStaffManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitSupportingStaffManagerActionPerformed
        String firstName = supportingStaffName.getText();
        String userName = supportingStaffuserName.getText();
        String passWord = supportingStaffPwd.getText();
        Player supportingStaffManager = (Player) supportingStaff.getSelectedItem();
        if(supportingStaffManager != null){
            supportingStaffManager.setName(userName);
            supportingStaffManager.setClub(currentClub);
            system.getUserAccountDirectory().createUserAccount(userName, passWord, new SupportingStaffManagerRole(),supportingStaffManager);
        }else {
            Player p = new Player();
            p.setName(firstName);
            p.setClub(currentClub);
            this.currentClub.getSupporttingStaff().addSupportingStaff(p);
            system.getUserAccountDirectory().createUserAccount(userName, passWord, new SupportingStaffManagerRole(),p);
        }
        supportingStaffName.setText("");
        supportingStaffuserName.setText("");
        supportingStaffPwd.setText("");
        populateTree();
        populateSupportingStaffComboBox();
        JOptionPane.showMessageDialog(null,"Supporting staff manager created!");
    }//GEN-LAST:event_submitSupportingStaffManagerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow>= 0){
            this.jPanel7.setVisible(true);
            this.player = (Player)jTable1.getValueAt(selectedRow, 0);
            fName.setText(this.player.getName());
            jPanel7.setVisible(true);
        }else JOptionPane.showMessageDialog(null, "Please select a Player!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameActionPerformed

    private void submitPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPlayerActionPerformed
        String firstName = fName.getText();
        String userName = jTextField1.getText();
        String passWord = jTextField2.getText();
        if(this.player == null){
            Player p = new Player();
            player.setName(firstName);
            this.currentClub.getClubPlayers().addPlayer(p);
            system.getUserAccountDirectory().createUserAccount(userName, passWord, new PlayerRole(),p);
            JOptionPane.showMessageDialog(null, "Player created succesfully!");
        }else {
            fName.setText(this.player.getName());
            this.player.setClub(this.currentClub);
            system.getUserAccountDirectory().createUserAccount(userName, passWord, new PlayerRole(),this.player);
            JOptionPane.showMessageDialog(null, "Player login created succesfully!");
            this.player = null;
        }
        fName.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jPanel7.setVisible(false);
    }//GEN-LAST:event_submitPlayerActionPerformed

    private void submitManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitManagerActionPerformed
        String userName = jTextField3.getText();
        String passWord = jTextField4.getText();
        String managerName = fName1.getText();
        //TeamManager tm = new  TeamManager(managerName, this.currentClub);
        this.currentClub.getManagerOrganization().getTm().setClub(this.currentClub);
        system.getUserAccountDirectory().createUserAccount(userName, passWord, new ManagerRole(), this.currentClub.getManagerOrganization().getTm());
        JOptionPane.showMessageDialog(null, "Manager login created succesfully!");
    }//GEN-LAST:event_submitManagerActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cl.show(this,"card5");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cl.show(this,"ownerMain");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       cl.show(this,"ownerMain");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       cl.show(this,"ownerMain");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cl.show(this,"ownerMain");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void supportingStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportingStaffActionPerformed
        Player supportingStaffManager = (Player) supportingStaff.getSelectedItem();
        if(supportingStaffManager != null)
        {
            supportingStaffName.setText(supportingStaffManager.getName());
        }
    }//GEN-LAST:event_supportingStaffActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
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
        for(Player p: this.currentClub.getClubPlayers().getPlayers()){
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

    private void pieChatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieChatButtonActionPerformed
        DefaultPieDataset dataset = new DefaultPieDataset( );
        double wins = 0;
        double loses = 0;
        double draws = 0;
        for(Match m :this.clubMatches){
            if(m.getScore().getWinner().equals("AWAY_TEAM")){
                if(m.getAwayTeam().getId().equals(this.currentClub.getId())){
                    wins++;
                }else loses++;
            }else if(m.getScore().getWinner().equals("HOME_TEAM")){
                if(m.getHomeTeam().getId().equals(this.currentClub.getId())){
                    wins++;
                }else loses++;
            }else if(m.getScore().getWinner().equals("DRAW")){
                draws++;
            }
        }

        dataset.setValue("Wins", (wins/(wins+loses+draws))*100);
        dataset.setValue("Loses",(loses/(wins+loses+draws))*100);
        dataset.setValue("Draws",(draws/(wins+loses+draws))*100);
        JFreeChart chart = ChartFactory.createPieChart("Win ratio", dataset,true,true,false);
        PiePlot p = (PiePlot) chart.getPlot();
        ChartFrame frame = new ChartFrame("Pie chart",chart);
        frame.setVisible(true);
        frame.setSize(450,500);
    }//GEN-LAST:event_pieChatButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cl.show(this, "card4");
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public void populateTree(){
        DefaultMutableTreeNode allPlayers;
        DefaultMutableTreeNode supportingStaff;
        DefaultMutableTreeNode playerNode;
        DefaultMutableTreeNode managerNode;
        DefaultMutableTreeNode supportingNode;
        DefaultTreeModel model=(DefaultTreeModel)jTree1.getModel();
        DefaultMutableTreeNode ClubOwnerNode =new DefaultMutableTreeNode(this.currentClub.getOwner());
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        model.setRoot(root);
        root.insert(ClubOwnerNode, 0);
        playerNode = new DefaultMutableTreeNode("Player Organization");
        managerNode = new DefaultMutableTreeNode("Manager Organization");
        supportingNode = new DefaultMutableTreeNode("supporting staff");
        ClubOwnerNode.insert(playerNode,0);
        ClubOwnerNode.insert(managerNode,1);
        ClubOwnerNode.insert(supportingNode,2);
        int countp = 0;
        for(Player p: this.currentClub.getClubPlayers().getPlayers()){
        p = this.currentClub.getClubPlayers().getPlayers().get(countp);
        allPlayers = new DefaultMutableTreeNode(p);
        playerNode.insert(allPlayers, countp);
        countp++;
        }
        DefaultMutableTreeNode teamManager = new DefaultMutableTreeNode(this.currentClub.getManagerOrganization().getTm().getManager());
        managerNode.insert(teamManager,0);
         int countS = 0;
        for(Player p: this.currentClub.getSupporttingStaff().getStaff()){
        p = this.currentClub.getSupporttingStaff().getStaff().get(countS);
        supportingStaff = new DefaultMutableTreeNode(p);
        supportingNode.insert(supportingStaff, countS);
        countS++;
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
    
    private void populatePlayerTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Player p : this.currentClub.getClubPlayers().getPlayers()){
            Object[] row = new Object[2];
            row[0] = p;
            row[1] = p.getPosition();
            model.addRow(row);
        }
    }
   
    private void populateSupportingStaffComboBox(){
        DefaultComboBoxModel cbm = (DefaultComboBoxModel) supportingStaff.getModel();
        cbm.removeAllElements();
            for(Player s: this.currentClub.getSupporttingStaff().getStaff()){
                cbm.addElement(s);
            }
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clubIcon;
    private javax.swing.JLabel clubNameJLabel;
    private javax.swing.JTextField fName;
    private javax.swing.JTextField fName1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton pieChatButton;
    private javax.swing.JTable standingTable;
    private javax.swing.JButton submitManager;
    private javax.swing.JButton submitPlayer;
    private javax.swing.JButton submitSupportingStaffManager;
    private javax.swing.JComboBox<String> supportingStaff;
    private javax.swing.JTextField supportingStaffName;
    private javax.swing.JPanel supportingStaffPanel;
    private javax.swing.JTextField supportingStaffPwd;
    private javax.swing.JTextField supportingStaffuserName;
    // End of variables declaration//GEN-END:variables
}
