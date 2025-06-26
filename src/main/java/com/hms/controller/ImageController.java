//package com.hms.controller;
//
//
//
//import com.fasterxml.jackson.annotation.JacksonInject;
//import com.learn.aws.springboots3.service.AmazonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import com.hms.repository.PropertyRepository;
//
//import java.awt.*;
//import java.util.List;
//
//
//
//
//
//
//@RestController
//@RequestMapping("/api/v1/images")
//public class ImageController {
//
//private BucketService bucketService;

//private PropertyRepository propertyRepository;
//private ImagesRepository imagesRepository;
//
//    public ImageController(BucketService bucketService, PropertyRepository propertyRepository, ImagesRepository imagesRepository) {
//        this.bucketService = bucketService;
//        this.propertyRepository = propertyRepository;
//        this.imagesRepository = imagesRepository;
//    }
//
//    @Autowired
//    private AmazonService amazonService;
//
//    @PostMapping(value = "/upload/file/{bucketName}/prperty/{propertyId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaYpe.APPLICATION_JSON_VALUE)
//    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {

//Property property = propertyRespository.findById(propertyId).get();
//Images image = new Images();
//image.setUrl(imageUrl);
//image.setProperty(property);
//Images savedImage = imagesRepository.save(image);
//return new ResponseEntity<>(savedImage, HttpStatus.OK);
//        return this.amazonService.uploadFile(file);
//    }
//
//
//
//    @DeleteMapping("/property/{propertyId}")
//    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
//        return this.amazonService.deleteFileFromS3Bucket(fileUrl);

//public ResponseEntity<List<Images>> getAllImages(
//     @PathVariable long propertyId){
//   List<Images> propertyImages = imagesRepository.findByProperty_Id(property);
//return new ResponseEntity<>(propertyImages, HttpStatus.OK);
//}
//    }
//
//    @GetMapping("/getFileList")
//    public List<String> getFileList() {
//        return this.amazonService.listFiles();
//    }
//
//}
//}
