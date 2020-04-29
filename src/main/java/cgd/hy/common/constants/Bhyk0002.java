package cgd.hy.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhyk0002 extends IDataStruct {
    
    @Data(size=2, value="HY")
    IString aplicSistemas() ;
    
    @Data(size=15, signed=true, value="20000")
    ILong nrCommitsDflt() ;
    
    /**
     * @return instancia da classe local Alfanumeric
     */
    @Data
    Alfanumeric alfanumeric() ;
    
    /**
     * @return instancia da classe local Tabelas
     */
    @Data
    Tabelas tabelas() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * NOMES DE ROTINAS
     * 
     * @version 2.0
     * 
     */
    public interface Alfanumeric extends IDataStruct {
        
        @Data(size=8, value="MHYJ230A")
        IString rotDatas() ;
        
        @Data(size=8, value="MHYJ300A")
        IString rotSeqfich() ;
        
        @Data(size=8, value="MHYJ301A")
        IString rotSeqfich2() ;
        
        @Data(size=8, value="MHYJ100A")
        IString rotActTabAct() ;
        
        @Data(size=8, value="MHYJ600A")
        IString rotValDtExep() ;
        
        @Data(size=8, value="MHYQ200A")
        IString rotProcesso() ;
        
        @Data(size=8, value="MHYQ700A")
        IString rotConsIdiMap() ;
        
        @Data(size=8, value="MHYQ400A")
        IString rotTeledisco() ;
        
        @Data(size=8, value="MHYQ500A")
        IString rotCommitsProc() ;
        
        @Data(size=8, value="MHYS110A")
        IString rotActIndRest() ;
        
        @Data(size=8, value="MHYS005A")
        IString rotValMsgErro() ;
        
        @Data(size=8, value="MHYS007A")
        IString vldMontante() ;
        
        @Data(size=8, value="MHYS002A")
        IString validOpcMenu() ;
        
    }
    
    /**
     * 
     * NOMES DE TABELAS
     * 
     * @version 2.0
     * 
     */
    public interface Tabelas extends IDataStruct {
        
        @Data(size=8, value="VHY00101")
        IString conVhy00101() ;
        
        @Data(size=8, value="VHY00201")
        IString conVhy00201() ;
        
        @Data(size=8, value="VHY00301")
        IString conVhy00301() ;
        
        @Data(size=8, value="VHY00401")
        IString conVhy00401() ;
        
        @Data(size=8, value="VHY00501")
        IString conVhy00501() ;
        
        @Data(size=8, value="VHY00601")
        IString conVhy00601() ;
        
        @Data(size=8, value="VHY00701")
        IString conVhy00701() ;
        
        @Data(size=8, value="VHY00801")
        IString conVhy00801() ;
        
        @Data(size=8, value="VHY00901")
        IString conVhy00901() ;
        
        @Data(size=8, value="VHY01001")
        IString conVhy01001() ;
        
        @Data(size=8, value="VHY01101")
        IString conVhy01101() ;
        
        @Data(size=8, value="VHY01201")
        IString conVhy01201() ;
        
        @Data(size=8, value="VHY01301")
        IString conVhy01301() ;
        
        @Data(size=8, value="VHY01401")
        IString conVhy01401() ;
        
        @Data(size=8, value="VHY01501")
        IString conVhy01501() ;
        
        @Data(size=8, value="VHY01601")
        IString conVhy01601() ;
        
        @Data(size=8, value="VHY01701")
        IString conVhy01701() ;
        
        @Data(size=8, value="VHY01801")
        IString conVhy01801() ;
        
        @Data(size=8, value="VHY01901")
        IString conVhy01901() ;
        
        @Data(size=8, value="VHY21101")
        IString conVhy21101() ;
        
        @Data(size=8, value="VHY21201")
        IString conVhy21201() ;
        
        @Data(size=8, value="VHY21301")
        IString conVhy21301() ;
        
        @Data(size=8, value="VHY21401")
        IString conVhy21401() ;
        
        @Data(size=8, value="VHY22101")
        IString conVhy22101() ;
        
        @Data(size=8, value="VHY27101")
        IString conVhy27101() ;
        
        @Data(size=8, value="VHY27201")
        IString conVhy27201() ;
        
    }
    
}
