package sample;


import java.io.IOException;
import java.util.*;

public class Handler extends Thread {
    public static volatile ArrayList<Passenger> passengers;
    public static volatile ArrayList<Floor> floors;
    public static volatile ArrayList<Lift> lifts;
    public static volatile Build build;
    public int[][] state;

    Handler(int[][] st) {
        state = st;
    }

    public static Lift getLessLoadedLift() {
        int liftIndex = 0;
        int minEvents = 2_147_483_647;


        for (int i = 0; i < build.getLiftsCount(); ++i) {
            if (build.getLifts().get(i).getEventsCount() < minEvents) {
                minEvents = build.getLifts().get(i).getEventsCount();
                liftIndex = i;
            }
        }
        return build.getLifts().get(liftIndex);
    }

    @Override
    public void run() {
        passengers = new ArrayList<Passenger>();
        floors = new ArrayList<Floor>();
        lifts = new ArrayList<Lift>();

        int floorsNumber, liftsNumber;
        System.out.println("Введите количество этажей и лифтов в здании:");
        Scanner scanner = new Scanner(System.in);
//        floorsNumber = scanner.nextInt();
//        liftsNumber = scanner.nextInt();
        floorsNumber = 5;
        liftsNumber = 5;

        Random gen = new Random();
        build = new Build();

        for (int i = 0; i < floorsNumber; ++i) {
            Floor floor = new Floor(i + 1);
            floors.add(floor);
            floor.setBuild(build);
        }
        for (int i = 0; i < liftsNumber; ++i) {
            Lift lift = new Lift(gen.nextInt(5) + 4, 0, 1, build, state, i);
            lifts.add(lift);
            lift.setBuild(build);
            System.out.println(lift.getLiftId());
        }

        build.setFloors(floors);
        build.setLifts(lifts);
        build.setHeight(floorsNumber);
        build.setLiftsCount(liftsNumber);

        // Simulate process:

        int passengerId = 0;

        for (int i = 0; i < build.getLiftsCount(); ++i) {
            build.getLifts().get(i).start();
        }

//        System.out.println(build.getLifts().get(0).getLiftId());
//        build.getLifts().get(0).addEvent(new Event(0, 5, 9));
//        build.getLifts().get(1).addEvent(new Event(1, 7, 2));
//        build.getLifts().get(0).addEvent(new Event(2, 6, 8));

        while (true) {
            int incomingPassengers = gen.nextInt(3) + 1;
            int curFloor = gen.nextInt(build.getHeight()) + 1;
            Lift currentLift = getLessLoadedLift();

            for (int i = 0; i < incomingPassengers; ++i) {
                Event e = build.getFloors().get(curFloor - 1).callLift(passengerId++);
                Lift l = getLessLoadedLift();
                l.addEvent(e);
            }
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    System.out.print(state[i][j]);
                }
                System.out.print('\n');
            }

            try {
                Thread.sleep(1000); // Чтобы сильно не загружать систему
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
