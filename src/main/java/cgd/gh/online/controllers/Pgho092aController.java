package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho092a ;

@RestController
public class Pgho092aController extends CgdBaseController {
    @PostMapping(path = "/pgho092a")
    
    /**
     * 
     * 
     * @param Pgho092a.EnvelopeIn envelope
     */
    public Pgho092a.EnvelopeOut callPgho092a(@RequestBody Pgho092a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
