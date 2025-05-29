package ac.cr.ucr.creativeSpaces.controller;


import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import ac.cr.ucr.creativeSpaces.service.CreativeSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cs")
public class CreativeSpaceController
{
    @Autowired
    CreativeSpaceService creativeSpaceService;



    @GetMapping
    public List<CreativeSpace> getAllSpace() {
        return this.creativeSpaceService.getAllSpace();
    }

    @GetMapping("/{id}")
    public CreativeSpace getSpaceByID(@PathVariable Integer id) {
        return this.creativeSpaceService.getSpaceByID(id);
    }

    @GetMapping("/{type}")
    public CreativeSpace getSpaceByType(@PathVariable String type) {
        return this.creativeSpaceService.getSpaceByType(type);
    }

    @GetMapping("/day/{day}")
    public CreativeSpace getSpaceByDay(@PathVariable Integer day) {
        return this.creativeSpaceService.getSpaceByDay(day);
    }

    @GetMapping("/{location}")
    public CreativeSpace getSpaceByLocation(@PathVariable String location) {
        return this.creativeSpaceService.getSpaceByLocation(location);
    }

    @PostMapping
    public CreativeSpace addSpace(@RequestBody CreativeSpace creativeSpace) {
        return this.creativeSpaceService.addSpace(creativeSpace);
    }

    @PutMapping("/{id}")
    public CreativeSpace editSpace(@PathVariable Integer id, @RequestBody CreativeSpace creativeSpaceEdit) {
        return this.creativeSpaceService.editSpace(id, creativeSpaceEdit);
    }

    @DeleteMapping("/{id}")
    public CreativeSpace deleteSpace(@PathVariable Integer id) {
        return this.creativeSpaceService.deleteSpace(id);
    }


}
