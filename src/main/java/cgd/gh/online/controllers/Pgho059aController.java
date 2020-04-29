package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho059a ;

@RestController
public class Pgho059aController extends CgdBaseController {
    @PostMapping(path = "/pgho059a")
    
    /**
     * 
     * 
     * @param Pgho059a.EnvelopeIn envelope
     */
    public Pgho059a.EnvelopeOut callPgho059a(@RequestBody Pgho059a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
