package htwberlin.Erinnerungsapp.web.service;

import htwberlin.Erinnerungsapp.web.api.Erinnerung;
import htwberlin.Erinnerungsapp.web.api.ErinnerungManipulationRequest;
import htwberlin.Erinnerungsapp.web.persistence.ErinnerungEntity;
import htwberlin.Erinnerungsapp.web.persistence.ErinnerungRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ErinnerungService {

    private final ErinnerungRepository erinnerungRepository;

    public ErinnerungService(ErinnerungRepository erinnerungRepository) {
        this.erinnerungRepository = erinnerungRepository;
    }

    public List<Erinnerung> findAll() {
        List<ErinnerungEntity> erinnerungen = erinnerungRepository.findAll();
        return erinnerungen.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Erinnerung findById(Long id){
        var erinnerungEntity = erinnerungRepository.findById(id);
        return erinnerungEntity.map(this::transformEntity).orElse(null);
    }

    public Erinnerung create(ErinnerungManipulationRequest request) {
        var erinnerungEntity = new ErinnerungEntity(request.getErsteAufgabe(), request.getNachsteAufgabe(), request.isErledigt(),request.getJob(),request.getArt());
        erinnerungEntity = erinnerungRepository.save(erinnerungEntity);
        return transformEntity(erinnerungEntity);
    }

    public Erinnerung update(Long id, ErinnerungManipulationRequest request) {
        var erinnerungEntityOptional = erinnerungRepository.findById(id);
        if (erinnerungEntityOptional.isEmpty()) {
            return null;
        }

        var erinnerungEntity = erinnerungEntityOptional.get();
        erinnerungEntity.setErsteAufgabe(request.getErsteAufgabe());
        erinnerungEntity.setNachsteAufgabe(request.getNachsteAufgabe());
        erinnerungEntity.setErledigt(request.isErledigt());
        erinnerungEntity.setJob(request.getJob());
        erinnerungEntity = erinnerungRepository.save(erinnerungEntity);

        return transformEntity(erinnerungEntity);
    }

    public boolean deleteById(Long id){
        if (!erinnerungRepository.existsById(id)){
            return false;
        }
        erinnerungRepository.deleteById(id);
        return true;


    }



    private Erinnerung transformEntity(ErinnerungEntity erinnerungEntity) {
        return new Erinnerung(
                erinnerungEntity.getId(),
                erinnerungEntity.getErsteAufgabe(),
                erinnerungEntity.getNachsteAufgabe(),
                erinnerungEntity.isErledigt(),
                erinnerungEntity.getJob(),
                erinnerungEntity.getArt()

        );



    }
}
