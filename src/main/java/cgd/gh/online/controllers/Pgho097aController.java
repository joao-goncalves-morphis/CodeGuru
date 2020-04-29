package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho097a ;

@RestController
public class Pgho097aController extends CgdBaseController {
    @PostMapping(path = "/pgho097a")
    
    /**
     * 
     * 
     * @param Pgho097a.EnvelopeIn envelope
     */
    public Pgho097a.EnvelopeOut callPgho097a(@RequestBody Pgho097a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
