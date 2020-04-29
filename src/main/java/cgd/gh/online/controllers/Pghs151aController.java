package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs151a ;

@RestController
public class Pghs151aController extends CgdBaseController {
    @PostMapping(path = "/pghs151a")
    
    /**
     * 
     * 
     * @param Pghs151a.EnvelopeIn envelope
     */
    public Pghs151a.EnvelopeOut callPghs151a(@RequestBody Pghs151a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
