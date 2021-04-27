 package examples.SLR;

 import jade.core.AID;

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 /**
  * @author ferru
  */

  class TeacherGui  extends JFrame {


    private TeacherSLR professor;

    private JTextField nValuex;

    TeacherGui(TeacherSLR t){
        super(t.getLocalName());

        professor = t;

        JPanel p = new JPanel();

        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Valor de X:"));
        nValuex = new JTextField(20);
        p.add(nValuex);

        getContentPane().add(p, BorderLayout.CENTER);

        JButton btnAdd = new JButton("add");
        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
               try{
                   String x = nValuex.getText().trim();
                   professor.dataReq(x);
                   nValuex.setText("");
               }catch(Exception e){
                   System.out.println("Error with the information. "+e.getMessage());
               }
            }
        });
        p = new JPanel();
        p.add(btnAdd);
        getContentPane().add(p, BorderLayout.SOUTH);

        // Make the agent terminate when the user closes 
        // the GUI using the button on the upper right corner	
        addWindowListener(new	WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            professor.doDelete();
          }
        } );

        setResizable(false);
    }

    public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}

  }