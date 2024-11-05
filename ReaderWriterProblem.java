package p4;
import java.util.concurrent.Semaphore;

public class ReaderWriterProblem 
{

    private static final Semaphore mutex = new Semaphore(1);
    private static final Semaphore writeLock = new Semaphore(1);
    private static int readerCount = 0;

    public static void main(String[] args) 
    {
        Thread reader1 = new Thread(new Reader());
        Thread reader2 = new Thread(new Reader());
        Thread writer1 = new Thread(new Writer());
        Thread writer2 = new Thread(new Writer());

        reader1.start();
        reader2.start();
        writer1.start();
        writer2.start();
    }

    static class Reader implements Runnable {
        public void run() {
            try {
                mutex.acquire();
                readerCount++;
                System.out.println("Reader " + Thread.currentThread().getName() + " acquired mutex");
                if (readerCount == 1) {
                    writeLock.acquire();
                    System.out.println("Reader " + Thread.currentThread().getName() + " acquired writeLock");
                }
                mutex.release();

                System.out.println("Reader " + Thread.currentThread().getName() + " is reading.");
                Thread.sleep(1000); // Simulate reading time

                mutex.acquire();
                readerCount--;
                if (readerCount == 0) {
                    writeLock.release();
                    System.out.println("Reader " + Thread.currentThread().getName() + " released writeLock");
                }
                mutex.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Writer implements Runnable {
        public void run() {
            try {
                writeLock.acquire();
                System.out.println("Writer " + Thread.currentThread().getName() + " acquired writeLock");
                System.out.println("Writer " + Thread.currentThread().getName() + " is writing.");
                Thread.sleep(1000); // Simulate writing time
                writeLock.release();
                System.out.println("Writer " + Thread.currentThread().getName() + " released writeLock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/* Output
Writer Thread-2 acquired writeLock
Reader Thread-0 acquired mutex
Writer Thread-2 is writing.
Writer Thread-3 acquired writeLock
Writer Thread-3 is writing.
Writer Thread-2 released writeLock
Writer Thread-3 released writeLock
Reader Thread-0 acquired writeLock
Reader Thread-0 is reading.
Reader Thread-1 acquired mutex
Reader Thread-1 is reading.
Reader Thread-0 released writeLock
*/