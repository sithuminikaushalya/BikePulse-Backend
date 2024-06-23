package com.motorbike_reservation_system.backend.ServiceType;

import com.motorbike_reservation_system.backend.ServiceType.Entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ServiceTypeRepo  extends JpaRepository<ServiceType, String> {

    ServiceType findByServiceTypeId(String serviceTypeId);

}
