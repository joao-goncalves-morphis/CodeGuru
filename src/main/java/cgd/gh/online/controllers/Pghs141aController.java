package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pghs141a ;

@RestController
public class Pghs141aController extends CgdBaseController {
    @PostMapping(path = "/pghs141a")
    
    /**
     * 
     * 
     * @param Pghs141a.EnvelopeIn envelope
     */
    public Pghs141a.EnvelopeOut callPghs141a(@RequestBody Pghs141a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
