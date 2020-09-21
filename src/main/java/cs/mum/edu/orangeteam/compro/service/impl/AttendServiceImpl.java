package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.DAO.AttendRepository;
import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class AttendServiceImpl implements AttendService {
    @Autowired
    private AttendRepository attendRepository;

    @Override
    public Attend addAttendance(Attend attend) {
        return attendRepository.save(attend);
    }

    @Override
    public Attend updateAttendance(Attend attend) {
        return attendRepository.save(attend);
    }

    @Override
    public void deleteAttendanceById(Long id) {
        attendRepository.deleteById(id);
    }

    @Override
    public Attend findAttendanceById(Long id) {
        return attendRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Attend> findAllAttendance() {
        return attendRepository.findAll();
    }
}
