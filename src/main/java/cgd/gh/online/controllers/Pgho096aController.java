package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho096a ;

@RestController
public class Pgho096aController extends CgdBaseController {
    @PostMapping(path = "/pgho096a")
    
    /**
     * 
     * 
     * @param Pgho096a.EnvelopeIn envelope
     */
    public Pgho096a.EnvelopeOut callPgho096a(@RequestBody Pgho096a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
