
package handson.slr;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;


// javac -cp lib\jade.jar src\examples\SimpleLR\*.java -d classes\
//java -cp lib\jade.jar;classes\ jade.Boot -gui SLR:handson.slr.OneShotAgent

public class OneShotAgent extends Agent{

    private SLRGui myGui;
    private SimpleLinearRegression slr;

    protected void setup() {
        System.out.println("Hi!!! --- " + getLocalName());

        myGui = new SLRGui(this);
        slr = new SimpleLinearRegression();
    }

    public void predict(int value){
        addBehaviour(new OneShotBehaviour() {
            public void action(){
                slr.printRegressionEquation();
                slr.predictY(value);
            }
        });
    }
}