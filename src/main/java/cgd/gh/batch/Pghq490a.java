package cgd.gh.batch;

import morphis.framework.server.controller.PersistenceCode ;
import static morphis.framework.commons.DateTimeHandling.* ;
import static java.nio.file.StandardOpenOption.* ;
import cgd.gh.framework.CgdGhBaseBatch ;
import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import static morphis.framework.commons.LogHandling.* ;
import morphis.framework.commons.TraceLevel ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;
import morphis.framework.datatypes.arrays.IArray ;
import morphis.framework.exceptions.* ;
import static morphis.framework.datatypes.serialization.DataUtils.convert ;
import cgd.gh.persistence.files.* ;
import morphis.framework.persistence.annotations.Handler ;
import morphis.framework.server.controller.ResponseCode ;
import cgd.gh.persistence.database.* ;
import cgd.ht.common.constants.Bhtk0001 ;
import cgd.ht.common.constants.Bhtk0002 ;
import cgd.hg.structures.link.Bhgl030a ;
import cgd.hg.structures.link.Bhgl004a ;
import cgd.hg.common.constants.Bhgk0002 ;
import cgd.hj.structures.work.Bhjw0016 ;
import cgd.hj.structures.link.Bhjl006a ;
import cgd.hj.common.constants.Bhjk0001 ;
import cgd.hj.common.constants.Bhjk0002 ;
import cgd.hj.structures.work.Bhjw8019 ;
import cgd.pp.structures.link.Bppl100a ;
import cgd.hk.structures.link.Bhkl072a ;
import cgd.hg.routines.Mhgj030a ;
import cgd.hg.routines.Mhgj004a ;
import cgd.pp.routines.Mppk100a ;
import cgd.hk.routines.Mhkj072a ;


/**
 * 
 * -> FICHEIRO DE SAIDA COM O LAYOUT DO MAPA
 * -> FICHEIRO DE ENTRADA COM CHAVE DA TABELA 16
 * APLICACAO     : GH - HISTORICO DE MOVIMENTOS PASSIVAS
 * OBJECTIVO     : TRATAMENTO DO PEDIDO GH00101 E GH00107
 * 
 * @version 2.0
 * 
 */
public abstract class Pghq490a extends CgdGhBaseBatch {
    /**
     * Handled Tables
     */
    /**
     * @return instancia da classe Vwsdghps01501Pedmovhst
     */
    @Data
    protected abstract Vwsdghps01501Pedmovhst hv01501Pedmovhst() ;
    
    /**
     * @return instancia da classe Vwsdhjps01901Nomes
     */
    @Data
    protected abstract Vwsdhjps01901Nomes hv01901Nomes() ;
    
    
    /**
     * Handled Files
     */
    /**
     * @return instancia da classe Fgh300
     */
    @Handler(name="FGH300", record="rgh03001121")
    @Data
    protected abstract Fgh300 fgh300() ;
    
    /**
     * @return instancia da classe Fgh870
     */
    @Handler(name="FGH870", record="fgh870Registo")
    @Data
    protected abstract Fgh870 fgh870() ;
    
    /**
     * @return instancia da classe Fgh875
     */
    @Handler(name="FGH875", record="fgh875Registo")
    @Data
    protected abstract Fgh875 fgh875() ;
    
    /**
     * @return instancia da classe Fwk490
     */
    @Handler(name="FWK490", record="regFwk490")
    @Data
    protected abstract Fwk490 fwk490() ;
    
    
    /**
     * Handled Routines
     */
    /**
     * @return instancia da classe Mhgj030a
     */
    @Data
    protected abstract Mhgj030a hrMhgj030a() ;
    
    /**
     * @return instancia da classe Mhgj004a
     */
    @Data
    protected abstract Mhgj004a hrMhgj004a() ;
    
    /**
     * @return instancia da classe Mppk100a
     */
    @Data
    protected abstract Mppk100a hrMppk100a() ;
    
    /**
     * @return instancia da classe Mhkj072a
     */
    @Data
    protected abstract Mhkj072a hrMhkj072a() ;
    
    
    /**
     * Member Variables(Working Storage)
     */
    
    /**
     * @return instancia da classe Bhgl030a
     */
    @Data
    protected abstract Bhgl030a bhgl030a() ;
    
    /**
     * @return instancia da classe Bhgl004a
     */
    @Data
    protected abstract Bhgl004a bhgl004a() ;
    
    /**
     * @return instancia da classe Bhgk0002
     */
    @Data
    protected abstract Bhgk0002 bhgk0002() ;
    
    /**
     * @return instancia da classe Bhjw0016
     */
    @Data
    protected abstract Bhjw0016 bhjw0016() ;
    
    /**
     * @return instancia da classe Bhjl006a
     */
    @Data
    protected abstract Bhjl006a bhjl006a() ;
    
    /**
     * @return instancia da classe Bhjk0001
     */
    @Data
    protected abstract Bhjk0001 bhjk0001() ;
    
    /**
     * @return instancia da classe Bhjk0002
     */
    @Data
    protected abstract Bhjk0002 bhjk0002() ;
    
    /**
     * @return instancia da classe Bhjw8019
     */
    @Data
    protected abstract Bhjw8019 bhjw8019() ;
    
    /**
     * @return instancia da classe Bppl100a
     */
    @Data
    protected abstract Bppl100a bppl100a() ;
    
    /**
     * @return instancia da classe Bhkl072a
     */
    @Data
    protected abstract Bhkl072a bhkl072a() ;
    
    /**
     * OBTENÇÃO DE IBAN E SWIFT
     */
    @Data(size=5, signed=true)
    protected IInt progStatus ;
    @Data
    @Condition("0")
    protected ICondition progOk ;
    
    
    @Data(size=10, signed=true, value="0")
    protected ILong wSqlcode ;
    
    @Data(size=3, signed=true, value="0")
    protected IInt swSqlcodeVhj01901 ;
    @Data
    @Condition("100")
    protected ICondition swVhj01901Notfnd ;
    @Data
    @Condition("0")
    protected ICondition swVhj01901Ok ;
    
    
    @Data(size=3, signed=true, value="0")
    protected IInt wsSqlcode ;
    
    @Data(size=8, value="0")
    protected ILong dataCorrente ;
    
    /**
     * @return instancia da classe local DataCorrenteMask
     */
    @Data
    @Mask
    protected abstract DataCorrenteMask dataCorrenteMask() ;
    
    @Data(size=8, value="0")
    protected ILong dataNum ;
    
    /**
     * @return instancia da classe local DataNumMask
     */
    @Data
    @Mask
    protected abstract DataNumMask dataNumMask() ;
    
    /**
     * @return instancia da classe local WTimestamp
     */
    @Data
    protected abstract WTimestamp wTimestamp() ;
    
    /**
     * @return instancia da classe local WTimerN
     */
    @Data
    protected abstract WTimerN wTimerN() ;
    
    /**
     * @return instancia da classe local WsChaveAnt
     */
    @Data
    protected abstract WsChaveAnt wsChaveAnt() ;
    
    /**
     * @return instancia da classe local WsConta
     */
    @Data
    protected abstract WsConta wsConta() ;
    
    /**
     * @return instancia da classe local WsChave
     */
    @Data
    protected abstract WsChave wsChave() ;
    
    @Data(size=10, value="0")
    protected IString wsNCliente ;
    
    @Data(size=3, value="0")
    protected IInt wsNsAbraCli ;
    
    @Data(size=4, value="0")
    protected IInt wsNsNomeCli ;
    
    @Data(size=6, value="MGH870")
    protected IString wsMapa ;
    
    @Data(size=6, value="MGH875")
    protected IString wsMapa2 ;
    
    @Data(size=8, value="BHJP0016")
    protected IString conBhjp0016 ;
    
    @Data(size=8, value="BHJ01901")
    protected IString conVhj01901 ;
    
    @Data(size=8, value="BHJP1019")
    protected IString conBhjp1019 ;
    
    @Data(size=2, value="SE")
    protected IString conSelect ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFgh870 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegEscrtFgh875 ;
    
    @Data(size=7, signed=true, value="0", compression=COMP3)
    protected IInt contRegLidosFwk490 ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorFich ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorDestino ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorHeader ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorDetalhe ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorTotais ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorFich2 ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorDestino2 ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorHeader2 ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorDetalhe2 ;
    
    @Data(size=8, signed=true, value="0", compression=COMP3)
    protected ILong wsContadorTotais2 ;
    
    @Data(size=1)
    protected IString dfheiblk ;
    
    /**
     * TABELA DE IMPRESSAO DE FGH300
     * @return instancia da classe local TabelaImpressao
     */
    @Data
    protected abstract TabelaImpressao tabelaImpressao() ;
    
    /**
     * @return instancia da classe local TabelaImpressaoMask
     */
    @Data
    @Mask
    protected abstract TabelaImpressaoMask tabelaImpressaoMask() ;
    
    
    
    /**
     * 
     * TABELA GERAIS - ACESSO A TABELAS GERAIS
     * 
     */
    protected void bhgp0030AcessoTabela() {
        hrMhgj030a().run() ;
    }
    
    /**
     * 
     * ACESSO A ROTINA DE ACESSO AOS DADOS DO ORGAO DE ESTRUTURA
     * MHGJ004A
     * 
     */
    protected void bhgp0004RotDadosOe() {
        hrMhgj004a().run() ;
    }
    
    /**
     * 
     * COPY  BHJP0016.
     * DEVOLVE O NOME DO CLIENTE
     * 
     */
    protected void bhjp0016Nome() {
        bhjp0016Inicializa() ;
        if (bhjw0016().semErros().isTrue()) {
            bhjp0016Programa() ;
        }
    }
    
    /**
     * 
     * BHJP0016-INICIALIZA
     * 
     */
    protected void bhjp0016Inicializa() {
        bhjw0016().cSqlcode().set(0);
        bhjw0016().cRtnoEvenSwal().set(0);
        bhjw0016().msgErrob().set(" ");
        bhjw0016().nmTabela().set(" ");
        bhjw0016().modOrigemErro().set(" ");
        bhjw0016().chAcesso().set(" ");
        bhjw0016().cTipoErroBbn().set(" ");
    }
    
    /**
     * 
     * BHJP0016-PROGRAMA
     * 
     */
    protected void bhjp0016Programa() {
        bhjp0016InputValida() ;
        if (bhjw0016().semErros().isTrue()) {
            bhjp0016AcedeNomes() ;
        }
    }
    
    /**
     * 
     * BHJP0016-INPUT-VALIDA
     * 
     */
    protected void bhjp0016InputValida() {
        if (bhjw0016().nCliente().isEqual(0) || bhjw0016().nsAbraCli().isEqual(0)) {
            bhjw0016().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
            bhjw0016().cRtnoEvenSwal().set(bhjk0001().erros().inputInsuf());
            bhjw0016().modOrigemErro().set(conBhjp0016);
            bhjw0016().msgErrob().set("INPUT INSUFICIENTE");
        }
    }
    
    /**
     * 
     * BHJP0016-ACEDE-NOMES
     * 
     */
    protected void bhjp0016AcedeNomes() {
        hv01901Nomes().nomes().initialize() ;
        if (!bhjw0016().nsNomeCli().isEqual(0)) {
            bhjw8019().tabela().nCliente().set(bhjw0016().nCliente());
            bhjw8019().tabela().nsAbraCli().set(bhjw0016().nsAbraCli());
            bhjw8019().tabela().nsNomeCli().set(bhjw0016().nsNomeCli());
            bhjp1019Consulta() ;
            bhjw0016().nmTabela().set(conVhj01901);
            swSqlcodeVhj01901.set(getPersistenceCode());
            m9020Db2check() ;
            if (!swVhj01901Ok.isTrue() && !swVhj01901Notfnd.isTrue()) {
                bhjw0016().abendDb2().setTrue() ;
                bhjw0016().cSqlcode().set(swSqlcodeVhj01901);
                bhjw0016().modOrigemErro().set(conBhjp1019);
                wsNCliente.set(hv01901Nomes().nomes().nCliente());
                wsNsAbraCli.set(hv01901Nomes().nomes().nsAbraCli());
                wsNsNomeCli.set(hv01901Nomes().nomes().nsNomeCli());
                bhjw0016().chAcesso().set(concat(conSelect, wsNCliente, wsNsAbraCli, wsNsNomeCli));
            }
            if (swVhj01901Notfnd.isTrue()) {
                bhjw0016().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                bhjw0016().cRtnoEvenSwal().set(bhjk0001().erros().nomeNExi());
                bhjw0016().modOrigemErro().set(conBhjp0016);
                bhjw0016().msgErrob().set("NOME NAO EXISTE");
                bhjw0016().cSqlcode().set(swSqlcodeVhj01901);
            } else {
                bhjw0016().nsNomeCli().set(bhjw8019().tabela().nsNomeCli());
                bhjw0016().cTipoNomeCli().set(bhjw8019().tabela().cTipoNomeCli());
                bhjw0016().nmCliAbvd().set(bhjw8019().tabela().nmCliAbvd());
                bhjw0016().anCliPrim().set(bhjw8019().tabela().anCliPrim());
                bhjw0016().anCliSegn().set(bhjw8019().tabela().anCliSegn());
                bhjw0016().anCliTerc().set(bhjw8019().tabela().anCliTerc());
            }
        } else {
            hv01901Nomes().nomes().nCliente().set(bhjw0016().nCliente());
            hv01901Nomes().nomes().nsAbraCli().set(bhjw0016().nsAbraCli());
            hv01901Nomes().nomes().cTipoNomeCli().set(bhjk0002().BHJK0002_NM_PRINCIP);
            /**
             * Migration Note:
             * call to extracted method to access (SELECT) table VHJ01901_NOMES
             */
            hv01901Nomes().selectBhjp0016148() ;
            bhjw0016().nmTabela().set(conVhj01901);
            swSqlcodeVhj01901.set(hv01901Nomes().getPersistenceCode());
            m9020Db2check() ;
            if (!swVhj01901Ok.isTrue() && !swVhj01901Notfnd.isTrue()) {
                bhjw0016().abendDb2().setTrue() ;
                bhjw0016().cSqlcode().set(swSqlcodeVhj01901);
                bhjw0016().modOrigemErro().set(conBhjp0016);
                wsNCliente.set(hv01901Nomes().nomes().nCliente());
                wsNsAbraCli.set(hv01901Nomes().nomes().nsAbraCli());
                bhjw0016().chAcesso().set(concat(conSelect, wsNCliente, wsNsAbraCli, hv01901Nomes().nomes().cTipoNomeCli()));
            }
            if (swVhj01901Notfnd.isTrue()) {
                bhjw8019().tabela().nCliente().set(bhjw0016().nCliente());
                bhjw8019().tabela().nsAbraCli().set(bhjw0016().nsAbraCli());
                bhjw8019().tabela().nsNomeCli().set(bhjk0002().BHJK0002_PRIM_NOME);
                bhjp1019Consulta() ;
                bhjw0016().nmTabela().set(conVhj01901);
                swSqlcodeVhj01901.set(hv01901Nomes().getPersistenceCode());
                m9020Db2check() ;
                if (!swVhj01901Ok.isTrue() && !swVhj01901Notfnd.isTrue()) {
                    bhjw0016().abendDb2().setTrue() ;
                    bhjw0016().cSqlcode().set(swSqlcodeVhj01901);
                    bhjw0016().modOrigemErro().set(conBhjp1019);
                    wsNCliente.set(hv01901Nomes().nomes().nCliente());
                    wsNsAbraCli.set(hv01901Nomes().nomes().nsAbraCli());
                    wsNsNomeCli.set(hv01901Nomes().nomes().nsNomeCli());
                    bhjw0016().chAcesso().set(concat(conSelect, wsNCliente, wsNsAbraCli, wsNsNomeCli));
                }
                if (swVhj01901Notfnd.isTrue()) {
                    bhjw0016().cSqlcode().set(swSqlcodeVhj01901);
                    bhjw0016().cTipoErroBbn().set(bhtk0002().indErros().errosFuncao());
                    bhjw0016().cRtnoEvenSwal().set(bhjk0001().erros().nomeNExi());
                    bhjw0016().modOrigemErro().set(conBhjp0016);
                    bhjw0016().msgErrob().set("NOME NAO EXISTE");
                } else {
                    bhjw0016().nsNomeCli().set(bhjw8019().tabela().nsNomeCli());
                    bhjw0016().cTipoNomeCli().set(bhjw8019().tabela().cTipoNomeCli());
                    bhjw0016().nmCliAbvd().set(bhjw8019().tabela().nmCliAbvd());
                    bhjw0016().anCliPrim().set(bhjw8019().tabela().anCliPrim());
                    bhjw0016().anCliSegn().set(bhjw8019().tabela().anCliSegn());
                    bhjw0016().anCliTerc().set(bhjw8019().tabela().anCliTerc());
                }
            } else {
                bhjw0016().nsNomeCli().set(hv01901Nomes().nomes().nsNomeCli());
                bhjw0016().cTipoNomeCli().set(hv01901Nomes().nomes().cTipoNomeCli());
                bhjw0016().nmCliAbvd().set(hv01901Nomes().nomes().nmCliAbvd());
                bhjw0016().anCliPrim().set(hv01901Nomes().nomes().anCliPrim());
                bhjw0016().anCliSegn().set(hv01901Nomes().nomes().anCliSegn());
                bhjw0016().anCliTerc().set(hv01901Nomes().nomes().anCliTerc());
            }
        }
    }
    
    /**
     * 
     * BHJP1019-CONSULTA
     * CONSULTA DE TODOS OS CAMPOS DA TABELA DE NOMES
     * 
     */
    protected void bhjp1019Consulta() {
        hv01901Nomes().nomes().nCliente().set(bhjw8019().tabela().nCliente());
        hv01901Nomes().nomes().nsAbraCli().set(bhjw8019().tabela().nsAbraCli());
        hv01901Nomes().nomes().nsNomeCli().set(bhjw8019().tabela().nsNomeCli());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VHJ01901_NOMES
         */
        hv01901Nomes().selectBhjp101914() ;
        bhjw8019().tabela().nCliente().set(hv01901Nomes().nomes().nCliente());
        bhjw8019().tabela().nsAbraCli().set(hv01901Nomes().nomes().nsAbraCli());
        bhjw8019().tabela().nsNomeCli().set(hv01901Nomes().nomes().nsNomeCli());
        bhjw8019().tabela().cTipoNomeCli().set(hv01901Nomes().nomes().cTipoNomeCli());
        bhjw8019().tabela().nmCliAbvd().set(hv01901Nomes().nomes().nmCliAbvd());
        bhjw8019().tabela().anCliPrim().set(hv01901Nomes().nomes().anCliPrim());
        bhjw8019().tabela().anCliSegn().set(hv01901Nomes().nomes().anCliSegn());
        bhjw8019().tabela().anCliTerc().set(hv01901Nomes().nomes().anCliTerc());
        bhjw8019().tabela().cUsidActzUlt().set(hv01901Nomes().nomes().cUsidActzUlt());
        bhjw8019().tabela().tsActzUlt().set(hv01901Nomes().nomes().tsActzUlt());
    }
    
    /**
     * 
     * BPPP0100-CALC-NIB-IBAN - ACESSO AO MODULO QUE CALCULA NIB
     * OU
     * RECEBE IBAN E DEVOLVE A CONTA
     * 
     */
    protected void bppp0100CalcNibIban() {
        hrMppk100a().run() ;
    }
    
    /**
     * 
     * COPY DE ACESSO A ROTINA
     * MHKJ072A -EFETUA A DERIVAÇÃO DO BIC SWIF DO BENEFICIÁRIO,
     * PARTINDO DO RESPETIVO IBAN DO BENEFICIÁRIO
     * 
     */
    protected void bhkp0072AcedeMhkj072a() {
        hrMhkj072a().run() ;
    }
    
    /**
     * 
     * 
     */
    protected void s10000Iniciar() {
        log(TraceLevel.Debug, "S10000-INICIAR");
        bghw0300().wsNmPrograma().set("PGHQ490A");
        progStatus.set(0);
        bghw0300().wsVariaveisHora().horaInicio().set(getTime()) ;
        dataCorrente.set(getTime("yyyyMMdd"));
        dataNum.set(dataCorrente);
        wTimestamp().wDataTimestamp().wAnoAa().set(dataCorrenteMask().anoCorrente());
        wTimestamp().wDataTimestamp().wMesMm().set(dataCorrenteMask().mesCorrente());
        wTimestamp().wDataTimestamp().wDiaDd().set(dataCorrenteMask().diaCorrente());
        tabelaImpressao().linha02().impData().set(wTimestamp().wDataTimestamp());
        tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
        wTimestamp().wTimerTimestamp().wHh().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().hhInicio());
        wTimestamp().wTimerTimestamp().wMm().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().mmInicio());
        wTimestamp().wTimerTimestamp().wSs().set(bghw0300().wsVariaveisHora().horaInicioR().horaMapa().ssInicio());
        wTimestamp().wDataTimestamp().wAnoAa().set(dataNumMask().anoNum());
        wTimerN().wHhN().set(wTimestamp().wTimerTimestamp().wHh());
        wTimerN().wMmN().set(wTimestamp().wTimerTimestamp().wMm());
        wTimerN().wSsN().set(wTimestamp().wTimerTimestamp().wSs());
        wTimerN().wDdN().set(wTimestamp().wTimerTimestamp().wDd());
        wTimestamp().wTimerTimestamp().wDd().set(0);
        wsChaveAnt().initialize() ;
        wsChave().initialize() ;
        a10000AbrirFgh300() ;
        if (progOk.isTrue()) {
            for (tabelaImpressaoMask().zimp().setIndex(1); tabelaImpressaoMask().zimp().index().isLessOrEqual(2); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        if (progOk.isTrue()) {
            a13000AbrirFgh870() ;
        }
        if (progOk.isTrue()) {
            a16000AbrirFgh875() ;
        }
        if (progOk.isTrue()) {
            a14000AbrirFwk490() ;
        }
        if (progOk.isTrue()) {
            a15000LerFwk490() ;
        }
    }
    
    /**
     * 
     * 
     */
    protected void a10000AbrirFgh300() {
        log(TraceLevel.Debug, "A10000-ABRIR-FGH300");
        fgh300().open(WRITE) ;
        if (!fgh300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FGH300 - OPEN - ", fgh300().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a12000EscreverFgh300() {
        log(TraceLevel.Debug, "A12000-ESCREVER-FGH300");
        fgh300().write(fgh300().rgh03001121) ;
        if (!fgh300().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FGH300 - WRITE - ", fgh300().getStatus());
            log(TraceLevel.Error, bghw0300().wsNmPrograma(), " - FIM ANORMAL");
        }
    }
    
    /**
     * 
     * 
     */
    protected void a13000AbrirFgh870() {
        log(TraceLevel.Debug, "A13000-ABRIR-FGH870");
        fgh870().open(CREATE ) ;
        if (!fgh870().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ490A - FGH870 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh870().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a14000AbrirFwk490() {
        log(TraceLevel.Debug, "A14000-ABRIR-FWK490");
        fwk490().open() ;
        if (!fwk490().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ490A - FWK490 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fwk490().getStatus());
        }
    }
    
    /**
     * 
     * 
     */
    protected void a15000LerFwk490() {
        log(TraceLevel.Debug, "A15000-LER-FWK490");
        wsChaveAnt().set(wsChave());
        fwk490().read() ;
        if (fwk490().getStatusOk()) {
            contRegLidosFwk490.add(1);
            wsChave().chaveTsPedido().set(fwk490().regFwk490().fwk490Pedido().fwk490TsPedido());
            wsChave().chaveCPedInfOpps().set(fwk490().regFwk490().fwk490Pedido().fwk490CPedInfOpps());
            wsChave().chaveZInicMov().set(fwk490().regFwk490().fwk490Pedido().fwk490ZInicMov());
            wsChave().chaveZFimMov().set(fwk490().regFwk490().fwk490Pedido().fwk490ZFimMov());
            wsChave().chaveCPaisIsoaDest().set(fwk490().regFwk490().fwk490Destino().fwk490CPaisIsoaDest());
            wsChave().chaveCMnemEgcDest().set(fwk490().regFwk490().fwk490Destino().fwk490CMnemEgcDest());
            wsChave().chaveCOePed().set(fwk490().regFwk490().fwk490Destino().fwk490COeEgcDest());
        }
        if (!fwk490().getStatusOk() && !fwk490().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHC201A - FWK490 - READ - ");
            tabelaImpressao().linha09().impStatus().set(fwk490().getStatus());
        }
    }
    
    /**
     * 
     * PRC19 - INI
     * 
     */
    protected void a16000AbrirFgh875() {
        log(TraceLevel.Debug, "A16000-ABRIR-FGH875");
        fgh875().open(CREATE ) ;
        if (!fgh875().getStatusOk()) {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ490A - FGH875 - OPEN - ");
            tabelaImpressao().linha09().impStatus().set(fgh875().getStatus());
        }
    }
    
    /**
     * 
     * PRC19 - FIM
     * 
     */
    protected void s30000Processar() {
        log(TraceLevel.Debug, "S30000-PROCESSAR");
        if (!fwk490().regFwk490().fwk490FicheiroFgh870().fwk490IDbcr().isEqual("X")) {
            if (fwk490().regFwk490().fwk490Pedido().fwk490CPedInfOpps().isEqual("GH00101")) {
                a31100Detalhe() ;
            } else {
                a32100Detalhe() ;
            }
        }
        if (progOk.isTrue()) {
            a15000LerFwk490() ;
        }
        if (progOk.isTrue()) {
            if (!wsChaveAnt().isEqual(wsChave())) {
                if (wsChaveAnt().antCPedInfOpps().isEqual("GH00101")) {
                    fgh870().fgh870Registo().initialize() ;
                    a31300Totais() ;
                    a31500ActPedido() ;
                    if (wsChave().chaveTsPedido().isGreater(0)) {
                        if (fwk490().regFwk490().fwk490Pedido().fwk490CPedInfOpps().isEqual("GH00101")) {
                            a31700Header() ;
                        } else {
                            a32700Header() ;
                        }
                    }
                } else {
                    a31500ActPedido() ;
                    if (wsChave().chaveTsPedido().isGreater(0)) {
                        if (fwk490().regFwk490().fwk490Pedido().fwk490CPedInfOpps().isEqual("GH00101")) {
                            a31700Header() ;
                        } else {
                            a32700Header() ;
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 
     * 
     */
    protected void a31130MoverDetalhe() {
        /**
         * *----------------------------------------------------------------*
         */
        wsContadorDetalhe.add(1);
        wsContadorFich.add(1);
        fgh870().fgh870Registo().fgh870Detalhe().fgh870CMapaR2().set(wsMapa);
        fgh870().fgh870Registo().fgh870Detalhe().fgh870CTipoRegR2().set("R2");
        fgh870().fgh870Registo().fgh870Detalhe().fgh870ZMapaR2().set(wTimestamp().wDataTimestamp());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870HMapaR2().set(wTimerN());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870CIdioIsoR2().set("POR");
        fgh870().fgh870Registo().fgh870Detalhe().fgh870NsRegFichR2().set(wsContadorFich);
        fgh870().fgh870Registo().fgh870Detalhe().fgh870NIdRegDestR2().set(wsContadorDestino);
        fgh870().fgh870Registo().fgh870Detalhe().fgh870NIdRegCabcR2().set(wsContadorHeader);
        fgh870().fgh870Registo().fgh870Detalhe().fgh870NsRegDtlhCabR2().set(wsContadorDetalhe);
        fgh870().fgh870Registo().fgh870Detalhe().fgh870ZMovimentoR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490ZMovimento());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870DDescR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490DDesc());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870MMovimentoR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490MMovimento());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870SinalMovR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490SinalMov());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870IDbcrR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490IDbcr());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870IEstornoR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490IEstorno());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870MSldoCbloR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490MSldoCblo());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870SinalSldR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490SinalSld());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870MSldoDpnlR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490MSldoDpnl());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870SinalDpnlR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490SinalDpnl());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870ZValorR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490ZValor());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870NDocOppsR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NDocOpps());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870MMovMoeOrigR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490MMovMoeOrig());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870SinalMovOrgR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490SinalMovOrg());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870CMoedIsoOrgR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CMoedIsoOrg());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870AAplR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490AApl());
        fgh870().fgh870Registo().fgh870Detalhe().fgh870NsMovimentoR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NsMovimento());
    }
    
    /**
     * 
     * 
     */
    protected void a31700Header() {
        log(TraceLevel.Debug, "A31700-HEADER");
        fgh870().fgh870Registo().initialize() ;
        a31730TrataDescricoes() ;
        wsContadorHeader.add(1);
        wsContadorDestino.add(1);
        wsContadorFich.add(1);
        wsContadorDetalhe.set(0);
        fgh870().fgh870Registo().fgh870Header().fgh870CMapaR1().set(wsMapa);
        fgh870().fgh870Registo().fgh870Header().fgh870CTipoRegR1().set("R1");
        fgh870().fgh870Registo().fgh870Header().fgh870ZMapaR1().set(wTimestamp().wDataTimestamp());
        fgh870().fgh870Registo().fgh870Header().fgh870HMapaR1().set(wTimerN());
        fgh870().fgh870Registo().fgh870Header().fgh870CIdioIsoR1().set("POR");
        fgh870().fgh870Registo().fgh870Header().fgh870NsRegFichR1().set(wsContadorFich);
        fgh870().fgh870Registo().fgh870Header().fgh870NIdRegDestR1().set(wsContadorDestino);
        fgh870().fgh870Registo().fgh870Header().fgh870NIdRegCabcR1().set(wsContadorHeader);
        fgh870().fgh870Registo().fgh870Header().fgh870CPaisIsoContR1().set(fwk490().regFwk490().fwk490Destino().fwk490CPaisIsoaDest());
        fgh870().fgh870Registo().fgh870Header().fgh870CBancContR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CBancCont());
        fgh870().fgh870Registo().fgh870Header().fgh870CBancContR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CBancCont());
        fgh870().fgh870Registo().fgh870Header().fgh870COeEgcContR1().set(wsChave().chaveCOePed());
        fgh870().fgh870Registo().fgh870Header().fgh870ZInicPesqR1().set(fwk490().regFwk490().fwk490Pedido().fwk490ZInicMov());
        fgh870().fgh870Registo().fgh870Header().fgh870ZFimPesqR1().set(fwk490().regFwk490().fwk490Pedido().fwk490ZFimMov());
        fgh870().fgh870Registo().fgh870Header().fgh870SubcontaR1().fgh870CPaisContR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CPaisIsoaCont());
        fgh870().fgh870Registo().fgh870Header().fgh870SubcontaR1().fgh870CBancR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CBancCont());
        wsConta().contaCOeEgcCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490COeEgcCont());
        wsConta().contaNsRdclCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NsRdclCont());
        wsConta().contaVChkdCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490VChkdCont());
        wsConta().contaCTipoCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CTipoCont());
        fgh870().fgh870Registo().fgh870Header().fgh870SubcontaR1().fgh870ContaR1().set(wsConta());
        fgh870().fgh870Registo().fgh870Header().fgh870SubcontaR1().fgh870NsDepositoR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NsDeposito());
        fgh870().fgh870Registo().fgh870Header().fgh870SubcontaR1().fgh870CMoedIsoSctaR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CMoedIsoScta());
        s10000WriteFgh870() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31300Totais() {
        log(TraceLevel.Debug, "A31300-TOTAIS");
        fgh870().fgh870Registo().initialize() ;
        wsContadorTotais.add(1);
        wsContadorFich.add(1);
        fgh870().fgh870Registo().fgh870Totais().fgh870CMapaR3().set(wsMapa);
        fgh870().fgh870Registo().fgh870Totais().fgh870CTipoRegR3().set("R3");
        fgh870().fgh870Registo().fgh870Totais().fgh870ZMapaR3().set(wTimestamp().wDataTimestamp());
        fgh870().fgh870Registo().fgh870Totais().fgh870HMapaR3().set(wTimerN());
        fgh870().fgh870Registo().fgh870Totais().fgh870CIdioIsoR3().set("POR");
        fgh870().fgh870Registo().fgh870Totais().fgh870NsRegFichR3().set(wsContadorFich);
        fgh870().fgh870Registo().fgh870Totais().fgh870NIdRegDestR3().set(wsContadorDestino);
        fgh870().fgh870Registo().fgh870Totais().fgh870NIdRegCabcR3().set(wsContadorHeader);
        fgh870().fgh870Registo().fgh870Totais().fgh870TotalMovimentsR3().set(wsContadorDetalhe);
        fgh870().fgh870Registo().fgh870Totais().fgh870NIdRegTotR3().set(wsContadorTotais);
        wsContadorDetalhe.set(0);
        s10000WriteFgh870() ;
    }
    
    /**
     * 
     * 
     */
    protected void a31100Detalhe() {
        log(TraceLevel.Debug, "A31100-DETALHE");
        fgh870().fgh870Registo().initialize() ;
        a31130MoverDetalhe() ;
        s10000WriteFgh870() ;
    }
    
    /**
     * 
     * PRC19 - INI
     * 
     */
    protected void a32130MoverDetalhe() {
        /**
         * *----------------------------------------------------------------*
         */
        wsContadorDetalhe2.add(1);
        wsContadorFich2.add(1);
        fgh875().fgh875Registo().fgh875Detalhe().fgh875CMapaR2().set(wsMapa2);
        fgh875().fgh875Registo().fgh875Detalhe().fgh875CTipoRegR2().set("R2");
        fgh875().fgh875Registo().fgh875Detalhe().fgh875ZMapaR2().set(wTimestamp().wDataTimestamp());
        fgh875().fgh875Registo().fgh875Detalhe().fgh875HMapaR2().set(wTimerN());
        fgh875().fgh875Registo().fgh875Detalhe().fgh875CIdioIsoR2().set("POR");
        fgh875().fgh875Registo().fgh875Detalhe().fgh875NsRegFichR2().set(wsContadorFich2);
        fgh875().fgh875Registo().fgh875Detalhe().fgh875NIdRegDestR2().set(wsContadorDestino2);
        fgh875().fgh875Registo().fgh875Detalhe().fgh875NIdRegCabcR2().set(wsContadorHeader2);
        fgh875().fgh875Registo().fgh875Detalhe().fgh875NsRegDtlhCabR2().set(wsContadorDetalhe2);
        fgh875().fgh875Registo().fgh875Detalhe().fgh875ZMovimentoR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490ZMovimento());
        fgh875().fgh875Registo().fgh875Detalhe().fgh875DDescR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490DDesc());
        fgh875().fgh875Registo().fgh875Detalhe().fgh875MMovimentoR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490MMovimento());
        fgh875().fgh875Registo().fgh875Detalhe().fgh875MSldoCbloR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490MSldoCblo());
        fgh875().fgh875Registo().fgh875Detalhe().fgh875ZValorR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490ZValor());
        fgh875().fgh875Registo().fgh875Detalhe().fgh875NDocOppsR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NDocOpps());
        fgh875().fgh875Registo().fgh875Detalhe().fgh875NsMovimentoR2().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NsMovimento());
    }
    
    /**
     * 
     * 
     */
    protected void a32700Header() {
        log(TraceLevel.Debug, "A32700-HEADER");
        fgh875().fgh875Registo().initialize() ;
        a31730TrataDescricoes() ;
        a32500ObtemCliente() ;
        if (!hv01501Pedmovhst().pedmovhst().nCliPed().isEqual(0)) {
            a32740ObtemNome() ;
        } else {
            bhjw0016().nmCliAbvd().set(" ");
        }
        a32750ObtemIban() ;
        a32760ObtemSwift() ;
        wsContadorHeader2.add(1);
        wsContadorDestino2.add(1);
        wsContadorFich2.add(1);
        wsContadorDetalhe2.set(0);
        fgh875().fgh875Registo().fgh875Header().fgh875CMapaR1().set(wsMapa2);
        fgh875().fgh875Registo().fgh875Header().fgh875CTipoRegR1().set("R1");
        fgh875().fgh875Registo().fgh875Header().fgh875ZMapaR1().set(wTimestamp().wDataTimestamp());
        fgh875().fgh875Registo().fgh875Header().fgh875HMapaR1().set(wTimerN());
        fgh875().fgh875Registo().fgh875Header().fgh875CIdioIsoR1().set("POR");
        fgh875().fgh875Registo().fgh875Header().fgh875NsRegFichR1().set(wsContadorFich2);
        fgh875().fgh875Registo().fgh875Header().fgh875NIdRegDestR1().set(wsContadorDestino2);
        fgh875().fgh875Registo().fgh875Header().fgh875NIdRegCabcR1().set(wsContadorHeader2);
        fgh875().fgh875Registo().fgh875Header().fgh875COeEgcContR1().set(wsChave().chaveCOePed());
        fgh875().fgh875Registo().fgh875Header().fgh875ZInicPesqR1().set(fwk490().regFwk490().fwk490Pedido().fwk490ZInicMov());
        fgh875().fgh875Registo().fgh875Header().fgh875ZFimPesqR1().set(fwk490().regFwk490().fwk490Pedido().fwk490ZFimMov());
        fgh875().fgh875Registo().fgh875Header().fgh875SubcontaR1().fgh875CPaisContR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CPaisIsoaCont());
        fgh875().fgh875Registo().fgh875Header().fgh875SubcontaR1().fgh875CBancR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CBancCont());
        wsConta().contaCOeEgcCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490COeEgcCont());
        wsConta().contaNsRdclCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NsRdclCont());
        wsConta().contaVChkdCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490VChkdCont());
        wsConta().contaCTipoCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CTipoCont());
        fgh875().fgh875Registo().fgh875Header().fgh875SubcontaR1().fgh875ContaR1().set(wsConta());
        fgh875().fgh875Registo().fgh875Header().fgh875SubcontaR1().fgh875NsDepositoR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NsDeposito());
        fgh875().fgh875Registo().fgh875Header().fgh875SubcontaR1().fgh875CMoedIsoSctaR1().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CMoedIsoScta());
        fgh875().fgh875Registo().fgh875Header().fgh875NClienteR1().set(hv01501Pedmovhst().pedmovhst().nCliPed());
        fgh875().fgh875Registo().fgh875Header().fgh875NmClienteR1().set(bhjw0016().nmCliAbvd());
        fgh875().fgh875Registo().fgh875Header().fgh875IbanR1().set(bppl100a().commarea().iban25Output());
        fgh875().fgh875Registo().fgh875Header().fgh875NibR1().set(bppl100a().commarea().nib21Output());
        fgh875().fgh875Registo().fgh875Header().fgh875SwiftR1().set(bhkl072a().commarea().dadosOutput().endSwif());
        s20000WriteFgh875() ;
    }
    
    /**
     * 
     * 
     */
    protected void a32740ObtemNome() {
        log(TraceLevel.Debug, "A32740-OBTEM-NOME");
        bhjw0016().nCliente().set(hv01501Pedmovhst().pedmovhst().nCliPed());
        bhjw0016().nsAbraCli().set(hv01501Pedmovhst().pedmovhst().nsAbraCliPed());
        bhjp0016Nome() ;
        if (!bhjw0016().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            wSqlcode.set(bhjl006a().commarea().erros().cSqlcode());
            tabelaImpressao().linha09().msgStatus().set("PGHQ490A - ERRO BHJP0016 - ");
            tabelaImpressao().linha09().impStatus().set(wsSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32750ObtemIban() {
        log(TraceLevel.Debug, "A32750-OBTEM-IBAN");
        bppl100a().commarea().initialize() ;
        bppl100a().commarea().calcNib().setTrue() ;
        bppl100a().commarea().cIdioIso().set("POR");
        bppl100a().commarea().cPaisIsoaCont().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CPaisIsoaCont());
        bppl100a().commarea().contaInput().cBancNib().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CBancCont());
        bppl100a().commarea().contaInput().cOeNib().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490COeEgcCont());
        bppl100a().commarea().contaInput().conta11Input().nsRdclNib().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490NsRdclCont());
        bppl100a().commarea().contaInput().conta11Input().vChkdNib().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490VChkdCont());
        bppl100a().commarea().contaInput().conta11Input().cTipoNib().set(fwk490().regFwk490().fwk490FicheiroFgh870().fwk490CTipoCont());
        bppp0100CalcNibIban() ;
        if (!bppl100a().commarea().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            wSqlcode.set(bppl100a().commarea().cSqlcode());
            tabelaImpressao().linha09().msgStatus().set("PGHQ490A - ERRO BPPP0100 - ");
            tabelaImpressao().linha09().impStatus().set(wsSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32760ObtemSwift() {
        log(TraceLevel.Debug, "A32760-OBTEM-SWIFT");
        bhkl072a().commarea().initialize() ;
        bhkl072a().commarea().dadosEntrada().modoSwift().setTrue() ;
        bhkl072a().commarea().dadosEntrada().sepaCt().setTrue() ;
        bhkl072a().commarea().dadosEntrada().iban().set(bppl100a().commarea().iban25Output());
        bhkp0072AcedeMhkj072a() ;
        if (!bhkl072a().commarea().dadosErros().semErros().isTrue()) {
            setReturnCode(16) ;
            progStatus.set(16);
            wSqlcode.set(bhkl072a().commarea().dadosErros().cSqlcode());
            tabelaImpressao().linha09().msgStatus().set("PGHQ490A - ERRO BHKP0072 - ");
            tabelaImpressao().linha09().impStatus().set(wsSqlcode);
        }
    }
    
    /**
     * 
     * 
     */
    protected void a32100Detalhe() {
        log(TraceLevel.Debug, "A32100-DETALHE");
        fgh875().fgh875Registo().initialize() ;
        a32130MoverDetalhe() ;
        s20000WriteFgh875() ;
    }
    
    /**
     * 
     * PRC19 - FIM
     * 
     */
    protected void a31500ActPedido() {
        log(TraceLevel.Debug, "A31500-ACT-PEDIDO");
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(wsChaveAnt().antCPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(wsChaveAnt().antZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(wsChaveAnt().antZFimMov());
        hv01501Pedmovhst().pedmovhst().tsPedido().set(wsChaveAnt().antTsPedido());
        hv01501Pedmovhst().pedmovhst().cEstPedHist().set("T");
        hv01501Pedmovhst().pedmovhst().zCluzPed().set(wTimestamp().wDataTimestamp());
        hv01501Pedmovhst().pedmovhst().cUsidActzUlt().set(bghw0300().wsNmPrograma());
        /**
         * Migration Note:
         * call to extracted method to access (UPDATE) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().updatePghq490a921() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() == PersistenceCode.NORMAL) {
            wsChaveAnt().set(wsChave());
        } else {
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("- UPDATE VGH01501 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * PRC19 - INI
     * 
     */
    protected void a32500ObtemCliente() {
        log(TraceLevel.Debug, "A32500-OBTEM-CLIENTE");
        hv01501Pedmovhst().pedmovhst().cPedInfOpps().set(fwk490().regFwk490().fwk490Pedido().fwk490CPedInfOpps());
        hv01501Pedmovhst().pedmovhst().zInicMov().set(fwk490().regFwk490().fwk490Pedido().fwk490ZInicMov());
        hv01501Pedmovhst().pedmovhst().zFimMov().set(fwk490().regFwk490().fwk490Pedido().fwk490ZFimMov());
        hv01501Pedmovhst().pedmovhst().tsPedido().set(fwk490().regFwk490().fwk490Pedido().fwk490TsPedido());
        /**
         * Migration Note:
         * call to extracted method to access (SELECT) table VGH01501_PEDMOVHST
         */
        hv01501Pedmovhst().selectPghq490a962() ;
        wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
        if (hv01501Pedmovhst().getPersistenceCode() != PersistenceCode.NORMAL) {
            wSqlcode.set(hv01501Pedmovhst().getPersistenceCode());
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("- SELECT VGH01501 - ");
            tabelaImpressao().linha09().impStatus().set(wSqlcode);
        }
    }
    
    /**
     * 
     * PRC19 - FIM
     * 
     */
    protected void a31730TrataDescricoes() {
        log(TraceLevel.Debug, "A39300-TRATA-DESCRICOES");
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set("910");
        bhgl030a().commarea().dadosInput().cCodigo().set(fwk490().regFwk490().fwk490Destino().fwk490CPaisIsoaDest());
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh870().fgh870Registo().fgh870Header().fgh870DPaisIsoContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh870().fgh870Registo().fgh870Header().fgh870DPaisIsoContR1().set(" ");
        }
        bhgl030a().commarea().initialize() ;
        bhgl030a().commarea().dadosInput().cTabBbn().set("983");
        bhgl030a().commarea().dadosInput().cCodigo().get(1, 3).set(fwk490().regFwk490().fwk490Destino().fwk490CPaisIsoaDest()) ;
        bhgl030a().commarea().dadosInput().cCodigo().get(4, 4).set("35") ;
        bhgl030a().commarea().dadosInput().cIdioIso().set("POR");
        bhgl030a().commarea().dadosInput().visualizacao().setTrue() ;
        bhgl030a().commarea().dadosInput().descricoes().setTrue() ;
        bhgp0030AcessoTabela() ;
        if (bhgl030a().commarea().dadosOutput().semErros().isTrue()) {
            fgh870().fgh870Registo().fgh870Header().fgh870DBancContR1().set(bhgl030a().commarea().dadosOutput().dCodAbvd());
        } else {
            fgh870().fgh870Registo().fgh870Header().fgh870DBancContR1().set(" ");
        }
        bhgl004a().commarea().initialize() ;
        bhgl004a().commarea().dadosInput().cPaisIsoAlfn().set(fwk490().regFwk490().fwk490Destino().fwk490CPaisIsoaDest());
        bhgl004a().commarea().dadosInput().cMnemEmpGcx().set(fwk490().regFwk490().fwk490Destino().fwk490CMnemEgcDest());
        bhgl004a().commarea().dadosInput().cOeEgc().set(wsChave().chaveCOePed());
        bhgp0004RotDadosOe() ;
        if (bhgl004a().commarea().dadosOutput().semErros().isTrue()) {
            fgh870().fgh870Registo().fgh870Header().fgh870DOeEgcContR1().set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
            fgh875().fgh875Registo().fgh875Header().fgh875DOeEgcContR1().set(bhgl004a().commarea().dadosOutput().nmOeAbvd());
        } else {
            fgh870().fgh870Registo().fgh870Header().fgh870DOeEgcContR1().set(" ");
            fgh875().fgh875Registo().fgh875Header().fgh875DOeEgcContR1().set(" ");
        }
    }
    
    /**
     * 
     * 
     */
    protected void s10000WriteFgh870() {
        log(TraceLevel.Debug, "S10000-WRITE-FGH870");
        fgh870().write(fgh870().fgh870Registo()) ;
        if (fgh870().getStatusOk()) {
            contRegEscrtFgh870.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ490A - FGH870 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh870().getStatus());
        }
    }
    
    /**
     * 
     * PRC19 - INI
     * 
     */
    protected void s20000WriteFgh875() {
        log(TraceLevel.Debug, "S20000-WRITE-FGH875");
        fgh875().write(fgh875().fgh875Registo()) ;
        if (fgh875().getStatusOk()) {
            contRegEscrtFgh875.add(1);
        } else {
            setReturnCode(16) ;
            progStatus.set(16);
            tabelaImpressao().linha09().msgStatus().set("PGHQ490A - FGH875 - WRITE   - ");
            tabelaImpressao().linha09().impStatus().set(fgh875().getStatus());
        }
    }
    
    /**
     * 
     * PRC19 - FIM
     * 
     */
    protected void s70000Fim() {
        log(TraceLevel.Debug, "S70000-FIM");
        if (progOk.isTrue()) {
            tabelaImpressao().linha07().impReturnCode().set(0);
            a71000CalculaTempoExecucao() ;
            tabelaImpressao().linha03().impHoraInicio().set(bghw0300().wsVariaveisHora().horaInicio());
            tabelaImpressao().linha03().impHoraFim().set(bghw0300().wsVariaveisHora().horaFim());
            tabelaImpressao().linha04().impTempoGasto().set(bghw0300().wsVariaveisHora().tempoExecucao());
            tabelaImpressao().linha05().impFichRead().set("FWK490");
            tabelaImpressao().linha05().impRegLidosFwk490().set(contRegLidosFwk490);
            for (tabelaImpressaoMask().zimp().setIndex(3); tabelaImpressaoMask().zimp().index().isLessOrEqual(5); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
            tabelaImpressao().linha06().impFichEsc().set("FGH870");
            tabelaImpressao().linha06().impRegEscrt().set(contRegEscrtFgh870);
            tabelaImpressaoMask().zimp().setIndex(6) ;
            a12000EscreverFgh300() ;
        } else {
            tabelaImpressao().linha07().impReturnCode().set(16);
            setReturnCode(16) ;
            tabelaImpressao().linha07().impReturnCode().set(returnCode);
            tabelaImpressao().linha0602().impMens1().set("PGHQ490A - FIM ANORMAL ");
            for (tabelaImpressaoMask().zimp().setIndex(7); tabelaImpressaoMask().zimp().index().isLessOrEqual(10); tabelaImpressaoMask().zimp().incIndex()) {
                a12000EscreverFgh300() ;
            }
        }
        fgh300().close() ;
        fwk490().close() ;
        fgh870().close() ;
        fgh875().close() ;
    }
    
    /**
     * 
     * 
     */
    protected void a71000CalculaTempoExecucao() {
        /**
         * *----------------------------------------------------------------*
         */
        bghw0300().wsVariaveisHora().horaFim().set(getTime()) ;
        /**
         * BOOK QUE CONTEM A ROTINA DE CALCULO DO TEMPO DE EXECUCAO
         * DO PROGRAMA
         */
        bghp0300() ;
    }
    
    /**
     * 
     * 
     */
    @Override
    protected void mainProcedure() {
        /**
         * *----------------------------------------------------------------*
         */
        s10000Iniciar() ;
        if (fwk490().getStatusOk()) {
            if (progOk.isTrue()) {
                if (fwk490().regFwk490().fwk490Pedido().fwk490CPedInfOpps().isEqual("GH00101")) {
                    a31700Header() ;
                } else {
                    a32700Header() ;
                }
                while (!fwk490().getStatusOk() && progOk.isTrue()) {
                    s30000Processar() ;
                }
            }
            if (progOk.isTrue()) {
                if (wsChaveAnt().antCPedInfOpps().isEqual("GH00101")) {
                    a31300Totais() ;
                }
            }
            if (progOk.isTrue()) {
                a31500ActPedido() ;
            }
        }
        s70000Fim() ;
        exit() ;
    }
    /**
     * Inner Classes
     */
    public interface DataCorrenteMask extends IDataMask {
        
        @Data(size=4)
        IInt anoCorrente() ;
        
        @Data(size=2)
        IInt mesCorrente() ;
        
        @Data(size=2)
        IInt diaCorrente() ;
        
    }
    public interface DataNumMask extends IDataMask {
        
        @Data(size=4)
        IInt anoNum() ;
        
        @Data(size=2)
        IInt mesNum() ;
        
        @Data(size=2)
        IInt diaNum() ;
        
    }
    public interface WTimestamp extends IDataStruct {
        
        /**
         * @return instancia da classe local WDataTimestamp
         */
        @Data
        WDataTimestamp wDataTimestamp() ;
        
        /**
         * @return instancia da classe local WTimerTimestamp
         */
        @Data(lpadding=1, lpaddingValue="-")
        WTimerTimestamp wTimerTimestamp() ;
        
        
        public interface WDataTimestamp extends IDataStruct {
            
            @Data(size=4)
            IInt wAnoAa() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wMesMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue="-")
            IInt wDiaDd() ;
            
        }
        
        public interface WTimerTimestamp extends IDataStruct {
            
            @Data(size=2)
            IInt wHh() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wMm() ;
            
            @Data(size=2, lpadding=1, lpaddingValue=".")
            IInt wSs() ;
            
            @Data(size=6, lpadding=1, lpaddingValue=".")
            IInt wDd() ;
            
        }
    }
    public interface WTimerN extends IDataStruct {
        
        @Data(size=2)
        IInt wHhN() ;
        
        @Data(size=2)
        IInt wMmN() ;
        
        @Data(size=2)
        IInt wSsN() ;
        
        @Data(size=6)
        IInt wDdN() ;
        
    }
    public interface WsChaveAnt extends IDataStruct {
        
        @Data(size=7)
        IString antCPedInfOpps() ;
        
        @Data(size=10)
        IString antZInicMov() ;
        
        @Data(size=10)
        IString antZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong antTsPedido() ;
        
        @Data(size=3)
        IString antCPaisIsoaDest() ;
        
        @Data(size=3)
        IString antCMnemEgcDest() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt antCOePed() ;
        
    }
    public interface WsConta extends IDataStruct {
        
        @Data(size=4)
        IInt contaCOeEgcCont() ;
        
        @Data(size=6)
        IInt contaNsRdclCont() ;
        
        @Data(size=1)
        IInt contaVChkdCont() ;
        
        @Data(size=2)
        IInt contaCTipoCont() ;
        
    }
    public interface WsChave extends IDataStruct {
        
        @Data(size=7)
        IString chaveCPedInfOpps() ;
        
        @Data(size=10)
        IString chaveZInicMov() ;
        
        @Data(size=10)
        IString chaveZFimMov() ;
        
        @Data(size=15, signed=true, compression=COMP3)
        ILong chaveTsPedido() ;
        
        @Data(size=3)
        IString chaveCPaisIsoaDest() ;
        
        @Data(size=3)
        IString chaveCMnemEgcDest() ;
        
        @Data(size=4, signed=true, compression=COMP3)
        IInt chaveCOePed() ;
        
    }
    
    /**
     * 
     * TABELA DE IMPRESSAO DE FGH300
     * 
     * @version 2.0
     * 
     */
    public interface TabelaImpressao extends IDataStruct {
        
        @Data(size=121, value=" ")
        IString linha01() ;
        
        /**
         * @return instancia da classe local Linha02
         */
        @Data
        Linha02 linha02() ;
        
        /**
         * @return instancia da classe local Linha03
         */
        @Data
        Linha03 linha03() ;
        
        /**
         * @return instancia da classe local Linha04
         */
        @Data
        Linha04 linha04() ;
        
        /**
         * @return instancia da classe local Linha05
         */
        @Data
        Linha05 linha05() ;
        
        /**
         * @return instancia da classe local Linha06
         */
        @Data
        Linha06 linha06() ;
        
        /**
         * @return instancia da classe local Linha07
         */
        @Data
        Linha07 linha07() ;
        
        /**
         * @return instancia da classe local Linha0602
         */
        @Data
        Linha0602 linha0602() ;
        
        /**
         * @return instancia da classe local Linha09
         */
        @Data
        Linha09 linha09() ;
        
        /**
         * @return instancia da classe local Linha10
         */
        @Data
        Linha10 linha10() ;
        
        
        public interface Linha02 extends IDataStruct {
            
            @Data(size=5, value=" ")
            IString filler001() ;
            
            @Data(size=8, value="PGHQ490A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(size=11, value="DATA:     ")
            IString filler004() ;
            
            @Data(size=10, rpadding=84, rpaddingValue="")
            IString impData() ;
            
        }
        
        public interface Linha03 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="HORA INICIO: ")
            IString filler002() ;
            
            @Data(size=8, decimal=2, value="0")
            IDecimal impHoraInicio() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(size=11, value="HORA FIM: ")
            IString filler004() ;
            
            @Data(size=8, decimal=2, value="0", rpadding=55, rpaddingValue="")
            IDecimal impHoraFim() ;
            
        }
        
        public interface Linha04 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=36, value="TEMPO GASTO NA EXECUCAO DE PGHQ490A")
            IString filler002() ;
            
            @Data(size=3, value=" ")
            IString filler003() ;
            
            @Data(format="ZZ.ZZ.Z9.99", value="0", rpadding=55, rpaddingValue="")
            IFormattedString impTempoGasto() ;
            
        }
        
        public interface Linha05 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS LIDOS EM ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichRead() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegLidosFwk490() ;
            
        }
        
        public interface Linha06 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=30, value="NUMERO DE REGISTOS ESCRITOS  ")
            IString filler002() ;
            
            @Data(size=8, value=" ")
            IString impFichEsc() ;
            
            @Data(format="ZZZZZZZZZZZZZZ9", value="0", lpadding=5, rpadding=47, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impRegEscrt() ;
            
        }
        
        public interface Linha07 extends IDataStruct {
            
            @Data(size=16, value=" ")
            IString filler001() ;
            
            @Data(size=14, value="RETURN COD. = ")
            IString filler002() ;
            
            @Data(size=4, value="0", rpadding=87, rpaddingValue="")
            IInt impReturnCode() ;
            
        }
        
        public interface Linha0602 extends IDataStruct {
            
            @Data(size=65, value=" ", lpadding=16, rpadding=40, lpaddingValue=" ", rpaddingValue=" ")
            IString impMens1() ;
            
        }
        
        public interface Linha09 extends IDataStruct {
            
            @Data(size=41, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgStatus() ;
            
            @Data(format="+ZZZZZZZ9", lpadding=2, rpadding=52, lpaddingValue=" ", rpaddingValue=" ")
            IFormattedString impStatus() ;
            
        }
        
        public interface Linha10 extends IDataStruct {
            
            @Data(size=105, value=" ", lpadding=16, lpaddingValue=" ")
            IString msgLivre() ;
            
        }
    }
    public interface TabelaImpressaoMask extends IDataMask {
        
        @Data(length=10, size=121)
        IArray<IString> zimp() ;
        
        
    }
    
}
