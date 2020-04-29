package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs163a ;

@RestController
public class Pghs163aController extends CgdBaseController {
    @PostMapping(path = "/pghs163a")
    
    /**
     * 
     * 
     * @param Pghs163a.EnvelopeIn envelope
     */
    public Pghs163a.EnvelopeOut callPghs163a(@RequestBody Pghs163a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
