package adverity.api

/**
 * @author Marcin Świerczyński
 * @since 04/02/2020
 */
class TreasurePath {

    private final List<CoordinateDTO> coordinates
    private final String error

    // needed for tess
    TreasurePath() {
    }

    TreasurePath(List<CoordinateDTO> coordinates) {
        this.coordinates = coordinates
        this.error = null
    }

    TreasurePath(String error) {
        this.coordinates = []
        this.error = error
    }

    List<CoordinateDTO> getCoordinates() {
        return coordinates
    }

    String getError() {
        return error
    }

}
