package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho058a ;

@RestController
public class Pgho058aController extends CgdBaseController {
    @PostMapping(path = "/pgho058a")
    
    /**
     * 
     * 
     * @param Pgho058a.EnvelopeIn envelope
     */
    public Pgho058a.EnvelopeOut callPgho058a(@RequestBody Pgho058a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
