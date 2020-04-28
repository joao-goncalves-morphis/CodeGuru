package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho094a ;

@RestController
public class Pgho094aController extends CgdBaseController {
    @PostMapping(path = "/pgho094a")
    
    /**
     * 
     * 
     * @param Pgho094a.EnvelopeIn envelope
     */
    public Pgho094a.EnvelopeOut callPgho094a(@RequestBody Pgho094a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
