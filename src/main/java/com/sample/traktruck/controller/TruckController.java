package com.sample.traktruck.controller;

import com.sample.traktruck.exception.ResourceNotFoundException;
import com.sample.traktruck.model.Truck;
import com.sample.traktruck.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TruckController {

    @Autowired
    TruckRepository truckRepository;

    @GetMapping("/trucks")
    public List<Truck> getAllLoads(){
        return truckRepository.findAll();
    }

    @PostMapping("/trucks")
    public Truck createLoad(@RequestBody Truck truck){
        return truckRepository.save(truck);
    }

    @GetMapping("/trucks/{id}")
    public Truck getLoadById(@PathVariable(value = "id") Long truckId) {
        return truckRepository.findById(truckId).orElseThrow(() -> new ResourceNotFoundException("Truck", "id", truckId));
    }

    @PutMapping("/trucks/{id}")
    public Truck updateLoad(@PathVariable(value = "id") Long truckId, @RequestBody Truck truckDetails){
        Truck truck = truckRepository.findById(truckId).orElseThrow(() -> new ResourceNotFoundException("Truck", "id", truckId));

        truck.setLoadingPoint(truckDetails.getLoadingPoint());
        truck.setUnloadingPoint(truckDetails.getUnloadingPoint());
        truck.setProductType(truckDetails.getProductType());
        truck.setTruckType(truckDetails.getTruckType());
        truck.setNumTrucks(truckDetails.getNumTrucks());
        truck.setWeight(truckDetails.getWeight());
        truck.setComment(truckDetails.getComment());
        truck.setShipDate(truckDetails.getShipDate());


        Truck updatedTruck = truckRepository.save(truck);
        return updatedTruck;
    }

    @DeleteMapping("/trucks/{id}")
    public ResponseEntity<?> deleteLoad(@PathVariable(value = "id") Long truckId) {
        Truck truck = truckRepository.findById(truckId).orElseThrow(() -> new ResourceNotFoundException("Truck", "id", truckId));
        truckRepository.delete(truck);
        return ResponseEntity.ok().build();
    }

}



