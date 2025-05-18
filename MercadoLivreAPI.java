import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MercadoLivreAPI {

    // Substitua pelo seu token de acesso
    private static final String ACCESS_TOKEN = "SEU_ACCESS_TOKEN";
    private static final String USER_ID = "SEU_USER_ID";

    public static void main(String[] args) {
        try {
            // URL da API para buscar os produtos do vendedor
            String endpoint = "https://api.mercadolibre.com/users/" + USER_ID + "/items/search?access_token=" + ACCESS_TOKEN;

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { // código 200
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Produtos retornados:");
                System.out.println(response.toString());
            } else {
                System.out.println("Erro na requisição: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
