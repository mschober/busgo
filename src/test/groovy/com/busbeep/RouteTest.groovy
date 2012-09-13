package com.busbeep

import groovy.util.GroovyTestCase
import org.junit.Test
import org.junit.Before

class RouteTest {


    def theRoute

    @Before
    public void setup() {
        theRoute = new Route([0, 5, 4], new Bus())
    }

    @Test
    public void createBasicThreeStopRoute() {
        def stops =[0, 5, 4]
        def route = new Route(stops)

        assert route

        assert route.numberOfStops() == 3
        assert route.timeBetween(0, 1) == 5
        assert route.timeBetween(1, 2) == 4
        assert route.totalTime() == 9
    }


    @Test
    public void registerBusWithRoute() {
        def route = new Route()
        assert route

        def bus = new Bus()
        assert bus

        route.register(bus)
        assert route.assignedBus() == bus
        assert bus.assignedRoute() == route
    }


    @Test
    public void busNotfiesRouteWhenLeavingStop() {
        def bus = theRoute.assignedBus()
        assert bus.currentStop() == theRoute.stop(0)
        assert bus.nextStop() == theRoute.stop(1)
        bus.leaveStop()
        assert bus.currentStop() == theRoute.stop(1)
        assert bus.timeTillNextStop() == 4
        assert bus.timeTillNextStop() == theRoute.timeBetween(1, 2)
    }


    @Test
    public void aFewSecondsAfterBusLeavesStop() {
        def bus = theRoute.assignedBus()
        bus.leaveStop()
        bus.timeElapsedFromLastStop = 2
        assert bus.timeTillNextStop() == theRoute.timeBetween(1,2) - 2
        assert bus.currentStop() == "En route"
        bus.closeDoor()
        assert bus.currentStop() == theRoute.stop(1)
    }
}
