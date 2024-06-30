import com.google.gson.Gson;

import java.util.Map;

public record Desserializar (String base_code, Map<String, Double> conversion_rates){

}
