#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

#define MOISTURE_SENSOR_PIN A0
#define RELAY_PIN D1
#define MOISTURE_THRESHOLD 250

const char* ssid = "OPPO A5s";
const char* password = "13b48cded6ce";
const char* serverUrl = "http://10.0.0.240:8407/api/datahumidity";

void setup() {
  Serial.begin(9600);
  pinMode(RELAY_PIN, OUTPUT);
  digitalWrite(RELAY_PIN, LOW);

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");

  delay(1000);
}

void loop() {
  int soilMoisture = analogRead(MOISTURE_SENSOR_PIN);

  if (soilMoisture == -1) {
    Serial.println("Erreur de lecture de l'humidité du sol");
    return;
  }

  Serial.print("Humidité du sol : ");
  Serial.println(soilMoisture);

  if (soilMoisture != 0 && soilMoisture < MOISTURE_THRESHOLD) {
    digitalWrite(RELAY_PIN, HIGH);
    Serial.println("Activation de la pompe à eau");

    if (soilMoisture != 0) {
      WiFiClient client; // Déclaration de la variable client
      HTTPClient http;
      http.begin(client, serverUrl);
      http.addHeader("Content-Type", "application/json");

      String jsonData = "{\"soilMoisture\": " + String(soilMoisture) + "}";

      int httpResponseCode = http.POST(jsonData);

      if (httpResponseCode > 0) {
        Serial.printf("Données envoyées avec succès. Code de réponse HTTP : %d\n", httpResponseCode);
      } else {
        Serial.printf("Erreur lors de l'envoi des données. Code d'erreur HTTP : %d\n", httpResponseCode);
      }

      http.end();
    }
  } else {
    digitalWrite(RELAY_PIN, LOW);
    Serial.println("Désactivation de la pompe à eau");
  }

  delay(1000);
}
