import RPi.GPIO as GPIO

GPIO.setwarning(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(3,GPIO.IN)
GPIO.setup(5,GPIO.OUT)

while 1:
    if(GPIO.input(3)==False):
        print("obstacle DETECED")
        GPIO.output(5,True)
    else:
        print("obstale not detected")
        GPIO.output(5,False)





































import RPi.GPIO as GPIO

GPIO.setwarning(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(3,GPIO.IN)
GPIO.setup(5,GPIO.OUT)

while 1:
    if(GPIO.input(3)==False):
        print("obstacle detected")
        GPIO.output(5, True)
    else:
        print("obstacle not detected")
        GPIO.output(5, True)
