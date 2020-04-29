package cgd.hj.online;

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
import cgd.hj.structures.messages.Bhjm1460 ;
import cgd.hj.structures.messages.Bhjm1461 ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Phjs625a extends CgdExternalOnline<Phjs625a.EnvelopeIn, Phjs625a.EnvelopeOut> {
    
    /**
     * Service Messages
     */
    @Data
    /**
     * @return instancia da mensagem Bhjm1460
     */
    public abstract Bhjm1460 msgIn() ;
    @Data
    /**
     * @return instancia da mensagem Bhjm1461
     */
    public abstract Bhjm1461 msgOut() ;
    
    /**
     * Service Envelope
     */
    public interface MessageIn extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bhjm1460.Msg msgIn() ;
        }
    }
    public interface MessageOut extends CgdMessageV1 {
        @Data
        Mensagem mensagem() ;
        
        public interface Mensagem extends CgdMessageV1.Mensagem {
            @Data
            Bhjm1461.Msg msgOut() ;
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
