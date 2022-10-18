package services;

import dto.GymClassDTO;
import dto.StudentDTO;
import entities.GymClass;
import entities.Student;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.GymClassRepository;
import repositories.StudentRepository;

import org.springframework.data.domain.Pageable;
import services.exceptions.DataBaseException;
import services.exceptions.ResourceNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


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

    @Transactional(readOnly = true)
    public StudentDTO findById(Long id) {
        Optional<Student> obj = repository.findById(id);
        Student entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        return new StudentDTO(entity, entity.getGymClass());
    }

    @Transactional
    public StudentDTO insert(StudentDTO dto) {
        Student entity = new Student();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new StudentDTO(entity);
    }

    @Transactional
    public StudentDTO update(Long id, StudentDTO dto) {
        try {
            Student entity = repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new StudentDTO(entity);
        }catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }


    private void copyDtoToEntity(StudentDTO dto, Student entity) {
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHeight(dto.getAge());
        entity.getGymClass().clear();
        for(GymClassDTO gcDTO : dto.getGymClass()) {
            GymClass gymClass = gymClassRepository.getOne(gcDTO.getId());
            entity.getGymClass().add(gymClass);
        }
    }




}
