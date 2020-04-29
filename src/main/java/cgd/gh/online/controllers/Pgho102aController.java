package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho102a ;

@RestController
public class Pgho102aController extends CgdBaseController {
    @PostMapping(path = "/pgho102a")
    
    /**
     * 
     * 
     * @param Pgho102a.EnvelopeIn envelope
     */
    public Pgho102a.EnvelopeOut callPgho102a(@RequestBody Pgho102a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
