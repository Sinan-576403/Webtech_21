package htwberlin.Erinnerungsapp.web.web2;


import htwberlin.Erinnerungsapp.web.api.Erinnerung;
import htwberlin.Erinnerungsapp.web.api.ErinnerungManipulationRequest;
import htwberlin.Erinnerungsapp.web.service.ErinnerungService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ErinnerungRestController {

    private final ErinnerungService erinnerungService;

    public ErinnerungRestController(ErinnerungService erinnerungService) {
        this.erinnerungService = erinnerungService;
    }


    @GetMapping(path = "/api/v1/erinnerung")
    public ResponseEntity<List<Erinnerung>> fetchErinnerungen(){
        return ResponseEntity.ok(erinnerungService.findAll());

    }

    @GetMapping(path = "/api/v1/erinnerung/{id}")
    public ResponseEntity<Erinnerung>fetchErinnerungById(@PathVariable Long id){
        var erinnerung = erinnerungService.findById(id);
        return erinnerung != null? ResponseEntity.ok(erinnerung): ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/erinnerung")
    public ResponseEntity<Void> createErinnerung(@RequestBody ErinnerungManipulationRequest request) throws URISyntaxException {
        var erinnerung= erinnerungService.create(request);
        URI uri = new URI("/api/v1/erinnerung/"+ erinnerung.getId());
        return ResponseEntity.created(uri).build();


    }
    @PutMapping(path = "/api/v1/erinnerung/{id}")
    public ResponseEntity<Erinnerung> updateErinnerung(@PathVariable Long id, @RequestBody ErinnerungManipulationRequest request) {
        var erinnerung = erinnerungService.update(id, request);
        return erinnerung != null? ResponseEntity.ok(erinnerung): ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/api/v1/erinnerung/{id}")
    public ResponseEntity<Void> deleteErinnerung(@PathVariable Long id){
        boolean successful = erinnerungService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
