package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho100a ;

@RestController
public class Pgho100aController extends CgdBaseController {
    @PostMapping(path = "/pgho100a")
    
    /**
     * 
     * 
     * @param Pgho100a.EnvelopeIn envelope
     */
    public Pgho100a.EnvelopeOut callPgho100a(@RequestBody Pgho100a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
