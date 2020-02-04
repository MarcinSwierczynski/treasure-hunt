package adverity.functional.application

import adverity.functional.infrastructure.TreasureMap

import javax.inject.Singleton

/**
 * @author Marcin Świerczyński
 * @since 03/02/2020
 */
@Singleton
class FunctionalTreasureHunter {

    int[][] findTreasure(int[] start) {
        return visitCoordinate(TreasureMap.TREASURE_MAP, start)
    }

    int[][] visitCoordinate(int[][][] map, int[] coordinate, List<int[]> result = []) {
        int row = coordinate[0] - 1
        int column = coordinate[1] - 1
        int[] nextCoordinate = map[row][column]

        if (nextCoordinate == coordinate) {
            result << coordinate
            return result
        }

        if (result.size() > map.length * map[0].length) {
            return []
        }

        visitCoordinate(map, nextCoordinate, result << coordinate)
    }

}
