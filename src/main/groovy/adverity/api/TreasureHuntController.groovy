package adverity.api

import adverity.functional.application.FunctionalTreasureHunter
import adverity.oo.application.ObjectOrientedTreasureHunter
import adverity.oo.domain.Coordinate
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject
import javax.validation.Valid

/**
 * @author Marcin Świerczyński
 * @since 03/02/2020
 */
@Controller('/treasure')
class TreasureHuntController {

    final FunctionalTreasureHunter functionalTreasureHunter
    final ObjectOrientedTreasureHunter objectOrientedTreasureHunter

    @Inject
    TreasureHuntController(ObjectOrientedTreasureHunter objectOrientedTreasureHunter,
                           FunctionalTreasureHunter functionalTreasureHunter) {
        this.functionalTreasureHunter = functionalTreasureHunter
        this.objectOrientedTreasureHunter = objectOrientedTreasureHunter
    }

    @Get("/oo{?start*}")
    TreasurePath oo(@Valid CoordinateDTO start) {
        List<Coordinate> pathToTreasure = objectOrientedTreasureHunter.findTreasure(start)
        if (pathToTreasure) {
            return new TreasurePath(pathToTreasure.collect { new CoordinateDTO(row: it.row, column: it.column) })
        }
        return new TreasurePath('NO TREASURE')
    }

    @Get("/functional{?start*}")
    TreasurePath functional(@Valid CoordinateDTO start) {
        int[] integers = [start.row, start.column]
        int[][] pathToTreasure = functionalTreasureHunter.findTreasure(integers)
        if (pathToTreasure) {
            return new TreasurePath(pathToTreasure.collect { new CoordinateDTO(row: it[0], column: it[1]) })
        }
        return new TreasurePath('NO TREASURE')
    }

}
