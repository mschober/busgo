package com.busgo

import groovy.util.GroovyTestCase
import org.junit.Test

class RouteTest {


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
    }
}
