package cgd.d2.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;
import static morphis.framework.commons.MathHandling.* ;
import java.math.BigDecimal ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Zd2667d extends IDataStruct {
    
    /**
     * @return instancia da classe local ZvghIpMessage
     */
    @Data
    ZvghIpMessage zvghIpMessage() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * **       UCS ZD2667D DATA GROUP                                **
     * **           COBOL COPYBOOK           ZD2667D                  **
     * **           DATA GROUP ID            71266700                 **
     * **           ELEMENT PREFIX           ZD2667                   **
     * **           DATA GROUP TYPE          SEQUENTIAL               **
     * **           PARENT DATA GROUP        NONE                     **
     * 
     * @version 2.0
     * 
     */
    public interface ZvghIpMessage extends IDataStruct {
        
        /**
         * @return instancia da classe local TransHeader
         */
        @Data
        TransHeader transHeader() ;
        
        /**
         * @return instancia da classe local MsgHeader
         */
        @Data
        MsgHeader msgHeader() ;
        
        /**
         * @return instancia da classe local ZvghIpSegHeader
         */
        @Data
        ZvghIpSegHeader zvghIpSegHeader() ;
        
        /**
         * @return instancia da classe local ZvghIpSegData
         */
        @Data
        ZvghIpSegData zvghIpSegData() ;
        
        /**
         * @return instancia da classe local ZvghOpSegData
         */
        @Data
        ZvghOpSegData zvghOpSegData() ;
        
        
        public interface TransHeader extends IDataStruct {
            
            @Data(size=9, value="PASW")
            IString trancode() ;
            
            @Data(size=1, value="~")
            IString fd001() ;
            
            @Data(size=2, value="0")
            IInt tranrc() ;
            
            @Data(size=1, value="~")
            IString fd002() ;
            
            @Data(size=1, value="%")
            IString sd001() ;
            
        }
        
        public interface MsgHeader extends IDataStruct {
            
            @Data(size=8, value="SGMP-GM")
            IString btcbMsgId() ;
            
            @Data(size=1, value="~")
            IString fd003() ;
            
            @Data(size=4, value="0")
            IInt btcbVersionNo() ;
            
            @Data(size=1, value="~")
            IString fd004() ;
            
            @Data(size=1, value="D")
            IString v151OutputFormatFlag() ;
            
            @Data(size=1, value="~")
            IString fd005() ;
            
            @Data(size=5, value="1")
            IInt btcbBranchNo() ;
            
            @Data(size=1, value="~")
            IString fd006() ;
            
            @Data(size=1, value=" ")
            IString v151FldDlmOverride() ;
            
            @Data(size=1, value="~")
            IString fd007() ;
            
            @Data(size=1, value=" ")
            IString v151SegDlmOverride() ;
            
            @Data(size=1, value="~")
            IString fd008() ;
            
            @Data(size=3, value="0")
            IInt v200NrSegReturned() ;
            
            @Data(size=1, value="~")
            IString fd009() ;
            
            @Data(size=8, value="GH00001H")
            IString tcbUmbrellaOperator() ;
            
            @Data(size=1, value="~")
            IString fd010() ;
            
            @Data(size=8, value=" ")
            IString cgdUtcbProfile() ;
            
            @Data(size=1, value="~")
            IString fd011() ;
            
            @Data(size=3, value="CGD")
            IString cgdUtcbBranchCoid() ;
            
            @Data(size=1, value="~")
            IString fd012() ;
            
            @Data(size=3, value=" ")
            IString cgdUtcbBranchCountry() ;
            
            @Data(size=1, value="~")
            IString fd013() ;
            
            @Data(size=5, value="0")
            IInt cgdUtcbBranch() ;
            
            @Data(size=1, value="~")
            IString fd014() ;
            
            @Data(size=8, value="GH")
            IString tcbSource() ;
            
            @Data(size=1, value="~")
            IString fd015() ;
            
            @Data(size=9, value="ZVGHIP")
            IString zv1001FeFunction() ;
            
            @Data(size=1, value="~")
            IString fd016() ;
            
            @Data(size=1, value="%")
            IString sd002() ;
            
        }
        
        public interface ZvghIpSegHeader extends IDataStruct {
            
            @Data(size=8, value="ZVGH-IP")
            IString btcbCurrentSegment() ;
            
            @Data(size=1, value="~")
            IString fd017() ;
            
            @Data(size=2, value="0")
            IInt btcbResponseCode() ;
            
            @Data(size=1, value="~")
            IString fd018() ;
            
            @Data(size=1, value="%")
            IString sd003() ;
            
        }
        
        public interface ZvghIpSegData extends IDataStruct {
            
            @Data(size=3)
            IString zd2667CMnemEgcOpex() ;
            
            @Data(size=1, value="~")
            IString fd019() ;
            
            @Data(size=3)
            IString zd2667CPaisIsoaOeOpx() ;
            
            @Data(size=1, value="~")
            IString fd020() ;
            
            @Data(size=8)
            IString zd2667CUserId() ;
            
            @Data(size=1, value="~")
            IString fd021() ;
            
            @Data(size=9)
            ILong zd2667NJourBbn() ;
            
            @Data(size=1, value="~")
            IString fd022() ;
            
            @Data(size=2)
            IInt zd2667NsJourBbn() ;
            
            @Data(size=1, value="~")
            IString fd023() ;
            
        }
        
        public interface ZvghOpSegData extends IDataStruct {
            
            @Data(size=5)
            IInt btcbUserCcApp() ;
            
            @Data(size=1, value="~")
            IString fd024() ;
            
            @Data(size=5)
            IInt btcbUserCc() ;
            
            @Data(size=1, value="~")
            IString fd025() ;
            
            @Data(size=40)
            IString btcbUserDescription() ;
            
            @Data(size=1, value="~")
            IString fd026() ;
            
            @Data(size=23)
            IString zd2667PlasticoContaCartao() ;
            
            @Data(size=1, value="~")
            IString fd027() ;
            
            @Data(size=40)
            IString zd2667NomeLocComer() ;
            
            @Data(size=1, value="~")
            IString fd028() ;
            
            @Data(size=4)
            IString zd2667AtmBalcaoApoio() ;
            
            @Data(size=1, value="~")
            IString fd029() ;
            
            @Data(size=3)
            IString zd2667AtmCodigo() ;
            
            @Data(size=1, value="~")
            IString fd030() ;
            
            @Data(size=18)
            IString zd2667AtmEquipamento() ;
            
            @Data(size=1, value="~")
            IString fd031() ;
            
            @Data(size=40)
            IString zd2667LocalidadeAtm() ;
            
            @Data(size=1, value="~")
            IString fd032() ;
            
            @Data(size=15)
            IString zd2667CodigoPostalAtm() ;
            
            @Data(size=1, value="~")
            IString fd033() ;
            
            @Data(size=8)
            IString zd2667HoraTransaccao() ;
            
            @Data(size=1, value="~")
            IString fd034() ;
            
            @Data(size=15, decimal=2)
            IDecimal zd2667ValorOrigTxn() ;
            
            @Data(size=1)
            IString zd2667ValorOrigTxnSgn() ;
            
            @Data(size=1, value="~")
            IString fd035() ;
            
            @Data(size=3)
            IString zd2667MoedaOrig() ;
            
            @Data(size=1, value="~")
            IString fd036() ;
            
            @Data(size=21)
            IString zd2667CodReferenciaDest() ;
            
            @Data(size=1, value="~")
            IString fd037() ;
            
            @Data(size=36)
            IString zd2667NomeOrdenante() ;
            
            @Data(size=1, value="~")
            IString fd038() ;
            
            @Data(size=5)
            IString zd2667Entidade() ;
            
            @Data(size=1, value="~")
            IString fd039() ;
            
            @Data(size=9)
            IString zd2667Referencia() ;
            
            @Data(size=1, value="~")
            IString fd040() ;
            
            @Data(size=30)
            IString zd2667DescTipoServico() ;
            
            @Data(size=1, value="~")
            IString fd041() ;
            
            @Data(size=14)
            IString zd2667CodIdentSibs() ;
            
            @Data(size=1, value="~")
            IString fd042() ;
            
            @Data(size=2)
            IString zd2667TipoSuporteMov() ;
            
            @Data(size=1, value="~")
            IString fd043() ;
            
            @Data(size=70)
            IString zd2667CodDadosAdicionais() ;
            
            @Data(size=1, value="~")
            IString fd044() ;
            
            @Data(size=1, value="%")
            IString sd004() ;
            
        }
    }
    
}
