#include <DHT.h>
#include <ESP8266WiFi.h>
#include <WiFiClient.h>

#define DHTPIN D2
#define DHTTYPE DHT11

DHT dht(DHTPIN, DHTTYPE);

const char* ssid = "Dar Kouki-OO";
const char* password = "@H@A@M@Z@A@#@H@A@M@Z@A@";
const char* serverUrl = "10.0.0.240";


void setup() {
  Serial.begin(9600);
  dht.begin();
  connectToWiFi();
}

void loop() {
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();

  if (isnan(temperature) || isnan(humidity)) {
    Serial.println("Erreur de lecture du capteur DHT11 !");
    return;
  }

  Serial.print("Température : ");
  Serial.print(temperature);
  Serial.println(" °C");

  Serial.print("Humidité : ");
  Serial.print(humidity);
  Serial.println(" %");

  sendTemperatureData(temperature, humidity);

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

void sendTemperatureData(float temperature, float humidity) {
  WiFiClient client;

  if (client.connect(serverUrl, 8407)) {
    String jsonData = "{\"temperature\": " + String(temperature) + ", \"humidity\": " + String(humidity) + "}";
    int contentLength = jsonData.length();
    String httpRequest = String("POST /api/addweather HTTP/1.1\r\n") +
                         String("Host: ") + String(serverUrl) + String(":8407\r\n") +
                         String("Content-Type: application/json\r\n") +
                         String("Content-Length: ") + String(contentLength) + String("\r\n") +
                         String("Connection: close\r\n\r\n") +
                         jsonData;

    client.print(httpRequest);
    delay(10);

    client.stop();
  } else {
    Serial.println("Erreur de connexion au serveur");
  }
}
