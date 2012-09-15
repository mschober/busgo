package com.busbeep

import groovy.util.GroovyTestCase
import org.junit.Test
import org.junit.Before

class StopSubscriberTest {


    def theRoute
    def bus

    @Before
    public void setup() {
        theRoute = new Route([0, 5, 4], new Bus())
        bus = theRoute.assignedBus()
    }


    @Test
    public void stopsHaveSubscribers() {
        assert theRoute.subscribers.size() == 3
        assert theRoute.subscribers() == 0
    }

    @Test
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
