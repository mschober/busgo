package com.busgo

class Route {

    private def stops

    Route(def stops) {
        this.stops = stops
    }

    def numberOfStops() {
        return stops.size()
    }

    def timeBetween(def stop1, def stop2) {
        return stops.get(stop2)
    }
}
