package dotest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


public class ApiTest {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("select t1.patent_number '申请号',t2.patent_name '名称'," +
                "t2.patent_belonger '专利权人',count(*) " +
                " from detection_result_table t0  " +
                " LEFT JOIN tort_patent_result_table t1 on t0.pk_epr_id=t1.pk_epr_id " +
                " LEFT JOIN user_patent_relation_table t2 on t1.patent_number=t2.patent_number " +
                " LEFT JOIN user_info_table t3 on t2.pk_user_id=t3.pk_user_id " +
                "where 1=1 ");
    }



}
