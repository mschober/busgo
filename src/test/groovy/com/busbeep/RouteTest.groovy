package com.busbeep

import groovy.util.GroovyTestCase
import org.junit.Test
import org.junit.Before

class RouteTest {

    def theRoute
    def bus

    @Before
    public void setup() {
        theRoute = new Route([0, 5, 4], new Bus())
        bus = theRoute.assignedBus()
    }

    @Test
    public void createBasicThreeStopRoute() {
        def stops = [0, 5, 4]
        def route = new Route(stops)

        assert route

        assert route.numberOfStops() == 3
        assert route.timeBetween(0, 1) == 5
        assert route.timeBetween(1, 2) == 4
        assert route.totalTime() == 9
    }
}
