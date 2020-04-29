package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghw0300 extends IDataStruct {
    
    @Data(size=8)
    IString wsNmPrograma() ;
    
    /**
     * @return instancia da classe local WsVariaveisHora
     */
    @Data
    WsVariaveisHora wsVariaveisHora() ;
    
    /**
     * Inner Classes
     */
    public interface WsVariaveisHora extends IDataStruct {
        
        @Data(size=8)
        ILong horaInicio() ;
        
        /**
         * @return instancia da classe local HoraInicioR
         */
        @Data
        @Mask
        HoraInicioR horaInicioR() ;
        
        @Data(size=8)
        ILong horaFim() ;
        
        /**
         * @return instancia da classe local HoraFimR
         */
        @Data
        @Mask
        HoraFimR horaFimR() ;
        
        @Data(size=8)
        ILong tempoExecucao() ;
        
        /**
         * @return instancia da classe local TempoExecucaoR
         */
        @Data
        @Mask
        TempoExecucaoR tempoExecucaoR() ;
        
        @Data(size=4, signed=true)
        IInt hhFimW() ;
        
        @Data(size=4, signed=true)
        IInt mmFimW() ;
        
        @Data(size=4, signed=true)
        IInt ssFimW() ;
        
        @Data(size=4, signed=true)
        IInt ccFimW() ;
        
        @Data(size=4, signed=true)
        IInt hhDifW() ;
        
        @Data(size=4, signed=true)
        IInt mmDifW() ;
        
        @Data(size=4, signed=true)
        IInt ssDifW() ;
        
        @Data(size=4, signed=true)
        IInt ccDifW() ;
        
        
        public interface HoraInicioR extends IDataMask {
            
            /**
             * @return instancia da classe local HoraMapa
             */
            @Data
            HoraMapa horaMapa() ;
            
            @Data(size=6)
            @Mask
            IInt horaMapaR() ;
            
            @Data(size=2)
            IInt ccInicio() ;
            
            
            public interface HoraMapa extends IDataMask {
                
                @Data(size=2)
                IInt hhInicio() ;
                
                @Data(size=2)
                IInt mmInicio() ;
                
                @Data(size=2)
                IInt ssInicio() ;
                
            }
        }
        
        public interface HoraFimR extends IDataMask {
            
            @Data(size=2)
            IInt hhFim() ;
            
            @Data(size=2)
            IInt mmFim() ;
            
            @Data(size=2)
            IInt ssFim() ;
            
            @Data(size=2)
            IInt ccFim() ;
            
        }
        
        public interface TempoExecucaoR extends IDataMask {
            
            @Data(size=2)
            IInt hhDif() ;
            
            @Data(size=2)
            IInt mmDif() ;
            
            @Data(size=2)
            IInt ssDif() ;
            
            @Data(size=2)
            IInt ccDif() ;
            
        }
    }
    
}
