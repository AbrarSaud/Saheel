package com.example.saheel.Controller;

import com.example.saheel.Api.ApiException;
import com.example.saheel.Model.Trainer;
import com.example.saheel.Model.User;
import com.example.saheel.Model.Veterinary;
import com.example.saheel.Service.VeterinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/veterinary")
@RequiredArgsConstructor
public class VeterinaryController {

    private final VeterinaryService veterinaryService;

    // Get veterinary by ID - Abeer
    @GetMapping("/get/{veterinary_Id}")
    public ResponseEntity<Veterinary> getVeterinaryById(@PathVariable Integer veterinary_Id) {
        Veterinary veterinary = veterinaryService.getVeterinaryById(veterinary_Id);
        return ResponseEntity.ok(veterinary);
    }

    //searchVeterinaryByName
    @GetMapping("/search-byName/{fullName}")
    public ResponseEntity<Veterinary> searchVeterinaryByName(@AuthenticationPrincipal User user, @PathVariable String fullName) {
        Veterinary veterinary = veterinaryService.searchVeterinaryByName(user.getId(),fullName);
        return ResponseEntity.ok(veterinary);
    }


    // Add veterinary - Abeer
    @PostMapping("/add/{stable_Id}")
    public ResponseEntity<ApiException> addVeterinary(@AuthenticationPrincipal User user, @PathVariable Integer stable_Id, @RequestBody Veterinary veterinary) {
        veterinaryService.addVeterinary(user.getId(), stable_Id, veterinary);
        return ResponseEntity.ok(new ApiException("Veterinary added successfully"));
    }

    //move veterinary To Stable by stable owner - Abeer
    @PostMapping("/moveVeterinary/{veterinary_Id}/ToStable/{stable_Id}")
    public ResponseEntity<ApiException> moveVeterinaryToAnotherStable(@AuthenticationPrincipal User user , @PathVariable Integer stable_Id, @PathVariable Integer veterinary_Id) {
        veterinaryService.moveVeterinaryToAnotherStable(user.getId(), stable_Id,veterinary_Id);
        return ResponseEntity.ok(new ApiException("Trainer assign successfully"));
    }

    // Update veterinary - Abeer
    @PutMapping("/update/{stable_Id}/{veterinary_Id}")
    public ResponseEntity<ApiException> updateVeterinary(@AuthenticationPrincipal User user, @PathVariable Integer stable_Id, @PathVariable Integer veterinary_Id, @RequestBody Veterinary veterinary) {
        veterinaryService.updateVeterinary(user.getId(), stable_Id, veterinary_Id, veterinary);
        return ResponseEntity.ok(new ApiException("Veterinary updated successfully"));
    }

    // Delete veterinary - Abeer
    @DeleteMapping("/delete/{veterinary_Id}")
    public ResponseEntity<ApiException> deleteVeterinary(@AuthenticationPrincipal User user , @PathVariable Integer veterinary_Id) {
        veterinaryService.deleteVeterinary(user.getId(), veterinary_Id);
        return ResponseEntity.ok(new ApiException("Veterinary deleted successfully"));
    }
}
