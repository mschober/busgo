package com.busbeep

class Catcher {

    private Route route
    private int stop

    def subscribe(route, stop) {
        this.route = route
        this.stop = stop
        route.subscribe(this, stop)
    }

    def stop() {
        return stop
    }

    def route() {
        return route
    }

    @Override
    public String toString() {
        return "Catcher"
    }
}
