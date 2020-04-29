package cgd.ht.structures.work;

import morphis.framework.datatypes.structs.IDataStruct ;
import morphis.framework.datatypes.annotations.Data ;
import morphis.framework.datatypes.fields.* ;


/**
 * 
 * 
 * @version 2.0
 * 
 */
public interface Bhtw0015 extends IDataStruct {
    
    /**
     * @return instancia da classe local Area
     */
    @Data
    Area area() ;
    
    /**
     * Inner Classes
     */
    
    /**
     * 
     * COPY DE WORKING PARA ACESSO AO BOOK BHTP0015
     * 
     * @version 2.0
     * 
     */
    public interface Area extends IDataStruct {
        
        /**
         * @return instancia da classe local Current
         */
        @Data
        Current current() ;
        
        /**
         * @return instancia da classe local CurrentFrm
         */
        @Data
        CurrentFrm currentFrm() ;
        
        
        public interface Current extends IDataStruct {
            
            /**
             * @return instancia da classe local CurrentDate
             */
            @Data
            CurrentDate currentDate() ;
            
            /**
             * @return instancia da classe local CurrentTime
             */
            @Data
            CurrentTime currentTime() ;
            
            /**
             * @return instancia da classe local CurrentTmst
             */
            @Data
            CurrentTmst currentTmst() ;
            
            
            public interface CurrentDate extends IDataStruct {
                
                @Data(size=4, value=" ")
                IString dateYear() ;
                
                @Data(size=2, value=" ")
                IString dateMonth() ;
                
                @Data(size=2, value=" ")
                IString dateDay() ;
                
            }
            
            public interface CurrentTime extends IDataStruct {
                
                @Data(size=2, value=" ")
                IString timeHour() ;
                
                @Data(size=2, value=" ")
                IString timeMin() ;
                
                @Data(size=2, value=" ")
                IString timeSec() ;
                
            }
            
            public interface CurrentTmst extends IDataStruct {
                
                @Data(size=2, value=" ")
                IString tmstSs1() ;
                
                @Data(size=2, value=" ")
                IString tmstSs2() ;
                
                @Data(size=2, value=" ")
                IString tmstSs3() ;
                
            }
        }
        
        public interface CurrentFrm extends IDataStruct {
            
            /**
             * @return instancia da classe local DateFrm
             */
            @Data
            DateFrm dateFrm() ;
            
            /**
             * @return instancia da classe local TimeFrm
             */
            @Data
            TimeFrm timeFrm() ;
            
            /**
             * @return instancia da classe local TmstFrm
             */
            @Data
            TmstFrm tmstFrm() ;
            
            
            public interface DateFrm extends IDataStruct {
                
                @Data(size=4, value=" ")
                IString dateYearFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
                IString dateMonthFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
                IString dateDayFrm() ;
                
            }
            
            public interface TimeFrm extends IDataStruct {
                
                @Data(size=2, value=" ")
                IString timeHhFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue=":")
                IString timeMmFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue=":")
                IString timeSsFrm() ;
                
            }
            
            public interface TmstFrm extends IDataStruct {
                
                @Data(size=4, value=" ")
                IString tmstYearFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
                IString tmstMonthFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
                IString tmstDayFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue="-")
                IString tmstHhFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
                IString tmstMmFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
                IString tmstSsFrm() ;
                
                @Data(size=2, value=" ", lpadding=1, lpaddingValue=".")
                IString tmstSs1Frm() ;
                
                @Data(size=2, value=" ")
                IString tmstSs2Frm() ;
                
                @Data(size=2, value=" ")
                IString tmstSs3Frm() ;
                
            }
        }
    }
    
}
