package adverity.api

import adverity.oo.domain.Coordinate
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxStreamingHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

/**
 * @author Marcin Świerczyński
 * @since 04/02/2020
 */
@MicronautTest
class TreasureHuntControllerSpec extends Specification {

    @Inject
    @Client("/treasure")
    RxStreamingHttpClient client

    def "verify treasure path can be fetched using HTTP GET"(String endpoint) {
        when:
        HttpRequest request = HttpRequest.GET(endpoint)
        HttpResponse<TreasurePath> rsp = client.toBlocking().exchange(request, Argument.of(TreasurePath))

        then: 'the endpoint can be accessed'
        rsp.status == HttpStatus.OK

        when:
        TreasurePath treasurePath = rsp.body()

        then:
        treasurePath.coordinates == [
                new CoordinateDTO(row: 1, column: 1),
                new CoordinateDTO(row: 3, column: 4),
                new CoordinateDTO(row: 4, column: 2),
                new CoordinateDTO(row: 1, column: 5),
                new CoordinateDTO(row: 2, column: 5),
                new CoordinateDTO(row: 3, column: 1),
                new CoordinateDTO(row: 5, column: 4),
                new CoordinateDTO(row: 1, column: 3),
                new CoordinateDTO(row: 3, column: 2),
                new CoordinateDTO(row: 4, column: 5),
                new CoordinateDTO(row: 3, column: 5),
                new CoordinateDTO(row: 2, column: 3),
                new CoordinateDTO(row: 4, column: 3),
                new CoordinateDTO(row: 5, column: 1),
                new CoordinateDTO(row: 2, column: 1),
                new CoordinateDTO(row: 1, column: 4),
                new CoordinateDTO(row: 4, column: 1),
                new CoordinateDTO(row: 3, column: 3),
                new CoordinateDTO(row: 5, column: 2)
        ]

        where:
        endpoint << ['/oo?row=1&column=1', '/functional?row=1&column=1']
    }

}
