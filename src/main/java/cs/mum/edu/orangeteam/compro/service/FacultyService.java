package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.Faculty;


import java.util.Collection;

public interface FacultyService {
    public Faculty addFaculty(Faculty faculty);
    public Faculty updateFaculty(Faculty faculty);
    public void deleteFacultyById(Long id);
    public Faculty findFacultyById(Long id);
    public Collection<Faculty> findAllFaculty();
}
