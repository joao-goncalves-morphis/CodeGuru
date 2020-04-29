package cgd.pu.routines;

import cgd.framework.CgdExternalRoutine ;
import morphis.framework.datatypes.annotations.Data ;
import cgd.pu.structures.link.Bpul300a ;


/**
 * 
 * migrated from [GH]
 * 
 * @version 2.0
 * 
 */
public abstract class Mpuj300a extends CgdExternalRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bpul300a
     */
    @Data
    public abstract Bpul300a bpul300a() ;
    
    
}
