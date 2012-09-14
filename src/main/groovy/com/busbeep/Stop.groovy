
package com.busbeep
class Stop {

    private def routeNumber
    private def name
    private def segmentDuration

    Stop(def routeNumber, def name, def segmentDuration) {
        this.routeNumber = routeNumber
        this.name = name
        this.segmentDuration = segmentDuration
    }

    def segmentDuration() {
        return segmentDuration
    }

    @Override
    public String toString() {
       return "Stop"
    }
}
