package nl.hu.pafr.ass2.richrail;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import nl.hu.pafr.ass2.controller.Controller;
import nl.hu.pafr.ass2.model.Train;
import nl.hu.pafr.ass2.model.Wagon;


public class RichRail extends javax.swing.JFrame implements ActionListener {
	
	private JButton ExecuteButton;	
	private JPanel RightPanel;
	private JPanel LeftPanel;
	private JPanel drawPanel;
	private JLabel CommandLabel;	
	private JTextField CommandField;
	private JTextArea rightOutput;
	private JTextArea leftOutput;
	private Controller controller = new Controller();
	private ArrayList<Train> allTrains = new ArrayList<Train>();
	
	
	
	private double[] weights = new double[] { 0.1, 0.1, 0.1, 0.1 };
	private int[]    heights = new int[]    { 7,   7,   7,   7   }; 
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RichRail richrail = new RichRail();
				richrail.setLocationRelativeTo(null);
				richrail.setVisible(true);
			}
		});
	}
	
	
	
	public RichRail() {
		super();
		initGUI();
	}
	
	// Create the GUI
	private void initGUI() {
		try {
			this.setTitle("RichRail");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);			
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.rowWeights = weights;
			gridBagLayout.rowHeights = heights;
			gridBagLayout.columnWeights = weights;
			gridBagLayout.columnWidths = heights;
			getContentPane().setLayout(gridBagLayout);
			
			
			// Upper Draw Panel
			drawPanel = new JPanel();
			drawPanel.setLayout(new BorderLayout());
			drawPanel.setBackground(Color.WHITE);
			getContentPane().add(drawPanel, new GridBagConstraints(0, 0, 4, 2, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			drawPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			
			
			GridBagLayout gridBagLayout1 = new GridBagLayout();	
			gridBagLayout1.rowWeights = weights;
			gridBagLayout1.rowHeights = heights;
			gridBagLayout1.columnWeights = weights;
			gridBagLayout1.columnWidths = heights;
			
			
			// Left Panel			
			LeftPanel = new JPanel();
			LeftPanel.setBounds(10, 10, 100, 15);	
			LeftPanel.setLayout(gridBagLayout1);
			getContentPane().add(LeftPanel, new GridBagConstraints(0, 2, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			LeftPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			
			
			// Left Output
			leftOutput = new JTextArea();				
			leftOutput.setLineWrap(true);
			leftOutput.setWrapStyleWord(true);
			leftOutput.setEditable(false);
			LeftPanel.add(leftOutput, new GridBagConstraints(0, 0, 4, 3, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			
						
			// Label Before Text Field For Commands
			CommandLabel = new JLabel();
			CommandLabel.setText("Command:");
			LeftPanel.add(CommandLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			
			
			// Text Field For Commands
			CommandField = new JTextField(20);
			LeftPanel.add(CommandField, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			
			
			// Execute Button			
			ExecuteButton = new JButton();
			LeftPanel.add(ExecuteButton, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			ExecuteButton.setText("Execute");
			ExecuteButton.addActionListener(this);
			
					
			// Grid Layout
			GridBagLayout gridBagLayout2 = new GridBagLayout();
			gridBagLayout2.rowWeights = weights;
			gridBagLayout2.rowHeights = heights;
			gridBagLayout2.columnWeights = weights;
			gridBagLayout2.columnWidths = heights;
			
			
			// Right Panel
			RightPanel = new JPanel();
			getContentPane().add(RightPanel, new GridBagConstraints(1, 2, 2, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			RightPanel.setLayout(gridBagLayout2);
			RightPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			
			
			
		
			
			// Right Output
			rightOutput = new JTextArea();				
			rightOutput.setLineWrap(true);
			rightOutput.setBackground(Color.black);
			rightOutput.setForeground(Color.white);
			rightOutput.setWrapStyleWord(true);
			rightOutput.setEditable(false);			
			RightPanel.add(rightOutput, new GridBagConstraints(0, 0, 4, 3, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			
			
			pack();
			setSize(1000, 800);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == ExecuteButton) {
			executeCommand();			
		}
	}
	
	
	
	public void executeCommand() {
		String command = CommandField.getText();
		rightOutput.append("<< " + command + "\n");
		
		
		
		if(command.toLowerCase().contains("new train")) {
			
			String[] arr = command.split("new train");		
			if(controller.newTrain(arr[1].trim()) == null) responseOutput("Train " + arr[1].trim() + " already exists");
			else responseOutput("train " + arr[1].trim() + " created");
			
		} else if(command.toLowerCase().contains("new wagon")) {
			
			String[] arr = command.split("new wagon");
			if(controller.getSelectedTrain() != null) {
				controller.getSelectedTrain().addWagon(new Wagon(arr[1].trim()));
				responseOutput("wagon " + arr[1].trim() + " created with 20 seats");	
			}
			else responseOutput("No selected train");
				
			
		} else if(command.toLowerCase().contains("new wagon") && command.toLowerCase().contains("numseats")) {
			
		} else if(command.toLowerCase().contains("add") && command.toLowerCase().contains("to")) {
			
		} else if(command.toLowerCase().contains("getnumseats train")) {
			
		} else if(command.toLowerCase().contains("getnumseats wagon")) {
			
		} else if(command.toLowerCase().contains("delete train")) {
			// Check if train exists
		} else if(command.toLowerCase().contains("remove") && command.toLowerCase().contains("from")) {
			
		} else {
			responseOutput("Command not recognized");
		}
		
		
		//
//		new train tr1; // response is “train tr1 created”
//		new wagon wg1; // response is “wagon wg1 created with 20 seats”
//		new wagon wg2 numseats 15; // response is “wagon wg2 created with 15 seats”
//		add wg1 to tr1; // response: “wagon wg1 added to train tr1”
//		getnumseats train tr1; // response: “number of seats in train tr1: 20”
//		getnumseats wagon wg2; // response: “number of seats in wagon wg2: 15”
//		delete train tr1; // response: “train tr1 deleted”
//		delete train tr2; // response: “train tr2 does not exist”
//		remove wg1 from tr1; // response: “wagon wg1 removed from train tr1”
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	public void responseOutput(String response) {
		rightOutput.append(">> " + response + "\n");
	}
	
	
	

	
	
	
	
	
	
}
