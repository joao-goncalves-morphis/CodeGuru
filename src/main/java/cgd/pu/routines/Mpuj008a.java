package cgd.pu.routines;

import cgd.framework.CgdExternalRoutine ;
import morphis.framework.datatypes.annotations.Data ;
import cgd.pu.structures.link.Bpul008a ;


/**
 * 
 * migrated from [GH]
 * 
 * @version 2.0
 * 
 */
public abstract class Mpuj008a extends CgdExternalRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bpul008a
     */
    @Data
    public abstract Bpul008a bpul008a() ;
    
    
}
