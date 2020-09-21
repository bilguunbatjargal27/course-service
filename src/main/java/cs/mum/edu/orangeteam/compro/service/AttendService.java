package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.Attend;


import java.util.Collection;

public interface AttendService {
    public Attend addAttendance(Attend attend);
    public Attend updateAttendance(Attend attend);
    public void deleteAttendanceById(Long id);
    public Attend findAttendanceById(Long id);
    public Collection<Attend> findAllAttendance();
}
