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

    @Test
    public void stopsHaveSubscribers() {
        assert theRoute.subscribers.size() == 3
        assert theRoute.subscribers() == 0
    }

    //@Test
    public void catcherCanSubscribe() {
        def catcher = new Catcher()
        assert catcher

        catcher.subscribe(theRoute, 2)
        assert catcher.stop() == 2
        assert catcher.route() == theRoute
        theRoute.subscribers() == 1
        theRoute.subscribers(1) == 0
        theRoute.subscribers(2) == 1
    }
}
