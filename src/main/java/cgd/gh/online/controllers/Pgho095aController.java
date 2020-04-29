package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho095a ;

@RestController
public class Pgho095aController extends CgdBaseController {
    @PostMapping(path = "/pgho095a")
    
    /**
     * 
     * 
     * @param Pgho095a.EnvelopeIn envelope
     */
    public Pgho095a.EnvelopeOut callPgho095a(@RequestBody Pgho095a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
