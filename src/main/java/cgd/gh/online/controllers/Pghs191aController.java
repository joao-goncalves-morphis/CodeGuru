package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs191a ;

@RestController
public class Pghs191aController extends CgdBaseController {
    @PostMapping(path = "/pghs191a")
    
    /**
     * 
     * 
     * @param Pghs191a.EnvelopeIn envelope
     */
    public Pghs191a.EnvelopeOut callPghs191a(@RequestBody Pghs191a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
