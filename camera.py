
from picamera import Picamera
import time

camera=Picamera()
camera.start_preview()
time.sleep(5)
camera.capture("image.png")
camera.stop_preview()











































from picamera import Picamera
import time

camera=Picamera()
camera.start_preview()
time.sleep(5)
camera.capture("image.png")
camera.stop_preview()
