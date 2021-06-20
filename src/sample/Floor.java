package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor {
    private int number;

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    private ArrayList<Integer> waitingPassengers;
    private Build build;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Integer> getWaitingPassengers() {
        return waitingPassengers;
    }

    public void setWaitingPassengers(ArrayList<Integer> waitingPassengers) {
        this.waitingPassengers = waitingPassengers;
    }

    Floor(int floorNumber) {
        number = floorNumber;
    }

    public Event callLift(int pasId) {
        Random gen = new Random();
        return new Event(pasId, number, gen.nextInt(build.getHeight() + 1));
    }
}
