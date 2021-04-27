

package examples.SLR;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
 * @author ferru
*/

public class TeacherSLR extends Agent {

    // The GUI by means of which the user can add x
    private TeacherGui myGui;

    protected void setup(){

        myGui = new TeacherGui(this);
        myGui.showGui();

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());

        ServiceDescription sd = new ServiceDescription();

        sd.setType("University Teacher");
        sd.setName("JADE-university-teacher");

        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        }
        catch (FIPAException fe) {
            fe.printStackTrace();
        }
        
    }

    // Put agent clean-up operations here
	protected void takeDown() {
		// Deregister from the yellow pages
		try {
			DFService.deregister(this);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}
		// Close the GUI
		myGui.dispose();
		// Printout a dismissal message
		System.out.println("Teacher-agent "+getAID().getName()+" terminating.");
    }
    
    public void dataReq(String x){
        addBehaviour(new OneShotBehaviour(){
            public void action() {
                SLRegression slr = new SLRegression();
                slr.print(x);
			}
        });
    }
}
