package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs181a ;

@RestController
public class Pghs181aController extends CgdBaseController {
    @PostMapping(path = "/pghs181a")
    
    /**
     * 
     * 
     * @param Pghs181a.EnvelopeIn envelope
     */
    public Pghs181a.EnvelopeOut callPghs181a(@RequestBody Pghs181a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
