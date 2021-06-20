package sample;

public class Event {

    static enum type {
        TAKE_ALL_PASSENGERS_FROM_FLOOR_N,
        SEND_PASSENGER_ID_TO_FLOOR_N,
    }

    private int type;
    private int fromFloor;
    private int destFloor;
    private int passengerId;

    public int getDestFloor() {
        return destFloor;
    }

    public void setDestFloor(int destFloor) {
        this.destFloor = destFloor;
    }

    Event(int pasId, int from, int to) {
        passengerId = pasId;
        fromFloor = from;
        destFloor = to;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public void setFromFloor(int fromFloor) {
        this.fromFloor = fromFloor;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
}

