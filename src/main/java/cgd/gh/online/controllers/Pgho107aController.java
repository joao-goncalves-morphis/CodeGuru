package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho107a ;

@RestController
public class Pgho107aController extends CgdBaseController {
    @PostMapping(path = "/pgho107a")
    
    /**
     * 
     * 
     * @param Pgho107a.EnvelopeIn envelope
     */
    public Pgho107a.EnvelopeOut callPgho107a(@RequestBody Pgho107a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
