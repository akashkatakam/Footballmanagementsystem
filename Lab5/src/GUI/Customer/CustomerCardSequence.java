/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Customer;

import Business.Abstract.User;
import Business.CustomerDirectory;
import Business.Users.Customer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author akash
 */
public class CustomerCardSequence extends javax.swing.JPanel {

    /**
     * Creates new form CustomerCardSequence
     */
    private CustomerDirectory custDirectory;
    public CustomerCardSequence( CustomerDirectory customerDirectory) {
        initComponents();
        this.custDirectory = customerDirectory;
        populateCombobox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginCustomer = new javax.swing.JPanel();
        txtPword = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userCombo = new javax.swing.JComboBox();

        setLayout(new java.awt.CardLayout());

        btnSubmit.setText("Login");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Customer Login");

        jLabel2.setText("Password");

        userCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout loginCustomerLayout = new javax.swing.GroupLayout(loginCustomer);
        loginCustomer.setLayout(loginCustomerLayout);
        loginCustomerLayout.setHorizontalGroup(
            loginCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginCustomerLayout.createSequentialGroup()
                .addGroup(loginCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginCustomerLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2))
                    .addGroup(loginCustomerLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(loginCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSubmit)
                            .addComponent(jLabel1)))
                    .addGroup(loginCustomerLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(userCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(loginCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loginCustomerLayout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(117, Short.MAX_VALUE)))
        );
        loginCustomerLayout.setVerticalGroup(
            loginCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginCustomerLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(userCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(btnSubmit)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(loginCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loginCustomerLayout.createSequentialGroup()
                    .addGap(135, 135, 135)
                    .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(143, Short.MAX_VALUE)))
        );

        add(loginCustomer, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
         Customer customerSelected =  (Customer)userCombo.getSelectedItem();
         if(customerSelected.verify(txtPword.getText())){
             JOptionPane.showMessageDialog(null, "111111");
         }
        
    }//GEN-LAST:event_btnSubmitActionPerformed
    public void populateCombobox(){
        DefaultComboBoxModel cbm = (DefaultComboBoxModel) userCombo.getModel();
        for(User c :custDirectory.getCustomerList()){
            cbm.addElement(c);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel loginCustomer;
    private javax.swing.JTextField txtPword;
    private javax.swing.JComboBox userCombo;
    // End of variables declaration//GEN-END:variables
}
