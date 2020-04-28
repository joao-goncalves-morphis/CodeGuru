package cgd.gh.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghr1702 extends IDataStruct {
    
    /**
     * @return instancia da classe local Registo
     */
    @Data
    Registo registo() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * LAYOUT DO FICHEIRO DE DONNEES PAIEMENTS PARA ENVIO PARA O BCL
     * 
     * @version 2.0
     * 
     */
    public interface Registo extends IDataStruct {
        
        @Data(size=400)
        IString componentComum() ;
        
        /**
         * HEADER
         * @return instancia da classe local Header
         */
        @Data
        @Mask
        Header header() ;
        
        /**
         * DETALHE V11 - Ficheiro com o detalhe dos registos de movimentos
         * de transferencias entre Clientes, sendo que uma das
         * partes envolvidas na transferencia nao e um Banco
         * @return instancia da classe local DetalheV11
         */
        @Data
        @Mask
        DetalheV11 detalheV11() ;
        
        /**
         * DETALHE V12 - Ficheiro com o detalhe dos registos de movimentos
         * de transferencias entre dois Bancos (Sempre que for
         * um movimento Nostro/Vostro)
         * @return instancia da classe local DetalheV12
         */
        @Data
        @Mask
        DetalheV12 detalheV12() ;
        
        /**
         * DETALHE V13 - Ficheiro com o detalhe dos registos de
         * Domiciliacoes (Debitos Directos)
         * @return instancia da classe local DetalheV13
         */
        @Data
        @Mask
        DetalheV13 detalheV13() ;
        
        /**
         * DETALHE V14 - Ficheiro com o Inventario de Cartoes
         * @return instancia da classe local DetalheV14
         */
        @Data
        @Mask
        DetalheV14 detalheV14() ;
        
        /**
         * DETALHE V15 - Ficheiro com os movimentos de Cartoes de Debito
         * @return instancia da classe local DetalheV15
         */
        @Data
        @Mask
        DetalheV15 detalheV15() ;
        
        /**
         * DETALHE V16 - Ficheiro com os movimentos de Cartoes Acquiring
         * @return instancia da classe local DetalheV16
         */
        @Data
        @Mask
        DetalheV16 detalheV16() ;
        
        /**
         * DETALHE V17 - Ficheiro com os movimentos de Cheques e
         * Mandatos de Pagamento
         * @return instancia da classe local DetalheV17
         */
        @Data
        @Mask
        DetalheV17 detalheV17() ;
        
        /**
         * DETALHE V18 - Ficheiro com os movimentos de Monaie Electronico
         * @return instancia da classe local DetalheV18
         */
        @Data
        @Mask
        DetalheV18 detalheV18() ;
        
        /**
         * DETALHE V111 - Ficheiro com os movimentos OTC (over the counter)
         * @return instancia da classe local DetalheV111
         */
        @Data
        @Mask
        DetalheV111 detalheV111() ;
        
        /**
         * DETALHE V112 - Ficheiro com os movimentos de transaccoes via tel
         * nicacoes digitais ou aparelhos IT  (transaction via telecommunic
         * ations, digital or IT device).
         * @return instancia da classe local DetalheV112
         */
        @Data
        @Mask
        DetalheV112 detalheV112() ;
        
        
        
        /**
         * 
         * HEADER
         * 
         * @version 2.0
         * 
         */
        public interface Header extends IDataMask {
            
            @Data(size=3)
            IString cVersao() ;
            @Data
            @Condition("V05")
            ICondition cVersaoV05() ;
            
            
            /**
             * GHXYZ-FIM: O C-VERSAO PASSA A SER FORMATADO POR SYSIN.
             * 10 BGHR1702-C-ID-FICH                   PIC  X(03).
             * 88 BGHR1702-C-ID-FICH-V11               VALUE 'V11'.
             * 88 BGHR1702-C-ID-FICH-V12               VALUE 'V12'.
             * 88 BGHR1702-C-ID-FICH-V17               VALUE 'V17'.
             * 88 BGHR1702-C-ID-FICH-V13               VALUE 'V13'.
             * 88 BGHR1702-C-ID-FICH-V15               VALUE 'V15'.
             */
            @Data(size=4)
            IString cIdFich() ;
            @Data
            @Condition("V101")
            ICondition cIdFichV101() ;
            @Data
            @Condition("V102")
            ICondition cIdFichV102() ;
            @Data
            @Condition("V107")
            ICondition cIdFichV107() ;
            @Data
            @Condition("V103")
            ICondition cIdFichV103() ;
            @Data
            @Condition("V105")
            ICondition cIdFichV105() ;
            @Data
            @Condition("V111")
            ICondition cIdFichV111() ;
            @Data
            @Condition("V112")
            ICondition cIdFichV112() ;
            
            
            /**
             * 10 BGHR1702-C-BANCO                     PIC  9(03).
             * 10 BGHR1702-C-BANCO                     PIC  X(04).
             */
            @Data(size=5)
            IString cBanco() ;
            
            @Data(size=4)
            IString zAnoMov() ;
            
            @Data(size=2)
            IString zMesMov() ;
            
            /**
             * 10 BGHR1702-FILLER-HEADER               PIC  X(384).
             */
            @Data(size=382)
            IString fillerHeader() ;
            
        }
        
        
        /**
         * 
         * DETALHE V11 - Ficheiro com o detalhe dos registos de movimentos
         * de transferencias entre Clientes, sendo que uma das
         * partes envolvidas na transferencia nao e um Banco
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV11 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV11() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V11() ;
            @Data
            @Condition("2")
            ICondition iTipMov2V11() ;
            
            
            @Data(size=8)
            IString zOperacaoV11() ;
            
            @Data(size=4)
            IString cTipPagmtoV11() ;
            @Data
            @Condition("VIRE")
            ICondition cTipPagmtoVireV11() ;
            @Data
            @Condition("VERS")
            ICondition cTipPagmtoVersV11() ;
            
            
            @Data(size=3)
            IString typeRTransV11() ;
            
            @Data(size=4)
            IString customerCatgV11() ;
            @Data
            @Condition("INCO")
            ICondition custmCatgV11Inco() ;
            
            
            @Data(size=4)
            IString cTipLqzPagV11() ;
            @Data
            @Condition("STE2")
            ICondition cTipLqzPagSt2V11() ;
            @Data
            @Condition("ONUS")
            ICondition cTipLqzPagOnsV11() ;
            @Data
            @Condition("CASH")
            ICondition cTipLqzPagCasV11() ;
            @Data
            @Condition("NOLO")
            ICondition cTipLqzPagNolV11() ;
            @Data
            @Condition("AUTR")
            ICondition cTipLqzPagAutV11() ;
            
            
            @Data(size=3)
            IString cTipClienteV11() ;
            
            @Data(size=3)
            IString cTipDirMovV11() ;
            @Data
            @Condition("EMI")
            ICondition cTipDirMovEmiV11() ;
            @Data
            @Condition("REC")
            ICondition cTipDirMovRecV11() ;
            
            
            @Data(size=1)
            IString iMovSepaV11() ;
            @Data
            @Condition("O")
            ICondition iMovSepaOV11() ;
            @Data
            @Condition("N")
            ICondition iMovSepaNV11() ;
            
            
            /**
             * 10 BGHR1702-I-FORM-PAPEL-V11            PIC  X(01).
             * 88 BGHR1702-I-FORM-PAPEL-O-V11          VALUE 'O'.
             * 88 BGHR1702-I-FORM-PAPEL-N-V11          VALUE 'N'.
             */
            @Data(size=5)
            IString cOrigOrdem() ;
            @Data
            @Condition("PAPER")
            ICondition cOrigOrdemPpV11() ;
            @Data
            @Condition("SINWB")
            ICondition cOrigOrdemSwV11() ;
            @Data
            @Condition("ELFBA")
            ICondition cOrigOrdemElV11() ;
            
            
            @Data(size=2)
            IString cPaisDestOperV11() ;
            
            @Data(size=2)
            IString cPaisOrigOperV11() ;
            
            @Data(size=15)
            ILong qVolumeRegV11() ;
            
            @Data(size=18, decimal=3)
            IDecimal mMovimentoV11() ;
            
            @Data(size=2)
            IInt mMovFillerV11() ;
            
            /**
             * 10 BGHR1702-I-MOVIMENTO-V11             PIC  X(01).
             * 88 BGHR1702-I-MOVIMENTO-NEG-V11         VALUE '-'.
             * 88 BGHR1702-I-MOVIMENTO-POS-V11         VALUE '+'.
             */
            @Data(size=3)
            IString cMoedMovV11() ;
            
            @Data(size=255)
            IString xDescritivoV11() ;
            
            /**
             * 10 BGHR1702-FILLER-V11                  PIC  X(71).
             */
            @Data(size=67)
            IString fillerV11() ;
            
        }
        
        
        /**
         * 
         * DETALHE V12 - Ficheiro com o detalhe dos registos de movimentos
         * de transferencias entre dois Bancos (Sempre que for
         * um movimento Nostro/Vostro)
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV12 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV12() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V12() ;
            @Data
            @Condition("2")
            ICondition iTipMov2V12() ;
            
            
            @Data(size=8)
            IString zOperacaoV12() ;
            
            @Data(size=4)
            IString cTipPagmtoV12() ;
            @Data
            @Condition("VIRE")
            ICondition cTipPagmtoVireV12() ;
            
            
            @Data(size=4)
            IString cTipLqzPagV12() ;
            @Data
            @Condition("TAR2")
            ICondition cTipLqzPagTarV12() ;
            @Data
            @Condition("AUTR")
            ICondition cTipLqzPagAutV12() ;
            
            
            @Data(size=3)
            IString cTipClienteV12() ;
            @Data
            @Condition("BAL")
            ICondition cTipClienteBalV12() ;
            
            
            @Data(size=3)
            IString cTipDirMovV12() ;
            @Data
            @Condition("EMI")
            ICondition cTipDirMovEmiV12() ;
            @Data
            @Condition("REC")
            ICondition cTipDirMovRecV12() ;
            
            
            @Data(size=1)
            IString iMovSepaV12() ;
            @Data
            @Condition("O")
            ICondition iMovSepaOV12() ;
            @Data
            @Condition("N")
            ICondition iMovSepaNV12() ;
            
            
            @Data(size=1)
            IString iFormPapelV12() ;
            @Data
            @Condition("O")
            ICondition iFormPapelOV12() ;
            @Data
            @Condition("N")
            ICondition iFormPapelNV12() ;
            
            
            @Data(size=2)
            IString cPaisDestOperV12() ;
            
            @Data(size=15)
            ILong qVolumeRegV12() ;
            
            @Data(size=18, decimal=3)
            IDecimal mMovimentoV12() ;
            
            @Data(size=2)
            IInt mMovFillerV12() ;
            
            /**
             * 10 BGHR1702-I-MOVIMENTO-V12             PIC  X(01).
             * 88 BGHR1702-I-MOVIMENTO-NEG-V12         VALUE '-'.
             * 88 BGHR1702-I-MOVIMENTO-POS-V12         VALUE '+'.
             */
            @Data(size=3)
            IString cMoedMovV12() ;
            
            @Data(size=255)
            IString xDescritivoV12() ;
            
            @Data(size=80)
            IString fillerV12() ;
            
        }
        
        
        /**
         * 
         * DETALHE V13 - Ficheiro com o detalhe dos registos de
         * Domiciliacoes (Debitos Directos)
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV13 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV13() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V13() ;
            @Data
            @Condition("2")
            ICondition iTipMov2V13() ;
            
            
            @Data(size=8)
            IString zOperacaoV13() ;
            
            @Data(size=4)
            IString cTipPagmtoV13() ;
            @Data
            @Condition("DEDE")
            ICondition cTipPagmtoDedeV13() ;
            @Data
            @Condition("RESC")
            ICondition cTipPagmtoRescV13() ;
            
            
            @Data(size=3)
            IString typeRTransV13() ;
            
            @Data(size=4)
            IString customerCatgV13() ;
            @Data
            @Condition("INCO")
            ICondition custmCatgV13Inco() ;
            
            
            @Data(size=3)
            IString sddSchemeV13() ;
            
            @Data(size=5)
            IString cOrigPagV13() ;
            
            @Data(size=4)
            IString cTipLqzPagV13() ;
            @Data
            @Condition("TAR2")
            ICondition cTipLqzPagTarV13() ;
            @Data
            @Condition("ONUS")
            ICondition cTipLqzPagOnsV13() ;
            @Data
            @Condition("NOLO")
            ICondition cTipLqzPagNolV13() ;
            @Data
            @Condition("AUTR")
            ICondition cTipLqzPagAutV13() ;
            
            
            @Data(size=3)
            IString cTipCnlTrmV13() ;
            @Data
            @Condition("DOM")
            ICondition cTipCnlTrmDomV13() ;
            @Data
            @Condition("INC")
            ICondition cTipCnlTrmIncV13() ;
            
            
            @Data(size=2)
            IString cPaisDestOperV13() ;
            
            @Data(size=2)
            IString cPaisOrigOperV13() ;
            
            @Data(size=15)
            ILong qVolumeRegV13() ;
            
            @Data(size=18, decimal=3)
            IDecimal mMovimentoV13() ;
            
            @Data(size=2)
            IInt mMovFillerV13() ;
            
            /**
             * 10 BGHR1702-I-MOVIMENTO-V13             PIC  X(01).
             * 88 BGHR1702-I-MOVIMENTO-NEG-V13         VALUE '-'.
             * 88 BGHR1702-I-MOVIMENTO-POS-V13         VALUE '+'.
             */
            @Data(size=3)
            IString cMoedMovV13() ;
            
            @Data(size=255)
            IString xDescritivoV13() ;
            
            /**
             * 10 BGHR1702-FILLER-V13                  PIC  X(73).
             */
            @Data(size=68)
            IString fillerV13() ;
            
        }
        
        
        /**
         * 
         * DETALHE V14 - Ficheiro com o Inventario de Cartoes
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV14 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV14() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V14() ;
            
            
            @Data(size=8)
            IString zOperacaoV14() ;
            
            @Data(size=4)
            IString cTipPagmtoV14() ;
            @Data
            @Condition("CADE")
            ICondition cTipPagmtoCadeV14() ;
            
            
            @Data(size=4)
            IString cTipShemeV14() ;
            @Data
            @Condition("VPAY")
            ICondition cTipShemeVpayV14() ;
            
            
            @Data(size=3)
            IString cTipTerminalV14() ;
            
            @Data(size=3)
            IString cTipOperV14() ;
            
            @Data(size=2)
            IString cPaisOrigOrdemV14() ;
            
            @Data(size=15)
            ILong qVolumeV14() ;
            
            @Data(size=15)
            ILong qVolClienteV14() ;
            
            @Data(size=15)
            ILong qVolOtrEntV14() ;
            
            @Data(size=18, decimal=3)
            IDecimal mValorV14() ;
            
            @Data(size=2)
            IInt mValFillerV14() ;
            
            @Data(size=1)
            IString iValorV14() ;
            @Data
            @Condition("-")
            ICondition iValorNegV14() ;
            @Data
            @Condition("+")
            ICondition iValorPosV14() ;
            
            
            @Data(size=18, decimal=3)
            IDecimal mVariacaoV14() ;
            
            @Data(size=2)
            IInt mVarFillerV14() ;
            
            @Data(size=1)
            IString iVariacaoV14() ;
            @Data
            @Condition("-")
            ICondition iVariacaoNegV14() ;
            @Data
            @Condition("+")
            ICondition iVariacaoPosV14() ;
            
            
            @Data(size=3)
            IString cMoedMovV14() ;
            
            @Data(size=255)
            IString xDescritivoV14() ;
            
            @Data(size=30)
            IString fillerV14() ;
            
        }
        
        
        /**
         * 
         * DETALHE V15 - Ficheiro com os movimentos de Cartoes de Debito
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV15 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV15() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V15() ;
            
            
            @Data(size=8)
            IString zOperacaoV15() ;
            
            @Data(size=4)
            IString cTipPagmtoV15() ;
            @Data
            @Condition("CADE")
            ICondition cTipPagmtoCadeV15() ;
            
            
            @Data(size=4)
            IString cTipShemeV15() ;
            @Data
            @Condition("MAES")
            ICondition cTipShemeMaesV15() ;
            @Data
            @Condition("VPAY")
            ICondition cTipShemeVpayV15() ;
            @Data
            @Condition("VISA")
            ICondition cTipShemeVisaV15() ;
            @Data
            @Condition("MAST")
            ICondition cTipShemeMastV15() ;
            @Data
            @Condition("AUTR")
            ICondition cTipShemeAutrV15() ;
            
            
            @Data(size=3)
            IString cTipTerminalV15() ;
            @Data
            @Condition("ATM")
            ICondition cTipTermAtmV15() ;
            @Data
            @Condition("POS")
            ICondition cTipTermPosV15() ;
            @Data
            @Condition("ECO")
            ICondition cTipTermEcoV15() ;
            @Data
            @Condition("IMP")
            ICondition cTipTermImpV15() ;
            @Data
            @Condition("AUT")
            ICondition cTipTermAutV15() ;
            
            
            @Data(size=3)
            IString cTipOperV15() ;
            @Data
            @Condition("SAL")
            ICondition cTipOperSalV15() ;
            @Data
            @Condition("ATM")
            ICondition cTipOperAtmV15() ;
            @Data
            @Condition("CAS")
            ICondition cTipOperCasV15() ;
            @Data
            @Condition("AUT")
            ICondition cTipOperAutV15() ;
            @Data
            @Condition("CRE")
            ICondition cTipOperCreV15() ;
            
            
            @Data(size=3)
            IString cTipModAceiV15() ;
            @Data
            @Condition("CON")
            ICondition cTipMoAceiConV15() ;
            @Data
            @Condition("ONL")
            ICondition cTipMoAceiOnlV15() ;
            
            
            @Data(size=2)
            IString cPaisOrigOperV15() ;
            
            @Data(size=15)
            ILong qVolumeV15() ;
            
            @Data(size=18, decimal=3)
            IDecimal mValorV15() ;
            
            @Data(size=2)
            IInt mValFillerV15() ;
            
            /**
             * 10 BGHR1702-I-VALOR-V15                 PIC  X(01).
             * 88 BGHR1702-I-VALOR-NEG-V15             VALUE '-'.
             * 88 BGHR1702-I-VALOR-POS-V15             VALUE '+'.
             */
            @Data(size=3)
            IString cMoedMovV15() ;
            
            @Data(size=255)
            IString xDescritivoV15() ;
            
            @Data(size=79)
            IString fillerV15() ;
            
        }
        
        
        /**
         * 
         * DETALHE V16 - Ficheiro com os movimentos de Cartoes Acquiring
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV16 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV16() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V16() ;
            
            
            @Data(size=8)
            IString zOperacaoV16() ;
            
            @Data(size=4)
            IString cTipPagmtoV16() ;
            @Data
            @Condition("CADE")
            ICondition cTipPagmtoCadeV16() ;
            @Data
            @Condition("CACR")
            ICondition cTipPagmtoCacrV16() ;
            @Data
            @Condition("CAMI")
            ICondition cTipPagmtoCamiV16() ;
            @Data
            @Condition("CAPR")
            ICondition cTipPagmtoCaprV16() ;
            
            
            @Data(size=4)
            IString cTipShemeV16() ;
            @Data
            @Condition("VPAY")
            ICondition cTipShemeVpayV16() ;
            @Data
            @Condition("MAES")
            ICondition cTipShemeMaesV16() ;
            @Data
            @Condition("VISA")
            ICondition cTipShemeVisaV16() ;
            @Data
            @Condition("MAST")
            ICondition cTipShemeMastV16() ;
            @Data
            @Condition("AUTR")
            ICondition cTipShemeAutrV16() ;
            
            
            @Data(size=3)
            IString cTipTerminalV16() ;
            @Data
            @Condition("ATM")
            ICondition cTipTermAtmV16() ;
            @Data
            @Condition("POS")
            ICondition cTipTermPosV16() ;
            @Data
            @Condition("ECO")
            ICondition cTipTermEcoV16() ;
            @Data
            @Condition("IMP")
            ICondition cTipTermImpV16() ;
            @Data
            @Condition("AUT")
            ICondition cTipTermAutV16() ;
            
            
            @Data(size=3)
            IString cTipOperV16() ;
            @Data
            @Condition("SAL")
            ICondition cTipOperSalV16() ;
            @Data
            @Condition("ATM")
            ICondition cTipOperAtmV16() ;
            @Data
            @Condition("AUT")
            ICondition cTipOperAutV16() ;
            @Data
            @Condition("CRE")
            ICondition cTipOperCreV16() ;
            
            
            @Data(size=3)
            IString cTipModAceiV16() ;
            @Data
            @Condition("CON")
            ICondition cTipMdAceiConV16() ;
            @Data
            @Condition("ONL")
            ICondition cTipMdAceiOnlV16() ;
            @Data
            @Condition("COF")
            ICondition cTipMdAceiCofV16() ;
            @Data
            @Condition("INC")
            ICondition cTipMdAceiIncV16() ;
            @Data
            @Condition("MAN")
            ICondition cTipMdAceiManV16() ;
            @Data
            @Condition("OFL")
            ICondition cTipMdAceiOflV16() ;
            
            
            @Data(size=2)
            IString cPaisOrigCartV16() ;
            
            @Data(size=2)
            IString cPaisOrigOperV16() ;
            
            @Data(size=15)
            ILong qVolumeV16() ;
            
            @Data(size=18, decimal=3)
            IDecimal mValorV16() ;
            
            @Data(size=2)
            IInt mValFillerV16() ;
            
            @Data(size=1)
            IString iValorV16() ;
            @Data
            @Condition("-")
            ICondition iValorNegV16() ;
            @Data
            @Condition("+")
            ICondition iValorPosV16() ;
            
            
            @Data(size=3)
            IString cMoedMovV16() ;
            
            @Data(size=255)
            IString xDescritivoV16() ;
            
            @Data(size=76)
            IString fillerV16() ;
            
        }
        
        
        /**
         * 
         * DETALHE V17 - Ficheiro com os movimentos de Cheques e
         * Mandatos de Pagamento
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV17 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV17() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V17() ;
            @Data
            @Condition("2")
            ICondition iTipMov2V17() ;
            
            
            @Data(size=8)
            IString zOperacaoV17() ;
            
            @Data(size=4)
            IString cTipPagmtoV17() ;
            @Data
            @Condition("CHEQ")
            ICondition cTipPagmtoCheqV17() ;
            
            
            @Data(size=3)
            IString cTipCnlTrmV17() ;
            @Data
            @Condition("ONU")
            ICondition cTipCnlTrmOnuV17() ;
            @Data
            @Condition("BIL")
            ICondition cTipCnlTrmBilV17() ;
            
            
            @Data(size=2)
            IString cPaisOrigOperV17() ;
            
            @Data(size=15)
            ILong qVolumeV17() ;
            
            @Data(size=18, decimal=3)
            IDecimal mValorV17() ;
            
            @Data(size=2)
            IInt mValFillerV17() ;
            
            /**
             * 10 BGHR1702-I-VALOR-V17                 PIC  X(01).
             * 88 BGHR1702-I-VALOR-NEG-V17             VALUE '-'.
             * 88 BGHR1702-I-VALOR-POS-V17             VALUE '+'.
             */
            @Data(size=3)
            IString cMoedMovV17() ;
            
            @Data(size=255)
            IString xDescritivoV17() ;
            
            @Data(size=89)
            IString fillerV17() ;
            
        }
        
        
        /**
         * 
         * DETALHE V18 - Ficheiro com os movimentos de Monaie Electronico
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV18 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV18() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V18() ;
            @Data
            @Condition("2")
            ICondition iTipMov2V18() ;
            @Data
            @Condition("3")
            ICondition iTipMov3V18() ;
            @Data
            @Condition("4")
            ICondition iTipMov4V18() ;
            @Data
            @Condition("5")
            ICondition iTipMov5V18() ;
            
            
            @Data(size=8)
            IString zOperacaoV18() ;
            
            @Data(size=4)
            IString cTipPagmtoV18() ;
            @Data
            @Condition("SCME")
            ICondition cTipPagmtoScmeV18() ;
            
            
            @Data(size=4)
            IString cTipShemeV18() ;
            @Data
            @Condition("AUTR")
            ICondition cTipShemeAutrV18() ;
            @Data
            @Condition("SUCA")
            ICondition cTipShemeSucaV18() ;
            @Data
            @Condition("SURE")
            ICondition cTipShemeSureV18() ;
            
            
            @Data(size=3)
            IString cTipTerminalV18() ;
            @Data
            @Condition("POS")
            ICondition cTipTermPosV18() ;
            @Data
            @Condition("TCH")
            ICondition cTipTermTchV18() ;
            
            
            @Data(size=3)
            IString cOrgCarrgV18() ;
            @Data
            @Condition("COB")
            ICondition cOrgCarrgCobV18() ;
            @Data
            @Condition("CAP")
            ICondition cOrgCarrgCapV18() ;
            @Data
            @Condition("AUT")
            ICondition cOrgCarrgAutV18() ;
            
            
            @Data(size=3)
            IString cTipOperV18() ;
            @Data
            @Condition("CHA")
            ICondition cTipOperChaV18() ;
            @Data
            @Condition("DCH")
            ICondition cTipOperDchV18() ;
            @Data
            @Condition("TEM")
            ICondition cTipOperTemV18() ;
            @Data
            @Condition("TRE")
            ICondition cTipOperTreV18() ;
            @Data
            @Condition("DDE")
            ICondition cTipOperDdeV18() ;
            
            
            @Data(size=3)
            IString cNvlActvV18() ;
            @Data
            @Condition("ACT")
            ICondition cNvlActvActV18() ;
            @Data
            @Condition("INA")
            ICondition cNvlActvInaV18() ;
            
            
            @Data(size=2)
            IString cPaisInterV18() ;
            
            @Data(size=2)
            IString cPaisResidenciaV18() ;
            
            @Data(size=15)
            ILong qVolClienteV18() ;
            
            @Data(size=15)
            ILong qVolOtrEntV18() ;
            
            @Data(size=15)
            ILong qVolumeV18() ;
            
            @Data(size=18, decimal=3)
            IDecimal mValorV18() ;
            
            @Data(size=2)
            IInt mValFillerV18() ;
            
            @Data(size=1)
            IString iValorV18() ;
            @Data
            @Condition("-")
            ICondition iValorNegV18() ;
            @Data
            @Condition("+")
            ICondition iValorPosV18() ;
            
            
            @Data(size=18, decimal=3)
            IDecimal mVariacaoV18() ;
            
            @Data(size=2)
            IInt mValFillerV1802() ;
            
            @Data(size=1)
            IString iVariacaoV18() ;
            @Data
            @Condition("-")
            ICondition iVariacaoNegV18() ;
            @Data
            @Condition("+")
            ICondition iVariacaoPosV18() ;
            
            
            @Data(size=3)
            IString cMoedMovV18() ;
            
            @Data(size=255)
            IString xDescritivoV18() ;
            
            @Data(size=22)
            IString fillerV18() ;
            
        }
        
        
        /**
         * 
         * DETALHE V111 - Ficheiro com os movimentos OTC (over the counter)
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV111 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV111() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V111() ;
            
            
            /**
             * 88 BGHR1702-I-TIP-MOV-2-V111            VALUE '2'.
             */
            @Data(size=8)
            IString zOperacaoV111() ;
            
            @Data(size=3)
            IString cTipOperV111() ;
            @Data
            @Condition("DEP")
            ICondition cTipOperDepV111() ;
            @Data
            @Condition("WIT")
            ICondition cTipOperWitV111() ;
            
            
            @Data(size=15)
            ILong qVolumeRegV111() ;
            
            @Data(size=18, decimal=3)
            IDecimal mValorV111() ;
            
            @Data(size=2)
            IInt mValFillerV111() ;
            
            @Data(size=3)
            IString cMoedMovV111() ;
            
            @Data(size=255)
            IString xDescritivoV111() ;
            
            @Data(size=95)
            IString fillerV111() ;
            
        }
        
        
        /**
         * 
         * DETALHE V112 - Ficheiro com os movimentos de transaccoes via tel
         * nicacoes digitais ou aparelhos IT  (transaction via telecommunic
         * ations, digital or IT device).
         * 
         * @version 2.0
         * 
         */
        public interface DetalheV112 extends IDataMask {
            
            @Data(size=1)
            IString iTipMovV112() ;
            @Data
            @Condition("1")
            ICondition iTipMov1V112() ;
            
            
            /**
             * 88 BGHR1702-I-TIP-MOV-2-V112            VALUE '2'.
             */
            @Data(size=8)
            IString zOperacaoV112() ;
            
            @Data(size=3)
            IString cTipOperV112() ;
            @Data
            @Condition("ITT")
            ICondition cTipOperIttV112() ;
            
            
            @Data(size=3)
            IString cTipDirMovV112() ;
            @Data
            @Condition("EMI")
            ICondition cTipDirMovEmV112() ;
            @Data
            @Condition("REC")
            ICondition cTipDirMovReV112() ;
            
            
            @Data(size=2)
            IString cPaisDestOperV112() ;
            
            @Data(size=15)
            ILong qVolumeRegV112() ;
            
            @Data(size=18, decimal=3)
            IDecimal mValorV112() ;
            
            @Data(size=2)
            IInt mValFillerV112() ;
            
            @Data(size=3)
            IString cMoedMovV112() ;
            
            @Data(size=255)
            IString xDescritivoV112() ;
            
            @Data(size=90)
            IString fillerV112() ;
            
        }
    }
    
}
