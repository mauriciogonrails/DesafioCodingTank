import java.util.Scanner;

public class CalculoSalario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salariosBrutos = new double[5];


        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o salário bruto do funcionário " + (i + 1) + ": ");
            salariosBrutos[i] = scanner.nextDouble();
        }

        System.out.println();


        double[] faixasInss = {1212.00, 2427.35, 3641.03, 7087.22, Double.MAX_VALUE};
        double[] percentuaisInss = {0.075, 0.09, 0.12, 0.14, 0.14};
        double[] faixasIr = {1903.98, 2826.65, 3751.05, 4664.68, Double.MAX_VALUE};
        double[] percentuaisIr = {0, 0.075, 0.15, 0.225, 0.275};


        for (double salarioBruto : salariosBrutos) {
            double descontoInss = calcularDesconto(salarioBruto, faixasInss, percentuaisInss);
            double descontoIr = calcularDesconto(salarioBruto, faixasIr, percentuaisIr);
            double salarioLiquido = salarioBruto - descontoInss - descontoIr;

            System.out.printf("Salário Bruto: R$ %.2f\n", salarioBruto);
            System.out.printf("Desconto INSS: R$ %.2f\n", descontoInss);
            System.out.printf("Desconto IR: R$ %.2f\n", descontoIr);
            System.out.printf("Salário Líquido: R$ %.2f\n\n", salarioLiquido);
        }

        scanner.close();
    }


    public static double calcularDesconto(double salarioBruto, double[] faixas, double[] percentuais) {
        for (int i = 0; i < faixas.length; i++) {
            if (salarioBruto <= faixas[i]) {
                return salarioBruto * percentuais[i];
            }
        }
        return 0;
    }
}
