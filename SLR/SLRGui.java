
package handson.slr;

import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SLRGui extends JFrame {	
	private OneShotAgent myAgent;
	
	private JTextField xValueField;
	
	SLRGui(OneShotAgent a) {
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 2));
		p.add(new JLabel("Valor de x:"));
		xValueField = new JTextField(15);
		p.add(xValueField);
		getContentPane().add(p, BorderLayout.CENTER);
		
		JButton addButton = new JButton("Calcular");
		addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String xValue = xValueField.getText().trim();
					myAgent.predict(Integer.parseInt(xValue));
					xValueField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(SLRGui.this, "Valor incorrecto "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		p = new JPanel();
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);
		
		// Make the agent terminate when the user closes 
		// the GUI using the button on the upper right corner	
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		} );
		
		setResizable(true);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, 100);
		pack();
		super.setVisible(true);
	}
}