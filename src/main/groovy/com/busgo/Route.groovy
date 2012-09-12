package com.busgo

class Route {

    private List stops
    private Bus bus

    Route() {
        this(null, null)
    }

    Route(List stops) {
        this(stops, null)
    }

    Route(List stops, Bus bus) {
        this.stops = stops
        register(bus)
    }

    def register(def bus) {
        this.bus = bus
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
        stops.inject(0) { time1, time2 -> time1 + time2 }
    }

}
