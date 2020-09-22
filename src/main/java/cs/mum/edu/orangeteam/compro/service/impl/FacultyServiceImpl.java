package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.repository.FacultyRepository;
import cs.mum.edu.orangeteam.compro.model.Faculty;
import cs.mum.edu.orangeteam.compro.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFacultyById(Long id) {
        facultyRepository.deleteById(id);

    }

    @Override
    public Faculty findFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Faculty> findAllFaculty() {
        return facultyRepository.findAll();
    }
}
