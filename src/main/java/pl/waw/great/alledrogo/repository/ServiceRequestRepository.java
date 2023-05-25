package pl.waw.great.alledrogo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.waw.great.alledrogo.domain.ServiceRequest;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends CrudRepository<ServiceRequest, String> {
    List<ServiceRequest> findByUserId(String userId);
}
