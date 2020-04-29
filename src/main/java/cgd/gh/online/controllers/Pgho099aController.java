package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho099a ;

@RestController
public class Pgho099aController extends CgdBaseController {
    @PostMapping(path = "/pgho099a")
    
    /**
     * 
     * 
     * @param Pgho099a.EnvelopeIn envelope
     */
    public Pgho099a.EnvelopeOut callPgho099a(@RequestBody Pgho099a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
