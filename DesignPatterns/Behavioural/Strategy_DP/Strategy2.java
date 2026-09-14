package DesignPatterns.Behavioural.Strategy_DP;


interface RouteStrategy {
    String buildRoute(String start, String end);
}

class DrivingRoute implements RouteStrategy {
    public String buildRoute(String start, String end) {
        return "Driving route from " + start + " to " + end + " via highway";
    }
}

class WalkingRoute implements RouteStrategy {
    public String buildRoute(String start, String end) {
        return "Walking route from " + start + " to " + end + " via footpaths";
    }
}

class PublicTransitRoute implements RouteStrategy {
    public String buildRoute(String start, String end) {
        return "Transit route from " + start + " to " + end + " via bus + metro";
    }
}

class NavigationApp {
    private RouteStrategy strategy;

    NavigationApp(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    void navigate(String start, String end) {
        System.out.println(strategy.buildRoute(start, end));
    }
}

public class Strategy2 {
    public static void main(String[] args) {
    NavigationApp app = new NavigationApp(new DrivingRoute());
    app.navigate("Home", "Office");

    app.setStrategy(new WalkingRoute());   // user taps "walking" mode in the UI
    app.navigate("Home", "Office");
    }
}
