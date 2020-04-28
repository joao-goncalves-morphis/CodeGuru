package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho053a ;

@RestController
public class Pgho053aController extends CgdBaseController {
    @PostMapping(path = "/pgho053a")
    
    /**
     * 
     * 
     * @param Pgho053a.EnvelopeIn envelope
     */
    public Pgho053a.EnvelopeOut callPgho053a(@RequestBody Pgho053a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
