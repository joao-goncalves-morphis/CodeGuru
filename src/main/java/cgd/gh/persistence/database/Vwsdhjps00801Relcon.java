package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.persistence.relational.annotations.Key ;
import morphis.framework.persistence.relational.annotations.Column ;
import morphis.framework.persistence.relational.BaseTableHandler ;
import morphis.framework.persistence.relational.BaseCursorHandler ;
import morphis.framework.exceptions.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdhjps00801Relcon extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Relcon
     */
    @Data
    public abstract Relcon relcon() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VHJ00801_RELCON
     * 
     * @version 2.0
     * 
     */
    public interface Relcon extends IDataStruct {
        
        /**
         * N_CLIENTE
         */
        @Column(name="N_CLIENTE")
        @Data(size=10, signed=true, compression=COMP3)
        ILong nCliente() ;
        
        /**
         * NS_ABRA_CLI
         */
        @Column(name="NS_ABRA_CLI")
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsAbraCli() ;
        
        /**
         * I_TIPO_ITVT
         */
        @Column(name="I_TIPO_ITVT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt iTipoItvt() ;
        
        /**
         * NS_TITC
         */
        @Column(name="NS_TITC")
        @Data(size=3, signed=true, compression=COMP3)
        IInt nsTitc() ;
        
        /**
         * C_PAIS_ISOA_CONT
         */
        @Column(name="C_PAIS_ISOA_CONT")
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        /**
         * C_BANC_CONT
         */
        @Column(name="C_BANC_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        /**
         * C_OE_EGC_CONT
         */
        @Column(name="C_OE_EGC_CONT")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        /**
         * NS_RDCL_CONT
         */
        @Column(name="NS_RDCL_CONT")
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        /**
         * V_CHKD_CONT
         */
        @Column(name="V_CHKD_CONT")
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        /**
         * C_TIPO_CONT
         */
        @Column(name="C_TIPO_CONT")
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        /**
         * Z_INIC_REL
         */
        @Column(name="Z_INIC_REL", type=java.sql.Date.class)
        @Data(size=10)
        IString zInicRel() ;
        
        /**
         * Z_INIC_CTTO
         */
        @Column(name="Z_INIC_CTTO", type=java.sql.Date.class)
        @Data(size=10)
        IString zInicCtto() ;
        
        /**
         * Z_FIM_REL
         */
        @Column(name="Z_FIM_REL", type=java.sql.Date.class)
        @Data(size=10)
        IString zFimRel() ;
        
        /**
         * C_TIPO_TRTT_CONT
         */
        @Column(name="C_TIPO_TRTT_CONT")
        @Data(size=2)
        IString cTipoTrttCont() ;
        
        /**
         * C_FAMI_PROD
         */
        @Column(name="C_FAMI_PROD")
        @Data(size=3)
        IString cFamiProd() ;
        
        /**
         * C_PRODUTO
         */
        @Column(name="C_PRODUTO")
        @Data(size=3)
        IString cProduto() ;
        
        /**
         * N_CONTRATO
         */
        @Column(name="N_CONTRATO")
        @Data(size=23)
        IString nContrato() ;
        
        /**
         * C_EST_ITVZ
         */
        @Column(name="C_EST_ITVZ")
        @Data(size=1)
        IString cEstItvz() ;
        
        /**
         * X_LCLZ_FICH_ASST
         */
        @Column(name="X_LCLZ_FICH_ASST")
        @Data(size=15)
        IString xLclzFichAsst() ;
        
        /**
         * I_SIT_CTTO
         */
        @Column(name="I_SIT_CTTO")
        @Data(size=1)
        IString iSitCtto() ;
        
        /**
         * C_USID_ACTZ_ULT
         */
        @Column(name="C_USID_ACTZ_ULT")
        @Data(size=8)
        IString cUsidActzUlt() ;
        
        /**
         * TS_ACTZ_ULT
         */
        @Column(name="TS_ACTZ_ULT", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsActzUlt() ;
        
    }
    
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_THJ08_12
     * called from Pghq998a.M2160FechaCrsThj0812M2160FechaCrsThj0812
     * 
     */
    public void closePghq998a1290() {
        BaseCursorHandler c = getCursor("CRS_THJ08_12") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor CRS_THJ08
     * called from Pghq998a.M2440FechaCrsThj08M2440FechaCrsThj08
     * 
     */
    public void closePghq998a1719() {
        BaseCursorHandler c = getCursor("CRS_THJ08") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_THJ08_12
     * called from Pghq998a.M2120FetchCrsThj0812M2120FetchCrsThj0812
     * 
     * @param pZInicio
     */
    public void fetchPghq998a1215(IString pZInicio) {
        BaseCursorHandler c = getCursor("CRS_THJ08_12") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            relcon().nCliente().set(c.getValue("N_CLIENTE")) ;
            pZInicio.set(c.getValue("Z_INICIO", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor CRS_THJ08
     * called from Pghq998a.M2420FetchCrsThj08M2420FetchCrsThj08
     * 
     */
    public void fetchPghq998a1622() {
        BaseCursorHandler c = getCursor("CRS_THJ08") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            relcon().cPaisIsoaCont().set(c.getValue("C_PAIS_ISOA_CONT")) ;
            relcon().cBancCont().set(c.getValue("C_BANC_CONT")) ;
            relcon().cOeEgcCont().set(c.getValue("C_OE_EGC_CONT")) ;
            relcon().nsRdclCont().set(c.getValue("NS_RDCL_CONT")) ;
            relcon().vChkdCont().set(c.getValue("V_CHKD_CONT")) ;
            relcon().cTipoCont().set(c.getValue("C_TIPO_CONT")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_THJ08_12
     * called from Pghq998a.M2100AbreCrsThj0812M2100AbreCrsThj0812
     * 
     * @param pConTitular
     * @param pBhjk0002BloqueioObito
     * @param pConSeis
     */
    public void openPghq998a1175(int pConTitular, String pBhjk0002BloqueioObito, String pConSeis) {
        sqlSttmt = "SELECT  " +
                "A.N_CLIENTE," +
                "B.Z_INICIO" +
            " FROM VWSDHJPS00801_RELCON AS A, VWSDHJPS01201_BLOQUEIOS AS B" +
            " WHERE " +
                "A.N_CLIENTE = B.N_CLIENTE AND " +
                "A.C_PAIS_ISOA_CONT = :cPaisIsoaCont AND " +
                "A.C_BANC_CONT = :cBancCont AND " +
                "A.C_OE_EGC_CONT = :cOeEgcCont AND " +
                "A.NS_RDCL_CONT = :nsRdclCont AND " +
                "A.V_CHKD_CONT = :vChkdCont AND " +
                "A.C_TIPO_CONT = :cTipoCont AND " +
                "A.I_TIPO_ITVT = :conTitular AND " +
                "(B.C_TIPO_BLQO_CLI = :bloqueioObito OR " +
                "B.C_TIPO_BLQO_CLI = :conSeis)" ;
        BaseCursorHandler c = addCursor("CRS_THJ08_12", sqlSttmt) ;
        c.setArgument( "cPaisIsoaCont", relcon().cPaisIsoaCont() ) ;
        c.setArgument( "cBancCont", relcon().cBancCont() ) ;
        c.setArgument( "cOeEgcCont", relcon().cOeEgcCont() ) ;
        c.setArgument( "nsRdclCont", relcon().nsRdclCont() ) ;
        c.setArgument( "vChkdCont", relcon().vChkdCont() ) ;
        c.setArgument( "cTipoCont", relcon().cTipoCont() ) ;
        c.setArgument( "conTitular", pConTitular ) ;
        c.setArgument( "bloqueioObito", pBhjk0002BloqueioObito ) ;
        c.setArgument( "conSeis", pConSeis ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor CRS_THJ08
     * called from Pghq998a.M2410AbreCrsThj08M2410AbreCrsThj08
     * 
     * @param pWsDataSaldo
     * @param pConTitular
     */
    public void openPghq998a1582(IString pWsDataSaldo, int pConTitular) {
        sqlSttmt = "SELECT  " +
                "C_PAIS_ISOA_CONT," +
                "C_BANC_CONT," +
                "C_OE_EGC_CONT," +
                "NS_RDCL_CONT," +
                "V_CHKD_CONT," +
                "C_TIPO_CONT" +
            " FROM VWSDHJPS00801_RELCON" +
            " WHERE " +
                "N_CLIENTE = :nCliente AND Z_INIC_REL <= :wsDataSaldo AND " +
                "Z_FIM_REL >= :wsDataSaldo AND " +
                "I_TIPO_ITVT = :conTitular" ;
        BaseCursorHandler c = addCursor("CRS_THJ08", sqlSttmt) ;
        c.setArgument( "nCliente", relcon().nCliente() ) ;
        c.setArgument( "wsDataSaldo", pWsDataSaldo, java.sql.Date.class ) ;
        c.setArgument( "conTitular", pConTitular ) ;
        c.open() ;
    }
}
