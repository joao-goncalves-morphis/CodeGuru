package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs121a ;

@RestController
public class Pghs121aController extends CgdBaseController {
    @PostMapping(path = "/pghs121a")
    
    /**
     * 
     * 
     * @param Pghs121a.EnvelopeIn envelope
     */
    public Pghs121a.EnvelopeOut callPghs121a(@RequestBody Pghs121a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
