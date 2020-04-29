package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho056a ;

@RestController
public class Pgho056aController extends CgdBaseController {
    @PostMapping(path = "/pgho056a")
    
    /**
     * 
     * 
     * @param Pgho056a.EnvelopeIn envelope
     */
    public Pgho056a.EnvelopeOut callPgho056a(@RequestBody Pgho056a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
