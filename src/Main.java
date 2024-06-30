import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcao = 0;
        double valor = 0;
        Scanner entrada = new Scanner(System.in);

        while (opcao != 5) {

            var moeda = new ConsultarMoeda();


            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(moeda.textoInicial()));
            } catch (InputMismatchException | NullPointerException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Opção inválida, Escolha uma nova opção!");
                opcao = Integer.parseInt(JOptionPane.showInputDialog(moeda.textoInicial()));
            }

            if(opcao == 5){
                break;
            }

            try {
                valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja converter:"));
            } catch (InputMismatchException | NullPointerException | NumberFormatException e){
                valor = Double.parseDouble(JOptionPane.showInputDialog("Valor inválido! Digite novamente o valor que deseja converter:"));
            }


            moeda.EscolherMoedas(opcao, valor);
            Desserializar novaConsulta = moeda.consultaMoeda(moeda.getMoeda1());



            if(opcao != 5) {
                try {
                    Map<String, Double> moedasConversao = novaConsulta.conversion_rates();
                    double valorMoedaConvertida = moedasConversao.get(moeda.getMoeda2());
                    JOptionPane.showMessageDialog(null,moeda + "" + valor * valorMoedaConvertida);
                    opcao = 0;

                } catch (InputMismatchException | NullPointerException | NumberFormatException e) {
                    System.out.println("Não foi possivel realizar a conversão, verifique se os dados foram inseridos corretamente e tente outra vez!");
                }
            }
        }
        System.out.println("Programa Encerrado!");
    }
}