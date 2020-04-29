package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho103a ;

@RestController
public class Pgho103aController extends CgdBaseController {
    @PostMapping(path = "/pgho103a")
    
    /**
     * 
     * 
     * @param Pgho103a.EnvelopeIn envelope
     */
    public Pgho103a.EnvelopeOut callPgho103a(@RequestBody Pgho103a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
