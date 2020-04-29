package cgd.gh.online.controllers;

import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import cgd.framework.CgdBaseController;
import cgd.gh.online.Pgho105a ;

@RestController
public class Pgho105aController extends CgdBaseController {
    @PostMapping(path = "/pgho105a")
    
    /**
     * 
     * 
     * @param Pgho105a.EnvelopeIn envelope
     */
    public Pgho105a.EnvelopeOut callPgho105a(@RequestBody Pgho105a.EnvelopeIn envelope) {
        return super.call(envelope);
    }
}
