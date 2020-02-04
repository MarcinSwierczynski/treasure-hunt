package adverity.api

import adverity.oo.domain.Coordinate
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import io.micronaut.core.annotation.Introspected

import javax.validation.constraints.Max
import javax.validation.constraints.Min

/**
 * @author Marcin Świerczyński
 * @since 03/02/2020
 */
@Introspected
@ToString
@EqualsAndHashCode
class CoordinateDTO {

    @Min(value = 1L)
    @Max(value = 5L)
    int row

    @Min(value = 1L)
    @Max(value = 5L)
    int column

    Coordinate toCoordinate() {
        return new Coordinate(row: row, column: column)
    }

}
