package ac.cr.ucr.creativeSpaces.service;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import ac.cr.ucr.creativeSpaces.repository.CreativeSpaceRegister;
import ac.cr.ucr.creativeSpaces.repository.ICreativeSpaceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreativeSpaceService implements ICreativeSpaceRegister
{
    @Autowired
    CreativeSpaceRegister creativeSpaceRegister;

    @Override
    public CreativeSpace addSpace(CreativeSpace creativeSpace) {
        return this.creativeSpaceRegister.addSpace(creativeSpace);
    }

    @Override
    public List<CreativeSpace> getAllSpace() {
        return this.creativeSpaceRegister.getAllSpace();
    }

    @Override
    public CreativeSpace getSpaceByID(Integer id) {
        return this.creativeSpaceRegister.getSpaceByID(id);
    }

    @Override
    public CreativeSpace getSpaceByType(String type) {
        return this.creativeSpaceRegister.getSpaceByType(type);
    }

    @Override
    public CreativeSpace getSpaceByDay(Integer day) {
        return this.creativeSpaceRegister.getSpaceByDay(day);
    }

    @Override
    public CreativeSpace getSpaceByLocation(String location) {
        return this.creativeSpaceRegister.getSpaceByLocation(location);
    }

    @Override
    public CreativeSpace editSpace(Integer id, CreativeSpace creativeSpaceEdit) {
        return this.creativeSpaceRegister.editSpace(id, creativeSpaceEdit);
    }

    @Override
    public CreativeSpace deleteSpace(Integer id) {
        return this.creativeSpaceRegister.deleteSpace(id);
    }
}
