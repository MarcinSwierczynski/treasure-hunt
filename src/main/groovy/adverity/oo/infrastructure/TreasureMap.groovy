package adverity.oo.infrastructure

import adverity.oo.domain.Coordinate

/**
 * This is our repository/data source (in DDD nomenclature). This one is in-memory.
 *
 * @author Marcin Świerczyński
 * @since 03/02/2020
 */
class TreasureMap {

    private final Coordinate[][] coordinates

    /*
        +------------------------+
        ¦ 34 ¦ 21 ¦ 32 ¦ 41 ¦ 25 ¦
        +----+----+----+----+----¦
        ¦ 14 ¦ 42 ¦ 43 ¦ 14 ¦ 31 ¦
        +----+----+----+----+----¦
        ¦ 54 ¦ 45 ¦ 52 ¦ 42 ¦ 23 ¦
        +----+----+----+----+----¦
        ¦ 33 ¦ 15 ¦ 51 ¦ 31 ¦ 35 ¦
        +----+----+----+----+----¦
        ¦ 21 ¦ 52 ¦ 33 ¦ 13 ¦ 23 ¦
        +------------------------+
    */
    TreasureMap() {
        this.coordinates = [
                [new Coordinate(row: 3, column: 4), new Coordinate(row: 2, column: 1), new Coordinate(row: 3, column: 2), new Coordinate(row: 4, column: 1), new Coordinate(row: 2, column: 5)],
                [new Coordinate(row: 1, column: 4), new Coordinate(row: 4, column: 2), new Coordinate(row: 4, column: 3), new Coordinate(row: 1, column: 4), new Coordinate(row: 3, column: 1)],
                [new Coordinate(row: 5, column: 4), new Coordinate(row: 4, column: 5), new Coordinate(row: 5, column: 2), new Coordinate(row: 4, column: 2), new Coordinate(row: 2, column: 3)],
                [new Coordinate(row: 3, column: 3), new Coordinate(row: 1, column: 5), new Coordinate(row: 5, column: 1), new Coordinate(row: 3, column: 1), new Coordinate(row: 3, column: 5)],
                [new Coordinate(row: 2, column: 1), new Coordinate(row: 5, column: 2), new Coordinate(row: 3, column: 3), new Coordinate(row: 1, column: 3), new Coordinate(row: 2, column: 3)],
        ]
    }

    TreasureMap(Coordinate[][] coordinates) {
        this.coordinates = coordinates
    }

    Coordinate findNextCoordinate(Coordinate coordinate) {
        return this.coordinates[coordinate.row - 1][coordinate.column - 1]
    }

}
