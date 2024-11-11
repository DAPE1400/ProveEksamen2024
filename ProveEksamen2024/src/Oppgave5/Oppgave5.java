package Oppgave5;

interface Transport {
    double calculateCost(int distance);
    double calculateTime(int distance, int minutesTilNextTransport);
}

class Train implements Transport {
    // It is not expected that the students make the constants static final, but it is a better solution if they do
    private static final double COST_PER_METER = 0.01;
    private static final double TIME_PER_1000_M = 0.5; //magic number as minutes per m would also be a good solution

    @Override
    public double calculateCost(int distance) {
        return distance * COST_PER_METER;
    }

    @Override
    public double calculateTime(int distance, int minutesTilNextTransport) {
        double travelTime = (distance / 1000.0) * TIME_PER_1000_M;
        return travelTime + minutesTilNextTransport;
    }

    @Override
    public String toString(){
        return "Train";
    }
}

class Taxi implements Transport {
    // It is not expected that the students make the constants static final, but it is a better solution if they do
    private static final double COST_PER_METER = 0.05;
    private static final double BASE_COST = 50;
    private static final double TIME_PER_1000_M = 1.0; //magic number as minutes per m would also be a good solution

    @Override
    public double calculateCost(int distance) {
        return BASE_COST + (distance * COST_PER_METER);
    }

    @Override
    public double calculateTime(int distance, int minutesTilNextTransport) {
        double travelTime = (distance / 1000.0) * TIME_PER_1000_M;
        return travelTime + minutesTilNextTransport;
    }

    @Override
    public String toString(){
        return "Taxi";
    }
}



public class Oppgave5 {
    public static void main(String[] args) {
        Transport train = new Train();
        Transport taxi = new Taxi();

        int[] distances = { 1000, 5000, 50000 };
        int trainWaitTime = 30;
        int taxiWaitTime = 5;

        Transport[] transports = { train, taxi };
        int[] waitTimes = { trainWaitTime, taxiWaitTime };

        // Loop through each transport type and calculate cost and time for each distance
        for (int i = 0; i < transports.length; i++) {
            Transport transport = transports[i];
            int waitTime = waitTimes[i];
            System.out.println("Calculations for " + transport + ":");
            for (int distance : distances) {
                double cost = transport.calculateCost(distance);
                // setting the waitTime could also be done with instanceOf, but it is not an expected solution
                double time = transport.calculateTime(distance, waitTime);
                System.out.print("Distance: " + distance + "m -> Cost: " + cost + " kr, Time: " + time + " minutes%n");
            }
            System.out.println();
        }
    }
}
