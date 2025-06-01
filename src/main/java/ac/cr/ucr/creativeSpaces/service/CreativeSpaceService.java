package ac.cr.ucr.creativeSpaces.service;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import ac.cr.ucr.creativeSpaces.repository.CreativeSpaceRegister;
import ac.cr.ucr.creativeSpaces.repository.CreativeSpaceRepository;
import ac.cr.ucr.creativeSpaces.repository.ICreativeSpaceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreativeSpaceService
{
    @Autowired
    private CreativeSpaceRepository creativeSpaceRepository;

    //CreativeSpaceRegister creativeSpaceRegister;


    public CreativeSpace addSpace(CreativeSpace creativeSpace) {
        return this.creativeSpaceRepository.save(creativeSpace);
    }


    public List<CreativeSpace> findAllSpace() {
        return this.creativeSpaceRepository.findAll();
    }


    public Optional<CreativeSpace> findByIdSpace(Integer id) {
        return creativeSpaceRepository.findById(id);
    }

    public Optional<CreativeSpace> findByType(String type) {
        return creativeSpaceRepository.findByType(type);
    }

    public Optional<CreativeSpace> findByDay(Integer day) {
        return creativeSpaceRepository.findByDay(day);
    }

    public Optional<CreativeSpace> findByLocation(String location) {
        return creativeSpaceRepository.findByLocation(location);
    }


   /*public CreativeSpace editSpace(Integer id, CreativeSpace creativeSpaceEdit) {
        return this.creativeSpaceRegister.editSpace(id, creativeSpaceEdit);
    }*/


    public void deleteSpace(Integer id) {
        this.creativeSpaceRepository.deleteById(id);
    }

}
