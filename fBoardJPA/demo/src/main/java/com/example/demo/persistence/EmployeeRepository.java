package com.example.demo.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Employee;
import java.util.*;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

    // 기본함수
    // 전체검색     : findAll()
    // 아이디검색   : findById()
    // 입력         : save()
    // 삭제         : deleteById()
    
    // 상세 검색    : findBy컬럼명키워드()

    // JPQL != SQL
    // @Query("SELECT e, d FROM Employee e INNER JOIN e.dept d")
    // @Query("SELECT e, e.dept FROM Employee e")
    // List<Object[]> getEmployeeList();

    // SQL

    @Query(value="SELECT e.*, d.* FROM emp e INNER JOIN dept d ON e.deptno = d.deptno", nativeQuery=true)
    List<Object[]> getEmployeeList();


     /*
      * 1. sql 문장이라면??

        2. Object[] -> Map으로 변경한다면??

        3. 검색 구체적으로 한다면??
            1- 이름이 SCOTT인 사원 검색
            2- 이름이 SCOTT, FORD인 사원 검색
            3- 입사일이 81년 1월 1일부터 81년 12월 31일에 입사한 사원 검색
            4- 입사일이 82년이후인 사원 검색
            5- 월급이 3000 미만인 사원 검색
            6- 매니저(상사)가 없는 사원 검색
            7- 이름에 'R'이 들어 있는 사원 검색
            8- 20번 부서의 사원들을 월급순으로 정렬하여 출력
      */

    
}
