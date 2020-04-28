package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho106a ;

@RestController
public class Pgho106aController extends CgdBaseController {
    @PostMapping(path = "/pgho106a")
    
    /**
     * 
     * 
     * @param Pgho106a.EnvelopeIn envelope
     */
    public Pgho106a.EnvelopeOut callPgho106a(@RequestBody Pgho106a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
