package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho051a ;

@RestController
public class Pgho051aController extends CgdBaseController {
    @PostMapping(path = "/pgho051a")
    
    /**
     * 
     * 
     * @param Pgho051a.EnvelopeIn envelope
     */
    public Pgho051a.EnvelopeOut callPgho051a(@RequestBody Pgho051a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
