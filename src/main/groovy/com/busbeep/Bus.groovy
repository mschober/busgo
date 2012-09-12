package com.busbeep

class Bus {


    private int currentStop
    private route
    private timeElapsedFromLastStop

    Bus() {
        this.currentStop = 0
        this.timeElapsedFromLastStop = 0
    }

    def register(Route route) {
        this.route = route
    }

    def assignedRoute() {
        return route
    }

    def currentStop() {
        return !enRoute()? currentStop : "En route"
    }

    def enRoute() {
        true
    }

    def nextStop() {
        return currentStop + 1
    }

    def leaveStop() {
        currentStop++
    }

    def timeTillNextStop() {
        return route.timeBetween(currentStop, nextStop()) - timeElapsedFromLastStop
    }

    def closeDoor() {
        leaveStop()
    }
}
