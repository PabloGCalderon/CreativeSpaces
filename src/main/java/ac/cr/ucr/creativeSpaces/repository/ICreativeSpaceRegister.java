package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;

import java.util.List;

public interface ICreativeSpaceRegister
{
    public CreativeSpace addSpace(CreativeSpace creativeSpace);
    public List<CreativeSpace> getAllSpace();
    public CreativeSpace getSpaceByID(Integer id);
    public CreativeSpace getSpaceByType(String type);
    public CreativeSpace getSpaceByDay(Integer day);
    public CreativeSpace getSpaceByLocation(String location);
    public CreativeSpace editSpace(Integer id, CreativeSpace creativeSpaceEdit);
    public CreativeSpace deleteSpace(Integer id);


}
