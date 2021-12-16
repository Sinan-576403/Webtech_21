package htwberlin.Erinnerungsapp.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErinnerungRepository extends JpaRepository<ErinnerungEntity, Long > {

    List<ErinnerungEntity> findAllByErsteAufgabe(String ersteAufgabe);


}
