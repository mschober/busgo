package com.busbeep

import groovy.util.GroovyTestCase
import org.junit.Test
import org.junit.Before

class BusRouteTest {


    def theRoute
    def bus

    @Before
    public void setup() {
        theRoute = new Route([0, 5, 4], new Bus())
        bus = theRoute.assignedBus()
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
        assert bus.currentStop() == theRoute.stop(0)
        assert bus.nextStop() == theRoute.stop(1)
        assert bus.estimatedTimeTillNextStop() == theRoute.timeBetween(0,1)
        bus.closeDoor()
        assert bus.currentStop() == theRoute.stop(1)
        assert bus.estimatedTimeTillNextStop() == theRoute.timeBetween(1, 2)
    }

    @Test
    public void aFewSecondsAfterBusLeavesStop() {
        assert bus.estimatedTimeTillNextStop() == theRoute.timeBetween(0,1)
        bus.timeElapsedFromLastStop = 2
        assert bus.estimatedTimeTillNextStop() == theRoute.timeBetween(0,1) - 2
        assert bus.currentStop() == theRoute.stop(0)

        bus.closeDoor()

        assert bus.currentStop() == theRoute.stop(1)
    }
}
