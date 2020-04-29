package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho098a ;

@RestController
public class Pgho098aController extends CgdBaseController {
    @PostMapping(path = "/pgho098a")
    
    /**
     * 
     * 
     * @param Pgho098a.EnvelopeIn envelope
     */
    public Pgho098a.EnvelopeOut callPgho098a(@RequestBody Pgho098a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
