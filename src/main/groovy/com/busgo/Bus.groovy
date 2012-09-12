package com.busgo

class Bus {


    private int currentStop

    Bus() {
        this.currentStop = 0
    }

    def currentStop() {
        return this.currentStop
    }

    def leaveStop() {
        currentStop++
    }
}
