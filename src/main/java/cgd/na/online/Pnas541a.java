package cgd.na.online;

import cgd.framework.CgdExternalOnline ;
import morphis.framework.datatypes.annotations.Data ;
import cgd.gh.framework.CgdGhBaseOnline ;
import morphis.framework.exceptions.* ;
import morphis.framework.server.controller.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.framework.envelope.CgdEnvelope ;
import cgd.framework.envelope.CgdFooterV1 ;
import cgd.framework.envelope.CgdHeaderV1 ;
import cgd.framework.envelope.CgdMessageV1 ;
import cgd.na.structures.messages.Bnam0540 ;
import cgd.na.structures.messages.Bnam0541 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Pnas541a extends CgdExternalOnline<Pnas541a.EnvelopeIn, Pnas541a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bnam0540
     */
    public abstract Bnam0540 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bnam0541
     */
    public abstract Bnam0541 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bnam0540.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bnam0541.Msg msgOut() ;
        }
    }
    @Data
    public interface EnvelopeIn extends CgdHeaderV1, MessageIn, CgdFooterV1, CgdEnvelope {
    }
    @Data
    public interface EnvelopeOut extends CgdHeaderV1, MessageOut, CgdFooterV1, CgdEnvelope {
    }
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    
}
