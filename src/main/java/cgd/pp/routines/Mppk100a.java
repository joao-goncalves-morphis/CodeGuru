package cgd.pp.routines;

import cgd.framework.CgdExternalRoutine ;
import morphis.framework.datatypes.annotations.Data ;
import cgd.pp.structures.link.Bppl100a ;


/**
 * 
 * migrated from [GH]
 * 
 * @version 2.0
 * 
 */
public abstract class Mppk100a extends CgdExternalRoutine {
    
    /**
     * Service Parameters
     */
    /**
     * @return instancia da área de ligação Bppl100a
     */
    @Data
    public abstract Bppl100a bppl100a() ;
    
    
}
