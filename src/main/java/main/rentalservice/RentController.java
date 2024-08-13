package main.rentalservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @Operation(summary = "Get Movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie All Founded :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @GetMapping("/movies/{id}")
    public ResponseEntity<Film> getMovie(@PathVariable Long id)
    {
        return ResponseEntity.ok(rentService.getMovie(id));
    }

    @Operation(summary = "Return Movie By ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie All Founded :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @PutMapping("/movies/{id}")
    public ResponseEntity<Film> returnMovie(@PathVariable Long id)
    {
        rentService.returnMovie(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Renting The Movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie All Founded :)",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Film.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @PutMapping("/movie/{id}")
    public ResponseEntity<Film> rentMovie(@PathVariable Long id)
    {
        rentService.rentMovie(id);
        return ResponseEntity.noContent().build();
    }
}
