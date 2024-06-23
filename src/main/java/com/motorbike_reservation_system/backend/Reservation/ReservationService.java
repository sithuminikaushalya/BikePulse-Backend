package com.motorbike_reservation_system.backend.Reservation;

import com.motorbike_reservation_system.backend.Authentication.Customer.Entity.Customer;
import com.motorbike_reservation_system.backend.Authentication.Customer.Repo.CustomerRepo;
import com.motorbike_reservation_system.backend.Authentication.Shop.Repo.ShopRepo;
import com.motorbike_reservation_system.backend.Fault_Management.Fault;
import com.motorbike_reservation_system.backend.Fault_Management.FaultRepository;
import com.motorbike_reservation_system.backend.Repair_Service.RepairRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepo reservationRepo;
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private RepairRepo repairRepo;
    @Autowired
    private FaultRepository faultRepo;
    @Autowired
    private EmailService emailService;

    private ReservationDTO reservationDTO;



    @Autowired
    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    public List<Reservation> saveReservation(List<Reservation> reservationList) {
        return reservationRepo.saveAll(reservationList);
    }

    public List<Reservation> getReservation() {
        return reservationRepo.findAll();
    }

    public Reservation getReservationByReservationId(String reservationId) {
        return reservationRepo.findByReservationId(reservationId);
        //.orElse(null);
    }

    public List<Reservation> getReservationsByShopId(int shopId) {
        return reservationRepo.findByShopId(shopId);
    }

    public List<Reservation> getReservationsByCustomerId(int customerId) {
        return reservationRepo.findByCustomerId(customerId);
    }


    public String deleteReservation(String reservationId) {
        reservationRepo.deleteById(reservationId);
        return "Reservation removed !! " + reservationId;
    }

    public List<Reservation> listAll() {
        return reservationRepo.findAll();
    }

//    public Reservation updateReservation(Reservation product) {
//        Reservation existingProduct = reservationRepo.findById(product.getId()).orElse(null);
//        existingProduct.setName(product.getName());
//        existingProduct.setQuantity(product.getQuantity());
//        existingProduct.setPrice(product.getPrice());
//        return reservationRepo.save(existingProduct);
//    }

//    public  String reservationDetails (){
//
//    }

//    public Reservation addReservation(ReservationDTO reservationDTO) {
//
//        Reservation reservation = Reservation.builder()
//                .motorbikeNumber(reservationDTO.getMotorbikeNumber())
//                .serviceType(reservationDTO.getServiceType())
//                .reservationDate(reservationDTO.getReservationDate())
//                .reservationTime(reservationDTO.getReservationTime())
//                .reservationAddress(reservationDTO.getReservationAddress())
//                .approvedStatus(Optional.ofNullable(reservationDTO.getApprovedStatus()).orElse("pending"))
//                .processStatus(Optional.ofNullable(reservationDTO.getProcessStatus()).orElse("pending"))
//                .paymentStatus(Optional.ofNullable(reservationDTO.getPaymentStatus()).orElse("pending"))
//                .customer(customerRepo.findByCustomerId(reservationDTO.getCustomerId()))
//                .shop(shopRepo.findByShopId(reservationDTO.getShopId()))
//                .repair(repairRepo.findByServiceId(reservationDTO.getServiceId()))
//                .fault(faultRepo.findByFaultId(reservationDTO.getFaultId()))
//                .build();
//
//         return reservationRepo.save(reservation);
//    }



    public Reservation addReservation(ReservationDTO reservationDTO) {
        Customer customer = customerRepo.findByCustomerId(reservationDTO.getCustomerId());
        if (customer == null) {
            // Handle the case where customer is not found
            throw new IllegalArgumentException("Customer not found for ID: " + reservationDTO.getCustomerId());
        }

        Reservation reservation = Reservation.builder()
                .motorbikeNumber(reservationDTO.getMotorbikeNumber())
                .serviceType(reservationDTO.getServiceType())
                .reservationDate(reservationDTO.getReservationDate())
                .reservationTime(reservationDTO.getReservationTime())
                .reservationAddress(reservationDTO.getReservationAddress())
                .approvedStatus(Optional.ofNullable(reservationDTO.getApprovedStatus()).orElse("pending"))
                .processStatus(Optional.ofNullable(reservationDTO.getProcessStatus()).orElse("pending"))
                .paymentStatus(Optional.ofNullable(reservationDTO.getPaymentStatus()).orElse("pending"))
                .customer(customer)
                .shop(shopRepo.findByShopId(reservationDTO.getShopId()))
                .repair(repairRepo.findByServiceId(reservationDTO.getServiceId()))
                .fault(faultRepo.findByFaultId(reservationDTO.getFaultId()))
                .build();

        String customerEmail = customer.getCustomerEmail();
        String customerName = customer.getCustomerName();
        String reservationDetails = buildReservationDetails(reservation); // You need to implement this method
        emailService.sendReservationConfirmation(customerEmail, customerName, reservationDetails);
        emailService.sendPendingReservationNotification(customerEmail, customerName, reservationDetails);

        return reservationRepo.save(reservation);
    }

    private String buildReservationDetails(Reservation reservation) {
        // Logic to build reservation details string from reservation
        // For example:
        return "Reservation Details:\n" +
                "Motorbike Number: " + reservation.getMotorbikeNumber() + "\n" +
                "Service Type: " + reservation.getServiceType() + "\n" +
                "Reservation Date: " + reservation.getReservationDate() + "\n" +
                "Reservation Time: " + reservation.getReservationTime() + "\n" +
                "Reservation Address: " + reservation.getReservationAddress() + "\n";
    }



    public List<ReservationDetailsDTO> getAllReservationDTOs() {
        List<Reservation> reservations = listAll();
        return reservations.stream()
                .map(reservation -> new ReservationDetailsDTO(
                        reservation.getReservationId(),
                        reservation.getMotorbikeNumber(),
                        reservation.getServiceType(),
                        convertToSqlDate(reservation.getReservationDate()),
                        reservation.getReservationTime(),
                        reservation.getReservationAddress(),
                        reservation.getApprovedStatus(),
                        reservation.getProcessStatus(),
                        reservation.getPaymentStatus(),
                        (reservation.getCustomer() != null) ? reservation.getCustomer().getCustomerName() : null,
                        reservation.getCustomer() != null ? reservation.getCustomer().getCustomerPhoneNumber() : null,
                        reservation.getCustomer() != null ? reservation.getCustomer().getCustomerEmail() : null,
                        (reservation.getShop() != null) ? reservation.getShop().getShopName() : null,
                        reservation.getShop() != null ? reservation.getShop().getEmail() : null,
                        reservation.getShop() != null ? reservation.getShop().getContactNumber() : null


                ))
                .collect(Collectors.toList());
    }

    private Date convertToSqlDate(java.util.Date date) {
        if (date != null) {
            return new Date(date.getTime());
        }
        return null;
    }

    @Transactional
    public void updateApprovedStatus(String reservationId, String approvedStatus) {
        reservationRepo.updateApprovedStatus(reservationId, approvedStatus);

        // Fetch reservation details and customer email
        Reservation reservation = reservationRepo.findByReservationId(reservationId);//.orElseThrow(() -> new RuntimeException("Reservation not found"));
        String recipientEmail = reservation.getCustomer().getCustomerEmail();
        String recipientCustomer = reservation.getCustomer().getCustomerName();
        String reservationDetails = buildReservationDetails(reservation);

        // Send appropriate notification based on the approved status
        if ("approved".equalsIgnoreCase(approvedStatus)) {
            emailService.sendReservationApprovedNotification(recipientEmail, recipientCustomer, reservationDetails);
        } else if ("rejected".equalsIgnoreCase(approvedStatus)) {
            emailService.sendReservationRejectedNotification(recipientEmail, recipientCustomer, reservationDetails);
        }
    }

    @Transactional
    public void updateProcessStatus(String reservationId, String processStatus) {
        reservationRepo.updateProcessStatus(reservationId, processStatus);

        // Fetch reservation details and customer email
        Reservation reservation = reservationRepo.findByReservationId(reservationId); //.orElseThrow(() -> new RuntimeException("Reservation not found"));
        String recipientEmail = reservation.getCustomer().getCustomerEmail();
        String recipientCustomer = reservation.getCustomer().getCustomerName();
        String reservationDetails = buildReservationDetails(reservation);

        // Send appropriate notification based on the process status
        switch (processStatus.toLowerCase()) {
            case "pending":
                emailService.sendReservationPendingNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            case "on_hold":
                emailService.sendReservationOnHoldNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            case "in_progress":
                emailService.sendReservationInProgressNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            case "completed":
                emailService.sendReservationCompletedNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            case "cancelled":
                emailService.sendReservationCancelledNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            case "delayed":
                emailService.sendReservationDelayedNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
        }



    }

    @Transactional
    public void updatePaymentStatus(String reservationId, String paymentStatus) {
        reservationRepo.updatePaymentStatus(reservationId, paymentStatus);

        // Get the reservation details
        Reservation reservation = reservationRepo.findById(reservationId).orElse(null);
        if (reservation == null) {
            return; // Handle the case where reservation is not found
        }

        String recipientEmail = reservation.getCustomer().getCustomerEmail();
        String recipientCustomer = reservation.getCustomer().getCustomerName();
        String reservationDetails = buildReservationDetails(reservation); // Create reservation details string

        // Send notification based on payment status
        switch (paymentStatus) {
            case "pending":
                emailService.sendReservationPaymentPendingNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            case "completed":
                emailService.sendReservationPaymentCompletedNotification(recipientEmail, recipientCustomer, reservationDetails);
                break;
            default:
                // Handle invalid payment status
                break;
        }
    }


    public Reservation getReservationById(String reservationId) {
        return reservationRepo.findByReservationId(reservationId);//.orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public Optional<ReservationDetailsDTO> getReservationDTOById(String reservationId) {
        return reservationRepo.findById(reservationId).map(this::convertToDTO);
    }

    private ReservationDetailsDTO convertToDTO(Reservation reservation) {
        return ReservationDetailsDTO.builder()
                .reservationId(reservation.getReservationId())
                .motorbikeNumber(reservation.getMotorbikeNumber())
                .serviceType(reservation.getServiceType())
                .reservationDate(convertToSqlDate(reservation.getReservationDate()))
                .reservationTime(reservation.getReservationTime())
                .reservationAddress(reservation.getReservationAddress())
                .approvedStatus(reservation.getApprovedStatus())
                .processStatus(reservation.getProcessStatus())
                .paymentStatus(reservation.getPaymentStatus())
                .customerName(reservation.getCustomer() != null ? reservation.getCustomer().getCustomerName() : null)
                .customerPhoneNumber(reservation.getCustomer() != null ? reservation.getCustomer().getCustomerPhoneNumber() : null)
                .customerEmail(reservation.getCustomer() != null ? reservation.getCustomer().getCustomerEmail() : null)
                .shopName(reservation.getShop() != null ? reservation.getShop().getShopName() : null)
                .email(reservation.getShop() != null ? reservation.getShop().getEmail() : null)
                .contactNumber(reservation.getShop() != null ? reservation.getShop().getContactNumber() : null)
                .build();
    }
}
