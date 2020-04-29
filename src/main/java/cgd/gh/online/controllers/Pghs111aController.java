package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs111a ;

@RestController
public class Pghs111aController extends CgdBaseController {
    @PostMapping(path = "/pghs111a")
    
    /**
     * 
     * 
     * @param Pghs111a.EnvelopeIn envelope
     */
    public Pghs111a.EnvelopeOut callPghs111a(@RequestBody Pghs111a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
