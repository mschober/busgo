package com.busgo

class Bus {


    private int currentStop
    private route

    Bus() {
        this.currentStop = 0
    }

    def register(Route route) {
        this.route = route
    }

    def currentStop() {
        return this.currentStop
    }

    def leaveStop() {
        currentStop++
    }

    def timeTillNextStop() {
        route.timeBetween(currentStop, currentStop + 1)
    }
}
