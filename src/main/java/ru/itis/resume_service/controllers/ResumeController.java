package ru.itis.resume_service.controllers;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.itis.resume_service.forms.ResumeForm;
import ru.itis.resume_service.forms.ResumeUpdateForm;
import ru.itis.resume_service.security.details.UserDetailsImpl;
import ru.itis.resume_service.services.ResumeService;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping
    public ResponseEntity<?> getAllResume(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity
                .ok()
                .body(resumeService.getResumeByUser(userDetails.getUser().getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResume(@PathVariable("id") ObjectId id,
                                       @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity
                .ok()
                .body(resumeService.getResume(id, userDetails.getUser()));
    }

    @PostMapping
    public ResponseEntity<?> createNewResume(@RequestBody ResumeForm resumeForm,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity
                .ok()
                .body(resumeService.createNewResume(resumeForm, userDetails.getUser()));
    }

    @PutMapping
    public ResponseEntity<?> updateResume(@RequestBody ResumeUpdateForm resumeUpdateForm) {
        return ResponseEntity
                .ok()
                .body(resumeService.updateResume(resumeUpdateForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResume(@PathVariable("id") ObjectId id) {
        resumeService.deleteResume(id);

        return ResponseEntity
                .ok()
                .body(id);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .badRequest()
                .body("Some problems");
    }
}
