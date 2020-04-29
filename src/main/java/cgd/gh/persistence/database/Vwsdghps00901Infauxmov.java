package cgd.gh.persistence.database;

import morphis.framework.server.controller.PersistenceCode ;
import java.sql.SQLException ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
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
public abstract class Vwsdghps00901Infauxmov extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Infauxmov
     */
    @Data
    public abstract Infauxmov infauxmov() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE DGOWNDB.VGH00901_INFAUXMOV
     * 
     * @version 2.0
     * 
     */
    public interface Infauxmov extends IDataStruct {
        
        /**
         * C_PAIS_ISOA_CONT
         */
        @Column(name="C_PAIS_ISOA_CONT")
        @Key
        @Data(size=3)
        IString cPaisIsoaCont() ;
        
        /**
         * C_BANC_CONT
         */
        @Column(name="C_BANC_CONT")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancCont() ;
        
        /**
         * C_OE_EGC_CONT
         */
        @Column(name="C_OE_EGC_CONT")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcCont() ;
        
        /**
         * NS_RDCL_CONT
         */
        @Column(name="NS_RDCL_CONT")
        @Key
        @Data(size=7, signed=true, compression=COMP3)
        IInt nsRdclCont() ;
        
        /**
         * V_CHKD_CONT
         */
        @Column(name="V_CHKD_CONT")
        @Key
        @Data(size=1, signed=true, compression=COMP3)
        IInt vChkdCont() ;
        
        /**
         * C_TIPO_CONT
         */
        @Column(name="C_TIPO_CONT")
        @Key
        @Data(size=3, signed=true, compression=COMP3)
        IInt cTipoCont() ;
        
        /**
         * C_MOED_ISO_SCTA
         */
        @Column(name="C_MOED_ISO_SCTA")
        @Key
        @Data(size=3)
        IString cMoedIsoScta() ;
        
        /**
         * NS_DEPOSITO
         */
        @Column(name="NS_DEPOSITO")
        @Key
        @Data(size=4, signed=true, compression=COMP3)
        IInt nsDeposito() ;
        
        /**
         * TS_MOVIMENTO
         */
        @Column(name="TS_MOVIMENTO", type=java.sql.Timestamp.class)
        @Key
        @Data(size=26)
        IString tsMovimento() ;
        
        /**
         * NS_MOVIMENTO
         */
        @Column(name="NS_MOVIMENTO")
        @Key
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovimento() ;
        
        /**
         * I_TRNZ_EFCD_ONLN
         */
        @Column(name="I_TRNZ_EFCD_ONLN")
        @Data(size=1)
        IString iTrnzEfcdOnln() ;
        
        /**
         * I_EXI_ATZ_JOUR_BBN
         */
        @Column(name="I_EXI_ATZ_JOUR_BBN")
        @Data(size=1)
        IString iExiAtzJourBbn() ;
        
        /**
         * I_PENALIZACAO
         */
        @Column(name="I_PENALIZACAO")
        @Data(size=1)
        IString iPenalizacao() ;
        
        /**
         * C_PAIS_ISOA_GERX
         */
        @Column(name="C_PAIS_ISOA_GERX")
        @Data(size=3)
        IString cPaisIsoaGerx() ;
        
        /**
         * C_BANC_GCX_GERX
         */
        @Column(name="C_BANC_GCX_GERX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cBancGcxGerx() ;
        
        /**
         * C_OE_EGC_GERX
         */
        @Column(name="C_OE_EGC_GERX")
        @Data(size=4, signed=true, compression=COMP3)
        IInt cOeEgcGerx() ;
        
        /**
         * N_ATRZ_CAMB
         */
        @Column(name="N_ATRZ_CAMB")
        @Data(size=8, signed=true, compression=COMP3)
        ILong nAtrzCamb() ;
        
        /**
         * X_REF_MOV_ORIG
         */
        @Column(name="X_REF_MOV_ORIG")
        @Data(size=35)
        IString xRefMovOrig() ;
        
        /**
         * I_ESTORNO
         */
        @Column(name="I_ESTORNO")
        @Data(size=1)
        IString iEstorno() ;
        
        /**
         * NS_MOV_ETND
         */
        @Column(name="NS_MOV_ETND")
        @Data(size=15, signed=true, compression=COMP3)
        ILong nsMovEtnd() ;
        
        /**
         * M_MOV_CTRV_EURO
         */
        @Column(name="M_MOV_CTRV_EURO")
        @Data(size=17, decimal=2, signed=true, compression=COMP3)
        IDecimal mMovCtrvEuro() ;
        
        /**
         * T_CAMB_EURO
         */
        @Column(name="T_CAMB_EURO")
        @Data(size=11, decimal=6, signed=true, compression=COMP3)
        IDecimal tCambEuro() ;
        
        /**
         * C_TERMINAL
         */
        @Column(name="C_TERMINAL")
        @Data(size=4)
        IString cTerminal() ;
        
        /**
         * TS_ACTZ_ULT
         */
        @Column(name="TS_ACTZ_ULT", type=java.sql.Timestamp.class)
        @Data(size=26)
        IString tsActzUlt() ;
        
        /**
         * C_USID_ACTZ_ULT
         */
        @Column(name="C_USID_ACTZ_ULT")
        @Data(size=8)
        IString cUsidActzUlt() ;
        
    }
    
    /**
     * BatchQ1
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00901_INFAUXMOV
     * called from Pghq009a.A31000TratarInfauxmovA31000TratarInfauxmov
     * 
     */
    public void insertPghq009a599() {
        sqlSttmt = "INSERT INTO VWSDGHPS00901_INFAUXMOV ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"TS_MOVIMENTO, " +
        	"NS_MOVIMENTO, " +
        	"I_TRNZ_EFCD_ONLN, " +
        	"I_EXI_ATZ_JOUR_BBN, " +
        	"I_PENALIZACAO, " +
        	"C_PAIS_ISOA_GERX, " +
        	"C_BANC_GCX_GERX, " +
        	"C_OE_EGC_GERX, " +
        	"N_ATRZ_CAMB, " +
        	"X_REF_MOV_ORIG, " +
        	"I_ESTORNO, " +
        	"NS_MOV_ETND, " +
        	"M_MOV_CTRV_EURO, " +
        	"T_CAMB_EURO, " +
        	"C_TERMINAL, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":cPaisIsoaCont, " +
        	":cBancCont, " +
        	":cOeEgcCont, " +
        	":nsRdclCont, " +
        	":vChkdCont, " +
        	":cTipoCont, " +
        	":cMoedIsoScta, " +
        	":nsDeposito, " +
        	":tsMovimento, " +
        	":nsMovimento, " +
        	":iTrnzEfcdOnln, " +
        	":iExiAtzJourBbn, " +
        	":iPenalizacao, " +
        	":cPaisIsoaGerx, " +
        	":cBancGcxGerx, " +
        	":cOeEgcGerx, " +
        	":nAtrzCamb, " +
        	":xRefMovOrig, " +
        	":iEstorno, " +
        	":nsMovEtnd, " +
        	":mMovCtrvEuro, " +
        	":tCambEuro, " +
        	":cTerminal, " +
        	":tsActzUlt, " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infauxmov().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infauxmov().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infauxmov().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infauxmov().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infauxmov().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infauxmov().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infauxmov().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infauxmov().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infauxmov().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infauxmov().nsMovimento() ) ;
        setQueryArgument( "iTrnzEfcdOnln", infauxmov().iTrnzEfcdOnln() ) ;
        setQueryArgument( "iExiAtzJourBbn", infauxmov().iExiAtzJourBbn() ) ;
        setQueryArgument( "iPenalizacao", infauxmov().iPenalizacao() ) ;
        setQueryArgument( "cPaisIsoaGerx", infauxmov().cPaisIsoaGerx() ) ;
        setQueryArgument( "cBancGcxGerx", infauxmov().cBancGcxGerx() ) ;
        setQueryArgument( "cOeEgcGerx", infauxmov().cOeEgcGerx() ) ;
        setQueryArgument( "nAtrzCamb", infauxmov().nAtrzCamb() ) ;
        setQueryArgument( "xRefMovOrig", infauxmov().xRefMovOrig() ) ;
        setQueryArgument( "iEstorno", infauxmov().iEstorno() ) ;
        setQueryArgument( "nsMovEtnd", infauxmov().nsMovEtnd() ) ;
        setQueryArgument( "mMovCtrvEuro", infauxmov().mMovCtrvEuro() ) ;
        setQueryArgument( "tCambEuro", infauxmov().tCambEuro() ) ;
        setQueryArgument( "cTerminal", infauxmov().cTerminal() ) ;
        setQueryArgument( "tsActzUlt", infauxmov().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", infauxmov().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    /**
     * BatchQ3
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH00901_INFAUXMOV
     * called from Pghq901a.M2100InsereTgh009M2100InsereTgh009
     * 
     */
    public void insertPghq901a607() {
        sqlSttmt = "INSERT INTO VWSDGHPS00901_INFAUXMOV ( " +
        	"C_PAIS_ISOA_CONT, " +
        	"C_BANC_CONT, " +
        	"C_OE_EGC_CONT, " +
        	"NS_RDCL_CONT, " +
        	"V_CHKD_CONT, " +
        	"C_TIPO_CONT, " +
        	"C_MOED_ISO_SCTA, " +
        	"NS_DEPOSITO, " +
        	"TS_MOVIMENTO, " +
        	"NS_MOVIMENTO, " +
        	"I_TRNZ_EFCD_ONLN, " +
        	"I_EXI_ATZ_JOUR_BBN, " +
        	"I_PENALIZACAO, " +
        	"C_PAIS_ISOA_GERX, " +
        	"C_BANC_GCX_GERX, " +
        	"C_OE_EGC_GERX, " +
        	"N_ATRZ_CAMB, " +
        	"X_REF_MOV_ORIG, " +
        	"I_ESTORNO, " +
        	"NS_MOV_ETND, " +
        	"M_MOV_CTRV_EURO, " +
        	"T_CAMB_EURO, " +
        	"C_TERMINAL, " +
        	"TS_ACTZ_ULT, " +
        	"C_USID_ACTZ_ULT" +
        " ) VALUES ( " +
        	":cPaisIsoaCont, " +
        	":cBancCont, " +
        	":cOeEgcCont, " +
        	":nsRdclCont, " +
        	":vChkdCont, " +
        	":cTipoCont, " +
        	":cMoedIsoScta, " +
        	":nsDeposito, " +
        	":tsMovimento, " +
        	":nsMovimento, " +
        	":iTrnzEfcdOnln, " +
        	":iExiAtzJourBbn, " +
        	":iPenalizacao, " +
        	":cPaisIsoaGerx, " +
        	":cBancGcxGerx, " +
        	":cOeEgcGerx, " +
        	":nAtrzCamb, " +
        	":xRefMovOrig, " +
        	":iEstorno, " +
        	":nsMovEtnd, " +
        	":mMovCtrvEuro, " +
        	":tCambEuro, " +
        	":cTerminal, " +
        	":tsActzUlt, " +
        	":cUsidActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infauxmov().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infauxmov().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infauxmov().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infauxmov().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infauxmov().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infauxmov().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infauxmov().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infauxmov().nsDeposito() ) ;
        setQueryArgument( "tsMovimento", infauxmov().tsMovimento(), java.sql.Timestamp.class ) ;
        setQueryArgument( "nsMovimento", infauxmov().nsMovimento() ) ;
        setQueryArgument( "iTrnzEfcdOnln", infauxmov().iTrnzEfcdOnln() ) ;
        setQueryArgument( "iExiAtzJourBbn", infauxmov().iExiAtzJourBbn() ) ;
        setQueryArgument( "iPenalizacao", infauxmov().iPenalizacao() ) ;
        setQueryArgument( "cPaisIsoaGerx", infauxmov().cPaisIsoaGerx() ) ;
        setQueryArgument( "cBancGcxGerx", infauxmov().cBancGcxGerx() ) ;
        setQueryArgument( "cOeEgcGerx", infauxmov().cOeEgcGerx() ) ;
        setQueryArgument( "nAtrzCamb", infauxmov().nAtrzCamb() ) ;
        setQueryArgument( "xRefMovOrig", infauxmov().xRefMovOrig() ) ;
        setQueryArgument( "iEstorno", infauxmov().iEstorno() ) ;
        setQueryArgument( "nsMovEtnd", infauxmov().nsMovEtnd() ) ;
        setQueryArgument( "mMovCtrvEuro", infauxmov().mMovCtrvEuro() ) ;
        setQueryArgument( "tCambEuro", infauxmov().tCambEuro() ) ;
        setQueryArgument( "cTerminal", infauxmov().cTerminal() ) ;
        setQueryArgument( "tsActzUlt", infauxmov().tsActzUlt(), java.sql.Timestamp.class ) ;
        setQueryArgument( "cUsidActzUlt", infauxmov().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate UPDATE access to table VGH00901_INFAUXMOV
     * called from Pghq901a.M2200ActualizaTgh009M2200ActualizaTgh009
     * 
     */
    public void updatePghq901a747() {
        sqlSttmt = "UPDATE VWSDGHPS00901_INFAUXMOV " +
            "SET I_ESTORNO = :iEstorno, " +
                "NS_MOV_ETND = :nsMovEtnd, " +
                "M_MOV_CTRV_EURO = :mMovCtrvEuro, " +
                "T_CAMB_EURO = :tCambEuro, " +
                "TS_ACTZ_ULT = NOW(), " +
                "C_USID_ACTZ_ULT = :cUsidActzUlt" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infauxmov().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infauxmov().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infauxmov().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infauxmov().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infauxmov().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infauxmov().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infauxmov().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infauxmov().nsDeposito() ) ;
        setQueryArgument( "nsMovimento", infauxmov().nsMovimento() ) ;
        setQueryArgument( "iEstorno", infauxmov().iEstorno() ) ;
        setQueryArgument( "nsMovEtnd", infauxmov().nsMovEtnd() ) ;
        setQueryArgument( "mMovCtrvEuro", infauxmov().mMovCtrvEuro() ) ;
        setQueryArgument( "tCambEuro", infauxmov().tCambEuro() ) ;
        setQueryArgument( "cUsidActzUlt", infauxmov().cUsidActzUlt() ) ;
        executeUpdate() ;
    }
    /**
     * Online
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH00901_INFAUXMOV
     * called from Pghs181a.M2311ValMovEstnM2311ValMovEstn
     * 
     * @param pWsDtMovimentoTgh9
     */
    public void selectPghs181a1761(IString pWsDtMovimentoTgh9) {
        sqlSttmt = "SELECT  " +
                "I_ESTORNO" +
            " FROM VWSDGHPS00901_INFAUXMOV" +
            " WHERE " +
                "C_PAIS_ISOA_CONT = :cPaisIsoaCont AND C_BANC_CONT = :cBancCont AND " +
                "C_OE_EGC_CONT = :cOeEgcCont AND " +
                "NS_RDCL_CONT = :nsRdclCont AND " +
                "V_CHKD_CONT = :vChkdCont AND " +
                "C_TIPO_CONT = :cTipoCont AND " +
                "C_MOED_ISO_SCTA = :cMoedIsoScta AND " +
                "NS_DEPOSITO = :nsDeposito AND " +
                "date(TS_MOVIMENTO) = :wsDtMovimentoTgh9 AND " +
                "NS_MOVIMENTO = :nsMovimento" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPaisIsoaCont", infauxmov().cPaisIsoaCont() ) ;
        setQueryArgument( "cBancCont", infauxmov().cBancCont() ) ;
        setQueryArgument( "cOeEgcCont", infauxmov().cOeEgcCont() ) ;
        setQueryArgument( "nsRdclCont", infauxmov().nsRdclCont() ) ;
        setQueryArgument( "vChkdCont", infauxmov().vChkdCont() ) ;
        setQueryArgument( "cTipoCont", infauxmov().cTipoCont() ) ;
        setQueryArgument( "cMoedIsoScta", infauxmov().cMoedIsoScta() ) ;
        setQueryArgument( "nsDeposito", infauxmov().nsDeposito() ) ;
        setQueryArgument( "wsDtMovimentoTgh9", pWsDtMovimentoTgh9 ) ;
        setQueryArgument( "nsMovimento", infauxmov().nsMovimento() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            infauxmov().iEstorno().set(getQueryReturnedValue("I_ESTORNO")) ;
        }
    }
}
