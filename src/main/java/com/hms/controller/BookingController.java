package com.hms.controller;

import com.hms.entity.Bookings;
import com.hms.entity.Property;
import com.hms.entity.Room;
import com.hms.repository.BookingsRepository;
import com.hms.repository.PropertyRepository;
import com.hms.repository.RoomRepository;
import com.hms.service.TwilioService;
import com.hms.util.PDFService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//http://localhost:8080/api/v1/bookings/1
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private PDFService pdfService;
    private PropertyRepository propertyRepository;
    private BookingsRepository bookingsRepository;
    private RoomRepository roomRepository;
    private TwilioService twilioService;


    public BookingController(PDFService pdfService, PropertyRepository propertyRepository, BookingsRepository bookingsRepository, RoomRepository roomRepository) {
        this.pdfService = pdfService;
        this.propertyRepository = propertyRepository;
        this.bookingsRepository = bookingsRepository;
        this.roomRepository = roomRepository;

    }

    @PostMapping("/create-booking")
    public ResponseEntity<?> createBookings(
            @RequestParam long propertyId,
            @RequestParam String type,
            @RequestBody Bookings bookings
            ){

        Property property = propertyRepository.findById(propertyId).get();
        List<Room> rooms = roomRepository.findByTypeAndProperty(bookings.getFromDate(), bookings.getToDate(),type,property);

        for (Room room : rooms){
            if (room.getCount()==0){
                return new ResponseEntity<>("No available room of this type", HttpStatus.OK);
        }
    }

        for (Room room : rooms){
            double totalPrice = room.getPerNightPrice() * (double) (rooms.size() - 1);
        }


//
//       Room room= roomRepository.findByTypeAndProperty(type, property);
//       if (room.getCount()==0){
//           return "No available room of this type";
//       }
//
//
        Bookings savedBooking = bookingsRepository.save(bookings);

       if (savedBooking!=null){
             for (Room room : rooms){
              room.setCount(room.getCount()-1);
               roomRepository.save(room);
        }
      }

       pdfService.generateBookingPdf("C:\\Users\\sanja\\OneDrive\\Desktop\\HMS_Booking\\confirmation-order"+savedBooking.getId()+".pdf",property);
       //twilioService.sendSms("own mobile number","mobile number given by twilio", "Booking confirmed. Your booking id is: "+bookings.getId());
       //twilioService.sendWhatsApp("mobile number given by twilio", "Booking confirmed. Your booking id is: " + savedBooking.getId()); (Demo)
        //twillioService.sendEmail("booking@example.com", "New Booking", "Booking confirmed. Your booking id is: " + savedBooking.getId()); ( Demo)
       return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}










//// ... other imports ...   //////UPDATED CODE AND METHOD //////
//
//@RestController
//@RequestMapping("/api/v1/bookings")
//public class BookingController {
//
//    // ... other fields and constructor ...
//
//    @PostMapping("/create-booking")
//    public ResponseEntity<?> createBookings(
//            @RequestParam long propertyId,
//            @RequestParam String type,
//            @RequestBody Bookings bookings
//    ) {
//        // UPDATED CODE
//        Property property = propertyRepository.findById(propertyId).orElseThrow(() -> new RuntimeException("Property not found"));
//        List<Room> rooms = roomRepository.findByTypeAndProperty(bookings.getFromDate(), bookings.getToDate(), type, property);
//
//        if (rooms.isEmpty() || rooms.stream().allMatch(room -> room.getCount() == 0)) {
//            return new ResponseEntity<>("No available room of this type", HttpStatus.OK);
//        }
//
//        Bookings savedBooking = bookingsRepository.save(bookings);
//
//        if (savedBooking != null) {
//            for (Room room : rooms) {
//                if (room.getCount() > 0) {
//                    room.setCount(room.getCount() - 1);
//                    roomRepository.save(room);
//                    break; // Only decrease the count for one room
//                }
//            }
//        }
//
//        pdfService.generateBookingPdf("C:\\Users\\sanja\\OneDrive\\Desktop\\HMS_Booking\\confirmation-order" + savedBooking.getId() + ".pdf", property);
//        twilioService.sendSms("own mobile number", "mobile number given by twilio", "Booking confirmed. Your booking id is: " + savedBooking.getId());
//        return new ResponseEntity<>(savedBooking, HttpStatus.OK);
//        // END OF UPDATED CODE
//    }
//}