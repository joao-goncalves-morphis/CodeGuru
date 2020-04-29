package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho057a ;

@RestController
public class Pgho057aController extends CgdBaseController {
    @PostMapping(path = "/pgho057a")
    
    /**
     * 
     * 
     * @param Pgho057a.EnvelopeIn envelope
     */
    public Pgho057a.EnvelopeOut callPgho057a(@RequestBody Pgho057a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
