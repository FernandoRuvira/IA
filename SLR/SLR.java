package examples.SLR;

public class SLR{
    //Variables globales para el dataset y los calculos de beta0 y beta1
    private static double[][] datos = null;
    private static double beta0 = 0.0;
    private static double beta1 = 0.0;

    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++)
            System.out.println(args[i] + ": " + (beta0 + Double.parseDouble(args[i]) * beta1));
    }

    public void print(String x) {
        inicializarDatos();
        System.out.println("Ecuacion lineal: y = " + beta0 + " + " + beta1 + "x");
        System.out.println(x + ": " + (beta0 + Double.parseDouble(x) * beta1));
    }

    private static void inicializarDatos() {
        datos = new double[2][12];

        datos[0][0] = 12;     datos[1][0] = 14;
        datos[0][1] = 34;     datos[1][1] = 32;
        datos[0][2] = 11;     datos[1][2] = 11;
        datos[0][3] = 11;     datos[1][3] = 11;
        datos[0][4] = 78;     datos[1][4] = 11;
        datos[0][5] = 21;     datos[1][5] = 48;
        datos[0][6] = 24;     datos[1][6] = 23;
        datos[0][7] = 53;     datos[1][7] = 22;
        datos[0][8] = 11;     datos[1][8] = 21;
        datos[0][9] = 22;     datos[1][9] = 13;
        datos[0][10] = 33;    datos[1][10] = 14;
        datos[0][11] = 19;    datos[1][11] = 15;

        calcularBeta0(12);
        calcularBeta1(12);
    }

    private static double sumaSimple(int f1, int i, int n) {
        double suma = 0.0;
        for(int j = i - 1; j < n; j++){
            suma += datos[f1][j];
        }
        return suma;
    }

    private static double sumaProductos(int f1, int f2, int i, int n) {
        double suma = 0.0;
        for(int j = i - 1; j < n; j++){
            suma += datos[f1][j] * datos[f2][j];
        }
        return suma;
    }

    private static double calcularBeta0(int n) {
        beta0 = (sumaSimple(1, 1, 12) / n) - (calcularBeta1(n) * (sumaSimple(0, 1, 12) / n));
        return beta0;
    }

    private static double calcularBeta1(int n) {
        beta1 = (n * sumaProductos(0, 1, 1, 12) - sumaSimple(0, 1, 12) * sumaSimple(1, 1, 12)) / (n * sumaProductos(0, 0, 1, 12) - Math.pow(sumaSimple(0, 1, 12), 2.0));
        return beta1;
    }
}
