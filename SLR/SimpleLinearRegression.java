
package handson.slr;

/**
 *
 * @author ferru
 */
public class SimpleLinearRegression {

    private class DataSet {
        public int n;
        public final int[] x;
        public final int[] y;

        public final double sumX;
        public final double sumX2;
        public final double sumXY;
        public final double sumY;

        public DataSet(int n) {
            this.n = 9;
            // "y" son las Sales y "x" el advertising
            this.x = new int[]{23, 26, 30, 34, 43, 48, 52, 57, 58};
            this.y = new int[]{651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};

            double _sumX = 0;
            double _sumX2 = 0;
            double _sumXY = 0;
            double _sumY = 0;

            for (int i = 0; i < this.n; i++) {
                _sumX += this.x[i];
                _sumX2 += this.x[i]*this.x[i];
                _sumXY += this.x[i]*this.y[i];
                _sumY += this.y[i];
            }
            sumX = _sumX;
            sumY = _sumY;
            sumX2 = _sumX2;
            sumXY = _sumXY;
        }
    }
    
    private DataSet ds;
    public double beta0;
    public double beta1;
    
    
    public SimpleLinearRegression() {
        this.ds = new DataSet(9);
        beta0 = this.dBeta0()/this.dSystem();
        beta1 = this.dBeta1()/this.dSystem();
    }
    
    private double dBeta0(){
        return (this.ds.sumX2*this.ds.sumY)- (this.ds.sumX*this.ds.sumXY);
    }
    
    private double dBeta1(){
        return (this.ds.n*this.ds.sumXY)-(this.ds.sumX*this.ds.sumY);
    }
    
    private double dSystem(){
        return (this.ds.n*this.ds.sumX2)-(this.ds.sumX*this.ds.sumX);
    }
    
    public void printRegressionEquation(){
        System.out.println("y = "+String.valueOf(beta0)+" + "+String.valueOf(beta1)+"x");
    }
    
    public void predictY(int x){
        System.out.println("Valor de x: "+String.valueOf(x));
        System.out.println("Prediccion: y = "+String.valueOf(beta0+beta1*x));
    }
}
