package adverity.oo.domain

import adverity.oo.infrastructure.TreasureMap
import spock.lang.Specification

/**
 * @author Marcin Świerczyński
 * @since 04/02/2020
 */
class CoordinateSpec extends Specification {

    def "should return the path to the treasure"() {
        when:
        List<Coordinate> pathToTreasure = new Coordinate(row: 1, column: 1).findTreasureOn(new TreasureMap())

        then:
        pathToTreasure == [
                new Coordinate(row: 1, column: 1),
                new Coordinate(row: 3, column: 4),
                new Coordinate(row: 4, column: 2),
                new Coordinate(row: 1, column: 5),
                new Coordinate(row: 2, column: 5),
                new Coordinate(row: 3, column: 1),
                new Coordinate(row: 5, column: 4),
                new Coordinate(row: 1, column: 3),
                new Coordinate(row: 3, column: 2),
                new Coordinate(row: 4, column: 5),
                new Coordinate(row: 3, column: 5),
                new Coordinate(row: 2, column: 3),
                new Coordinate(row: 4, column: 3),
                new Coordinate(row: 5, column: 1),
                new Coordinate(row: 2, column: 1),
                new Coordinate(row: 1, column: 4),
                new Coordinate(row: 4, column: 1),
                new Coordinate(row: 3, column: 3),
                new Coordinate(row: 5, column: 2)
        ]
    }

    def "should return first element if it is a treasure"() {
        given:
        Coordinate[][] coordinates = [
                [new Coordinate(row: 1, column: 1), new Coordinate(row: 2, column: 1), new Coordinate(row: 3, column: 2), new Coordinate(row: 4, column: 1), new Coordinate(row: 2, column: 5)],
                [new Coordinate(row: 1, column: 4), new Coordinate(row: 4, column: 2), new Coordinate(row: 4, column: 3), new Coordinate(row: 1, column: 4), new Coordinate(row: 3, column: 1)],
                [new Coordinate(row: 5, column: 4), new Coordinate(row: 4, column: 5), new Coordinate(row: 5, column: 2), new Coordinate(row: 4, column: 2), new Coordinate(row: 2, column: 3)],
                [new Coordinate(row: 3, column: 3), new Coordinate(row: 1, column: 5), new Coordinate(row: 5, column: 1), new Coordinate(row: 3, column: 1), new Coordinate(row: 3, column: 5)],
                [new Coordinate(row: 2, column: 1), new Coordinate(row: 5, column: 2), new Coordinate(row: 3, column: 3), new Coordinate(row: 1, column: 3), new Coordinate(row: 2, column: 3)],
        ]

        when:
        List<Coordinate> pathToTreasure = new Coordinate(row: 1, column: 1).findTreasureOn(new TreasureMap(coordinates))

        then:
        pathToTreasure == [new Coordinate(row: 1, column: 1)]
    }


    def "should return empty list if there is no treasure"() {
        given:
        Coordinate[][] coordinates = [
                [new Coordinate(row: 1, column: 2), new Coordinate(row: 1, column: 3), new Coordinate(row: 1, column: 4), new Coordinate(row: 1, column: 5), new Coordinate(row: 2, column: 1)],
                [new Coordinate(row: 2, column: 2), new Coordinate(row: 2, column: 3), new Coordinate(row: 2, column: 4), new Coordinate(row: 2, column: 5), new Coordinate(row: 3, column: 1)],
                [new Coordinate(row: 3, column: 2), new Coordinate(row: 3, column: 3), new Coordinate(row: 3, column: 4), new Coordinate(row: 3, column: 5), new Coordinate(row: 4, column: 1)],
                [new Coordinate(row: 4, column: 2), new Coordinate(row: 4, column: 3), new Coordinate(row: 4, column: 4), new Coordinate(row: 4, column: 5), new Coordinate(row: 5, column: 1)],
                [new Coordinate(row: 5, column: 2), new Coordinate(row: 5, column: 3), new Coordinate(row: 5, column: 4), new Coordinate(row: 5, column: 5), new Coordinate(row: 1, column: 1)],
        ]

        when:
        List<Coordinate> pathToTreasure = new Coordinate(row: 1, column: 1).findTreasureOn(new TreasureMap(coordinates))

        then:
        pathToTreasure == []
    }

    def "should return empty list if there is a loop"() {
        given:
        Coordinate[][] coordinates = [
                [new Coordinate(row: 3, column: 4), new Coordinate(row: 2, column: 1), new Coordinate(row: 3, column: 2), new Coordinate(row: 4, column: 1), new Coordinate(row: 2, column: 5)],
                [new Coordinate(row: 1, column: 4), new Coordinate(row: 4, column: 2), new Coordinate(row: 4, column: 3), new Coordinate(row: 1, column: 4), new Coordinate(row: 3, column: 1)],
                [new Coordinate(row: 5, column: 4), new Coordinate(row: 4, column: 5), new Coordinate(row: 5, column: 2), new Coordinate(row: 4, column: 2), new Coordinate(row: 2, column: 3)],
                [new Coordinate(row: 3, column: 3), new Coordinate(row: 1, column: 5), new Coordinate(row: 5, column: 1), new Coordinate(row: 3, column: 1), new Coordinate(row: 3, column: 5)],
                [new Coordinate(row: 2, column: 1), new Coordinate(row: 5, column: 3), new Coordinate(row: 3, column: 3), new Coordinate(row: 1, column: 3), new Coordinate(row: 2, column: 3)],
        ]

        when:
        List<Coordinate> pathToTreasure = new Coordinate(row: 1, column: 1).findTreasureOn(new TreasureMap(coordinates))

        then:
        pathToTreasure == []
    }

}
