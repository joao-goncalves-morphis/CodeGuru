package cgd.hy.structures.link;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import morphis.framework.datatypes.masks.IDataMask ;
import morphis.framework.datatypes.annotations.Mask ;
import static morphis.framework.commons.StringHandling.* ;
import static morphis.framework.datatypes.serialization.Algorithm.* ;
import morphis.framework.datatypes.annotations.Condition ;
import morphis.framework.datatypes.conditions.ICondition ;
import morphis.framework.datatypes.conditions.IConditions ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhyl230a extends IDataStruct {
    
    /**
     * @return instancia da classe local Commarea
     */
    @Data
    Commarea commarea() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * BHYL230A - AREA DE LIGACAO COM A ROTINA
     * DE CONVERSAO E CALCULO DE DATAS
     * SEMPRE QUE ESTE COPY FOR ALTERADO O BHYL231A TAMBEM DEVERA SER
     * **  CAMPOS DE ENTRADA                                           **
     * **    BHYL230A-C-FUNZ-MDLO-DATA  -  CODIGO DO PROCESSAMENTO A   **
     * **                                  EFECTUAR                    **
     * **    BHYL230A-I-TIPO-EXE        -  INDICADOR DE TIPO DE EXECUCAO*
     * **                                  VALORE POSSIVEIS:           **
     * **                                  'B' - CALCULO BASE, DEVOLVE **
     * **                                        PROXIMA DATA UTIL E   **
     * **                                        ULTIMA DATA UTIL      **
     * **                                  'R' - REDUZIDA, NAO DEVOLVE **
     * **                                        A ULTIMA DATA UTIL NEM**
     * **                                        A PROXIMA DATA UTIL   **
     * **    BHYL230A-DAT-INPUT1        -   DATA INICIAL               **
     * **    BHYL230A-DAT-INPUT2        -   DATA FINAL                 **
     * **    BHYL230A-C-TIPO-PRAZ       -   TIPO DE PRAZO A CONVERTER  **
     * **    BHYL230A-DU-TIPO-PRAZ      -   DURACAO DO TIPO DE PRAZO   **
     * **    BHYL230A-DU-PRAZ-ANO       -   PRAZO EM ANOS              **
     * **    BHYL230A-DU-PRAZ-MES       -   PRAZO EM MESES             **
     * **    BHYL230A-DU-PRAZ-DIA       -   PRAZO EM DIAS              **
     * **    BHYL230A-C-OE-EGC          -   BALCAO A QUE SE REFERE A DT**
     * **    BHYL230A-C-PAIS-ISO-ALFN   -   COD. PAIS DO ORGAO DE ESTR.**
     * **    BHYL230A-C-MNEM-EMP-GCX    -   COD. DA EMPRESA DO OE      **
     * **  CAMPOS DE SAIDA                                             **
     * **    BHYL230A-Q-DIA-OUTP    -   DIAS RESULTANTES               **
     * **    BHYL230A-DAT-RES       -   DATA RESULTANTE                **
     * **    BHYL230A-Z-OUTPUT      -   DATA RESULTANTE EDITADA        **
     * **    BHYL230A-I-DIA-UTIL    -   TIPO DE DATA VALORES POSSIVEIS **
     * **                                   'U' - DIA UTIL             **
     * **                                   'N' - DIA NAO UTIL         **
     * **BHYL230A-N-DIA-SMN-DAT-OUTP - DIA DA SEMANA A QUE CORRESPONDE **
     * **                              A DATA RESULTANTE               **
     * **                              VALORES POSSIVEIS:              **
     * **                                   'D' - DOMINGO              **
     * **                                   '2' - SEGUNDA              **
     * **                                   '3' - TERCA                **
     * **                                   '4' - QUARTA               **
     * **                                   '5' - QUINTA               **
     * **                                   '6' - SEXTA                **
     * **                                   'S' - SABADO               **
     * **  BHYL230A-ZD-DATA-OUTPESC -   DATA RESULTANTE POR EXTENSO    **
     * **  BHYL230A-DAT-UT-ANT      -   DATA UTIL ANTERIOR             **
     * **  BHYL230A-Z-DIA-UTIL-ULT  -   DATA UTIL ANTERIOR EDITADA     **
     * **  BHYL230A-DAT-UT-POS      -   DATA UTIL POSTERIOR            **
     * **  BHYL230A-Z-DIA-UTIL-PROX -   DATA UTIL POSTERIOR EDITADA    **
     * **  CAMPOS DE CONTROLO DE CONTROLO:                             **
     * **  BHYL230A-I-TIPO-ERRO-BBN  -  CODIGO DE RETORNO              **
     * **                               VALORES POSSIVEIS:             **
     * **                                  'AT' - ERRO ARQUITECTURA    **
     * **                                  'A2' - ERRO DB2             **
     * **                                  '  ' - CALCULO EFECTUADO    **
     * **  BHYL230A-C-RTNO-EVEN-SWAL -   NUMERO DA MENSAGEM DE ERRO    **
     * **  FORMA DE UTILIZACAO:                                        **
     * **   CAMPOS DE ENTRADA NECESSARIOS PARA TODOS OS PROCESSOS:     **
     * **    BHYL230A-C-FUNZ-MDLO-DATA                                 **
     * **    BHYL230A-I-TIPO-EXE                                       **
     * **    BHYL230A-DAT-INPUT1                                       **
     * **    BHYL230A-C-OE-EGC                                         **
     * **   RELACAO CAMPOS DE ENTRADA / PROCESSOS                      **
     * **    BHYL230A-DAT-INPUT2    -   05 - 06                        **
     * **    BHYL230A-Z-IPUT-JULN   -   51 - 53 - 54 - 55              **
     * **                               56 - 57                        **
     * **    BHYL230A-C-TIPO-PRAZ   -   21 - 22 - 23 - 24              **
     * **    BHYL230A-DU-PRAZ-ANO   -   21 - 22 - 23 - 24              **
     * **    BHYL230A-DU-PRAZ-MES   -   21 - 22 - 23 - 24              **
     * **    BHYL230A-DU-PRAZ-DIA   -   21 - 22 - 23 - 24              **
     * **                               25 - 26 - 27 - 28              **
     * **                               56 - 57 - 33 - 34              **
     * **    BHYL230A-C-PAIS-ISO-ALFN - 02 - 04 - 22 - 24              **
     * **                               26 - 28 - 30 - 32              **
     * **   DESCRICAO DOS PROCESSOS                                    **
     * **    01  -  CALCULAR O PENULTIMO DIA UTIL DUM MES,             **
     * **           A PARTIR DE UMA DATA.                              **
     * **    02  -  CALCULAR O PENULTIMO DIA UTIL DUM MES C/EXTENSO,   **
     * **    03  -  CALCULAR O ULTIMO DIA UTIL DUM MES,                **
     * **    04  -  CALCULAR O ULTIMO DIA UTIL DUM MES C/EXTENSO,      **
     * **    05  -  CALCULAR A DIFERENCA ENTRE DUAS DATAS EM DIAS UTEIS**
     * **    06  -  CALCULAR A DIFERENCA ENTRE DUAS DATAS EM DIAS      **
     * **    07  -  CALCULAR O ULTIMO DIA UTIL DE UMA SEMANA, A PARTIR **
     * **           DE UMA DATA                                        **
     * **    08  -  RETORNA O PENULTIMO DIA DO MES                     **
     * **    09  -  RETORNA O ULTIMO DIA DO MES                        **
     * **    10  -  RETORNA O MESMO DIA SE ESTE FOR UTIL, SE NAO       **
     * **           RETORNA O DIA UTIL SEGUINTE                        **
     * **    11  -  RETORNA O PRIMEIRO DIA UTIL DO MES                 **
     * **    12  -  RETORNA A DATA DE CALCULO DE PERIODIFICACOES       **
     * **           SEMANAIS E ATE QUE DATA DEVE CALCULAR              **
     * **    21  -  CALCULA A DATA RESULTANTE DA ADICAO DUM PRAZO      **
     * **           A UMA DATA                                         **
     * **    22  -  CALCULA A DATA RESULTANTE, C/EXTENSO , DA ADICAO   **
     * **           DUM PRAZO A UMA DATA                               **
     * **    23  -  CALCULA A DATA RESULTANTE DA SUBTRACCAO DUM PRAZO  **
     * **    24  -  CALCULA A DATA RESULTANTE, C/EXTENSO , DA          **
     * **           SUBTRACCAO DUM PRAZO A UMA DATA                    **
     * **    25  -  CALCULA A DATA RESULTANTE DA ADICAO DE DIAS        **
     * **           UTEIS A UMA DATA                                   **
     * **    26  -  CALCULA A DATA RESULTANTE C/EXTENSO, DA ADICAO     **
     * **           DE DIAS UTEIS A UMA DATA                           **
     * **    27  -  CALCULA A DATA RESULTANTE DA SUBTRACCAO DE DIAS    **
     * **    28  -  CALCULA A DATA RESULTANTE C/EXTENSO, DA SUBTRACCAO **
     * **    29  -  CALCULA O PENULTIMO DIA UTIL DO MES, RESULTANTE    **
     * **           DA ADICAO DE UM PRAZO A UMA DATA                   **
     * **    30  -  CALCULA O PENULTIMO DIA UTIL DO MES, C/EXTENSO,    **
     * **           RESULTANTE DA ADICAO DE UM PRAZO A UMA DATA        **
     * **    31  -  CALCULA O ULTIMO DIA UTIL DO MES, RESULTANTE       **
     * **    32  -  CALCULA O ULTIMO DIA UTIL DO MES, C/EXTENSO,       **
     * **    33  -  CALCULAR A DATA RESULTANTE DA ADICAO DE DIAS       **
     * **    34  -  CALCULAR A DATA RESULTANTE DA SUBTRACAO DE DIAS    **
     * **    35  -  CALCULAR A DATA RESULTANTE DA SUBTRACAO DE UM      **
     * **           PRAZO A UMA DATA E RETORNA O 1 DIA DESSE MES       **
     * **    40  -  CALCULAR O ULTIMO DIA UTIL DO MES (CALCULO         **
     * **           LIQUIDACAO MENSAL)                                 **
     * **    41  -  CALCULAR O ULTIMO DIA UTIL DO TRIMESTRE CIVIL      **
     * **           (CALCULO LIQUIDACAO TRIMESTRAL)                    **
     * **    42  -  CALCULAR O ULTIMO DIA UTIL DO SEMESTRE CIVIL       **
     * **           (CALCULO LIQUIDACAO SEMESTRAL)                     **
     * **    43  -  CALCULAR O ULTIMO DIA UTIL ANUAL CIVIL             **
     * **           (CALCULO LIQUIDACAO ANUAL)                         **
     * **    50  -  CONVERTER UMA DATA GREGORIANA EM JULIANA SECULAR   **
     * **    51  -  CONVERTER UMA DATA JULIANA SECULAR EM GREGORIANA   **
     * **    52  -  CONVERTER UMA DATA GREGORIANA EM JULIANA ANUAL     **
     * **    53  -  CONVERTER UMA DATA JULIANA ANUAL EM GREGORIANA     **
     * **    54  -  SOMAR DIAS A UMA DATA JULIANA                      **
     * **    55  -  SUBTRAIR DIAS A UMA DATA JULIANA                   **
     * **    56  -  SOMAR DIAS UTEIS A UMA DATA JULIANA                **
     * **    57  -  SUBTRAIR DIAS UTEIS A AUMA DATA JULIANA            **
     * **    99  -  RETORNA O DIA DA SEMANA E O DESCRITIVO             **
     * 
     * @version 2.0
     * 
     */
    public interface Commarea extends IDataStruct {
        
        /**
         * @return instancia da classe local DadosEntrada
         */
        @Data
        DadosEntrada dadosEntrada() ;
        
        /**
         * @return instancia da classe local DadosSaida
         */
        @Data
        DadosSaida dadosSaida() ;
        
        
        public interface DadosEntrada extends IDataStruct {
            
            @Data(size=2)
            IString cFunzMdloData() ;
            
            @Data(size=1)
            IString iTipoExe() ;
            @Data
            @Condition("B")
            ICondition base() ;
            @Data
            @Condition("R")
            ICondition reduzido() ;
            
            
            @Data(size=10)
            IString datInput1() ;
            
            /**
             * @return instancia da classe local DatInput110
             */
            @Data
            @Mask
            DatInput110 datInput110() ;
            
            @Data(size=3)
            IString cMnemEmpGcx() ;
            
            @Data(size=3)
            IString cPaisIsoAlfn() ;
            
            @Data(size=4)
            IInt cOeEgc() ;
            
            @Data(size=10)
            IString datInput2() ;
            
            /**
             * @return instancia da classe local DatInput210
             */
            @Data
            @Mask
            DatInput210 datInput210() ;
            
            @Data(size=6)
            IInt zIputJuln() ;
            
            /**
             * @return instancia da classe local Prazo
             */
            @Data
            Prazo prazo() ;
            
            @Data(size=3)
            IInt duPrazAno() ;
            
            @Data(size=4)
            IInt duPrazMes() ;
            
            @Data(size=5)
            IInt duPrazDia() ;
            
            
            public interface DatInput110 extends IDataMask {
                
                @Data(size=4)
                IInt zaDataIpt1() ;
                
                @Data(size=2, lpadding=1)
                IInt zmDataIpt1() ;
                
                @Data(size=2, lpadding=1)
                IInt zdDataIpt1() ;
                
            }
            
            public interface DatInput210 extends IDataMask {
                
                @Data(size=4)
                IInt zaDataIpt2() ;
                
                @Data(size=2, lpadding=1)
                IInt zmDataIpt2() ;
                
                @Data(size=2, lpadding=1)
                IInt zdDataIpt2() ;
                
            }
            
            public interface Prazo extends IDataStruct {
                
                @Data(size=4)
                IInt cTipoPraz() ;
                
                @Data(size=5)
                IInt duTipoPraz() ;
                
            }
        }
        
        public interface DadosSaida extends IDataStruct {
            
            @Data(size=5)
            IInt qDiaOutp() ;
            
            @Data(size=6)
            IInt zOutpJuln() ;
            
            /**
             * @return instancia da classe local ZRstd
             */
            @Data
            ZRstd zRstd() ;
            
            @Data(size=10)
            IString zOutput() ;
            
            @Data(size=1)
            IString iDiaUtil() ;
            
            @Data(size=1)
            IString nDiaSmnDatOutp() ;
            
            @Data(size=20)
            IString zdDataOutpesc() ;
            
            /**
             * @return instancia da classe local DatUtAnt
             */
            @Data
            DatUtAnt datUtAnt() ;
            
            @Data(size=10)
            IString zDiaUtilUlt() ;
            
            /**
             * @return instancia da classe local DatUtPos
             */
            @Data
            DatUtPos datUtPos() ;
            
            @Data(size=10)
            IString zDiaUtilProx() ;
            
            @Data(size=2)
            IString aAplErr() ;
            
            /**
             * @return instancia da classe local Estado
             */
            @Data
            Estado estado() ;
            
            
            public interface ZRstd extends IDataStruct {
                
                @Data(size=4)
                IInt zaRstd() ;
                
                @Data(size=2)
                IInt zmRstd() ;
                
                @Data(size=2)
                IInt zdRstd() ;
                
            }
            
            public interface DatUtAnt extends IDataStruct {
                
                @Data(size=4)
                IInt zaDiaUtilUlt() ;
                
                @Data(size=2)
                IInt zmDiaUtilUlt() ;
                
                @Data(size=2)
                IInt zdDiaUtilUlt() ;
                
            }
            
            public interface DatUtPos extends IDataStruct {
                
                @Data(size=4)
                IInt zaDiaUtilProx() ;
                
                @Data(size=2)
                IInt zmDiaUtilProx() ;
                
                @Data(size=2)
                IInt zdDiaUtilProx() ;
                
            }
            
            public interface Estado extends IDataStruct {
                
                @Data(size=2)
                IString cTipoErroBbn() ;
                @Data
                @Condition(" ")
                ICondition calculoEfectuado() ;
                @Data
                @Condition("AT")
                ICondition erroArquitectura() ;
                @Data
                @Condition("A2")
                ICondition erroDb2() ;
                @Data
                @Condition("  ")
                ICondition semErros() ;
                @Data
                @Condition("DA")
                ICondition erDadosEntrada() ;
                
                
                @Data(size=3, signed=true, compression=COMP3)
                IInt cRtnoEvenSwal() ;
                @Data
                @Condition("004")
                ICondition warningDb2() ;
                @Data
                @Condition("005")
                ICondition msgErroDb2() ;
                @Data
                @Condition("912")
                ICondition opcaoMalFormatad() ;
                @Data
                @Condition("913")
                ICondition opcaoInvalida() ;
                @Data
                @Condition("917")
                ICondition dataIncorrecta() ;
                @Data
                @Condition("921")
                ICondition prazoNaoExiste() ;
                
                
                @Data(size=9, signed=true, compression=COMP)
                ILong cSqlcode() ;
                
                @Data(size=16)
                IString nmTabela() ;
                
            }
        }
    }
    
}
