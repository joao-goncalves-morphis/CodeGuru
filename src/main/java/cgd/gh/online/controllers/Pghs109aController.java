package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs109a ;

@RestController
public class Pghs109aController extends CgdBaseController {
    @PostMapping(path = "/pghs109a")
    
    /**
     * 
     * 
     * @param Pghs109a.EnvelopeIn envelope
     */
    public Pghs109a.EnvelopeOut callPghs109a(@RequestBody Pghs109a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
