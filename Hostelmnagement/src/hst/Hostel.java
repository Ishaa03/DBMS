package hst;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Hostel{
    private JFrame frame;
    private Connection con;
    private Statement stmt;

    private JTextField idField;
    private JTextField nameField;
    private JTextField feesField;
    private JTextField roomNoField;
    private JTextField roomTypeField;
    private JTextField occupancyField;
    private JTextArea resultArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Hostel window = new Hostel();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Hostel() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Hostel Management System");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleLabel.setBounds(200, 10, 300, 20);
        frame.getContentPane().add(titleLabel);

        // Building Record Fields
        idField = new JTextField();
        idField.setBounds(50, 60, 120, 25);
        frame.getContentPane().add(idField);

        nameField = new JTextField();
        nameField.setBounds(200, 60, 120, 25);
        frame.getContentPane().add(nameField);

        feesField = new JTextField();
        feesField.setBounds(350, 60, 120, 25);
        frame.getContentPane().add(feesField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(80, 90, 50, 20);
        frame.getContentPane().add(idLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(230, 90, 50, 20);
        frame.getContentPane().add(nameLabel);

        JLabel feesLabel = new JLabel("Fees:");
        feesLabel.setBounds(380, 90, 50, 20);
        frame.getContentPane().add(feesLabel);

        JButton insertBuildingButton = new JButton("Insert");
        insertBuildingButton.addActionListener(e -> insertBuildingRecord());
        insertBuildingButton.setBounds(60, 120, 100, 25);
        frame.getContentPane().add(insertBuildingButton);
        
        JButton deleteBuildingButton = new JButton("Delete");
        deleteBuildingButton.addActionListener(e -> deleteBuildingRecord());
        deleteBuildingButton.setBounds(160, 120, 100, 25);
        frame.getContentPane().add(deleteBuildingButton);
        
        JButton displayBuildingButton = new JButton("Display");
        displayBuildingButton.addActionListener(e -> displayBuildingRecords());
        displayBuildingButton.setBounds(270, 120, 100, 25);
        frame.getContentPane().add(displayBuildingButton);

        JButton updateBuildingButton = new JButton("Update");
        updateBuildingButton.addActionListener(e -> updateBuildingRecord());
        updateBuildingButton.setBounds(380, 120, 100, 25);
        frame.getContentPane().add(updateBuildingButton);


        // Room Record Fields
        roomNoField = new JTextField();
        roomNoField.setBounds(50, 160, 120, 25);
        frame.getContentPane().add(roomNoField);

        roomTypeField = new JTextField();
        roomTypeField.setBounds(200, 160, 120, 25);
        frame.getContentPane().add(roomTypeField);

        occupancyField = new JTextField();
        occupancyField.setBounds(350, 160, 120, 25);
        frame.getContentPane().add(occupancyField);

        JLabel roomNoLabel = new JLabel("Room No:");
        roomNoLabel.setBounds(80, 190, 80, 20);
        frame.getContentPane().add(roomNoLabel);

        JLabel roomTypeLabel = new JLabel("Room Type:");
        roomTypeLabel.setBounds(230, 190, 80, 20);
        frame.getContentPane().add(roomTypeLabel);

        JLabel occupancyLabel = new JLabel("Occupancy:");
        occupancyLabel.setBounds(380, 190, 80, 20);
        frame.getContentPane().add(occupancyLabel);

        JButton insertRoomButton = new JButton("Insert Room");
        insertRoomButton.addActionListener(e -> insertRoomRecord());
        insertRoomButton.setBounds(50, 220, 150, 25);
        frame.getContentPane().add(insertRoomButton);

        JButton deleteButton = new JButton("Delete Room");
        deleteButton.addActionListener(e -> deleteRoomRecord());
        deleteButton.setBounds(210, 220, 150, 25);
        frame.getContentPane().add(deleteButton);

        JButton displayButton = new JButton("Display Room");
        displayButton.addActionListener(e -> displayRoomRecords());
        displayButton.setBounds(370, 220, 150, 25);
        frame.getContentPane().add(displayButton);

        JButton updateRoomButton = new JButton("Update Room");
        updateRoomButton.addActionListener(e -> updateRoomRecord());
        updateRoomButton.setBounds(50, 250, 150, 25);
        frame.getContentPane().add(updateRoomButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> exitApplication());
        exitButton.setBounds(370, 250, 150, 25);
        frame.getContentPane().add(exitButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBounds(50, 280, 470, 80);
        frame.getContentPane().add(resultArea);
    }

    private Object displayBuildingRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object updateBuildingRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object deleteBuildingRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	private void connectToDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "Vijay@1972");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBuildingRecord() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int fees = Integer.parseInt(feesField.getText());

            String insertQuery = "INSERT INTO building VALUES (" + id + ", '" + name + "', " + fees + ")";
            stmt.executeUpdate(insertQuery);
            resultArea.setText("Building record inserted successfully.");
        } catch (Exception e) {
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void insertRoomRecord() {
        try {
            int roomNo = Integer.parseInt(roomNoField.getText());
            String roomType = roomTypeField.getText();
            int occupancy = Integer.parseInt(occupancyField.getText());

            String insertQuery = "INSERT INTO room VALUES (" + roomNo + ", '" + roomType + "', " + occupancy + ")";
            stmt.executeUpdate(insertQuery);
            resultArea.setText("Room record inserted successfully.");
        } catch (Exception e) {
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void deleteRoomRecord() {
        try {
            int roomNo = Integer.parseInt(roomNoField.getText());
            String deleteQuery = "DELETE FROM room WHERE room_no = " + roomNo;
            stmt.executeUpdate(deleteQuery);
            resultArea.setText("Room record deleted successfully.");
        } catch (Exception e) {
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void displayRoomRecords() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM room");
            resultArea.setText("Room No\tRoom Type\tOccupancy\n");
            while (rs.next()) {
                int roomNo = rs.getInt(1);
                String roomType = rs.getString(2);
                int occupancy = rs.getInt(3);
                resultArea.append(roomNo + "\t" + roomType + "\t" + occupancy + "\n");
            }
        } catch (Exception e) {
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void updateRoomRecord() {
        try {
            int roomNo = Integer.parseInt(roomNoField.getText());
            String roomType = roomTypeField.getText();
            int occupancy = Integer.parseInt(occupancyField.getText());

            String updateQuery = "UPDATE room SET room_type = '" + roomType + "', occupancy = " + occupancy + " WHERE room_no = " + roomNo;
            int rowsUpdated = stmt.executeUpdate(updateQuery);

            if (rowsUpdated > 0) {
                resultArea.setText("Room record updated successfully.");
            } else {
                resultArea.setText("No room record found for update.");
            }
        } catch (Exception e) {
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void exitApplication() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.dispose();
    }
}
