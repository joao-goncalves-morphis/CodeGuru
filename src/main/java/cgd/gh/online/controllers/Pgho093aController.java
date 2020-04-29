package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho093a ;

@RestController
public class Pgho093aController extends CgdBaseController {
    @PostMapping(path = "/pgho093a")
    
    /**
     * 
     * 
     * @param Pgho093a.EnvelopeIn envelope
     */
    public Pgho093a.EnvelopeOut callPgho093a(@RequestBody Pgho093a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
