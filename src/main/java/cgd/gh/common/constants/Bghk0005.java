package cgd.gh.common.constants;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bghk0005 extends IDataStruct {
    
    /**
     * @return instancia da classe local LimitesMontanteNum
     */
    @Data
    LimitesMontanteNum limitesMontanteNum() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BGHK0005
     * TERC - COPY DE LIMITES DOS MONTANTES EM NUMERARIO
     * GH
     * 
     * @version 2.0
     * 
     */
    public interface LimitesMontanteNum extends IDataStruct {
        
        /**
         * *I* ENTREGAS (ETG) ***
         * *-1- ITVT PROPRIO(P) / CTA PARTICULAR(P) SEM RISCO
         */
        @Data(size=5, value="15000")
        IInt etgNmriPp() ;
        
        @Data(size=5, value="15000")
        IInt acmdDepPp() ;
        
        @Data(size=5, value="15000")
        IInt acmdCtaPp() ;
        
        /**
         * *-2- ITVT TERCEIRO(T) / CTA PARTICULAR(P) COM E SEM RISCO(RISC)
         */
        @Data(size=5, value="5000")
        IInt etgNmriTpRisc() ;
        
        @Data(size=4, value="5000")
        IInt acmdDepTpRisc() ;
        
        @Data(size=5, value="10000")
        IInt etgNmriTp() ;
        
        @Data(size=5, value="10000")
        IInt acmdDepTp() ;
        
        /**
         * *-3- ITVT PROPRIO(P) OU MANDATARIO(M) / CTA EMPRESA(E)
         */
        @Data(size=5, value="15000")
        IInt etgNmriPe() ;
        
        @Data(size=5, value="15000")
        IInt acmdDepPe() ;
        
        @Data(size=5, value="15000")
        IInt acmdCtaPe() ;
        
        @Data(size=5, value="15000")
        IInt etgNmriMe() ;
        
        /**
         * *-4- ITVT TERCEIRO(T) / CTA EMPRESA(E) COM E SEM RISCO E EMPRESAS
         * COM E SEM EXCECAO(EXC)
         */
        @Data(size=5, value="5000")
        IInt etgNmriTeRisc() ;
        
        @Data(size=4, value="5000")
        IInt acmdDepTeRisc() ;
        
        @Data(size=5, value="15000")
        IInt etgNmriTeExc() ;
        
        @Data(size=5, value="15000")
        IInt acmdDepTeExc() ;
        
        @Data(size=5, value="10000")
        IInt etgNmriTe() ;
        
        @Data(size=5, value="10000")
        IInt acmdDepTe() ;
        
        /**
         * *-5- ITVT DEPÓSITO EXPRESSO 24H
         */
        @Data(size=5, value="10000")
        IInt etgNmri24() ;
        
        /**
         * *-ATS-
         */
        @Data(size=5, value="15000")
        IInt etgNmriAts() ;
        
        @Data(size=5, value="15000")
        IInt acmdDepAts() ;
        
        @Data(size=5, value="15000")
        IInt acmdCtaAts() ;
        
        /**
         * *F* ENTREGAS ***
         * *I* LEVANTAMENTOS (LEV) / PAGAMENTO DE CHEQUES (CHQ) ***
         * *-1- ITVT PROPRIO(P) / CTA PARTICULAR(P)
         */
        @Data(size=5, value="15000")
        IInt levNmriPp() ;
        
        @Data(size=5, value="15000")
        IInt acmdItvLevPp() ;
        
        @Data(size=5, value="15000")
        IInt acmdLevCtaPp() ;
        
        /**
         * *-2- ITVT PROPRIO(P) / CTA EMPRESA(E)
         */
        @Data(size=5, value="15000")
        IInt levNmriPe() ;
        
        @Data(size=5, value="15000")
        IInt acmdItvLevPe() ;
        
        @Data(size=5, value="15000")
        IInt acmdLevCtaPe() ;
        
        /**
         * *-3- BENEFICIARIO CHEQUE(B) / CTA PARTICULAR(P)
         */
        @Data(size=5, value="15000")
        IInt chqNmriBp() ;
        
        @Data(size=5, value="15000")
        IInt acmdChqBp() ;
        
        /**
         * *-4- BENEFICIARIO CHEQUE(B) / CTA EMPRESA(E)
         */
        @Data(size=5, value="15000")
        IInt chqNmriBe() ;
        
        @Data(size=5, value="15000")
        IInt acmdChqBe() ;
        
        /**
         * *-ATS-
         * **  05 BGHK0005-LEV-NMRI-ATS       PIC  9(05)  VALUE 15000.
         */
        @Data(size=5, value="15000")
        IInt acmdItvLevAts() ;
        
        @Data(size=5, value="15000")
        IInt acmdLevCtaAts() ;
        
        /**
         * *F* LEVANTAMENTOS (LEV) / PAGAMENTO DE CHEQUES (CHQ) ***
         * *I* OCASIONAIS (OCA) ***
         * *-1- TIPO ITVT ORDENANTE(O) / TIPO CLIENTE PARTICULAR/ENI(P)
         */
        @Data(size=5, value="15000")
        IInt montOpeOcaOp() ;
        
        @Data(size=5, value="15000")
        IInt acmdItvOcaOp() ;
        
        /**
         * *-2- TIPO ITVT BENEFICIARIO(B) / TIPO CLIENTE PARTICULAR/ENI(P)
         */
        @Data(size=5, value="15000")
        IInt montOpeOcaBp() ;
        
        @Data(size=5, value="15000")
        IInt acmdItvOcaBp() ;
        
        /**
         * *-3- TIPO ITVT ORDENANTE(O) / TIPO CLIENTE EMPRESA(E)
         */
        @Data(size=5, value="15000")
        IInt montOpeOcaOe() ;
        
        @Data(size=5, value="15000")
        IInt acmdItvOcaOe() ;
        
        /**
         * *-4- TIPO ITVT BENEFICIARIO(B) / TIPO CLIENTE EMPRESA(E)
         */
        @Data(size=5, value="15000")
        IInt montOpeOcaBe() ;
        
        @Data(size=5, value="15000")
        IInt acmdItvOcaBe() ;
        
        /**
         * *F* OCASIONAIS (OCA) ***
         * PASSIVAS 4497 - UCO 2.7 - LEI Nº 83 OSI3656 (INI)
         * *-1- TIPO ITVT ORDENANTE(O) / TIPO CLIENTE PARTICULAR/ENI(P)
         */
        @Data(size=5, value="1000")
        IInt montOpeOcaOpLei83() ;
        
        @Data(size=5, value="1000")
        IInt acmdItvOcaOpLei83() ;
        
        /**
         * *-2- TIPO ITVT BENEFICIARIO(B) / TIPO CLIENTE PARTICULAR/ENI(P)
         */
        @Data(size=5, value="1000")
        IInt montOpeOcaBpLei83() ;
        
        @Data(size=5, value="1000")
        IInt acmdItvOcaBpLei83() ;
        
        /**
         * *-3- TIPO ITVT ORDENANTE(O) / TIPO CLIENTE EMPRESA(E)
         */
        @Data(size=5, value="1000")
        IInt montOpeOcaOeLei83() ;
        
        @Data(size=5, value="1000")
        IInt acmdItvOcaOeLei83() ;
        
        /**
         * *-4- TIPO ITVT BENEFICIARIO(B) / TIPO CLIENTE EMPRESA(E)
         */
        @Data(size=5, value="1000")
        IInt montOpeOcaBeLei83() ;
        
        @Data(size=5, value="1000")
        IInt acmdItvOcaBeLei83() ;
        
    }
    
}
