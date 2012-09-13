package com.busbeep

class Route {

    private List stops
    private Bus bus
    private def subscribers = []

    Route() {
        this(null, null)
    }

    Route(List stops) {
        this(stops, null)
    }

    Route(List stops, Bus bus) {
        this.stops = stops

        for(def i = 0; i < stops?.size(); i++) {
            subscribers << []
        }

        register(bus)
    }

    def register(def bus) {
        this.bus = bus
        bus?.register(this)
    }

    def assignedBus() {
        return bus
    }

    def numberOfStops() {
        return stops.size()
    }

    def timeBetween(def stop1, def stop2) {
        return stops.get(stop2)
    }

    def totalTime() {
        stops.sum()//inject(0) { time1, time2 -> time1 + time2 }
    }

    def stop(int stop) {
        return stop
    }

    def subscribe(def catcher, def stop) {
        subscribers.get(stop) << catcher
    }

    def subscribers() {
        def subscriberCount = subscribers.collect{ it.size() }
        return subscriberCount.sum()
    }

    def subscribers(stop) {
        return subscribers.get(stop)
    }

    @Override
    public String toString() {
        return """ Route ${stops} ${bus}
 Subscribers: ${subscribers}
               """
    }
}
