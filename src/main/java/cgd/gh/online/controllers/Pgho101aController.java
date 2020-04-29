package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho101a ;

@RestController
public class Pgho101aController extends CgdBaseController {
    @PostMapping(path = "/pgho101a")
    
    /**
     * 
     * 
     * @param Pgho101a.EnvelopeIn envelope
     */
    public Pgho101a.EnvelopeOut callPgho101a(@RequestBody Pgho101a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
