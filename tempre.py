import RPi.GPIO as GPIO
import dht11
import time

GPIO.setwarning(False)
GPIO.setmode(GPIO.BCM)

dhtPin=dht11.DHT11(pin=21)

while:
    dhtvalue=dhtPin.read()
    if dhtvalue.is_valid():
        print("tempreature %c" %dhtvalue.tempreature)
        print("Humidity: %d %%" % dhtvalue.humidity)

    time.sleep(1)





































import RPi.GPIO as GPIO
import dht11
import time

GPIO.setwarning(False)
GPIO.setmode(GPIO.BCM)

dhtpin=dht11.DHT11(pin 21)

while:
    dhtvalue=dhtpin.read()
    if dhtvalue.is_valid():
        print("Tempreature: %c" %dhtvalue.tempreature)
        print("humidity: %d %%" %dhtvslue.humidity)
    time.sleep(1)
