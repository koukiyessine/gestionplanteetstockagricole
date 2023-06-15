#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <DHT.h>

#define DHTPIN D2
#define DHTTYPE DHT11
#define SOIL_MOISTURE_PIN A0

DHT dht(DHTPIN, DHTTYPE);

const char* ssid = "Dar Kouki-OO";
const char* password = "@H@A@M@Z@A@#@H@A@M@Z@A@";
const char* serverUrl = "10.0.0.240";
int serverPort = 8407;

void setup() {
  Serial.begin(9600);
  dht.begin();
  connectToWiFi();
}

void loop() {
  delay(2000);

  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();

  int soilMoisture = analogRead(SOIL_MOISTURE_PIN);
  float soilMoisturePercentage = map(soilMoisture, 0, 1023, 0, 100);

  if (isnan(temperature) || isnan(humidity)) {
    Serial.println("Échec de lecture du capteur DHT11 !");
    return;
  }

  Serial.print("Température : ");
  Serial.print(temperature);
  Serial.print(" °C\t");
  Serial.print("Humidité : ");
  Serial.print(humidity);
  Serial.print(" %\t");
  Serial.print("Humidité du sol : ");
  Serial.print(soilMoisturePercentage);
  Serial.println(" %");

  String plantHealthStatus;
  if (soilMoisturePercentage < 30) {
    Serial.println("L'état de santé de la plante est mauvais : faible humidité du sol.");
    plantHealthStatus = "BAD: Low soil moisture";
  } else if (humidity > 80) {
    Serial.println("L'état de santé de la plante est mauvais : humidité de l'air élevée.");
    plantHealthStatus = "BAD: High air humidity";
  } else {
    Serial.println("L'état de santé de la plante est bon.");
    plantHealthStatus = "GOOD";
  }

  sendPlantHealthStatus(plantHealthStatus);

  delay(2000);
}

void connectToWiFi() {
  Serial.print("Connecting to WiFi");
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}

void sendPlantHealthStatus(String plantHealthStatus) {
  WiFiClient client;

  if (client.connect(serverUrl, serverPort)) {
    // Création de la requête HTTP POST
    String httpRequest = "POST /api/addhealthstatus HTTP/1.1\r\n" +
                         String("Host: ") + String(serverUrl) + ":" + String(serverPort) + "\r\n" +
                         "Content-Type: application/json\r\n" +  // Utilisation du type de contenu JSON
                         "Content-Length: " + String(plantHealthStatus.length()) + "\r\n" +
                         "Connection: close\r\n\r\n" +
                         plantHealthStatus;

    client.print(httpRequest);
    delay(10);

    client.stop();
  } else {
    Serial.println("Erreur de connexion au serveur");
  }
}
