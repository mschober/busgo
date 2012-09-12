package com.busgo

class Route {

    private def stops
    private def bus

    Route(def stops) {
        this.stops = stops
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

    def register(def bus) {
        this.bus = bus
    }

    def assignedBus() {
        return bus
    }
}
