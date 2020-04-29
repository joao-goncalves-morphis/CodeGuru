package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho054a ;

@RestController
public class Pgho054aController extends CgdBaseController {
    @PostMapping(path = "/pgho054a")
    
    /**
     * 
     * 
     * @param Pgho054a.EnvelopeIn envelope
     */
    public Pgho054a.EnvelopeOut callPgho054a(@RequestBody Pgho054a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
