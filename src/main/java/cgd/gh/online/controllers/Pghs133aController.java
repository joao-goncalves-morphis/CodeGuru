package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs133a ;

@RestController
public class Pghs133aController extends CgdBaseController {
    @PostMapping(path = "/pghs133a")
    
    /**
     * 
     * 
     * @param Pghs133a.EnvelopeIn envelope
     */
    public Pghs133a.EnvelopeOut callPghs133a(@RequestBody Pghs133a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
