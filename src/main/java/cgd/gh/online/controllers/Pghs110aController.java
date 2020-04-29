package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs110a ;

@RestController
public class Pghs110aController extends CgdBaseController {
    @PostMapping(path = "/pghs110a")
    
    /**
     * 
     * 
     * @param Pghs110a.EnvelopeIn envelope
     */
    public Pghs110a.EnvelopeOut callPghs110a(@RequestBody Pghs110a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
