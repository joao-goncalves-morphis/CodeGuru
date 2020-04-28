package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho091a ;

@RestController
public class Pgho091aController extends CgdBaseController {
    @PostMapping(path = "/pgho091a")
    
    /**
     * 
     * 
     * @param Pgho091a.EnvelopeIn envelope
     */
    public Pgho091a.EnvelopeOut callPgho091a(@RequestBody Pgho091a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
