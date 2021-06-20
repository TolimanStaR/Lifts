package sample;

import java.util.ArrayList;
import java.util.List;

public class Build {
    private ArrayList<Floor> floors;
    private ArrayList<Lift> lifts;
    private int height;
    private int liftsCount;

    Build(ArrayList<Floor> floorsList, ArrayList<Lift> liftsList, int buildHeight, int liftsCount1) {
        floors = floorsList;
        lifts = liftsList;
        height = buildHeight;
        liftsCount = liftsCount1;
    }

    public int getLiftsCount() {
        return liftsCount;
    }

    public void setLiftsCount(int liftsCount) {
        this.liftsCount = liftsCount;
    }

    Build() {

    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public ArrayList<Lift> getLifts() {
        return lifts;
    }

    public void setLifts(ArrayList<Lift> lifts) {
        this.lifts = lifts;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

