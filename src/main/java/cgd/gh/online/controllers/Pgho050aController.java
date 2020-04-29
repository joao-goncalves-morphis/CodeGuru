package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho050a ;

@RestController
public class Pgho050aController extends CgdBaseController {
    @PostMapping(path = "/pgho050a")
    
    /**
     * 
     * 
     * @param Pgho050a.EnvelopeIn envelope
     */
    public Pgho050a.EnvelopeOut callPgho050a(@RequestBody Pgho050a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
