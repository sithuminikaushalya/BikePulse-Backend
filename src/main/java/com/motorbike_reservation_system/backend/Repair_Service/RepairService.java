package com.motorbike_reservation_system.backend.Repair_Service;

import com.motorbike_reservation_system.backend.Authentication.Customer.Repo.CustomerRepo;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopRepo;
import com.motorbike_reservation_system.backend.Feedback.FeedbackRepo;
import com.motorbike_reservation_system.backend.Motorbike.Motorbike;
import com.motorbike_reservation_system.backend.Motorbike.MotorbikeRepo;
import com.motorbike_reservation_system.backend.Reservation.ReservationRepo;
import com.motorbike_reservation_system.backend.payment.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {


        @Autowired
        private RepairRepo repairRepo;
        @Autowired
        private CustomerRepo customerRepo;
        @Autowired
        private ShopRepo shopRepo;
        @Autowired
        private ReservationRepo reservationRepo;
        @Autowired
        private FeedbackRepo feedbackRepo;
        @Autowired
        private PaymentRepository paymentRepository;

        public Repair saveService(Repair repair) {
            return repairRepo.save(repair);
        }

        public List<Repair> getService() {
            return repairRepo.findAll();
        }

        public Repair getServiceByRepairServiceId(String repairServiceId) {
            return repairRepo.findByServiceId(repairServiceId);
        }

        public String deleteService(String repairServiceId) {
            repairRepo.deleteById(repairServiceId);
            return "Service " + repairServiceId + " removed !! " ;
        }

        public Repair updateService(Repair repair) {
            Repair existingService = repairRepo.findByServiceId(repair.getServiceId());
            existingService.setServiceTime(repair.getServiceTime());
            existingService.setServiceDate(repair.getServiceDate());
            existingService.setServiceCategory(repair.getServiceCategory());
            existingService.setServiceStatus(repair.getServiceStatus());
            existingService.setPartsNumber(repair.getPartsNumber());
            return repairRepo.save(existingService);
        }

        public Repair addService(RepairDTO repairDTO) {
            Repair repair = Repair.builder()
                    .serviceTime(repairDTO.getServiceTime())
                    .serviceDate(repairDTO.getServiceDate())
                    .serviceCategory(repairDTO.getServiceCategory())
                    .serviceStatus(repairDTO.getServiceStatus())
                    .partsNumber(repairDTO.getPartsNumber())
                    .customer(customerRepo.findByCustomerId(repairDTO.getCustomerId()))
                    .shop(shopRepo.findByShopId(repairDTO.getShopId()))
                    .reservation(reservationRepo.findByReservationId(repairDTO.getReservationId()))
                    .feedback(feedbackRepo.findByFeedbackId(repairDTO.getFeedbackId()))
                    .payment(paymentRepository.findByPaymentId(repairDTO.getPaymentId()))
                    .build();
            return repairRepo.save(repair);
        }

}
