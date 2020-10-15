package javapuzzle;

public class RWLock {
    volatile int w;
    volatile int r;
    void wLock() {
        while(w > 0 || r > 0) {

        }
        w++;
        System.out.println("W LOCK!");
    }

    void wRelease() {
        w--;
    }

    void rLock() {
        while(w > 0) {

        }
        r++;
        System.out.println("R LOCK");
    }

    void rRelease() {
        r--;
    }


}
