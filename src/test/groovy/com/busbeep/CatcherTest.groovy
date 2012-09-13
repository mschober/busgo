package com.busbeep

import groovy.util.GroovyTestCase
import org.junit.Test
import org.junit.Before

class CatcherTest {


    @Test
    public void subscribeToStop() {
       def route =  new Route([0, 1])
       assert route
       assert route.numberOfStops() == 2

       def catcher = new Catcher()
       assert catcher

       catcher.subscribe(route, 1)
       assert catcher.route() == route
       assert catcher.stop() == 1
    }

}
