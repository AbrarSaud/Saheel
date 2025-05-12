package com.example.saheel.Controller;

import com.example.saheel.Api.ApiResponse;
import com.example.saheel.Api.ApiResponse;
import com.example.saheel.Model.Horse;
import com.example.saheel.Model.Trainer;
import com.example.saheel.Model.User;
import com.example.saheel.Repository.HorseRepository;
import com.example.saheel.Service.StaffManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/saheel/staff-manager")
@RequiredArgsConstructor
public class StaffManagerController {
    private final StaffManagerService staffManagerService;
    private final HorseRepository horseRepository;


    // ( #42 of 50 endpoints)
    //move Trainer To Stable by stable owner - Abeer
    @PostMapping("/move-trainer/{trainer_Id}/ToStable/{stable_Id}")
    public ResponseEntity<ApiResponse> moveTrainerToAnotherStable(@AuthenticationPrincipal User user , @PathVariable Integer stable_Id, @PathVariable Integer trainer_Id) {
        staffManagerService.moveTrainerToAnotherStable(user.getId(), stable_Id,trainer_Id);
        return ResponseEntity.ok(new ApiResponse("Trainer assign successfully"));
    }

    // ( #43 of 50 endpoints)
    //move breeder To Stable by stable owner - Abeer
    @PostMapping("/move-breeder/{breeder_Id}/ToStable/{stable_Id}")
    public ResponseEntity<ApiResponse> moveBreederToAnotherStable(@AuthenticationPrincipal User user , @PathVariable Integer breeder_Id, @PathVariable Integer stable_Id) {
        staffManagerService.moveBreederToAnotherStable(user.getId(),breeder_Id, stable_Id);
        return ResponseEntity.ok(new ApiResponse("Breeder assign successfully"));
    }

//    //assignBreederToHorse - abeer
//    @PutMapping("/assign-breeder/{breeder_Id}/ToHorse/{horse_Id}")
//    public ResponseEntity<ApiResponse> assignBreederToHorse(@PathVariable Integer breeder_Id,@PathVariable Integer horse_Id) {
//        staffManagerService.assignBreederToHorse(breeder_Id, horse_Id);
//        return ResponseEntity.ok(new ApiResponse("Breeder Assign to horse successfully"));
//    }

    //move veterinary To Stable by stable owner - Abeer
    @PostMapping("/move-veterinary/{veterinary_Id}/ToStable/{stable_Id}")
    public ResponseEntity<ApiResponse> moveVeterinaryToAnotherStable(@AuthenticationPrincipal User user , @PathVariable Integer stable_Id, @PathVariable Integer veterinary_Id) {
        staffManagerService.moveVeterinaryToAnotherStable(user.getId(), stable_Id,veterinary_Id);
        return ResponseEntity.ok(new ApiResponse("Trainer assign successfully"));
    }

    // ( #45 of 50 endpoints)
    //assign Breeder To Horse - abeer
    @PutMapping("/assign-breeder/{breeder_Id}/ToHorse/{horse_Id}")
    public ResponseEntity<ApiResponse> assignBreederToHorse( @AuthenticationPrincipal User user ,@PathVariable Integer breeder_Id,@PathVariable Integer horse_Id) {
        staffManagerService.assignBreederToHorse(user.getId(), breeder_Id, horse_Id);
        return ResponseEntity.ok(new ApiResponse("Breeder Assign to horse successfully"));
    }
    // ( #46 of 50 endpoints)
    //assign Veterinary To Horse - abeer
    @PutMapping("/assign-veterinary/{veterinary_Id}/to-horse/{horse_Id}")
    public ResponseEntity<ApiResponse> assignVeterinaryToHorse(@AuthenticationPrincipal User user, @PathVariable Integer veterinary_Id,@PathVariable Integer horse_Id) {
        staffManagerService.assignVeterinaryToHorse(user.getId(),veterinary_Id, horse_Id);
        return ResponseEntity.ok(new ApiResponse("veterinary Assign to horse successfully"));
    }

    // ( #47 of 50 endpoints)
    // Get Available Trainer - Abeer
    @GetMapping("/get-available-trainer")
    public ResponseEntity<List<Trainer>> getTrainerById() {
        List<Trainer> trainers = staffManagerService.getAvailableTrainer();
        return ResponseEntity.ok(trainers);
    }

    // ( #48 of 50 endpoints)
    // Get all horses to veterinary
    @GetMapping("/all-horse-to-veterinary/{veterinary_Id}")
    public ResponseEntity<List<Horse>> getAllHorsesByVeterinary( @PathVariable Integer veterinary_Id) {
        List<Horse> horses = staffManagerService.getHorsesByVeterinary( veterinary_Id);
        return ResponseEntity.ok(horses);
    }

    // ( #49 of 50 endpoints)
    // Get all horses to breeder
    @GetMapping("/all-horse-to-breeder/{breeder_Id}")
    public ResponseEntity<List<Horse>> getAllHorsesByBreeder( @PathVariable Integer breeder_Id) {
        List<Horse> horses = staffManagerService.getHorsesByBreeder(breeder_Id);
        return ResponseEntity.ok(horses);
    }


    // ( #50 of 50 endpoints)
    //visit To horse by veterinary
    @PostMapping("/veterinary/visit/{horse_Id}")
    public ResponseEntity<ApiResponse>createVetVisit(@AuthenticationPrincipal User user,
                                                      @PathVariable Integer horse_Id) {
        String message = staffManagerService.requestVisitToVet(user.getId(), horse_Id);
        return ResponseEntity.ok(new ApiResponse(message));
    }
    //( #51 of 50 endpoints)
    //mark Visit AsCompleted
    @PutMapping("/veterinary/visit/fit/{visit_Id}")
    public ResponseEntity<ApiResponse> markHorseAsFit(@AuthenticationPrincipal User user, @PathVariable Integer visit_Id, @RequestBody String medicalReport) {
        staffManagerService.markHorseAsFit(user.getId(), visit_Id, medicalReport);
        return ResponseEntity.ok(new ApiResponse("The horse's status has been updated to medically fit," +
                " and the report has been sent to the owner."));
    }


}