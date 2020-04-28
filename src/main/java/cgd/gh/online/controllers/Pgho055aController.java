package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho055a ;

@RestController
public class Pgho055aController extends CgdBaseController {
    @PostMapping(path = "/pgho055a")
    
    /**
     * 
     * 
     * @param Pgho055a.EnvelopeIn envelope
     */
    public Pgho055a.EnvelopeOut callPgho055a(@RequestBody Pgho055a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
