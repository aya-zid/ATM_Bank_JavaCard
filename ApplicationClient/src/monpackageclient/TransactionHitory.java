package monpackageclient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TransactionHitory extends JFrame {
    private JTable table;
    
    public TransactionHitory() {
        setTitle("Transaction History");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a table model and add data from the file
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Date");
        tableModel.addColumn("Hour");
        tableModel.addColumn("Transaction");
        tableModel.addColumn("Amount");

        try {
            FileReader fileReader = new FileReader("transaction_history.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] rowData = line.split(" ");
                tableModel.addRow(rowData);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a JTable with the model
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
