package MercadonaAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MercadonaAPI.model.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer>{

}
