
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class MainWindow extends javax.swing.JFrame {

    
     
        
       //Variablen für die DatenBank Verbindung erstellen
        private Connection con = null; 
        DatabaseMetaData md = null;
        
        
        PreparedStatement pst = null;
        ResultSet rs = null;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        
        //Verbindung mit MySQL durch den JDBC DriverManager Schnitstelle erstellen
        /*zusatzlich wird es um einen Try & Catch Block gegegeben, damit wir eine Fehlermeldung kriegen 
        wenn der Driver nicht ladet. 
       */
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            
            
            
          /* ClassNotFoundExeption wird ausgelöst, wenn eine Anwendung versucht, eine Klasse über ihren String-Namen zu laden.
            Die forName-Methode in der Klasse Class.(siehe oben^)
            ...
            Es wurde jedoch keine Definition für die Klasse mit dem angegebenen Namen gefunden.

            */
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not load mysql driver!");
            javax.swing.JOptionPane.showMessageDialog(this, "Error loading MySQL Driver");
           
            // Wenn das der Fall ist, schliess den Program.
            System.exit(1);
        }
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        lblServer = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntries = new javax.swing.JTable();
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblDatabase = new javax.swing.JLabel();
        txtDatabase = new javax.swing.JTextField();
        cbxTables = new javax.swing.JComboBox<String>();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        ctrNameIns = new javax.swing.JLabel();
        txtCtrInsert = new javax.swing.JTextField();
        txtPopIns = new javax.swing.JTextField();
        popIns = new javax.swing.JLabel();
        lblIDtodel = new javax.swing.JLabel();
        txtIDtodel = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblServer.setText("Server:");

        lblPort.setText("Port: ");

        txtServer.setText("localhost");
        txtServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerActionPerformed(evt);
            }
        });

        txtPort.setText("8080");
        txtPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPortActionPerformed(evt);
            }
        });

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnDisconnect.setText("Disconnect");
        btnDisconnect.setEnabled(false);
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        tblEntries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEntries.setCellSelectionEnabled(true);
        tblEntries.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblEntriesPropertyChange(evt);
            }
        });
        tblEntries.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblEntriesVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblEntries);

        lblUser.setText("User:");

        lblPassword.setText("Password: ");

        txtUser.setText("root");
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        lblDatabase.setText("Database: ");

        txtDatabase.setText("world");
        txtDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatabaseActionPerformed(evt);
            }
        });

        cbxTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTablesActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        ctrNameIns.setText("Name");

        txtCtrInsert.setText("Shkoder");
        txtCtrInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCtrInsertActionPerformed(evt);
            }
        });

        txtPopIns.setText("2800000");

        popIns.setText("Population");

        lblIDtodel.setText("id");

        txtIDtodel.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblServer)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPort)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPort)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ctrNameIns, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIDtodel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCtrInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(txtIDtodel))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword)
                                    .addComponent(lblUser)
                                    .addComponent(popIns))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                            .addComponent(txtPassword))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lblDatabase)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbxTables, 0, 130, Short.MAX_VALUE))))
                                    .addComponent(txtPopIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDisconnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(364, 364, 364)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServer)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatabase)
                    .addComponent(txtDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisconnect)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(ctrNameIns)
                    .addComponent(txtCtrInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPopIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(popIns))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(lblIDtodel)
                    .addComponent(txtIDtodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPortActionPerformed

    
    
    
    // Unten folgt die Funktionalität von dem Connect Button  
    
    
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        
        
        
        /* Erstellung von Variablen in denen die Input von Benutzer
           gespeichert wird. 
           Also, wir holen aus den Text Fields 
           der User, das Passwort, der Datenbankname und den Server und speichern sie in 
           Strings. 
        */
        
        String user = txtUser.getText();
        String password = txtPassword.getText();
        String database = txtDatabase.getText();
        String server = txtServer.getText();
        int port = 0; // Das Port wird zuerst mit 0 initialisiert
        
        
        
        try {
            
            /* ParseInt wird verwendet, um den primitiven Datentyp eines bestimmten
             Strings abzurufen. Also wir wandeln den Port auf einer String zu einem Integer. 
             Das alles wird um einen Try Catch Block gegeben, damit wir ein Fehlermeldung kriegen wenn
             ein falsches Portnummer hineingetippt wurde.
            */
            
            port = Integer.parseInt(txtPort.getText());
            
            
            
            
        } catch (NumberFormatException ex) {
            
            /*
         
            NumberFormatException wird ausgelöst, 
            wenn eine Zeichenfolge nicht in eine Zahl formatiert (konvertiert) werden kann.
            */
            
            System.out.println("Please insert a correct port number!");
            javax.swing.JOptionPane.showMessageDialog(this, "Please insert a correct port number");
        }

        try {
            
            /* Verbindung herstellen 
            DriveManager diese vollständig implementierte Klasse verbindet
            unsere Anwendung mit der Datenbank mittels seine URL.
            Natürlich sind server, port, datenbank, benutzername und passwort vom Benutzer gesetzt. 
            */
            
            con = DriverManager.getConnection 
            ("jdbc:mysql://" + server + ":" + port + "/" + database, user, password);
            
            /* getEnabled () wird uns den korrekten Status wiedergeben
            in dem Moment setzen wir alles auf False aus folgenden Grund:
             damit der Benutzer kein Input mehr in die Text Fields eingeben kann
            */
            
            txtUser.setEnabled(false);
            txtPassword.setEnabled(false);
            txtDatabase.setEnabled(false);
            txtServer.setEnabled(false);
            txtPort.setEnabled(false);
            btnConnect.setEnabled(false);
            btnDisconnect.setEnabled(true); 
            cbxTables.setEnabled(true);
            
            
            
        // Exception ausloesen wenn die Verbindung mit der Datenbank fehlschlägt.
        } catch (SQLException ex) {
            System.out.println("Could not connect to world database!");
            javax.swing.JOptionPane.showMessageDialog(this, "Could not connect to Server");
        }

        
        try {
            
            /*
            Wir wollen die Datenbank mit  SELECT-Anweisungen abfragen, 
            deswegen ist es notwendig die Ergebnise in einem ResultSet-Objekt speichern.
            (die haben wir frueher mit null initialisiert)
            */ 
            
            md = con.getMetaData();
            
            ResultSet rs = md.getTables(null, null, null, null);
            while (rs.next()) {
                cbxTables.addItem(rs.getString(3));
               
            }
        } catch (SQLException ex) {
            System.out.println("Could not retrieve database meta-data");
            javax.swing.JOptionPane.showMessageDialog(this, "Could not retrieve database meta-data");
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    
    
    
    
    //Unten folgt die Funktionalität unserer Disconnect Button.
    
    
    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed

        try {
            
            /* Wenn der Benutzer auf Disconnect druckt, soll die Verbindung ausfallen, also 
            geschlossen werden. 
            */
            con.close();

            // Jetzt nachdem keine Verbindung mehr da ist. darf der Benutzer in die Text Fields text eingeben.
            txtUser.setEnabled(true);
            txtPassword.setEnabled(true);
            txtDatabase.setEnabled(true);
            txtServer.setEnabled(true);
            txtPort.setEnabled(true);
            btnConnect.setEnabled(true);
            btnDisconnect.setEnabled(false);
            
            
            
            //Das Standardmodell für Kombinationsfelder setzen
            cbxTables.setModel(new DefaultComboBoxModel<String>());
            // Kombinationsfeld auf false setzen damit wir auf den keine Aktion fuehren. 
            cbxTables.setEnabled(false);

            //Hier folgt die Erstellung von der Tabelle. 
            tblEntries.setModel(new DefaultTableModel());
            
            tblEntries.setEnabled(false);
        } catch (SQLException ex) {
            System.out.println("Error closing database connection");
            javax.swing.JOptionPane.showMessageDialog(this, "Error closing database connection");
        }


    }//GEN-LAST:event_btnDisconnectActionPerformed

    
    //Unten folgt die Funktionalitaet des Kombinationsfeld. 
    private void cbxTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTablesActionPerformed
        
        
        int num_columns = 0;
 
        try {
            
            /*Hier speichern wir die Columns in einem Resultset und benutzen unseren md Objekt die die Daten von Datenbank 
             holt. */
            ResultSet result = md.getColumns(null, null, cbxTables.getSelectedItem().toString(), null);

            /*
            DefaultTableModel ist eine Implementierung von TableModel,
            die einen Vektor der Vektoren zum Speichern der Zellenwertobjekte verwendet.
            */
            DefaultTableModel tableModel = new DefaultTableModel();
            
            //Schleife durch die Spalten zählen und Daten in die Tabelle speichern.
            while (result.next()) {
                String columnName = result.getString(4);

                tableModel.addColumn(columnName);
                num_columns++;
                
                
            }
            //  Das Modell auf den Table setzen.
            tblEntries.setModel(tableModel);

        } catch (SQLException ex) {
            System.out.println("Error building column structure for table " + cbxTables.getSelectedItem().toString());
            javax.swing.JOptionPane.showMessageDialog(this, "Error building column structure for table " + cbxTables.getSelectedItem().toString());
        }

        
        
        // Neue Statement erzeugen
        Statement stmt;
        try {
            
            // mit der Datenbank verbinden
            stmt = con.createStatement();
            
            // Selektierte Daten in ResultSet speichern. 
            ResultSet res = stmt.executeQuery("SELECT * FROM " + cbxTables.getSelectedItem().toString());
            //Schleife zahlt durch solange es spalten gibt. 
            while (res.next()) {
                
                // Array Object erzeugen, also die Tabelle mit den Daten einfüllen
                Object[] row = new Object[num_columns];
                for (int i = 1; i <= num_columns; i++) {
                    row[i - 1] = res.getObject(i);
                }
                ((DefaultTableModel) tblEntries.getModel()).insertRow(res.getRow() - 1, row);
            }
            
            
            
            
            tblEntries.getModel().addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    
                    //Wenn eine Änderung gescheht, "Table Changed" auf den Bildschirm zeigen. 
                    System.out.println("table changed");
                }
            });

        } catch (SQLException ex) {
            System.out.println("Error building result table from database");
            javax.swing.JOptionPane.showMessageDialog(this, "Error building result table from database");
        }
        
        
        


    }//GEN-LAST:event_cbxTablesActionPerformed

    private void tblEntriesVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblEntriesVetoableChange
        // System.out.println("row edited");
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEntriesVetoableChange

    private void tblEntriesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblEntriesPropertyChange
        // TODO add your handling code here:
       // System.out.println("row edited");
    }//GEN-LAST:event_tblEntriesPropertyChange

    private void txtDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatabaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatabaseActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // Hier drinnen folgt die Funktionalität der Insert Button:
        
        
         
         
        try{
            
        //Connection aufbauen  
        String user = txtUser.getText();
        String password = txtPassword.getText();
        String database = txtDatabase.getText();
        String server = txtServer.getText();
        int port = 0;
      
        con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, user, password);
        
        //User Input fuer countryName und 
        String countryName= txtCtrInsert.getText(); 
        String population= txtPopIns.getText(); 
        
        String insertBefehl = "INSERT INTO CITY (Name, population) VALUES("
                + "?,?)" ;  
            
                    
        
        
        
                pst = con.prepareStatement(insertBefehl) ;
                pst.setString(1, countryName);
                pst.setString(2, population);
                // Anweisung zum Einfügen von SQL Prepared Statement
                pst.executeUpdate(); 
                JOptionPane.showMessageDialog(null, "Einfügen von Datensatz erfolgreich geschlossen.");
                
            } catch (SQLException ex) {
                System.out.println("Fehler beim Einfügen von Datensätze");
            }
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
     
        try{
            
        //Connection aufbauen
        String user = txtUser.getText();
        String password = txtPassword.getText();
        String database = txtDatabase.getText();
        String server = txtServer.getText();
        
        int port = 0;
        
         con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, user, password);
        // SQL Befehl fuers Löschen in einer Variable speichern und in Statement führen.
        String sql = "DELETE FROM city WHERE ID =?";
       
        pst = con.prepareStatement(sql);
        // Den Statement der Input Id als parameter geben. 
        pst.setString(1,txtIDtodel.getText());
        pst.executeUpdate();
        System.out.println("Löschen von Datensatz erfolgreich");

        }
        catch(SQLException ex){
            System.out.println("Löschen von Datensatz funktioniert leider nicht :( ");
}
        
            

            
            /*
        
            
            delete version 1.5
        
            / i = indize von den selektierten Zeile. 
            try{   
            DefaultTableModel tableModel = new DefaultTableModel();
            int i = tblEntries.getSelectedRow();
            if (i >= 0) {
            // remove a row from jtable
            tableModel.removeRow(i);
            }
            else{
            System.out.println("There were issue while Deleting the Row(s).");
            }
            }
            catch(SQLException e){
                
                System.out.println("");
            }
            
         
            
      // Class.forName("com.mysql.jdbc.Driver");
        
        
        /*
        String user = txtUser.getText();
        String password = txtPassword.getText();
        String database = txtDatabase.getText();
        String server = txtServer.getText();
        
        
        
        
        String id = txtCtrDel.getText();
        int port = 0;
        con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, user, password);

        PreparedStatement st = con.prepareStatement("DELETE * FROM City WHERE name = id ");
        st.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        */ 
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServerActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtCtrInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCtrInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCtrInsertActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> cbxTables;
    private javax.swing.JLabel ctrNameIns;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JLabel lblIDtodel;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblServer;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel popIns;
    private javax.swing.JTable tblEntries;
    private javax.swing.JTextField txtCtrInsert;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JTextField txtIDtodel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPopIns;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
