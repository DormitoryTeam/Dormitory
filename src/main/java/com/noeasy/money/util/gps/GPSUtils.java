package com.noeasy.money.util.gps;

import org.apache.commons.lang3.tuple.Pair;

public class GPSUtils {
    public static final double RADIUS_OF_EARTH = 6378D;



    public static Pair<Double, Double> convertGeographicCoordinateToLegs(Pair<Double, Double> from,
            Pair<Double, Double> to) {
        double dx = RADIUS_OF_EARTH * (Math.PI * to.getLeft() / 180 - Math.PI * from.getLeft() / 180)
                * Math.cos(Math.PI * from.getRight() / 180);
        double dy = RADIUS_OF_EARTH * (Math.PI * to.getRight() / 180 - Math.PI * from.getRight() / 180);
        return Pair.of(dx, dy);
    }



    public static Double getDistance(Pair<Double, Double> legs) {
        return Math.sqrt(legs.getLeft() * legs.getLeft() + legs.getRight() * legs.getRight());
    }



    public static void main(String[] args) {
        // left longitude, right latitude
        Pair<Double, Double> from = Pair.of(113.670094D, 34.749660D);
        Pair<Double, Double> to = Pair.of(3.214617D, 55.932809D);
        Pair<Double, Double> legs = convertGeographicCoordinateToLegs(from, to);
        System.out.println(legs.getLeft());
        System.out.println(legs.getRight());
        System.out.println(getDistance(legs));
    }
}
