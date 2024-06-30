import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoeda {

    private String moeda1;
    private String moeda2;

    private double valorParaConverter;
    public String getMoeda1() {
        return this.moeda1;
    }

    public String getMoeda2() {
        return this.moeda2;
    }

    public double getValorParaConverter() {
        return valorParaConverter;
    }

    String textoInicial(){
        return "~~~~~~~~//~~~~~~~~~~~~~~~~~~~~~~//~~~~~~~~\n" +
                "Digite o número referente a ação que deseja executar:\" \n" +
                "1 - Real >>> Dólar\n"  +
                "2 - Dólar >>> Real\n" +
                "3 - Real >>> Iene\n" +
                "4 - Iene >>> Real\n" +
                "5 - Sair\n" +
                "~~~~~~~~//~~~~~~~~~~~~~~~~~~~~~~//~~~~~~~~"
        ;
    }

    public void EscolherMoedas(int Opcao, Double valor) {


            if (Opcao == 1) {
                this.moeda1 = "BRL";
                this.moeda2 = "USD";
                this.valorParaConverter = valor;
            } else if (Opcao == 2) {
                this.moeda1 = "USD";
                this.moeda2 = "BRL";
                this.valorParaConverter = valor;
            } else if (Opcao == 3) {
                this.moeda1 = "BRL";
                this.moeda2 = "JPY";
                this.valorParaConverter = valor;
            } else if (Opcao == 4) {
                this.moeda1 = "JPY";
                this.moeda2 = "BRL";
                this.valorParaConverter = valor;
            }


    }

    public Desserializar consultaMoeda(String moeda) throws IOException, InterruptedException {

        URI url = URI.create("https://v6.exchangerate-api.com/v6/607093466b67bb2eb2b50b21/latest/"+moeda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
            return gson.fromJson(response.body(), Desserializar.class);

    }

    @Override
    public String toString() {
        return "O valor de " + getValorParaConverter() + " " + getMoeda1() + " convertido para " + getMoeda2() + " é de ";
    }
}
