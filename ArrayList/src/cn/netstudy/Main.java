package cn.netstudy;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Main {
    private static class Coordinate {
        int X;
        int Y;

        public Coordinate(int x, int y) {
            this.X = x;
            this.Y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + X;
            result = prime * result + Y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Coordinate other = (Coordinate) obj;
            if (X != other.X)
                return false;
            if (Y != other.Y)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "X = " + X + ", Y = " + Y;
        }
    }

    private static class PostMan {
        Coordinate coordinate;
        int Capacity;

        public PostMan(int x, int y, int c) {
            this.coordinate = new Coordinate(x, y);
            this.Capacity = c;
        }
    }

    private static class WareHouse {
        Coordinate coordinate;

        public WareHouse(int x, int y) {
            this.coordinate = new Coordinate(x, y);
        }
    }

    private static class Residential {
        Coordinate coordinate;
        int requirement;

        public Residential(int x, int y, int r) {
            this.coordinate = new Coordinate(x, y);
            this.requirement = r;
        }
    }

    private static class Donate {
        Coordinate coordinate;
        int Stock;

        public Donate(int x, int y, int s) {
            this.coordinate = new Coordinate(x, y);
            this.Stock = s;
        }
    }

    private static PostMan man;
    private static WareHouse wh;
    private static Set<Residential> residentialSet = new HashSet<>();
    private static Set<Donate> donateSet = new HashSet<>();
    private static Residential currentResident = null;

    private static int MAX_LIMIT = 100;
    private static int MAX_STEP = 12 * 12;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String step;

        while (scan.hasNext()) {
            String command = scan.nextLine();
            String[] commandList = command.split(" ");
            if (commandList[0].equalsIgnoreCase("S")) {
                man = new PostMan(Integer.parseInt(commandList[1]), Integer.parseInt(commandList[2]), MAX_LIMIT);
                wh = new WareHouse(Integer.parseInt(commandList[1]), Integer.parseInt(commandList[2]));
            } else if (commandList[0].equalsIgnoreCase("R")) {
                if (Integer.parseInt(commandList[3]) <= 0) {
                    Residential residential = new Residential(Integer.parseInt(commandList[1]), Integer.parseInt(commandList[2]), Integer.parseInt(commandList[3]));
                    residentialSet.add(residential);
                } else {
                    Donate donate = new Donate(Integer.parseInt(commandList[1]), Integer.parseInt(commandList[2]), Integer.parseInt(commandList[3]));
                    donateSet.add(donate);
                }
            } else if (commandList[0].equalsIgnoreCase("G")) {
                if (processData()) {
                    return;
                }
                step = getNextStep();
                System.out.println(step);
                if (processData()) {
                    return;
                }
            } else {
            }
        }
    }

    private static String getNextStep() {
        String result = "";
        if (currentResident == null || currentResident.requirement >= 0) {
            currentResident = findNearestRes();
        }
        if (man.Capacity <= 0) {
            result = goGetMask();
            return result;
        }

        return parseStep(man.coordinate, currentResident.coordinate);
    }

    private static boolean processData() {
        Iterator<Residential> resIt = residentialSet.iterator();
        while (resIt.hasNext()) {
            Residential res = resIt.next();
            if (man.coordinate.equals(res.coordinate)) {
                if (res.requirement + man.Capacity >= 0) {
                    man.Capacity = man.Capacity + res.requirement;
                    res.requirement = 0;
                    resIt.remove();
                } else {
                    res.requirement = res.requirement + man.Capacity;
                    man.Capacity = 0;
                }
            }
        }

        Iterator<Donate> deIt = donateSet.iterator();
        while (deIt.hasNext()) {
            Donate de = deIt.next();
            int manNeed = MAX_LIMIT - man.Capacity;
            if (man.coordinate.equals(de.coordinate)) {
                if (de.Stock <= 0) {
                } else if (de.Stock > manNeed) {
                    man.Capacity = 100;
                    de.Stock = de.Stock - manNeed;
                } else {
                    man.Capacity = man.Capacity + de.Stock;
                    de.Stock = 0;
                    deIt.remove();
                }
            }
        }

        if (man.coordinate.equals(wh.coordinate)) {
            man.Capacity = 100;
        }

        if (residentialSet.isEmpty()) {
            return true;
        }
        return false;
    }

    private static Residential findNearestRes() {
        int dis = MAX_STEP;
        Residential result = null;
        for (Residential res : residentialSet) {
            int tempDis = calculateDis(man.coordinate, res.coordinate);
            if (tempDis < dis) {
                result = res;
                dis = tempDis;
            }
        }
        return result;
    }

    private static Donate findNearestDonate() {
        int dis = MAX_STEP;
        Donate result = null;
        for (Donate res : donateSet) {
            int tempDis = calculateDis(man.coordinate, res.coordinate);
            if (tempDis < dis) {
                result = res;
                dis = tempDis;
            }
        }
        return result;
    }

    private static String goGetMask() {
        Donate nearDonate = findNearestDonate();
        int whDis = calculateDis(man.coordinate, wh.coordinate);
        if (nearDonate != null && whDis > calculateDis(man.coordinate, nearDonate.coordinate)) {
            return parseStep(man.coordinate, nearDonate.coordinate);
        } else {
            return parseStep(man.coordinate, wh.coordinate);
        }
    }

    private static int calculateDis(Coordinate m, Coordinate r) {
        return Math.abs(m.X - r.X) + Math.abs(m.Y - r.Y);
    }

    private static String parseStep(Coordinate man, Coordinate des) {
        String result = "";
        if (des.X - man.X < 0) {
            man.X = man.X - 1;
            result = "N";
        } else if (des.X - man.X > 0) {
            man.X = man.X + 1;
            result = "S";
        } else if (des.Y - man.Y < 0) {
            man.Y = man.Y - 1;
            result = "W";
        } else if (des.Y - man.Y > 0) {
            man.Y = man.Y + 1;
            result = "E";
        }
//      System.exit(0);
        return result;
    }
}