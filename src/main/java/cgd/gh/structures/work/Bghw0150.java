package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import morphis.framework.datatypes.arrays.IArray ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghw0150 extends IDataStruct {
    
    /**
     * @return instancia da classe local TabelaBaldHstAct
     */
    @Data
    TabelaBaldHstAct tabelaBaldHstAct() ;
    
    /**
     * @return instancia da classe local TbBaldHstAct
     */
    @Data
    @Mask
    TbBaldHstAct tbBaldHstAct() ;
    
    /**
     * @return instancia da classe local TabelaBaldHstNorm
     */
    @Data
    TabelaBaldHstNorm tabelaBaldHstNorm() ;
    
    /**
     * @return instancia da classe local TbBaldHstNorm
     */
    @Data
    @Mask
    TbBaldHstNorm tbBaldHstNorm() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * CONTROLO DO BALDEAMENTO DOS HISTORICOS
     * ESTES RECURSOS SAO PASSADOS TODOS OS ANOS NO DIA 15-01
     * *--> EM 2011
     * O ANO 2008 PASSA DA TABELA VGH00201 PARA VGH02801
     * *--> EM 2012
     * O ANO 2009 PASSA DA TABELA VGH00201 PARA VGH02701
     * 
     * @version 2.0
     * 
     */
    public interface TabelaBaldHstAct extends IDataStruct {
        
        @Data(size=13, value="2004-VGH02601")
        IString filler001() ;
        
        @Data(size=13, value="2005-VGH02501")
        IString filler002() ;
        
        @Data(size=13, value="2006-VGH02401")
        IString filler003() ;
        
        @Data(size=13, value="2007-VGH02301")
        IString filler004() ;
        
        @Data(size=13, value="2008-VGH02801")
        IString filler005() ;
        
        @Data(size=13, value="2009-VGH02701")
        IString filler006() ;
        
        @Data(size=13, value="2010-VGH02601")
        IString filler007() ;
        
        @Data(size=13, value="2011-VGH02501")
        IString filler008() ;
        
        @Data(size=13, value="2012-VGH02401")
        IString filler009() ;
        
        @Data(size=13, value="2013-VGH02301")
        IString filler010() ;
        
        @Data(size=13, value="2014-VGH02801")
        IString filler011() ;
        
        @Data(size=13, value="2015-VGH02701")
        IString filler012() ;
        
        @Data(size=13, value="2016-VGH02601")
        IString filler013() ;
        
        @Data(size=13, value="2017-VGH02501")
        IString filler014() ;
        
        @Data(size=13, value="2018-VGH02401")
        IString filler015() ;
        
        @Data(size=13, value="2019-VGH02301")
        IString filler016() ;
        
        @Data(size=13, value="2020-VGH02801")
        IString filler017() ;
        
        @Data(size=13, value="2021-VGH02701")
        IString filler018() ;
        
        @Data(size=13, value="2022-VGH02601")
        IString filler019() ;
        
        @Data(size=13, value="2023-VGH02501")
        IString filler020() ;
        
        @Data(size=13, value="2024-VGH02401")
        IString filler021() ;
        
        @Data(size=13, value="2025-VGH02301")
        IString filler022() ;
        
        @Data(size=13, value="2026-VGH02801")
        IString filler023() ;
        
        @Data(size=13, value="2027-VGH02701")
        IString filler024() ;
        
        @Data(size=13, value="2028-VGH02601")
        IString filler025() ;
        
        @Data(size=13, value="2029-VGH02501")
        IString filler026() ;
        
        @Data(size=13, value="2030-VGH02401")
        IString filler027() ;
        
        @Data(size=13, value="2031-VGH02301")
        IString filler028() ;
        
        @Data(size=13, value="2032-VGH02801")
        IString filler029() ;
        
        @Data(size=13, value="2033-VGH02701")
        IString filler030() ;
        
        @Data(size=13, value="2034-VGH02601")
        IString filler031() ;
        
        @Data(size=13, value="2035-VGH02501")
        IString filler032() ;
        
        @Data(size=13, value="2036-VGH02401")
        IString filler033() ;
        
        @Data(size=13, value="2037-VGH02301")
        IString filler034() ;
        
    }
    public interface TbBaldHstAct extends IDataMask {
        
        /**
         * @return instancia da classe local ItemHstA
         */
        @Data(length=30)
        IArray<ItemHstA> itemHstA() ;
        
        
        public interface ItemHstA extends IDataMask {
            
            
            @Data(size=4)
            IInt tabZaAnoAct() ;
            
            @Data(size=8, lpadding=1)
            IString tabNmRecursoAct() ;
            
        }
    }
    
    /**
     * 
     * CONTROLO DO BALDEAMENTO DO HISTORICO-INACTIVO
     * *--> EM 2011
     * O ANO 2002 PASSA DA TABELA VGH02801 PARA A TAPE GHSA2002
     * *--> EM 2012
     * O ANO 2003 PASSA DA TABELA VGH02701 PARA A TAPE GHSA2003
     * 
     * @version 2.0
     * 
     */
    public interface TabelaBaldHstNorm extends IDataStruct {
        
        @Data(size=13, value="1990-GHSA1990")
        IString filler001() ;
        
        @Data(size=13, value="1991-GHSA1991")
        IString filler002() ;
        
        @Data(size=13, value="1992-GHSA1992")
        IString filler003() ;
        
        @Data(size=13, value="1993-GHSA1993")
        IString filler004() ;
        
        @Data(size=13, value="1994-GHSA1994")
        IString filler005() ;
        
        @Data(size=13, value="1995-GHSA1995")
        IString filler006() ;
        
        @Data(size=13, value="1996-GHSA1996")
        IString filler007() ;
        
        @Data(size=13, value="1997-GHSA1997")
        IString filler008() ;
        
        @Data(size=13, value="1998-GHSA1998")
        IString filler009() ;
        
        @Data(size=13, value="1999-GHSA1999")
        IString filler010() ;
        
        @Data(size=13, value="2000-GHSA2000")
        IString filler011() ;
        
        @Data(size=13, value="2001-GHSA2001")
        IString filler012() ;
        
        @Data(size=13, value="2002-GHSA2002")
        IString filler013() ;
        
        @Data(size=13, value="2003-GHSA2003")
        IString filler014() ;
        
        @Data(size=13, value="2004-GHSA2004")
        IString filler015() ;
        
        @Data(size=13, value="2005-GHSA2005")
        IString filler016() ;
        
        @Data(size=13, value="2006-GHSA2006")
        IString filler017() ;
        
        @Data(size=13, value="2007-GHSA2007")
        IString filler018() ;
        
        @Data(size=13, value="2008-GHSA2008")
        IString filler019() ;
        
        @Data(size=13, value="2009-GHSA2009")
        IString filler020() ;
        
        @Data(size=13, value="2010-GHSA2010")
        IString filler021() ;
        
        @Data(size=13, value="2011-GHSA2011")
        IString filler022() ;
        
        @Data(size=13, value="2012-GHSA2012")
        IString filler023() ;
        
        @Data(size=13, value="2013-GHSA2013")
        IString filler024() ;
        
        @Data(size=13, value="2014-GHSA2014")
        IString filler025() ;
        
        @Data(size=13, value="2015-GHSA2015")
        IString filler026() ;
        
        @Data(size=13, value="2016-GHSA2016")
        IString filler027() ;
        
        @Data(size=13, value="2017-GHSA2017")
        IString filler028() ;
        
        @Data(size=13, value="2018-GHSA2018")
        IString filler029() ;
        
        @Data(size=13, value="2019-GHSA2019")
        IString filler030() ;
        
        @Data(size=13, value="2020-GHSA2020")
        IString filler031() ;
        
        @Data(size=13, value="2021-GHSA2021")
        IString filler032() ;
        
        @Data(size=13, value="2022-GHSA2022")
        IString filler033() ;
        
        @Data(size=13, value="2023-GHSA2023")
        IString filler034() ;
        
        @Data(size=13, value="2024-GHSA2024")
        IString filler035() ;
        
        @Data(size=13, value="2025-GHSA2025")
        IString filler036() ;
        
        @Data(size=13, value="2026-GHSA2026")
        IString filler037() ;
        
        @Data(size=13, value="2027-GHSA2027")
        IString filler038() ;
        
        @Data(size=13, value="2028-GHSA2028")
        IString filler039() ;
        
        @Data(size=13, value="2029-GHSA2029")
        IString filler040() ;
        
        @Data(size=13, value="2030-GHSA2030")
        IString filler041() ;
        
        @Data(size=13, value="2031-GHSA2031")
        IString filler042() ;
        
    }
    public interface TbBaldHstNorm extends IDataMask {
        
        /**
         * 05  ITEM-HST-B OCCURS 30 TIMES
         * @return instancia da classe local ItemHstB
         */
        @Data(length=42)
        IArray<ItemHstB> itemHstB() ;
        
        
        
        /**
         * 
         * 05  ITEM-HST-B OCCURS 30 TIMES
         * 
         * @version 2.0
         * 
         */
        public interface ItemHstB extends IDataMask {
            
            
            @Data(size=4)
            IInt tabZaAnoNorm() ;
            
            @Data(size=8, lpadding=1)
            IString tabNmRecursoNorm() ;
            
        }
    }
    
}
