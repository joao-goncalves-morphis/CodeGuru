package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho104a ;

@RestController
public class Pgho104aController extends CgdBaseController {
    @PostMapping(path = "/pgho104a")
    
    /**
     * 
     * 
     * @param Pgho104a.EnvelopeIn envelope
     */
    public Pgho104a.EnvelopeOut callPgho104a(@RequestBody Pgho104a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
