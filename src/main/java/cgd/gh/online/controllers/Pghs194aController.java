package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs194a ;

@RestController
public class Pghs194aController extends CgdBaseController {
    @PostMapping(path = "/pghs194a")
    
    /**
     * 
     * 
     * @param Pghs194a.EnvelopeIn envelope
     */
    public Pghs194a.EnvelopeOut callPghs194a(@RequestBody Pghs194a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
