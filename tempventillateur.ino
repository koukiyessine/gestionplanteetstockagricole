#include <DHT.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>

#define DHT_PIN D1
#define DHT_TYPE DHT11
#define RELAY_PIN D2
#define TEMPERATURE_THRESHOLD 25

DHT dht(DHT_PIN, DHT_TYPE);
WiFiClient client; // Nouvelle instance de WiFiClient

const char* ssid = "OPPO A1k";
const char* password = "cfedfcf69f95";
const char* serverUrl = "http://10.0.0.240:8407/api/receiveData";

unsigned long previousMillis = 0;
const long interval = 2000;

void setup() {
  Serial.begin(9600);
  pinMode(RELAY_PIN, OUTPUT);
  digitalWrite(RELAY_PIN, LOW);
  dht.begin();

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");

  delay(1000);
}

void loop() {
  unsigned long currentMillis = millis();

  if (currentMillis - previousMillis >= interval) {
    previousMillis = currentMillis;

    float temperature = dht.readTemperature();

    if (isnan(temperature)) {
      Serial.println("Erreur de lecture de la température");
      return;
    }

    Serial.print("Température de la plante : ");
    Serial.print(temperature);
    Serial.println(" °C");

    if (temperature > TEMPERATURE_THRESHOLD) {
      digitalWrite(RELAY_PIN, HIGH);
      Serial.println("Activation du ventilateur");
    } else {
      digitalWrite(RELAY_PIN, LOW);
      Serial.println("Désactivation du ventilateur");
    }

    HTTPClient http;

    if (http.begin(client, serverUrl)) { // Utilisation de client au lieu de http.begin(serverUrl)
      String jsonData = "{\"value\": " + String(temperature) + "}";

      http.addHeader("Content-Type", "application/json");
      http.addHeader("Access-Control-Allow-Origin", "*"); // Ajout de l'en-tête CORS

      int httpCode = http.POST(jsonData);

      if (httpCode > 0) {
        Serial.printf("HTTP POST request sent, response code: %d\n", httpCode);

        String response = http.getString();
        Serial.println("Response: " + response);
      } else {
        Serial.printf("HTTP POST request failed, error: %s\n", http.errorToString(httpCode).c_str());
      }

      http.end();
    } else {
      Serial.println("Unable to connect to server");
    }
  }
}
