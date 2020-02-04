package adverity.functional.application

import adverity.functional.infrastructure.TreasureMap
import spock.lang.Specification

/**
 * @author Marcin Świerczyński
 * @since 04/02/2020
 */
class FunctionalTreasureHunterSpec extends Specification {

    FunctionalTreasureHunter treasureHunter

    void setup() {
        treasureHunter = new FunctionalTreasureHunter()
    }

    def "should return the path to the treasure"() {
        when:
        int[] start = [1, 1]
        int[][] pathToTreasure = treasureHunter.visitCoordinate(TreasureMap.TREASURE_MAP, start)

        then:
        pathToTreasure == [
                [1, 1],
                [3, 4],
                [4, 2],
                [1, 5],
                [2, 5],
                [3, 1],
                [5, 4],
                [1, 3],
                [3, 2],
                [4, 5],
                [3, 5],
                [2, 3],
                [4, 3],
                [5, 1],
                [2, 1],
                [1, 4],
                [4, 1],
                [3, 3],
                [5, 2],
        ]
    }

    def "should return first element if it is a treasure"() {
        given:
        int[][][] coordinates = [
                    [[1, 1], [2, 1], [3, 2], [4, 1], [2, 5]],
                    [[1, 4], [4, 2], [4, 3], [1, 4], [3, 1]],
                    [[5, 4], [4, 5], [5, 2], [4, 2], [2, 3]],
                    [[3, 3], [1, 5], [5, 1], [3, 1], [3, 5]],
                    [[2, 1], [5, 2], [3, 3], [1, 3], [2, 3]],
            ]

        when:
        int[] start = [1, 1]
        int[][] pathToTreasure = treasureHunter.visitCoordinate(coordinates, start)

        then:
        pathToTreasure == [[1, 1]]
    }


    def "should return empty list if there is no treasure"() {
        given:
        int[][][] coordinates = [
                    [[1, 2], [1, 3], [1, 4], [1, 5], [2, 1]],
                    [[2, 2], [2, 3], [2, 4], [2, 5], [3, 1]],
                    [[3, 2], [3, 3], [3, 4], [3, 5], [4, 1]],
                    [[4, 2], [4, 3], [4, 4], [4, 5], [5, 1]],
                    [[5, 2], [5, 3], [5, 4], [5, 5], [1, 1]],
            ]

        when:
        int[] start = [1, 1]
        int[][] pathToTreasure = treasureHunter.visitCoordinate(coordinates, start)

        then:
        pathToTreasure == []
    }

    def "should return empty list if there is a loop"() {
        given:
        int[][][] coordinates = [
                    [[3, 4], [2, 1], [3, 2], [4, 1], [2, 5]],
                    [[1, 4], [4, 2], [4, 3], [1, 4], [3, 1]],
                    [[5, 4], [4, 5], [5, 2], [4, 2], [2, 3]],
                    [[3, 3], [1, 5], [5, 1], [3, 1], [3, 5]],
                    [[2, 1], [5, 3], [3, 3], [1, 3], [2, 3]],
            ]

        when:
        int[] start = [1, 1]
        int[][] pathToTreasure = treasureHunter.visitCoordinate(coordinates, start)

        then:
        pathToTreasure == []
    }

}
