package me.clark.martyn.decoder;

import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.util.List;

/**
 * User: martyn
 * Date: 27/01/2017
 * Time: 14:11
 */
public class PolylineManager {

    private PolylineDecoder polylineDecoder;

    private Path2D path2D;

    public PolylineManager() {
        this.polylineDecoder = new PolylineDecoder();
        this.path2D = new Path2D.Double();
    }

    /**
     * Test if given lat lns fall within the zone.
     *
     * @param latitude      long
     * @param longitude     long
     * @param encodedPoints String
     * @return boolean true/false
     */
    public boolean isCoordinateInZone(double latitude, double longitude, String encodedPoints) {
        List<Coordinate> coords = this.polylineDecoder.decode(encodedPoints);
        Area shape = buildShape(coords);
        return shape.contains(latitude, longitude);
    }

    /**
     * Utility Method for building a shape from the list of <Object>Coordinate</Object>
     *
     * @param coords List
     * @return Area of the shape.
     */
    private Area buildShape(List<Coordinate> coords) {
        boolean isFirst = true;
        for (Coordinate c : coords) {
            if (isFirst) {
                this.path2D.moveTo(c.getLatitude(), c.getLongitude());
                isFirst = false;
            } else {
                this.path2D.lineTo(c.getLatitude(), c.getLongitude());
            }
        }
        this.path2D.closePath();
        return new Area(path2D);
    }
}
