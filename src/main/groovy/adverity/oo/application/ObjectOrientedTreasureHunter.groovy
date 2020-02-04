package adverity.oo.application

import adverity.api.CoordinateDTO
import adverity.oo.domain.Coordinate
import adverity.oo.infrastructure.TreasureMap

import javax.inject.Singleton

/**
 * This is our application service (in DDD nomenclature). It fetches the data from a data source (here: in memory),
 * and operates on the domain objects.
 *
 * @author Marcin Świerczyński
 * @since 03/02/2020
 */
@Singleton
class ObjectOrientedTreasureHunter {

    List<Coordinate> findTreasure(CoordinateDTO start) {
        Coordinate startCoordinate = start.toCoordinate()
        return startCoordinate.findTreasureOn(new TreasureMap())
    }

}
