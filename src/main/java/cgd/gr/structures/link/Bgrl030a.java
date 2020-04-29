package cgd.gr.structures.link;

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
public interface Bgrl030a extends IDataStruct {
    
    /**
     * @return instancia da classe local Mgr030aArealig
     */
    @Data
    Mgr030aArealig mgr030aArealig() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * M G R C 0 3 0 A
     * - TRATAMENTO DE DATAS -
     * AREA DE LIGACAO :
     * - MGR030A-FUNCAO   - PREENCHIMENTO OBRIGATORIO
     * - MGR030A-COD  - INDICA A OPERACAO A EFECTUAR
     * - MGR030A-FORM - INDICA O FORMATO DA DATA A FORNECER
     * AO MODULO
     * - MGR030A-RETORNO  - E SEMPRE DEVOLVIDO COM OS VALORES
     * INDICADOS NA SUA DEFINICAO. O VA-
     * LOR 'E' CORRESPONDE A UMA SITUACAO
     * NAO ESPECIFICADA
     * NOTA : NAS FUNCOES QUE ENVOLVEM CALCULO COM DIAS FERIA-
     * DOS, SAO CONSIDERADOS OS FERIADOS FIXOS DE QUAL-
     * QUER ANO E OS FERIADOS MOVEIS DO ANO CORRENTE.
     * *COD! FORMATO !  CAMPOS DE  !  CAMPOS DE  !       FUNCAO
     * !         !    INPUT    !   OUTPUT    !
     * 1 !  1,2,3  ! GREGORIANA1 !             !
     * +---------+-------------+ RETORNO     ! VALIDACAO DE DATAS
     * !   4,5   ! JULIANA1    !             !
     * 2 !  1,2,3  ! GREGORIANA1 ! DATAS       !
     * +---------+-------------+ RETORNO     ! CONVERSAO DE DATAS
     * 3 !  1,2,3  ! GREGORIANA1 !             !
     * !         ! GREGORIANA2 ! DIFERENCA   !
     * +---------+-------------+ RETORNO     ! DIFERENCA DE DATAS
     * !         ! JULIANA2    !             !
     * 4 !  1,2,3  ! GREGORIANA1 !             !
     * !         ! NRDIAS      ! DATAS       ! SOMA DE UMA DATA COM
     * +---------+-------------+ RETORNO     ! UM DADO NUMERO DIAS
     * !   4,5   ! JULIANA1    !             ! POSITIVO OU NEGATIVO
     * !         ! NRDIAS      !             !
     * 5 !  1,2,3  ! GREGORIANA1 !             ! SOMA DE UMA DATA COM
     * !         ! NRDIAS      ! DATAS       ! UM DADO NUMERO (POSI-*
     * +---------+-------------+ RETORNO     ! TIVO OU NEGATIVO) DE
     * !   4,5   ! JULIANA1    !             ! DIAS UTEIS
     * 6 !  1,2,3  ! GREGORIANA1 ! DIA-SEMANA  ! INDICA DIA DA SEMANA
     * +---------+-------------+ FERIADO     ! E SE A DATA DADA COR-*
     * !   4,5   ! JULIANA1    ! RETORNO     ! RESPONDE A FERIADO
     * ESTE MODULO EH SEMELHANTE AO MGRC018A MAS TRABALHA C/ 4
     * POSICOES P/ O ANO PERMITINDO CALCULOS ATE 2099
     * GR00121 - 2001-03-22 - DEDS148
     * -  NOVA FUNCAO PARA O TRATAMENTO DE FERIADOS DO CUT
     * 
     * @version 2.0
     * 
     */
    public interface Mgr030aArealig extends IDataStruct {
        
        /**
         * @return instancia da classe local Mgr030aFuncao
         */
        @Data
        Mgr030aFuncao mgr030aFuncao() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong mgr030aGregoriana1() ;
        
        @Data(size=8, signed=true, compression=COMP3)
        ILong mgr030aGregoriana2() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt mgr030aJuliana1() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt mgr030aJuliana2() ;
        
        @Data(size=7, signed=true, compression=COMP3)
        IInt mgr030aNrdias() ;
        
        @Data(size=1)
        IString mgr030aDiaSemana() ;
        @Data
        @Condition("1")
        ICondition mgr030aDomingo() ;
        @Data
        @Condition("2")
        ICondition mgr030aSegunda() ;
        @Data
        @Condition("3")
        ICondition mgr030aTerca() ;
        @Data
        @Condition("4")
        ICondition mgr030aQuarta() ;
        @Data
        @Condition("5")
        ICondition mgr030aQuinta() ;
        @Data
        @Condition("6")
        ICondition mgr030aSexta() ;
        @Data
        @Condition("0")
        ICondition mgr030aSabado() ;
        @Data
        @Condition(range={"2", "6"})
        ICondition mgr030aDiaUtil() ;
        
        
        @Data(size=1)
        IString mgr030aFeriado() ;
        @Data
        @Condition("0")
        ICondition mgr030aNaoEhFeriado() ;
        @Data
        @Condition({ "1", "2" })
        ICondition mgr030aEhFeriado() ;
        @Data
        @Condition("1")
        ICondition mgr030aEhFeriadoFixo() ;
        @Data
        @Condition("2")
        ICondition mgr030aEhFeriadoMovel() ;
        @Data
        @Condition("3")
        ICondition mgr030aEhFeriadoCut() ;
        
        
        @Data(size=5, signed=true, compression=COMP3)
        IInt mgr030aDiferenca() ;
        
        /**
         * @return instancia da classe local Mgr030aDatas
         */
        @Data
        Mgr030aDatas mgr030aDatas() ;
        
        @Data(size=1)
        IString mgr030aRetorno() ;
        @Data
        @Condition("0")
        ICondition mgr030aOk() ;
        @Data
        @Condition("1")
        ICondition mgr030aCodInvalido() ;
        @Data
        @Condition("2")
        ICondition mgr030aFormInvalido() ;
        @Data
        @Condition("3")
        ICondition mgr030aDataInvalida() ;
        @Data
        @Condition("E")
        ICondition mgr030aNaoOk() ;
        
        
        
        public interface Mgr030aFuncao extends IDataStruct {
            
            @Data(size=1)
            IInt mgr030aCodigo() ;
            
            @Data(size=1)
            @Mask
            IString mgr030aCod() ;
            @Data
            @Condition(range={"1", "7"})
            ICondition mgr030aCodValido() ;
            @Data
            @Condition("3")
            ICondition mgr030aDiferencaDatas() ;
            @Data
            @Condition({ "4", "5" })
            ICondition mgr030aSomarDias() ;
            
            
            @Data(size=1)
            IString mgr030aForm() ;
            @Data
            @Condition(range={"1", "5"})
            ICondition mgr030aFormValido() ;
            @Data
            @Condition({ "1", "2", "3" })
            ICondition mgr030aFormatoGregoriano() ;
            @Data
            @Condition("1")
            ICondition mgr030aDataAaaammdd() ;
            @Data
            @Condition("2")
            ICondition mgr030aDataDdmmaaaa() ;
            @Data
            @Condition("3")
            ICondition mgr030aDataMmddaaaa() ;
            @Data
            @Condition({ "4", "5" })
            ICondition mgr030aFormatoJuliano() ;
            @Data
            @Condition("4")
            ICondition mgr030aDataAaaaddd() ;
            @Data
            @Condition("5")
            ICondition mgr030aDataDddaaaa() ;
            
            
        }
        
        public interface Mgr030aDatas extends IDataStruct {
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong mgr030aAaaammdd() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong mgr030aDdmmaaaa() ;
            
            @Data(size=8, signed=true, compression=COMP3)
            ILong mgr030aMmddaaaa() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt mgr030aAaaaddd() ;
            
            @Data(size=7, signed=true, compression=COMP3)
            IInt mgr030aDddaaaa() ;
            
        }
    }
    
}
