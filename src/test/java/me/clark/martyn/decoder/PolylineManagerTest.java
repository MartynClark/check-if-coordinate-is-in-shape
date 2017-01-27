package me.clark.martyn.decoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * User: martyn
 * Date: 27/01/2017
 * Time: 14:04
 */
class PolylineManagerTest {

    private static final String ENCODED_POINTS = "{sopDeawdH_BeFzEsCrCbHmFlD";

    private PolylineManager polylineManager;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.polylineManager = new PolylineManager();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        this.polylineManager = null;
    }

    @org.junit.jupiter.api.Test
    void coordinateInZone() {
        final double LATITUDE_UNDER_TEST = 29.084273379078198;
        final double LONGITUDE_UNDER_TEST = 48.129236698150635;
        boolean expected = true;
        boolean actual = polylineManager.isCoordinateInZone(LATITUDE_UNDER_TEST, LONGITUDE_UNDER_TEST, ENCODED_POINTS);
        assertEquals(expected, actual);
    }

    @Test
    void coordinateOutSideZone() {
        final double LATITUDE_UNDER_TEST = 29.0845359064853;
        final double LONGITUDE_UNDER_TEST = 48.12779366970062;
        final boolean expected = false;
        final boolean actual = polylineManager.isCoordinateInZone(LATITUDE_UNDER_TEST, LONGITUDE_UNDER_TEST,
                ENCODED_POINTS);
        assertEquals(expected, actual);
    }
}
