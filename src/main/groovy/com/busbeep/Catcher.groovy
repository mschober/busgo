package com.busbeep

import groovy.sql.Sql

class Catcher {

    private Route route
    private int stop

    public static void main(String[] args){
        def sql = Sql.newInstance("jdbc:mysql://localhost:3306/busbeep_dev", "busbeep",
                              "DannyBoy6812", "com.mysql.jdbc.Driver")

        sql.eachRow("select * from todo") {
            println "Gromit likes ${it.title}"
        }
    }

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
