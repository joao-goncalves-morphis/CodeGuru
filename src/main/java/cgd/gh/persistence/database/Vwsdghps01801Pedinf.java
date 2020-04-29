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
 * External
 */
import cgd.gh.structures.link.Bghl018a.Argumento ;
import cgd.gh.structures.link.Bghl018a.Detalhe ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public abstract class Vwsdghps01801Pedinf extends BaseTableHandler {
    /**
     * Member Variables(Working Storage)
     */
    
    
    /**
     * @return instancia da classe local Pedinf
     */
    @Data
    public abstract Pedinf pedinf() ;
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COBOL DECLARATION FOR TABLE VGH01801_PEDINF
     * 
     * @version 2.0
     * 
     */
    public interface Pedinf extends IDataStruct {
        
        /**
         * C_PED_INF_OPPS
         */
        @Column(name="C_PED_INF_OPPS")
        @Key
        @Data(size=7)
        IString cPedInfOpps() ;
        
        /**
         * D_PED_INF_OPPS
         */
        @Column(name="D_PED_INF_OPPS")
        @Data(size=50)
        IString dPedInfOpps() ;
        
        /**
         * C_FRMT_INF
         */
        @Column(name="C_FRMT_INF")
        @Data(size=1)
        IString cFrmtInf() ;
        
        /**
         * C_TIPO_RPTE
         */
        @Column(name="C_TIPO_RPTE")
        @Data(size=1)
        IString cTipoRpte() ;
        
        /**
         * NM_FICH_OUTP_RTNO
         */
        @Column(name="NM_FICH_OUTP_RTNO")
        @Data(size=20)
        IString nmFichOutpRtno() ;
        
        /**
         * Q_DIA_DPNZ_INF
         */
        @Column(name="Q_DIA_DPNZ_INF")
        @Data(size=2, signed=true, compression=COMP3)
        IInt qDiaDpnzInf() ;
        
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
     * BatchQ2
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01801_PEDINF
     * called from Pghq600a.A32000InserirTabelaA32000InserirTabela
     * 
     */
    public void insertPghq600a324() {
        sqlSttmt = "INSERT INTO VWSDGHPS01801_PEDINF ( " +
        	"C_PED_INF_OPPS, " +
        	"D_PED_INF_OPPS, " +
        	"C_FRMT_INF, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"Q_DIA_DPNZ_INF, " +
        	"C_USID_ACTZ_ULT, " +
        	"TS_ACTZ_ULT" +
        " ) VALUES ( " +
        	":cPedInfOpps, " +
        	":dPedInfOpps, " +
        	":cFrmtInf, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":qDiaDpnzInf, " +
        	":cUsidActzUlt, " +
        	"NOW()" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        setQueryArgument( "dPedInfOpps", pedinf().dPedInfOpps() ) ;
        setQueryArgument( "cFrmtInf", pedinf().cFrmtInf() ) ;
        setQueryArgument( "cTipoRpte", pedinf().cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pedinf().nmFichOutpRtno() ) ;
        setQueryArgument( "qDiaDpnzInf", pedinf().qDiaDpnzInf() ) ;
        setQueryArgument( "cUsidActzUlt", pedinf().cUsidActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01801_PEDINF
     * called from Pghq503a.A31000ValidarPedidoA31000ValidarPedido
     * 
     */
    public void selectPghq503a543() {
        sqlSttmt = "SELECT  " +
                "C_FRMT_INF," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "Q_DIA_DPNZ_INF" +
            " FROM VWSDGHPS01801_PEDINF" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cFrmtInf().set(getQueryReturnedValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(getQueryReturnedValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(getQueryReturnedValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01801_PEDINF
     * called from Pghq506a.A32110ValidarPedidoA32110ValidarPedido
     * 
     */
    public void selectPghq506a685() {
        sqlSttmt = "SELECT  " +
                "C_FRMT_INF," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "Q_DIA_DPNZ_INF" +
            " FROM VWSDGHPS01801_PEDINF" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cFrmtInf().set(getQueryReturnedValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(getQueryReturnedValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(getQueryReturnedValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01801_PEDINF
     * called from Pghq507a.A31000ValidarPedidoA31000ValidarPedido
     * 
     */
    public void selectPghq507a600() {
        sqlSttmt = "SELECT  " +
                "C_FRMT_INF," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "Q_DIA_DPNZ_INF" +
            " FROM VWSDGHPS01801_PEDINF" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cFrmtInf().set(getQueryReturnedValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(getQueryReturnedValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(getQueryReturnedValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01801_PEDINF
     * called from Pghq509a.A32110ValidarPedidoA32110ValidarPedido
     * 
     */
    public void selectPghq509a712() {
        sqlSttmt = "SELECT  " +
                "C_FRMT_INF," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "Q_DIA_DPNZ_INF" +
            " FROM VWSDGHPS01801_PEDINF" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cFrmtInf().set(getQueryReturnedValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(getQueryReturnedValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(getQueryReturnedValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01801_PEDINF
     * called from Pghq520a.A32110ValidarPedidoA32110ValidarPedido
     * 
     */
    public void selectPghq520a699() {
        sqlSttmt = "SELECT  " +
                "C_FRMT_INF," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "Q_DIA_DPNZ_INF" +
            " FROM VWSDGHPS01801_PEDINF" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cFrmtInf().set(getQueryReturnedValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(getQueryReturnedValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(getQueryReturnedValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
        }
    }
    /**
     * Rotinas
     */
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate CLOSE access to cursor C1
     * called from Mghs018a.A5300ListaTabelaA5300ListaTabela
     * 
     */
    public void closeMghs018a329() {
        BaseCursorHandler c = getCursor("C1") ;
        c.close() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate DELETE access to table VGH01801_PEDINF
     * called from Mghs018a.A5500EliminarTabelaA5500EliminarTabela
     * 
     * @param pCPedInfOpps
     */
    public void deleteMghs018a381(IString pCPedInfOpps) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "DELETE FROM VWSDGHPS01801_PEDINF " +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pCPedInfOpps ) ;
        executeUpdate() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs018a.A5300ListaTabelaA5300ListaTabela
     * 
     */
    public void fetchMghs018a271() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedinf().dPedInfOpps().set(c.getValue("D_PED_INF_OPPS")) ;
            pedinf().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedinf().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
            pedinf().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate FETCH access to cursor C1
     * called from Mghs018a.A5300ListaTabelaA5300ListaTabela
     * 
     */
    public void fetchMghs018a311() {
        BaseCursorHandler c = getCursor("C1") ;
        c.fetch() ;
        if (c.getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cPedInfOpps().set(c.getValue("C_PED_INF_OPPS")) ;
            pedinf().dPedInfOpps().set(c.getValue("D_PED_INF_OPPS")) ;
            pedinf().cFrmtInf().set(c.getValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(c.getValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(c.getValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(c.getValue("Q_DIA_DPNZ_INF")) ;
            pedinf().cUsidActzUlt().set(c.getValue("C_USID_ACTZ_ULT")) ;
            pedinf().tsActzUlt().set(c.getValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate INSERT access to table VGH01801_PEDINF
     * called from Mghs018a.A5400InserirTabelaA5400InserirTabela
     * 
     * @param pArgumento
     * @param pDetalhe
     */
    public void insertMghs018a341(Argumento pArgumento, Detalhe pDetalhe) {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "INSERT INTO VWSDGHPS01801_PEDINF ( " +
        	"C_PED_INF_OPPS, " +
        	"D_PED_INF_OPPS, " +
        	"C_FRMT_INF, " +
        	"C_TIPO_RPTE, " +
        	"NM_FICH_OUTP_RTNO, " +
        	"Q_DIA_DPNZ_INF, " +
        	"C_USID_ACTZ_ULT, " +
        	"TS_ACTZ_ULT" +
        " ) VALUES ( " +
        	":cPedInfOpps, " +
        	":dPedInfOpps, " +
        	":cFrmtInf, " +
        	":cTipoRpte, " +
        	":nmFichOutpRtno, " +
        	":qDiaDpnzInf, " +
        	":cUsidActzUlt, " +
        	":tsActzUlt" +
        ")" ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pArgumento.cPedInfOpps() ) ;
        setQueryArgument( "dPedInfOpps", pDetalhe.dPedInfOpps() ) ;
        setQueryArgument( "cFrmtInf", pDetalhe.cFrmtInf() ) ;
        setQueryArgument( "cTipoRpte", pDetalhe.cTipoRpte() ) ;
        setQueryArgument( "nmFichOutpRtno", pDetalhe.nmFichOutpRtno() ) ;
        setQueryArgument( "qDiaDpnzInf", pDetalhe.qDiaDpnzInf() ) ;
        setQueryArgument( "cUsidActzUlt", pDetalhe.cUsidActzUlt() ) ;
        setQueryArgument( "tsActzUlt", pDetalhe.tsActzUlt() ) ;
        executeInsert() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate OPEN access to cursor C1
     * called from Mghs018a.A5300ListaTabelaA5300ListaTabela
     * 
     */
    public void openMghs018a259() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PED_INF_OPPS," +
                "D_PED_INF_OPPS," +
                "C_FRMT_INF," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "Q_DIA_DPNZ_INF," +
                "C_USID_ACTZ_ULT," +
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS01801_PEDINF" +
            " WHERE " +
                "C_PED_INF_OPPS > :cPedInfOpps"  +
            " ORDER BY " +
                "C_PED_INF_OPPS ASC" +
            " LIMIT 11" ;
        BaseCursorHandler c = addCursor("C1", sqlSttmt) ;
        c.setArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        c.open() ;
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01801_PEDINF
     * called from Mghj202a.A31000ValidarPedidoA31000ValidarPedido
     * 
     */
    public void selectMghj202a377() {
        sqlSttmt = "SELECT  " +
                "C_FRMT_INF," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "Q_DIA_DPNZ_INF" +
            " FROM VWSDGHPS01801_PEDINF" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cFrmtInf().set(getQueryReturnedValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(getQueryReturnedValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(getQueryReturnedValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
        }
    }
    
    /**
     * 
     * Migration Note:
     * extracted method to encapsulate SELECT access to table VGH01801_PEDINF
     * called from Mghs018a.A5200ConsultaTabelaA5200ConsultaTabela
     * 
     */
    public void selectMghs018a211() {
        /**
         * *----------------------------------------------------------------*
         */
        sqlSttmt = "SELECT  " +
                "C_PED_INF_OPPS," +
                "D_PED_INF_OPPS," +
                "C_FRMT_INF," +
                "C_TIPO_RPTE," +
                "NM_FICH_OUTP_RTNO," +
                "Q_DIA_DPNZ_INF," +
                "C_USID_ACTZ_ULT," +
                "TS_ACTZ_ULT" +
            " FROM VWSDGHPS01801_PEDINF" +
            " WHERE " +
                "C_PED_INF_OPPS = :cPedInfOpps"  ;
        setQueryStatement(sqlSttmt) ;
        setQueryArgument( "cPedInfOpps", pedinf().cPedInfOpps() ) ;
        executeQuery() ;
        if (getPersistenceCode() == PersistenceCode.NORMAL) {
            pedinf().cPedInfOpps().set(getQueryReturnedValue("C_PED_INF_OPPS")) ;
            pedinf().dPedInfOpps().set(getQueryReturnedValue("D_PED_INF_OPPS")) ;
            pedinf().cFrmtInf().set(getQueryReturnedValue("C_FRMT_INF")) ;
            pedinf().cTipoRpte().set(getQueryReturnedValue("C_TIPO_RPTE")) ;
            pedinf().nmFichOutpRtno().set(getQueryReturnedValue("NM_FICH_OUTP_RTNO")) ;
            pedinf().qDiaDpnzInf().set(getQueryReturnedValue("Q_DIA_DPNZ_INF")) ;
            pedinf().cUsidActzUlt().set(getQueryReturnedValue("C_USID_ACTZ_ULT")) ;
            pedinf().tsActzUlt().set(getQueryReturnedValue("TS_ACTZ_ULT", String.class)) ;
        }
    }
}
