package builder;

import builder.sub.effective.Student;
import builder.sub.effective.StudentBuilder;
import builder.sub.normal.Data;
import builder.sub.normal.Director;
import builder.sub.normal.HtmlBuilder;
import builder.sub.normal.TextBuilder;

public class Main {
    public static void main(String[] args) {
        /**
         * 일반적인 디자인 빌더 패턴
         */
        Data data = new Data("빌더 패턴", "개요", new String[]{"설명1 입니다.", "설명2 입니다."});

        System.out.println("==텍스트 형태 출력==");
        Director textDirector = new Director(new TextBuilder(data));
        String result1 = textDirector.build();
        System.out.println(result1);

        System.out.println("==HTML 형태 출력==");
        Director htmlDirector = new Director(new HtmlBuilder(data));
        String result2 = htmlDirector.build();
        System.out.println(result2);

        /**
         * 이펙티브 자바에서 제안하는 빌더 패턴
         */
        System.out.println("==이펙티브 자바에서 제안하는 빌더 패턴==");
        Student student = new StudentBuilder(1) // 필수값
                .name("김XX") // 선택값
                .grade("3학년")
                .phoneNumber("010-1234-5678")
                .build();
        System.out.println(student);

        Student student2 = new StudentBuilder(2)
                .name("박XX")
                .grade("2학년")
                .build();
        System.out.println(student2);

        System.out.println();

        try {
            new StudentBuilder(2)
                    .name("박XX")
                    .grade("2학년")
                    .phoneNumber("111-1234-5678")
                    .build();

        } catch (IllegalArgumentException e) {
            System.out.println("==예외 발생==");
            System.out.println(e.getMessage());
        }
    }
}
