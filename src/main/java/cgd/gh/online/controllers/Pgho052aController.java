package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho052a ;

@RestController
public class Pgho052aController extends CgdBaseController {
    @PostMapping(path = "/pgho052a")
    
    /**
     * 
     * 
     * @param Pgho052a.EnvelopeIn envelope
     */
    public Pgho052a.EnvelopeOut callPgho052a(@RequestBody Pgho052a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
