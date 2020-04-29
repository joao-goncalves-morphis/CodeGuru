package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho090a ;

@RestController
public class Pgho090aController extends CgdBaseController {
    @PostMapping(path = "/pgho090a")
    
    /**
     * 
     * 
     * @param Pgho090a.EnvelopeIn envelope
     */
    public Pgho090a.EnvelopeOut callPgho090a(@RequestBody Pgho090a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
