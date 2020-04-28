package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs193a ;

@RestController
public class Pghs193aController extends CgdBaseController {
    @PostMapping(path = "/pghs193a")
    
    /**
     * 
     * 
     * @param Pghs193a.EnvelopeIn envelope
     */
    public Pghs193a.EnvelopeOut callPghs193a(@RequestBody Pghs193a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
