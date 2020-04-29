package cgd.pp.routines;

import cgd.framework.CgdExternalRoutine ;
import morphis.framework.datatypes.annotations.Data ;
import cgd.pp.structures.link.Bppl500a ;


/**
 * 
 * migrated from [GH]
 * 
 * @version 2.0
 * 
 */
public abstract class Mppj500a extends CgdExternalRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bppl500a
     */
    @Data
    public abstract Bppl500a bppl500a() ;
    
    
}
