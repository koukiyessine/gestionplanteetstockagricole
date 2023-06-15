#include <ESP8266WiFi.h>
#include <WiFiClient.h>

const char* ssid = "OPPO A5s";
const char* password = "13b48cded6ce";
const char* serverHost = "10.0.0.240";
const int serverPort = 8407;
const char* serverPath = "/api/addquantiteeau";
const int sensorPin = A0;

void setup() {
  Serial.begin(9600);
  connectToWiFi();
}

void loop() {
  int sensorValue = analogRead(sensorPin);
  int humidityPercentage = map(sensorValue, 0, 1023, 0, 100);

  Serial.print("Humidité du sol : ");
  Serial.print(humidityPercentage);
  Serial.println("%");

  sendHumidityData(humidityPercentage);

  delay(1000);
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

void sendHumidityData(int humidityPercentage) {
  WiFiClient client;

  if (client.connect(serverHost, serverPort)) {
    String jsonData = "{\"humidity\": " + String(humidityPercentage) + "}";
    String httpRequest = "POST " + String(serverPath) + " HTTP/1.1\r\n" +
                         "Host: " + String(serverHost) + "\r\n" +
                         "Content-Type: application/json\r\n" +
                         "Content-Length: " + String(jsonData.length()) + "\r\n" +
                         "Connection: close\r\n\r\n" +
                         jsonData;

    client.print(httpRequest);
    delay(10);

    client.stop();
  } else {
    Serial.println("Erreur de connexion au serveur");
  }
}
