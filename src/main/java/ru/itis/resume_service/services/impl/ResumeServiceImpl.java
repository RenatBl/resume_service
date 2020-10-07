package ru.itis.resume_service.services.impl;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import ru.itis.resume_service.dto.ListResumeDto;
import ru.itis.resume_service.dto.ResumeDto;
import ru.itis.resume_service.forms.ResumeForm;
import ru.itis.resume_service.forms.ResumeUpdateForm;
import ru.itis.resume_service.mappers.ResumeMapper;
import ru.itis.resume_service.models.Resume;
import ru.itis.resume_service.models.User;
import ru.itis.resume_service.repositories.ResumeRepository;
import ru.itis.resume_service.services.ResumeService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final ResumeMapper resumeMapper;

    @Override
    public Resume createNewResume(ResumeForm form, User user) {
        return resumeRepository.save(Resume.builder()
                .ownerId(user.getId())
                .jobTitle(form.getJobTitle())
                .workExperiences(form.getWorkExperiences())
                .employmentType(form.getEmploymentType())
                .skills(form.getSkills())
                .educations(form.getEducations())
                .languages(form.getLanguages())
                .dateOfCreating(LocalDateTime.now())
                .build());
    }

    @Override
    public Resume updateResume(ResumeUpdateForm form) {
        Resume resume = findResumeById(form.getId());

        resume.setJobTitle(form.getJobTitle());
        resume.setWorkExperiences(form.getWorkExperiences());
        resume.setEmploymentType(form.getEmploymentType());
        resume.setSkills(form.getSkills());
        resume.setEducations(form.getEducations());
        resume.setLanguages(form.getLanguages());

        return resumeRepository.save(resume);
    }

    @Override
    public ResumeDto getResume(ObjectId id, User user) {
        return resumeMapper.resumeToDto(findResumeById(id), user);
    }

    @Override
    public List<ListResumeDto> getResumeByUser(ObjectId userId) {
        return resumeMapper.resumeToDto(resumeRepository.getByOwnerId(userId));
    }

    @Override
    public void deleteResume(ObjectId id) {
        resumeRepository.deleteById(id);
    }

    private Resume findResumeById(ObjectId id) {
        return resumeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Resume with id " + id + " not found")
        );
    }
}
