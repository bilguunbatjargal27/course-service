package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.DAO.AttendRepository;
import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class AttendServiceImpl implements AttendService {

    @Autowired
    private AttendRepository repository;

    @Override
    public Attend addAttend(Attend attend) {
        return repository.save(attend);
    }

    @Override
    public Attend updateAttend(Attend attend) {
        return repository.save(attend);
    }

    @Override
    public void deleteAttend(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Attend findAttendById(Long id) {
        if(repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @Override
    public Collection<Attend> findAll() {
        return repository.findAll();
    }
}
