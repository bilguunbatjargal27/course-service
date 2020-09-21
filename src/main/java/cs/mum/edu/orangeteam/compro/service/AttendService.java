package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.Attend;

import java.util.Collection;

public interface AttendService {
    public Attend addAttend(Attend attend);
    public Attend updateAttend(Attend attend);
    public void deleteAttend(Long id);
    public Attend findAttendById(Long id);
    public Collection<Attend> findAll();
}
