package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho108a ;

@RestController
public class Pgho108aController extends CgdBaseController {
    @PostMapping(path = "/pgho108a")
    
    /**
     * 
     * 
     * @param Pgho108a.EnvelopeIn envelope
     */
    public Pgho108a.EnvelopeOut callPgho108a(@RequestBody Pgho108a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
