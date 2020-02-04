package adverity.oo.domain

import adverity.oo.infrastructure.TreasureMap
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * This is our domain (in DDD nomenclature).
 *
 * @author Marcin Świerczyński
 * @since 03/02/2020
 */
@ToString
@EqualsAndHashCode
class Coordinate {

    int row
    int column
    private boolean visited = false

    List<Coordinate> findTreasureOn(TreasureMap treasureMap) {
        List<Coordinate> pathToTreasure = []

        Coordinate currentCoordinate = this
        while (!currentCoordinate.visited) {
            pathToTreasure << currentCoordinate

            if (currentCoordinate.isTreasure(treasureMap)) {
                return pathToTreasure
            }

            currentCoordinate.visit()
            currentCoordinate = treasureMap.findNextCoordinate(currentCoordinate)
        }

        return []
    }

    private boolean isTreasure(TreasureMap treasureMap) {
        return this == treasureMap.findNextCoordinate(this)
    }

    private void visit() {
        this.visited = true
    }

}
