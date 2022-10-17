package services;

import dto.StudentDTO;
import entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.GymClassRepository;
import repositories.StudentRepository;

import org.springframework.data.domain.Pageable;


@Service
public class StudentService {

    private final StudentRepository repository;

    private final GymClassRepository gymClassRepository;

    public StudentService(StudentRepository repository, GymClassRepository gymClassRepository) {
        this.repository = repository;
        this.gymClassRepository = gymClassRepository;
    }

    @Transactional(readOnly = true)
    public Page<StudentDTO> findAllPaged(Pageable pageable) {
        Page<Student> list = repository.findAll(pageable);
        return list.map(x -> new StudentDTO(x));
    }



//    @Transactional(readOnly = true)



}
