package be.hogent.data.web.rest;

import be.hogent.data.service.ModificationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Set;

@RestController
@RequestMapping(value = "/log")
public class ModificationLogController {
    @Autowired
    private ModificationLogService modificationLogService;

    @RequestMapping(value = "/{table}", method = RequestMethod.GET)
    public ResponseEntity<Set<Long>> findModifiedIds(@PathVariable("table") String table,
                                                      @PathVariable("since") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Calendar calendar) {
        ResponseEntity<Set<Long>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Set<Long> modified = modificationLogService.findModified(table, calendar.getTime());
        if (modified != null && !modified.isEmpty()) {
            responseEntity = new ResponseEntity<>(modified, HttpStatus.OK);
        }
        return responseEntity;
    }
}
